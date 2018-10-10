<template>
    <!-- template 有且仅有一个子元素-->
    <body  class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">登录用户</p>
                <form >
                   <!--  用户名 -->
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="Full name" v-model="username"  value="test" @keyup="loginkeyup($event)"/> <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <!--  密码 -->
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Password" v-model="password" value="test" @keyup="loginkeyup($event)"/> <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <!--  登录按钮 -->
                    <div class="row">
                        <div class="col-xs-12">
                            <button type="button" class="btn btn-primary btn-block btn-flat" id="submit" @click="login()" @keyup="loginkeyup($event)">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


    </body>
</template>
<script>


var authUrl = 'http://localhost:8800/login'
export default {
    name: "login",
    data:function(){
        return {
            username:"",
            password:""
            
        }
    },
    created:function(){
        // 调用实际加载方法
        this.init();
    },
    mounted:function(){

    },
    methods:{
        init:function(){
            // 初始化加载方法
        },
        login:function(){
            // 登录方法
            var credentials = {
                username:this.username,
                password:this.password
            };
            /*
            post方法提交username和password
            认证成功将返回的用户信息写入到localStorage，并跳转到下一页面
            失败提示认证错误
            */
            this.$axios.post(authUrl,JSON.stringify(credentials)).then(response => {
                localStorage.token = response.data.token
                localStorage.tokenExpired = response.data.tokenExpired
                localStorage.userDisplayName = response.data.displayName
                this.$router.push('/')
            }, response => {
                this.show = true
            })

        },
        loginkeyup:function(e){
            // 回车键按下确认事件
            if(e.keyCode == 13){
                // 调用实际登录方法
                this.login();
            }
       }
    }
}
</script>
<style scoped>

</style>

