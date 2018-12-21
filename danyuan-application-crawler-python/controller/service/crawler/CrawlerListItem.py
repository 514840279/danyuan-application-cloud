#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from controller.service.crawler.CrawlerUtils import CrawlerUtils
from common.HtmlSource import HtmlSource
from common.Rule import Rule
from controller.dao.CrawlerTaskDao import *

class CrawlerListItem():
    def __init__(self):
        pass

    if __name__ == '__main__':
        pass

    # 列表页面采集控制中心
    def crawlerListPage(self, task, group):
        if(group['parent_uuid']!= '' and group['parent_uuid']!= None ):
            # 获取上一层的group
            sysCrawlerGroupInfo = SysCrawlerGroupInfo()
            pgroup = sysCrawlerGroupInfo.findOne(group['parent_uuid'])

            # 获取 字典数据
            crawlerResults = CrawlerResults()
            rows =  crawlerResults.get_navigation_List(group)

            #循环取url
            for item in rows:
                # TODO “连接”需要经过配置得到
                self.crawlerListPageWithUrl(task, group, item['连接'])

        else:
           self.crawlerListPageWithUrl(task,group,task['url'])

    # 但页面采集解析
    def crawlerListPageWithUrl(self,task,group,url):
        ## 源码采集 ##############
        source = HtmlSource()
        html = source.get_html(url_p=url, type_p=task['requestType'], chartset_p=task['charset'])

        # 获取列表规则
        sysCrawlerCloumnInfo = SysCrawlerCloumnInfo()
        columndata = sysCrawlerCloumnInfo.findAll(group)

        ## 数据提取 ##############

        rule = Rule()
        rows, nextpage = rule.html_content_analysis_list(html_text=html, group=group, column=columndata)
        source = HtmlSource()
        root_url = source.get_url_root(task['url'])
        nextpage = source.addr_whole(nextpage, root_url)

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
            self.runNext(task, group, nextpage, columndata, condata)

    # 循环取下一页数据
    def runNext(self,task, group, nextpage,columndata,condata):
        ## 源码采集 ##############
        source = HtmlSource()
        html = source.get_html(url_p=nextpage[0], type_p=task['requestType'], chartset_p=task['charset'])

        ## 数据提取 ##############
        rule = Rule()
        rows, nextpage = rule.html_content_analysis_list(html_text=html, group=group, column=columndata)
        source = HtmlSource()
        root_url = source.get_url_root(task['url'])
        nextpage = source.addr_whole(nextpage,root_url)


        # 拼装入库语句,入库
        crawlerResults = CrawlerResults()
        crawlerResults.instertItems(condata, rows)

        # TODO 更新任务表
        # TODO 更新数据表根据md5

        if(len(nextpage)>0):
            # 下一页
            self.runNext(task, group, nextpage,columndata, condata)