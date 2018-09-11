# maven

maven 的安装及其简单，解压，配置环境，大功告成

###### 下载
maven [下载 3.5.4](http://mirrors.hust.edu.cn/apache/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.zip)
如果下载不了，请访问[官网](http://maven.apache.org/download.cgi) 

![点击下载](https://upload-images.jianshu.io/upload_images/2787821-0d2874acc2169701.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###### 安装
在windows 中新建一个文件夹 起名 tools
解压下载下来的压缩包到tools下就完成了安装

![解压](https://upload-images.jianshu.io/upload_images/2787821-a4d79160297ba754.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###### 环境配置
环境配置分两步
1. 配置环境变量


|变量名|变量值|
|---------|---------|
|MAVEN_HOME|F:\tools\apache-maven-3.5.4|
|path|%MAVEN_HOME%\bin;|

2. 设置settings
settings 中主要修改三处内容
  
找到settings 文件位于 MAVEN_HOME 下的conf文件夹中

![settings](https://upload-images.jianshu.io/upload_images/2787821-d4369824e2591cb5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

复制文件到 用户路径下.m2 文件夹下

如何找到 用户路径： win键+R 》 %userprofile%

打开的窗口就是用户路径

![win+R](https://upload-images.jianshu.io/upload_images/2787821-6b9d2502a29a9a63.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

找到 .m2文件夹，注意.m2是隐藏文件需要修改文件夹与搜索选项

![image.png](https://upload-images.jianshu.io/upload_images/2787821-933ae6081079aadc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![选中显示隐藏的文件](https://upload-images.jianshu.io/upload_images/2787821-ed13b0e333462926.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

这时如果还没有找到.m2文件夹就手动创建一个
![m2](https://upload-images.jianshu.io/upload_images/2787821-5b6fc1ae6f6f661b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

将settings 复制到.m2中

![复制一份](https://upload-images.jianshu.io/upload_images/2787821-0d3db3ca25256b52.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

然后用文本编辑器修改
一共修改三处
![第一处指定本地jar包存放位置](https://upload-images.jianshu.io/upload_images/2787821-17bad536173e87af.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![第二处指定从哪里下载jar](https://upload-images.jianshu.io/upload_images/2787821-73597546b4f8f503.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
这里mirror 是指定的本地搭建的nexus路径，如果你没有搭建nexus私服，可以指定阿里maven仓库

![下载源码，和doc](https://upload-images.jianshu.io/upload_images/2787821-8d9b3365e0bde678.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

这里profile 可以不用修改，这段代码代表是否同时下载源码和javadoc

最后测试一下，找到项目右键打开命令窗口
![image.png](https://upload-images.jianshu.io/upload_images/2787821-f983b87ccea9ac70.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

键入 mvn -v

![image.png](https://upload-images.jianshu.io/upload_images/2787821-4c6615d164ea1ce7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

键入 mvn clean

![image.png](https://upload-images.jianshu.io/upload_images/2787821-f983eebf8e1ed528.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

大功告成