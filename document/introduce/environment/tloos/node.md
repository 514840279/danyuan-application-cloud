# node

node 安装十分简单，一般就是下一步，下一步
###### 下载
[下载 v8.11.4-x64](https://nodejs.org/dist/v8.11.4/node-v8.11.4-x64.msi)
[官网](https://nodejs.org/zh-cn/)
![node下载](https://upload-images.jianshu.io/upload_images/2787821-3deb9b26423ccb64.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
node比较势力只支持x64的版本
###### 安装
![启动](https://upload-images.jianshu.io/upload_images/2787821-fb7382724ab28818.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![运行](https://upload-images.jianshu.io/upload_images/2787821-65ab8b385d805afa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![next](https://upload-images.jianshu.io/upload_images/2787821-f25f1fbcb791325a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![next](https://upload-images.jianshu.io/upload_images/2787821-7bb294899ed128a8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![next](https://upload-images.jianshu.io/upload_images/2787821-ed856060e21c3baa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![next](https://upload-images.jianshu.io/upload_images/2787821-a89dcac32e7ce639.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![next](https://upload-images.jianshu.io/upload_images/2787821-ba0037dfdebdcbdc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![安装中](https://upload-images.jianshu.io/upload_images/2787821-ae60fd39a00dc82a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![安装完成](https://upload-images.jianshu.io/upload_images/2787821-dcceb6274184d6cb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

打开 Node.js command 键入 
  1. node -v
  2. npm -v
![查看版本](https://upload-images.jianshu.io/upload_images/2787821-fba50b20f89d3137.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


###### 加速 
设置淘宝 NPM 镜像

    npm install -g cnpm --registry=https://registry.npm.taobao.org


###### 工具安装
    ### ionic安装
        cnpm install -g cordova ionic

        ionic start myApp tabs
        cd myApp
        ionic serve
        http://localhost:8100

    ### axios    
        cnpm install -g axios

    ### vue
        # 全局安装 vue-cli
        cnpm install --global vue-cli
        # 创建一个基于 webpack 模板的新项目
        vue init webpack my-project
        cd my-project
        npm install
        npm run dev
    
    ###  gitbook
        cnpm install -g gitbook

    ###  cordova6
        cnpm install -g cordova@6.0.0
        cordova create MyApp
        cd MyApp
        # cordova platform add browser
        cordova platform add android
        cordova platform ls
        cordova requirements
        # 注意：检查需要 jdk1.8 且不能升级，android需要api 23，同时gradle 默认2.2.1 不能修改
        cordova build android
        # 打包并签名
        cordova run android --release -- --keystore=../my-release-key.keystore --storePassword=password --alias=alias_name --password=password.
