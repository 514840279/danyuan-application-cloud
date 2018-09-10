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
[import](../../../start/start-all.bat)
###### start-crawler
[import](../../../start/start-crawler.bat)
###### start-eureka
[import](../../../start/start-eureka.bat)
###### start-getway
[import](../../../start/start-getway.bat)

