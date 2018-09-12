# nginx

nginx 是一种服务器，作为反向代理方面也是绝无仅有的优势，而作为服务器它的优势就是一个字快。
nginx 的 安装主要分为 两步 安装和配置，配置需要有一定了解nginx 

###### 下载
 nginx [下载](http://nginx.org/download/nginx-1.15.3.zip) [官网](http://nginx.org/en/download.html)
###### 安装
安装方法其实很简单，解压就可以了无需任何配置

![image.png](https://upload-images.jianshu.io/upload_images/2787821-c7dfef9940e04318.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/2787821-629427d7b804c387.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/2787821-c60bbd87aa38087a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

ok 现在nginx 已经安装完成

###### 配置
1. 环境配置
nginx 启动可以双击 nginx.exe执行也可以 命令行中 执行 nginx start/stop.为了方便可以将exe加入环境变量中

![软件](https://upload-images.jianshu.io/upload_images/2787821-dd87470e3f39fbda.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

设置环境变量

|变量名|变量值|
|---------|---------|
|NGINX_HOME|F:\tools\nginx-1.15.3|
|path|%NGINX_HOME%;|

cmd >  nginx -v

![image.png](https://upload-images.jianshu.io/upload_images/2787821-98ed6d924f3adf18.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2. 软件配置
这里要修改nginx.conf
文件位于conf 中

![image.png](https://upload-images.jianshu.io/upload_images/2787821-db2b8deb47d19979.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

以下是修改后端内容

```

#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #access_log  logs/access.log  main;

    sendfile        on;
	
	#将tcp_nopush和tcp_nodelay两个指令设置为on用于防止网络阻塞
    tcp_nopush      on;
    tcp_nodelay     on;

	#连接超时时间
    #keepalive_timeout  0;
    keepalive_timeout  65;

	#开启gzip压缩
    gzip  on;
	gzip_disable "MSIE [1-6]\.(?!.*SV1)";
	
	# 反向代理服务器列表
	upstream mysvr {
        #weigth参数表示权值，权值越高被分配到的几率越大
        #本机上的Squid开启3128端口
        server localhost:82 weight=5;
        server 192.168.0.98:85  weight=10;
        server 192.168.8.3:80  weight=6;
    }
    server {
        listen       81;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html;
            index  index.html index.htm;
			proxy_redirect off;
			proxy_set_header Host $host;  #后端的Web服务器可以通过X-Forwarded-For获取用户真实IP
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			proxy_pass  http://mysvr;#请求转向mysvr 定义的服务器列表
			
			client_max_body_size 100m;    #允许客户端请求的最大单文件字节数
            client_body_buffer_size 128k;  #缓冲区代理缓冲用户端请求的最大字节数，
            #proxy_connect_timeout 90;  #nginx跟后端服务器连接超时时间(代理连接超时)
            #proxy_send_timeout 90;        #后端服务器数据回传时间(代理发送超时)
            #proxy_read_timeout 90;         #连接成功后，后端服务器响应时间(代理接收超时)
            proxy_buffer_size 4k;             #设置代理服务器（nginx）保存用户头信息的缓冲区大小
            proxy_buffers 4 32k;               #proxy_buffers缓冲区，网页平均在32k以下的话，这样设置
            proxy_busy_buffers_size 64k;    #高负荷下缓冲大小（proxy_buffers*2）
            proxy_temp_file_write_size 64k;  #设定缓存文件夹大小，大于这个值，将从upstream服务器传
        }

        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}
```