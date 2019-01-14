#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from common.inc_conn import Conn_mysql


# 网站 查询，修改，状态，计算采集情况
class SysCrawlerTaskInfo():

    #  初始化 实例一个数据库连接
    def __init__(self):
        self.conn = Conn_mysql()
        pass

    # 更新任务表完成
    def updateTaskInfo(self,uuid,status,surplus):
        sql = '''
            update sys_crawler_task_info
            set home_statue ='%s',
            surplus_num=surplus_num+%d,
            success_num=success_num+1
            where uuid='%s'
        ''' % (status,surplus,uuid)
        print(sql)
        self.conn.write_sql(sql)
        self.conn.close()

    # 更新采集完页面 计算数量
    def updateTimeAndSlusAndSuccess(self,uuid):
        pass

    #  更新错误信息，并记录错误 日志
    def updateStatusError(self,uuid,group,url,error_code,error_msg):
        pass

    if __name__ == '__main__':
        pass

# 网站页面类型规则查询
class SysCrawlerGroupInfo():

    # 初始化 实例一个数据库连接
    def __init__(self):
        self.conn = Conn_mysql()
        self.requestConn = 0

    # 查询
    def findAllByTaskId(self,uuid):
        groupsql = '''
            select * from sys_crawler_ruler_info r
            where r.task_uuid='%s'
        ''' % uuid
        res, groupdata = self.conn.read_sql(groupsql)
        return groupdata

    # 查询
    def findAllByTaskIdAndGroup(self, uuid,groupid):
        ## 数据提取参数获取 ##############
        groupsql = '''
            select * from sys_crawler_ruler_info r
            where r.task_uuid='%s'
            and r.parent_uuid = '%s'
        ''' % (uuid,groupid)
        res, groupdata = self.conn.read_sql(groupsql)
        return groupdata

    # 查询
    def findOne(self, uuid):
        ## 数据提取参数获取 ##############
        groupsql = '''
            select * from sys_crawler_ruler_info r
            where r.uuid = '%s'
        ''' % (uuid)
        res, groupdata = self.conn.read_sql(groupsql)
        return groupdata[0]

    # TODO 更新任务表完成
    def updateGroupInfo(self,groupid, uuid, status, surplus):
        # 更新任务 状态完成
        sql = '''
            update sys_crawler_ruler_info
            set statue ='%s'
            where uuid='%s'
        ''' % (status,groupid)
        print(sql)
        self.conn.write_sql(sql)
        self.conn.close()

        # 更新表组表状态 完成
        sysCrawlerTaskInfo = SysCrawlerTaskInfo()
        sysCrawlerTaskInfo.updateTaskInfo(uuid,status, surplus)


    if __name__ == '__main__':
        pass

# 详细分析提取的数据规则查询
class SysCrawlerCloumnInfo():

    # 初始化 实例一个数据库连接
    def __init__(self):
        self.conn = Conn_mysql()
        pass

    # 查询
    def findAll(self,group):
        columnsql = '''
           select * from sys_crawler_ruler_colum_info c
           where c.ruler_uuid = '%s'
        ''' % group['uuid']
        ress, columndata = self.conn.read_sql(columnsql)
        return  columndata

    if __name__ == '__main__':
        pass

# 映射关系 表查询
class SysCrawlerMappedTableOfColumnInfo():

    # 查询表配置信息映射关系
    def findCondata(self,group):
        sql = '''
            select r.*,t.tabs_name from sys_crawler_result_ruler_info r
            inner join sys_dbms_tabs_info t on r.table_uuid = t.uuid
            where ruler_uuid='%s'
        ''' % group['uuid']
        print(sql)
        res, condata = self.conn.read_sql(sql)
        self.conn.close()
        return condata

    # 查询
    def findAll(self,group):
        pass

    # 初始化 实例一个数据库连接
    def __init__(self):
        self.conn = Conn_mysql()
        pass

    if __name__ == '__main__':
        pass

# 结果数据录错误信息
class CrawlerResults():

    # 初始化 实例一个数据库连接
    def __init__(self):
        self.conn = Conn_mysql()

    # 修改结果采集的状态完成
    def instertItems(self,condata,rows):
        insertsql = '''insert into %s (''' % condata[0]['tabs_name']

        for i in range(len(condata)):
            if (i > 0):
                insertsql = insertsql + ','
            insertsql = insertsql + condata[i]['cols_name']
        insertsql = insertsql + ") values("

        instconn = Conn_mysql()
        for item in rows:
            insertsqlval = "'"
            for i in range(len(condata)):
                if (i > 0):
                    insertsqlval = insertsqlval + "','"
                for data in item:
                    if (data[0] == condata[i]['ruler_colum_name']):
                        val = data[1]
                        if (type(val).__name__ == 'list' and len(val) == 0):
                            pass
                        elif (type(val).__name__ == 'list' and len(val) > 0):
                            insertsqlval = insertsqlval + str(val).replace("'", "").replace("[", "").replace("]", "")
                        elif (type(val).__name__ == 'string'):
                            insertsqlval = insertsqlval + val.replace("'", "")
            insertsqlval = insertsqlval + "'"
            insettemsql = insertsql + insertsqlval + ")"
            print(insettemsql)
            instconn.write_sql(insettemsql)


    def get_navigation_List(self,group):
        sysCrawlerMappedTableOfColumnInfo = SysCrawlerMappedTableOfColumnInfo()
        condata = sysCrawlerMappedTableOfColumnInfo.findCondata(group)
        sql = """
            select * from %s 
        """ % condata[0]['tabs_name']
        res,data = self.conn.read_sql(sql=sql)
        return data


    if __name__ == '__main__':
        pass