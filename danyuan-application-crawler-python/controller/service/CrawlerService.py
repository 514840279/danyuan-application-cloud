#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from common.inc_conn import Conn_mysql
from common.HtmlSource import HtmlSource
from bs4 import BeautifulSoup as bs_4
import uuid



# 爬虫
class CrawlerService():
    def __init__(self):
        pass
    # 爬虫采集程序
    def crawler(self,searchUrl,keyword,plant):
        # 通用数据库连接 全局接口
        conn = Conn_mysql(host='localhost', port=3306, user='root', passwd='514840279@qq.com', db='flasktest')
        # 使用自定义获取源码脚本获取 网页
        source = HtmlSource()
        html = source.get_html(url_p=searchUrl,type_p='rg')
        #使用beautifulSoup 解析html 字符串，'lxml' 原理还是xPath
        soup = bs_4(html,'lxml')
        # beautifulSoup 写法解析获取列表 区别 find  与 findAll
        result_list =soup.find("div",id="content_left").findAll("div",srcid="1599",tpl="se_com_default")
        for result in result_list:
            #print(result)
            title = result.find("h3").get_text()
            url = result.find("h3").find("a").get("href")
            summary = result.find("div", class_="c-abstract").get_text()
            snapshot = result.find("div", class_="f13").find("a", class_="m").get("href")
            sql = "insert into search_local_temp(uuid,title,url,summary,snapshot,search_keyword,search_plant,create_user) values('%s','%s','%s','%s','%s','%s','%s','%s') " % (uuid.uuid1(),title,url,summary,snapshot,keyword,plant,'wth')
            #print(sql)
            conn.write_sql(sql=sql)
        conn.close()

    if __name__ == '__main__':
        pass


