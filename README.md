# danyuan-application(C版)

[![GitHub issues](https://img.shields.io/github/issues/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/issues)[![GitHub forks](https://img.shields.io/github/forks/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/network)[![GitHub stars](https://img.shields.io/github/stars/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/stargazers)[![GitHub license](https://img.shields.io/github/license/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/blob/master/LICENSE)[![Twitter](https://img.shields.io/twitter/url/https/github.com/514840279/danyuan-application.svg?style=social&style=plastic)](https://twitter.com/intent/tweet?text=Wow:&url=https%3A%2F%2Fgithub.com%2F514840279%2Fdanyuan-application)

## 系统采用技术或开源框架：

1. 前端框架：vue
2. 前端模板：adminLTE
3. 前端技术：bootstrap,bootstrap-table,js,juqery,ajax,ztree,...
4. 后端技术：spring-cloud
5. 数据库: mysql
6. 其他工具：maven

## 项目启动配置:

1. 系统安装jdk1.8，mysql5.7，maven3.3

2. 新建数据库:application

3. 导入数据库脚本 sql/All.sql

4. 启动服务端：
  1. danyuan-application-eureka-server  
  2. danyuan-application-crawler-server
  3. danyuan-application-getway-server
  
5. 需要修改启动配置nginx 监听服务端口81 改代理端口82
	 server {
        listen       81;
        server_name  localhost;
        location / {
            root   html;
            index  index.html index.htm;
			proxy_redirect off;
			proxy_set_header Host $host;
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			proxy_pass http://localhost:82;
        }  
6. 启动客户端；
  客户端是由node创建的vue框架，所以需要使用node运行
  cd   danyuan-application-web-vue-lte
  npm run dev

  

## 演示地址
http://www.danyuan.wang/#

