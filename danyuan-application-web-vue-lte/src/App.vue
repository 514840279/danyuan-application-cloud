<template>
  <router-view/>
</template>

<script>

import loginPath from "./components/login/login"

export default {
  name: 'App',
  
  methods:{
    
  },
  components:{
    loginPath
  },
  created:function(){
    this.$router.push('/')
    //this.$router.push('loginPath')
  }
}

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin: 0px;
  padding: 0px;
}

</style>
