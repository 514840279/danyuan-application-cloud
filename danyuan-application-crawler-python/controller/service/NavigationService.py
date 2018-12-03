#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from common.inc_conn import Conn_mysql
# 导航
class NavigationService():
    def __init__(self):
        pass

    # 导航程序
    def findAll(self,page_number=1,page_size=10,params={}):
        # 通用数据库连接
        # 全局接口
        conn = Conn_mysql()
        sql = """select `uuid`,`name`,`snapshot_img_url`,`logo_url`,`url`,`intro`,`create_time`,`create_user`,`update_time`, `update_user`,`delete_flag`, `type`,`group`,`click_num`, `praise_num`,`keyword`
                from seach_knowledge_navigation_map
                where `type`='%s' and `group`='%s' limit %d,%d""" % ( params['type'], params['group'], (page_number - 1) * page_size, page_size)
        res, data = conn.read_sql(sql=sql)
        print(sql)
        conn.close()
        return data

    # 导航程序
    def findAllByName(self,page_number=1,page_size=10,params={}):
        # 通用数据库连接
        # 全局接口
        conn = Conn_mysql()
        sql = """select `uuid`,`name`,`snapshot_img_url`,`logo_url`,`url`,`intro`,`create_time`,`create_user`,`update_time`, `update_user`,`delete_flag`, `type`,`group`,`click_num`, `praise_num`,`keyword`
                from seach_knowledge_navigation_map
                where `name` regexp '%s'  limit %d,%d""" % ( params['name'], (page_number - 1) * page_size, page_size)
        res, data = conn.read_sql(sql=sql)
        print(sql)
        conn.close()
        return data

    # 查询分组
    def findGroupList(self):
        # 通用数据库连接
        # 全局接口
        conn = Conn_mysql()
        sql = """select distinct `group`  from seach_knowledge_navigation_map"""
        res, data = conn.read_sql(sql=sql)
        conn.close()
        return data

    # 查询种类
    def findTypeList(self,group):
        # 通用数据库连接
        # 全局接口
        conn = Conn_mysql()
        sql = """select distinct `type` 
         from seach_knowledge_navigation_map
            where `group` ='%s'
         """ % group
        res, data = conn.read_sql(sql=sql)
        conn.close()
        return data

    # 导航程序
    def findOne(self,uuid):
        # 通用数据库连接
        # 全局接口
        conn = Conn_mysql()
        sql = """ update seach_knowledge_navigation_map
                set click_num = click_num+1
                where uuid='%s' """ % uuid
        conn.write_sql(sql=sql)
        conn.close()

        conn = Conn_mysql()
        sql = """select `uuid`,`name`,`snapshot_img_url`,`logo_url`,`url`,`intro`,`create_time`,`create_user`,`update_time`, `update_user`,`delete_flag`, `type`,`group`,`click_num`, `praise_num`,`keyword`
                from seach_knowledge_navigation_map
                where `uuid`='%s' """ % uuid
        res, data = conn.read_sql(sql=sql)
        conn.close()
        return data


    # 点赞
    def updatePraise(self, uuid):
        # 通用数据库连接
        # 全局接口
        conn = Conn_mysql()
        sql = """ 
           update seach_knowledge_navigation_map
            set praise_num = praise_num+1
            where uuid='%s'
           """ % uuid
        res, data = conn.read_sql(sql=sql)
        conn.close()
        return data

    if __name__ == '__main__':
        pass

