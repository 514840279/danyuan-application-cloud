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

    # 列表页面
    def crawlerListPage(self, task, group):
        ## 源码采集 ##############
        source = HtmlSource()
        html = source.get_html(url_p=task['url'], type_p=task['requestType'], chartset_p=task['charset'])

        # 获取列表规则
        sysCrawlerCloumnInfo = SysCrawlerCloumnInfo()
        columndata = sysCrawlerCloumnInfo.findAll(group)

        ## 数据提取 ##############
        rule = Rule()
        rows,nextpage = rule.html_content_analysis_list(html_text=html, group=group, column=columndata)

        ## 动态入库参数数据提取 ##########
        sysCrawlerMappedTableOfColumnInfo = SysCrawlerMappedTableOfColumnInfo()
        condata = sysCrawlerMappedTableOfColumnInfo.findCondata(group)

        # 拼装入库语句,入库
        crawlerResults = CrawlerResults()
        crawlerResults.instertItems(condata,rows)

        # TODO 更新任TODO
        # TODO 更新数据表根据md5

        if (len(nextpage) > 0):
            #  下一页
            self.runNext(task, group, nextpage,condata)


    def runNext(self,task, group, nextpage,columndata,condata):
        ## 源码采集 ##############
        source = HtmlSource()
        html = source.get_html(url_p=nextpage[0], type_p=task['requestType'], chartset_p=task['charset'])

        ## 数据提取 ##############
        rule = Rule()
        rows, nextpage = rule.html_content_analysis_list(html_text=html, group=group, column=columndata)

        # 拼装入库语句,入库
        crawlerResults = CrawlerResults()
        crawlerResults.instertItems(condata, rows)

        # TODO 更新任务表
        # TODO 更新数据表根据md5

        if(len(nextpage)>0):
            # 下一页
            self.runNext(task, group, nextpage, condata)
