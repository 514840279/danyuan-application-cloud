@echo off
 ::设置标题文字
 title start-all
 ::设置背景黑色，字体浅绿色
 color 0A
 echo ================================================================================
 echo 查看环境变量 ：
 echo 	JAVA_HOME=%JAVA_HOME%
 echo 	M2_HOME/MAVEN_HOME=%M2_HOME%%MAVEN_HOME%
 echo 	python=%python3%%python%%Anaconda3%
 echo/
 echo ------------- 
 echo 当前路径 ：
 echo 	%CD%
 echo/
 echo ================================================================================


echo 正在启动服务注册与发现组件(Eureka),默认端口：8761

start  /wait start-eureka.bat 

echo --等待10s启动eureka完成
TIMEOUT /T 10

echo --正在启动启动服务(Crawler),默认端口：8080 预计用时30s
start start-crawler.bat 

echo --正在启动启动服务(Dbms),默认端口：8081 预计用时30s
start start-dbms.bat 

echo --正在启动启动服务(sidecar),默认端口：9000 预计用时10s
start start-sidecar.bat

echo --正在启动启动服务(python web),默认端口：3000 预计用时3s
::start start-python.bat

echo 正在启动统一登陆,鉴权中心组件(oAuth2),默认端口：8761
start  start-oauth2.bat 

echo --等待10s启动OAuth2完成
TIMEOUT /T 10

echo --正在启动启动网关(zuul),默认端口：82 预计用时10s
start start-zuul.bat

echo ================================================================================

pause
exit


