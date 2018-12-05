#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from common.inc_conn import Conn_mysql
from common.HtmlSource import HtmlSource
from common.Rule import Rule
from bs4 import BeautifulSoup as bs_4


# 启动监控
class StartService():

    # 启动爬虫程序
    def run(self,task):


        ## 源码采集 ##############
        source = HtmlSource()
        html =  source.get_html(url_p=task['url'],type_p=task['requestType'],chartset_p=task['charset'])
        rule = Rule()
        rows=[]

        ## 数据提取参数获取 ##############
        groupsql = '''
                    select * from sys_crawler_ruler_info r
                    where r.task_uuid='%s'
                    and (r.parent_uuid is null or r.parent_uuid ='')
                ''' % task['uuid']
        conn = Conn_mysql(db='application')
        res, groupdata = conn.read_sql(groupsql)
        group = groupdata[0]
        columnsql = '''
            select * from sys_crawler_ruler_colum_info c
            where c.ruler_uuid = '%s'
        ''' % group['uuid']

        ress ,columndata =  conn.read_sql(columnsql)

        ## 数据提取 ##############
        if group['type'] == 'navigation_bar':
            rows = rule.html_content_analysis_navigation(html_text=html,group_ruler=group['ruler'], column=columndata)
        elif group['type'] == 'detialPage':
            rows = rule.html_content_analysis_detial(html_text=html,group_ruler=group['ruler'], column=columndata)
        elif group['type'] == 'listPage':
            rows = rule.html_content_analysis_list(html_text=html,group_ruler=group['ruler'], column=columndata)
        else:
            rows= rule.html_content_analysis_allPage(html_text=html,group_ruler=group['ruler'], column=columndata)

        ## 动态入库参数数据提取 ##########
        print(rows)
        return rows

    def __init__(self):
        pass

    if __name__ == '__main__':
        pass

