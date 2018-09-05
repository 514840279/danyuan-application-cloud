if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-getway-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-getway-server/target/danyuan-application-getway-server.jar 