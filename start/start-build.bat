@echo off
 echo ================================================================================
 echo �鿴�������� ��
 echo 	JAVA_HOME=%JAVA_HOME%
 echo 	M2_HOME/MAVEN_HOME=%M2_HOME%%MAVEN_HOME%
 echo/
 echo ------------- 
 echo ��ǰ·�� ��
 echo 	%CD%
 echo/
 echo ================================================================================
cd ../danyuan-application-service

mvn clean install

::call start-all.bat

pause