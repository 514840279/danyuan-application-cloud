 -- （1） 调整错误    Packet for query is too large (1120 > 1024). You can change this value on the server by setting the max_allowed_packet' variable.
 -- 查看
 show VARIABLES like '%max_allowed_packet%';
 -- 设置
 set global max_allowed_packet = 2*1024*1024*10;
 -- 重启数据库
 -- 再次查看
  show VARIABLES like '%max_allowed_packet%';
  
  
  