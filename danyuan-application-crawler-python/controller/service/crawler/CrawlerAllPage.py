#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from controller.service.crawler.CrawlerUtils import CrawlerUtils
from common.HtmlSource import HtmlSource
from common.Rule import Rule
from controller.dao.CrawlerTaskDao import *

class CrawlerAllPage():
    # 详细页面
    def crawlerAllPage(self, task, group):

        # 详细页面
        def crawlerDetialPage(self, task, group):

            if (group['parent_uuid'] != '' and group['parent_uuid'] != None):
                # 获取上一层的group
                sysCrawlerGroupInfo = SysCrawlerGroupInfo()
                pGroup = sysCrawlerGroupInfo.findOne(group['parent_uuid'])

                # 获取 字典数据
                crawlerResults = CrawlerResults()
                rows = crawlerResults.get_navigation_List(pGroup)

                # 上一层的字段
                sysCrawlerCloumnInfo = SysCrawlerCloumnInfo()
                pColumndata = sysCrawlerCloumnInfo.findAll(pGroup)

                # 对比得到配置的连接字段名
                for column in pColumndata:
                    if (column['uuid'] == group['parent_dic_uuid']):
                        pLinkConf = column['colum_name']


            else:
                pass

    if __name__ == '__main__':
        pass
    def __init__(self):
        pass
