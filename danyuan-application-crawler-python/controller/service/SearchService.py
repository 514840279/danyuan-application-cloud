#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from common.inc_conn import Conn_mysql


# 本地缓存服务
class SearchService():

    def findAll(self,page_number=1,page_size=10,search_keyword="",search_plant=""):
        # 通用数据库连接 全局接口
        conn = Conn_mysql(host='localhost', port=3306, user='root', passwd='514840279@qq.com', db='flasktest')
        sql  ="select uuid,title,url,summary,snapshot,search_keyword,search_plant,create_user from search_local_temp where search_plant='%s' and search_keyword='%s' limit %d,%d" %(search_plant,search_keyword,(page_number-1)*page_size,page_size)

        res,data = conn.read_sql(sql=sql)
        print(data)
        conn.close()
        return data

    if __name__ == '__main__':
        pass
    def __init__(self):
        pass
