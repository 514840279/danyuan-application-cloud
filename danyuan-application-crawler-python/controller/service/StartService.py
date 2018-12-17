#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from common.inc_conn import Conn_mysql
from common.HtmlSource import HtmlSource
from common.Rule import Rule


from controller.service.crawler.CrawlerDetialInfoPage import CrawlerDetialInfoPage
from controller.service.crawler.CrawlerListItem import CrawlerListItem
from controller.service.crawler.CrawlerNavigation import CrawlerNavigation



# 启动监控
class StartService():

    # 启动爬虫程序
    def run(self,task):

        ## 数据提取参数获取 ##############
        groupsql = '''
            select * from sys_crawler_ruler_info r
            where r.task_uuid='%s'
            and (r.parent_uuid is null or r.parent_uuid ='')
        ''' % task['uuid']
        conn = Conn_mysql()
        res, groupdata = conn.read_sql(groupsql)

        # 判断配置的第一个是那种类型的页面进行爬取
        for group in groupdata:
            if(group['type'] == 'navigation_bar'):# 导航页面
                navigation = CrawlerNavigation()
                rows = navigation.crawlerNavigation(task,group);
                #  调用配置中心进行下一组任务
                navigation.runconfig(task,group,rows)
            elif (group['type'] == 'listPage'):# 列表页面
                listItem = CrawlerListItem()
                #  列表页面采集
                rows,nexpage = listItem.crawlerListPage(task, group);
                # 下一页
                listItem.runNext(task,group,nexpage)
            elif (group['type'] == 'detialPage'):# 详细页面
                # TODO
                rows = self.crawlerDetialPage(task, group);




    def __init__(self):
        pass

    if __name__ == '__main__':
        pass