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
cd ../danyuan-application-service

mvn clean install

::call start-all.bat

pause