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
start  java -jar  -Xms10m -Xmx200m ../danyuan-application-service/danyuan-application-eureka-server/target/danyuan-application-eureka-server.jar

echo --�ȴ�15s����eureka���
TIMEOUT /T 15

echo --����������������(Crawler),Ĭ�϶˿ڣ�8080 Ԥ����ʱ30s
start  java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-serve-provider/danyuan-application-crawler-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-serve-provider/danyuan-application-crawler-server/target/danyuan-application-crawler-server.jar

echo --����������������(Dbms),Ĭ�϶˿ڣ�8081 Ԥ����ʱ30s
start  java  -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-serve-provider/danyuan-application-dbms-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-serve-provider/danyuan-application-dbms-server/target/danyuan-application-dbms-server.jar

echo --����������������(sidecar),Ĭ�϶˿ڣ�9000 Ԥ����ʱ10s
start  java  -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-sidecar-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-sidecar-server/target/danyuan-application-sidecar-server.jar 

echo --����������������(python web),Ĭ�϶˿ڣ�3000 Ԥ����ʱ3s
start  python ../danyuan-application-crawler-python/web.py

echo ��������ͳһ��½,��Ȩ�������(oAuth2),Ĭ�϶˿ڣ�8761
start  java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-oauth2-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-oauth2-server/target/danyuan-application-oauth2-server.jar 

echo --�ȴ�15s����OAuth2���
TIMEOUT /T 15

echo --����������������(zuul),Ĭ�϶˿ڣ�82 Ԥ����ʱ10s
start java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-zuul-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-zuul-server/target/danyuan-application-zuul-server.jar 

echo ================================================================================

pause
exit


