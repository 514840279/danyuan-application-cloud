# start java

1. 了解java 的人都知道 java 启动通过-jar方式： java -jar XXX.jar
尤其是springboot的项目经常会用到这个命令，于是我做了一些整理，对于微服务拥有多个jar包的这种
分别对每个服务编写了一个bat程序，指定了内纯大小，指定了外部的application.properties
2. 为了防止微服务变多后启动麻烦，又统一使用 start 来启动,这样只需要只行all 就启动所有的服务，
3. linux有nohub守护进程进行执行，windons没有，于是就考虑了隐藏窗口，这样感觉一样后台执行的

```
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
```
上面三句在bat中头部执行表示隐藏黑窗口

start xxx.bat 可以调用执行其他的bat脚本

###### start-all
``` bash
@echo off
 echo ================================================================================
 echo 查看环境变量 ：
 echo 	JAVA_HOME=%JAVA_HOME%
 echo 	M2_HOME/MAVEN_HOME=%M2_HOME%%MAVEN_HOME%
 echo/
 echo ------------- 
 echo 当前路径 ：
 echo 	%CD%
 echo/
 echo ================================================================================


echo 正在启动服务注册与发现组件(eureka),默认端口：8761

start  start-eureka.bat 

echo --等待10s启动eureka完成
TIMEOUT /T 10

echo --正在启动启动网关(getway),默认端口：82 预计用时10s
start start-getway.bat

echo --正在启动启动服务(crawler),默认端口：8080 预计用时30s
start start-crawler.bat 

echo ================================================================================

pause
exit



 ``` 
###### start-crawler
``` bash
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-crawler-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-crawler-server/target/danyuan-application-crawler-server.jar
```
###### start-eureka
``` bash
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
java -jar  -Xms10m -Xmx200m ../danyuan-application-service/danyuan-application-eureka-server/target/danyuan-application-eureka-server.jar
```
###### start-getway
``` bash
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
java -jar  -Xms10m -Xmx200m -Dspring.config.location=../danyuan-application-service/danyuan-application-getway-server/src/main/resources/application.yml ../danyuan-application-service/danyuan-application-getway-server/target/danyuan-application-getway-server.jar 

```

