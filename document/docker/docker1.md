# 环境搭建
今天想起来学习docker就顺便记下笔记，

学习第一步就是环境搭建，

使用Linux7搭建很简单

以下是命令

安装

    yum -y install docker

查看安装的版本

    docker --version

测试

    docker run hello-world

这时无论如何都不会成功 因为国内有墙

这时需要一个国内的镜像库 或者直接翻墙

我用的daocloud的免费加速服务 其实就是一个计算你流量的镜像库，他需要你去注册他的服务然后提供一个地址给你，

daocloud 官网 


点击加速器



根据系统选择
详细的配置方法有文档介绍

使用crul 注册到你的 systemctl 文件 这时会提示你重启 systemctl 使生效

重启后 执行

    docker run hello-world

提示成功

至此环境一切OK 可以下一步学习了



如果是win7  或者 win10 请下载  官网的软件  通用配置加速 详细参照 daocloud 文档



-- 镜像加速 windos docker tools 方法

    docker-machine ssh default

    sudo sed -i "s|EXTRA_ARGS='|EXTRA_ARGS='--registry-mirror=http://dcfc451e.m.daocloud.io |g" /var/lib/boot2docker/profile

    exit

    docker-machine restart default

注意： http://dcfc451e.m.daocloud.io 是在daoclould 上注册的加速器