@echo off
 ::设置标题文字
 title start-build
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
cd ../danyuan-application-service

mvn clean install

::call start-all.bat

pause