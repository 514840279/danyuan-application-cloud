
# danyuan-application-web-vue-lte

> danyuan-application-web-vue-lte

###################################################
# cordova 安装

npm config --global set registry http://registry.cnpmjs.org
npm install -g cordova

# 创建应用
cordova create hello com.demo.hello hello
cd hello
cordova platform add android --save



## Build Setup

``` bash
# 1. install dependencies
npm install

# dependencies
cnpm install jquery --save
cnpm i bootstrap@3 --save
cnpm install font-awesome --save 
cnpm install admin-lte --save
npm install vuex --save
npm install --save vue-router
npm install --save axios

# 2. serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).



