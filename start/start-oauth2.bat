@echo off
 set _title=start-oauth2
 ::设置标题文字
 title %_title%
 ::设置背景黑色，字体浅绿色
 color 0A
 copy "%JAVA_HOME%\bin\java.exe"  "%JAVA_HOME%\bin\%_title%.exe"
 set _RUNJAVA="%JAVA_HOME%\bin\%_title%"
 echo ================================================================================
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
%_RUNJAVA% -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-oauth2-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-oauth2-server/target/danyuan-application-oauth2-server.jar 