<template>
    <!-- template 有且仅有一个子元素-->
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
import mainHeader from "@/components/mainHeader"
import mainFooter from "@/components/mainFooter"
import controlSidebar from "@/components/controlSidebar"
import mainSidebar from "@/components/mainSidebar"

export default {
    name: "test",
    data:function(){
        return {

        }
    },
    components:{
        mainHeader,mainFooter,mainSidebar,controlSidebar
    },
    created:function(){
        this.init();
    },
    mounted:function(){

    },
    methods:{
        init:function(){

        }
    }
}
</script>
<style scoped>

</style>

