<template>
    <!-- template 有且仅有一个子元素-->
    <div id="app">
        <!-- 登录判断 -->
        <div v-show="!showFlag">
            <login/>

        </div>
         <!-- 主要内容 -->
        <div v-show="showFlag">
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
   

    </div>
</template>
<script>
import mainHeader from "@/components/mainHeader"
import mainFooter from "@/components/mainFooter"
import controlSidebar from "@/components/controlSidebar"
import mainSidebar from "@/components/mainSidebar"
import login from "@/components/login"

export default {
    name: "test",
    data:function(){
        return {
            showFlag:this.$store.state.showFlag
        }
    },
    components:{
        mainHeader,mainFooter,mainSidebar,controlSidebar,login
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

