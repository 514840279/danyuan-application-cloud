if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-serve-provider/danyuan-application-crawler-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-serve-provider/danyuan-application-crawler-server/target/danyuan-application-crawler-server.jar