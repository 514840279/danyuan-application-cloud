import Vue from 'vue'
import Router from 'vue-router'
import AddrIndex from '@/components/dbms/addrIndex'
import TypeIndex from '@/components/dbms/typeIndex'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/addrIndexPath',
      name: 'addrIndex',
      component: AddrIndex
    }, {
      path: '/typeIndexPath',
      name: 'typeIndex',
      component: TypeIndex
    }
  ]
})
