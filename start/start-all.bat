@echo off
 echo ================================================================================
 echo 查看环境变量 ：
 echo 	JAVA_HOME=%JAVA_HOME%
 echo 	M2_HOME/MAVEN_HOME=%M2_HOME%%MAVEN_HOME%
 echo/
 echo ------------- 
 echo 当前路径 ：
 echo 	%CD%
 echo/
 echo ================================================================================


echo 正在启动服务注册与发现组件(eureka),默认端口：8761

start  start-eureka.bat 

echo --等待10s启动eureka完成
TIMEOUT /T 10

echo --正在启动启动网关(getway),默认端口：82 预计用时10s
start start-getway.bat

echo --正在启动启动服务(crawler),默认端口：8080 预计用时30s
start start-crawler.bat 

echo --正在启动启动服务(python web),默认端口：3000 预计用时3s
start start-python.bat

echo --正在启动启动服务(sidecar),默认端口：9000 预计用时10s
start start-sidecar.bat

echo ================================================================================

pause
exit


