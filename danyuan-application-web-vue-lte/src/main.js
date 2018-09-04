// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Axios from 'axios'

// 全局参数设置
Vue.prototype.$axios = Axios
Vue.prototype.baseURL = "http://localhost:81";
Vue.config.productionTip = false

/** 全局默认配置 */
Axios.defaults.baseURL="http://localhost:81";
Axios.defaults.headers.post['Content-Type']='application/x-www-form-urlencoded';

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { 
    App 
  },
  template: '<App/>',
  //这里可以用created或mounted
  // created 模板渲染成html前
  // mounted 模板渲染成html后，
  created:function(){

  },
  mounted:function() {
    this.submitForm()
  },
  methods: {
    submitForm() {     
      
     
    }
  }
})

