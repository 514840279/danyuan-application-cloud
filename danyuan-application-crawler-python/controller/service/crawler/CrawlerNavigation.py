#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from controller.service.crawler.CrawlerUtils import CrawlerUtils
from controller.dao.CrawlerTaskDao import *
from common.HtmlSource import HtmlSource
from common.Rule import Rule

class CrawlerNavigation():
    def __init__(self):
        pass
    if __name__ == '__main__':
        pass


    # 导航页面
    def crawlerNavigation(self,task,group):
        if ['homeStatue']=='完成':
            sysCrawlerMappedTableOfColumnInfo = SysCrawlerMappedTableOfColumnInfo()
            condata = sysCrawlerMappedTableOfColumnInfo.findCondata(group)
            sql ="""
                select * from %s 
            """  % condata[0]['tabs_name']
            conn = Conn_mysql(db=self.db)
            rows = conn.read_sql(sql=sql)
            return rows
        else:
            ## 源码采集 ##############
            source = HtmlSource()
            html = source.get_html(url_p=task['url'], type_p=task['requestType'], chartset_p=task['charset'])

            # 获取列表规则
            sysCrawlerCloumnInfo = SysCrawlerCloumnInfo()
            columndata = sysCrawlerCloumnInfo.findAll(group)

            ## 数据提取 ##############.
            rule = Rule()
            rows = rule.html_content_analysis_navigation(html_text=html, group_ruler=group['ruler'], column=columndata)

            ## 动态入库参数数据提取 ##########
            sysCrawlerMappedTableOfColumnInfo = SysCrawlerMappedTableOfColumnInfo()
            condata = sysCrawlerMappedTableOfColumnInfo.findCondata(group)

            print(condata)
            # 拼装入库语句
            crawlerResults = CrawlerResults()
            crawlerResults.instertItems(condata, rows)

            # 更新表状态 完成
            sysCrawlerTaskInfo = SysCrawlerTaskInfo()
            sysCrawlerTaskInfo.updateTaskInfo(task['uuid'],'完成',len(rows))
        return rows

    # 找到新的 配置中心 调用 下一步执行
    def runconfig(self,task,group,rows):
        ## 数据提取参数获取 ##############
        groupsql = '''
            select * from sys_crawler_ruler_info r
            where r.task_uuid='%s'
            and (r.parent_uuid is '$s')
        ''' % (task['uuid'],group('uuid'))
        conn = Conn_mysql(db=self.db)
        res, groupdata = conn.read_sql(groupsql)

        # 判断配置的第一个是那种类型的页面进行爬取
        for group in groupdata:
            if (group['type'] == 'listPage'):  # 列表页面
                rows = self.crawlerListPage(conn, task, group,rows)
            elif (group['type'] == 'detialPage'):  # 详细页面
                rows = self.crawlerDetialPage(conn, task, group)