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


echo 正在启动服务注册与发现组件，默认端口：8761

start start-eureka.bat

echo --
TIMEOUT /T 10

start start-crawler.bat

start start-getway.bat

pause
