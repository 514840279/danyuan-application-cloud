#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from controller.service.crawler.CrawlerUtils import CrawlerUtils
from common.HtmlSource import HtmlSource
from common.Rule import Rule
from controller.dao.CrawlerTaskDao import *

class CrawlerDetialInfoPage():
    # 详细页面
    def crawlerDetialPage(self,  task, group):

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
        return;
    if __name__ == '__main__':
        pass
    def __init__(self):
        pass
