#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from common.inc_conn import Conn_mysql
from common.HtmlSource import HtmlSource
from common.Rule import Rule


from controller.service.crawler.CrawlerDetialInfoPage import CrawlerDetialInfoPage
from controller.service.crawler.CrawlerListItem import CrawlerListItem
from controller.service.crawler.CrawlerNavigation import CrawlerNavigation
from controller.dao.CrawlerTaskDao import SysCrawlerGroupInfo


# 启动监控
class StartService():

    # 启动爬虫程序
    def run(self,task):
        ## 数据参数获取 ##############
        sysCrawlerGroupInfo = SysCrawlerGroupInfo()
        groupdata =  sysCrawlerGroupInfo.findAllByTaskId(task['uuid'])

        # 判断配置的第一个是那种类型的页面进行爬取
        for group in groupdata:
            if(group['type'] == 'navigation_bar'):# 导航页面
                navigation = CrawlerNavigation()
                navigation.crawlerNavigation(task,group);
            elif (group['type'] == 'listPage'):# 列表页面
                listItem = CrawlerListItem()
                #  列表页面采集
                listItem.crawlerListPage(task, group);

            elif (group['type'] == 'detialPage'):# 详细页面
                # TODO
                rows = self.crawlerDetialPage(task, group);




    def __init__(self):
        pass

    if __name__ == '__main__':
        pass