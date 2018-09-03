import Vue from 'vue'
import Router from 'vue-router'
import AddrIndex from '@/components/dbms/addr/index'

Vue.use(Router)

export default new Router({
  routes: [
     {
      path: '/addrIndexPath',
      name: 'addrIndex',
      component: AddrIndex
    }
  ]
})
