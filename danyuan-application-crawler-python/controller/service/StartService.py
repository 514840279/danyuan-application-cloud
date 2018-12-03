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
        groupsql  = '''
            select * from sys_crawler_ruler_info r
            where r.task_uuid='%s'
            and r.parent_uuid is null
        ''' % task['uuid']
        #print(groupsql)
        conn = Conn_mysql(db='application')
        res,groupdata = conn.read_sql(groupsql)
        group = groupdata[0]
        #print(groupdata)
        columnsql = '''
            select * from sys_crawler_ruler_colum_info c
            where c.ruler_uuid = '%s'
        ''' % group['uuid']

        ress ,columndata =  conn.read_sql(columnsql)
        print(columndata)
        source = HtmlSource()
        html =  source.get_html(url_p=task['url'],type_p=task['requestType'],chartset_p=task['charset'])
        #print(html)
        rule = Rule()
        rows=[]

        if group['type'] == 'navigation_bar':
            rows = rule.html_content_analysis_navigation(html_text=html,column=columndata,url=task['url'])
        elif group['type'] == 'detialPage':
            rows = rule.html_content_analysis_detial(html_text=html, column=columndata, url=task['url'])
        elif group['type'] == 'listPage':
            rows = rule.html_content_analysis_list(html_text=html, column=columndata, url=task['url'])
        else:
            rows= rule.html_content_analysis_allPage(html_text=html, column=columndata, url=task['url'])

        print(rows)

    def __init__(self):
        pass

    if __name__ == '__main__':
        pass

