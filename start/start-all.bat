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


echo ������������ע���뷢�����(eureka),Ĭ�϶˿ڣ�8761

start  start-eureka.bat 

echo --�ȴ�10s����eureka���
TIMEOUT /T 10

echo --����������������(getway),Ĭ�϶˿ڣ�82 Ԥ����ʱ10s
start start-getway.bat

echo --����������������(crawler),Ĭ�϶˿ڣ�8080 Ԥ����ʱ30s
start start-crawler.bat 

echo ================================================================================

pause
exit


