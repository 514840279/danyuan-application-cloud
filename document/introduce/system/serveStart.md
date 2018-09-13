# 服务启动

服务启动主要介绍微服务的启动，启动主要有两种方式，命令行和工具（主要是sts中）
[快速启动](https://514840279.gitbooks.io/danyuan/content/)章节中已经介绍过如何启动本系统，这章节中主要介绍启动命令，以及sts工具中使用的方式

###### 命令行启动
在windows 中打开service目录

![进入项目service路径](https://upload-images.jianshu.io/upload_images/2787821-17e6812366040d30.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

shift + 右键打开

![选择命令窗口](https://upload-images.jianshu.io/upload_images/2787821-79376b54b408f0ac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![打开窗口](https://upload-images.jianshu.io/upload_images/2787821-a75f5f4f89f64e9d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

首先键入 mvn clean install 

![install](https://upload-images.jianshu.io/upload_images/2787821-0298d152e739bb41.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![success](https://upload-images.jianshu.io/upload_images/2787821-58b9a39cbd8d0692.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

当执行完时就可以 启动了
键入 
    
    java - jar  danyuan-application-eureka-server\target\danyuan-application-eureka-server.jar
    java - jar  danyuan-application-getway-server\target\danyuan-application-getway-server.jar
    java - jar  danyuan-application-crawler-server\target\danyuan-application-crawler-server.jar
如此系统就启动起来了

###### sts方式启动程序
启动sts 首先导入 程序 参照 [环境搭建](https://514840279.gitbooks.io/danyuan/content/introduce/environment/%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA.html#%E5%90%8E%E5%8F%B0%E6%9C%8D%E5%8A%A1)

![启动sts](https://upload-images.jianshu.io/upload_images/2787821-979ee70c2108675e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

可以看到左侧部分被分成两块，上面部分展示的项目和包结构，下面是服务器配置，点开boot dashhoard 看到各微服务的快速启动，依次启动
     eureka 》getway 》 crawler 
完成sts中程序的启动
