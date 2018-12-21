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
        # 假如 采集完成状态为 “完成” ,需要手动重置 状态才可以重新进行采集
        if group['statue']=='完成':
            crawlerResults = CrawlerResults()
            return crawlerResults.get_navigation_List(group)
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

