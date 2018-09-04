<template>
  <div id="app">
    
    <mainHeader/>
    
    <mainSidebar/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" id="mainDiv">
      <router-view/>
      <div id="tabContainer"></div>
      <!-- 			<div id="tab_content"></div> -->
    </div>
    <!-- /.content-wrapper -->

    <mainFooter/>


    <controlSidebar/>

   
  </div>
</template>

<script>
import mainHeader from "./components/mainHeader"
import mainFooter from "./components/mainFooter"
import controlSidebar from "./components/controlSidebar"
import mainSidebar from "./components/mainSidebar"


export default {
  name: 'App',
  
  methods:{
    
  },
  components:{
    mainHeader,mainFooter,mainSidebar,controlSidebar
  }
}

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
