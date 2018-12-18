#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from controller.service.crawler.CrawlerUtils import CrawlerUtils
from controller.service.crawler.CrawlerListItem import CrawlerListItem
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
            conn = Conn_mysql()
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
        sysCrawlerGroupInfo = SysCrawlerGroupInfo()
        groupdata = sysCrawlerGroupInfo.findAllByGroup(task['uuid'],group['uuid'])
        # 判断配置的第一个是那种类型的页面进行爬取
        for group in groupdata:
            if (group['type'] == 'listPage'):  # 列表页面
                rows = self.crawlerListPage(task, group,rows)
            elif (group['type'] == 'detialPage'):  # 详细页面
                rows = self.crawlerDetialPage(task, group)

    # 采集列表页面
    def crawlerListPage(self,task,group,rows):
        crawlerListItem = CrawlerListItem()
        for row in rows:
            if(row['statue']=="完成"):
                continue
            else:

                # 获取列表规则
                sysCrawlerCloumnInfo = SysCrawlerCloumnInfo()
                columndata = sysCrawlerCloumnInfo.findAll(group)

                # 找到配置的主要连接字段
                for column in columndata:
                    if(column['link_url']==1):
                        url = column['column_name']
                ## 源码采集 ##############
                source = HtmlSource()
                html = source.get_html(url_p=row[url], type_p=task['requestType'], chartset_p=task['charset'])

                ## 数据提取 ##############
                rule = Rule()
                rows, nextpage = rule.html_content_analysis_list(html_text=html, group=group, column=columndata)

                ## 动态入库参数数据提取 ##########
                sysCrawlerMappedTableOfColumnInfo = SysCrawlerMappedTableOfColumnInfo()
                condata = sysCrawlerMappedTableOfColumnInfo.findCondata(group)

                # 拼装入库语句,入库
                crawlerResults = CrawlerResults()
                crawlerResults.instertItems(condata, rows)

                # TODO 更新任TODO

                # TODO 更新数据表根据md5


                if (len(nextpage) > 0):
                    #  下一页
                    self.runNext(task, group, nextpage, condata)
                #
                crawlerListItem.runNext()