# java

###### 下载
java 开发机器上一定要选择jdk 版本的

java [官网](https://www.oracle.com/technetwork/java/javase/downloads/index.html) [下载 10.0.2](http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_windows-x64_bin.exe)


###### 安装
java 安装比较简单，下一步，下一步安装

![双击执行](https://upload-images.jianshu.io/upload_images/2787821-8a8bcb4bbef73ed7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![下一步](https://upload-images.jianshu.io/upload_images/2787821-fcd1431c198b7ea8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![下一步](https://upload-images.jianshu.io/upload_images/2787821-7c6f03118b97d392.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![jdk安装中](https://upload-images.jianshu.io/upload_images/2787821-c6067bfb18fee7b3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![安装jre](https://upload-images.jianshu.io/upload_images/2787821-f4bad257e503494b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![jre安装中](https://upload-images.jianshu.io/upload_images/2787821-76b7e3adeb429d0d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![安装完](https://upload-images.jianshu.io/upload_images/2787821-c361a803135af8d3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###### 环境配置
安装好后记得一定要手动设置一下环境变量

|变量名|变量值|
|---------|---------|
|JAVA_HOME|C:\Program Files\Java\jdk-10.0.2|
|CLASSPATH|.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar |
|path|%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;|

大功告成 现在启动cmd窗口键入 java -version 查看
![版本10.0.2](https://upload-images.jianshu.io/upload_images/2787821-dba1236a0b4f2238.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

