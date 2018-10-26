if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
java -jar  -Xms10m -Xmx200m ../danyuan-application-service/danyuan-application-eureka-server/target/danyuan-application-eureka-server.jar