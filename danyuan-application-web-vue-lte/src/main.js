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

Vue.prototype.findError=function(result) {
  window.parent.window.alert(JSON.stringify(result));
  // window.parent.window.alert("出错了");
};

Vue.prototype.dateTimeFormatter= function (value, row, index) {
  return new Date(value).toLocaleString();
}


Vue.prototype.getUuid = function() {
  var len = 32; // 32长度
  var radix = 16; // 16进制
  var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
  var uuid = [],
    i;
  radix = radix || chars.length;
  if (len) {
    for (i = 0; i < len; i++)
      uuid[i] = chars[0 | Math.random() * radix];
  } else {
    var r;
    uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
    uuid[14] = '4';
    for (i = 0; i < 36; i++) {
      if (!uuid[i]) {
        r = 0 | Math.random() * 16;
        uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
      }
    }
  }
  return uuid.join('');
}

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

