@echo off
 ::���ñ�������
 title start-build
 ::���ñ�����ɫ������ǳ��ɫ
 color 0A
 echo ================================================================================
 echo �鿴�������� ��
 echo 	JAVA_HOME=%JAVA_HOME%
 echo 	M2_HOME/MAVEN_HOME=%M2_HOME%%MAVEN_HOME%
 echo 	python=%python3%%python%%Anaconda3%
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