# Windows下MySQL的主从热备

本配置方法适用于5.1之后的版本，个人在5.5上配置成功（5.1之前版本请参考另外的配置说明）
 环境说明：
Master：192.168.1.200
Slave：192.168.1.210
 
MySQL 的 Master 配置：
配置my.ini：
 
[mysqld]

    # The TCP/IP Port the MySQL Server will listen on
    port=3306
    server-id=200
    # replicate-do-db = NearbyPeople
    log-bin=mysql-bin
    relay-log=relay-bin
    binlog-bin-db= NearbyPeople
    relay-log-index=relay-bin-index
    replicate_wild_do_table= NearbyPeople.%  
    
    # replicate_wild_do_table= NearbyPeople.%  
    # replicate_wild_do_table=lmis.%  


*配置好后，重启Master 的 MySQL服务！！！ 

    service mysqld restart

授权 ：

    flush privileges;   #刷新系统授权表
    grant replication slave  on NearbyPeople.* to ' root '@'1.13.239.14' identified by ' root' with grant option;  #授权用户xkhz只能从192.168.21.129这个IP访问主服务器192.168.21.128上面的数据库，并且只具有数据库备份的权限




//--------------------------------------------------
MySQL 的 Slave 配置：
配置my.ini：
 
[mysqld]

    # The TCP/IP Port the MySQL Server will listen on
    port=3306
    server-id = 210
    replicate-do-db = NearbyPeople
    slave-skip-errors = 1062 
    #slave-skip-errors=1062,1053,1146 #跳过指定error no类型的错误
    #slave-skip-errors=all #跳过所有错误
 
*配置好后，重启Slave 的 MySQL服务！！！
//--------------------------------------------------
 
登录Slave，然后执行下面命令：
 
    stop slave;
    change master to master_host='101.200.233.241',master_user='xkhz',master_password='Xkhz%^#', master_port=17215, master_log_file='mysql-bin.000001',master_log_pos=57361018;
    start slave;
    show slave status;
 
查看这两项是否为YES，yes为正常。

    Slave_IO_Running: Yes
    Slave_SQL_Running: Yes



    slave stop;
    set GLOBAL SQL_SLAVE_SKIP_COUNTER=1;
    slave start;
