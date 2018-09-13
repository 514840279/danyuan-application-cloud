# oracle linux 7以下 关闭防火墙
重启后生效：
   
    开启： chkconfig iptables on
    关闭： chkconfig iptables off

即时生效，重启后失效：
   
    开启：service iptables start
    关闭：service iptables stop

![image.png](http://upload-images.jianshu.io/upload_images/2787821-f7166dfe770d881e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


 #Linux 7 关闭、禁用防火墙服务
1 查看防火墙状态

    [root@lvxinghao ~]# **systemctl status firewalld**
![image](http://upload-images.jianshu.io/upload_images/2787821-f5151583d1008bcc.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2 查看开机是否启动防火墙服务
    
    [root@lvxinghao ~]# **systemctl is-enabled firewalld**
![image](http://upload-images.jianshu.io/upload_images/2787821-6c7419d37ccc9a4a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

3 关闭防火墙
    
    [root@lvxinghao ~]# **systemctl stop firewalld**
    [root@lvxinghao ~]#** systemctl status firewalld**
![image](http://upload-images.jianshu.io/upload_images/2787821-a9651d95a09ac26d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

4 禁用防火墙（系统启动时不启动防火墙服务）
   
    [root@lvxinghao ~]# **systemctl disable firewalld**
    [root@lvxinghao ~]# **systemctl is-enabled firewalld**
![image](http://upload-images.jianshu.io/upload_images/2787821-641de6ae44a00f22.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

