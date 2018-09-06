# danyuan-application(C版)

[![GitHub issues](https://img.shields.io/github/issues/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/issues)[![GitHub forks](https://img.shields.io/github/forks/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/network)[![GitHub stars](https://img.shields.io/github/stars/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/stargazers)[![GitHub license](https://img.shields.io/github/license/514840279/danyuan-application.svg?style=plastic)](https://github.com/514840279/danyuan-application/blob/master/LICENSE)[![Twitter](https://img.shields.io/twitter/url/https/github.com/514840279/danyuan-application.svg?style=social&style=plastic)](https://twitter.com/intent/tweet?text=Wow:&url=https%3A%2F%2Fgithub.com%2F514840279%2Fdanyuan-application)

## 系统采用技术或开源框架：

1. 前端模板：adminLTE
2. 前端技术：vue
3. 后端技术：spring-cloud,nginx,maven,node...
4. 数据库: mysql
5. 其他工具：sts,vscode

## 项目启动配置:

1. 系统安装jdk1.8，mysql5.7，maven3.3 node ,nginx,sts,vscode

2. 新建数据库:application

3. 导入数据库脚本 sql/AllForC.sql

4. 需要修改启动配置nginx 监听服务端口81 改代理端口82 ，有示例模板（design/nginx.conf）

  ```
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
  ```

5. 启动服务端：
       1. 执行 start/start-build.bat  
       2. 执行 start/start-all.bat 

6. 启动客户端；
     客户端是由node创建的vue框架，所以需要使用node运行 
     ```bash
     	cd   danyuan-application-web-vue-lte
     ```
     1. install dependencies
     ```bash
     	npm install
     	#npm install --save vue-router
     	#npm install --save axios
     ```
     2. serve with hot reload at localhost:80
     ```bash
     	npm run dev
     ```

     3. http://localhost

