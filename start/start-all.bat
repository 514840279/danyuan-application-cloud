@echo off
 ::���ñ�������
 title start-all
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


echo ������������ע���뷢�����(Eureka),Ĭ�϶˿ڣ�8761

start  /wait start-eureka.bat 

echo --�ȴ�10s����eureka���
TIMEOUT /T 10

echo ��������ͳһ��½,��Ȩ�������(oAuth2),Ĭ�϶˿ڣ�8761
start  start-oauth2.bat 

echo --�ȴ�10s����OAuth2���
TIMEOUT /T 10

echo --����������������(Getway),Ĭ�϶˿ڣ�82 Ԥ����ʱ10s
start start-getway.bat

echo --����������������(Crawler),Ĭ�϶˿ڣ�8080 Ԥ����ʱ30s
start start-crawler.bat 

echo --����������������(Dbms),Ĭ�϶˿ڣ�8081 Ԥ����ʱ30s
start start-dbms.bat 

echo --����������������(sidecar),Ĭ�϶˿ڣ�9000 Ԥ����ʱ10s
start start-sidecar.bat

echo --����������������(python web),Ĭ�϶˿ڣ�3000 Ԥ����ʱ3s
::start start-python.bat

echo ================================================================================

pause
exit


