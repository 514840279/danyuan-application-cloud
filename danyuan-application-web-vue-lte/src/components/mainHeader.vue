<template>
    <div>
        <header class="main-header">
        
            <!-- Logo -->
            <a href="index.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">
                <b>DY</b>
            </span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">
                <b>初学者</b>
            </span>
            </a>
        
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
            
            <ul class="nav navbar-nav">

                <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-envelope-o"></i>
                    <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 4 messages</li>
                    <li>

                    <ul class="menu">

                    </ul>
                    </li>
                    <li class="footer">
                    <a href="#">See All Messages</a>
                    </li>
                </ul>
                </li>

                <li class="dropdown notifications-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-bell-o"></i>
                    <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 10 notifications</li>
                    <li>

                    <ul class="menu">

                    </ul>
                    </li>
                    <li class="footer">
                    <a href="#">View all</a>
                    </li>
                </ul>
                </li>

                <li class="dropdown tasks-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-flag-o"></i>
                    <span class="label label-danger">9</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 9 tasks</li>
                    <li>

                    <ul class="menu">

                    </ul>
                    </li>
                    <li class="footer">
                    <a href="#">View all tasks</a>
                    </li>
                </ul>
                </li>
                
                <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="../../static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image" />
                
                </a>
                <ul class="dropdown-menu">
                    
                    <li class="user-header">
                    <img src="../../static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />

                    </li>
                    <!-- Menu Body -->
                    <li class="user-body">
                    <div class="row">
                        <div class="col-xs-4 text-center">
                        <a href="#">Followers</a>
                        </div>
                        <div class="col-xs-4 text-center">
                        <a href="#">Sales</a>
                        </div>
                        <div class="col-xs-4 text-center">
                        <a href="#">Friends</a>
                        </div>
                    </div>
                    <!-- /.row -->
                    </li>
                    <!-- Menu Footer-->
                    <li class="user-footer">
                    <div class="pull-left">
                        <a href="#" class="btn btn-default btn-flat" id="show_profile">Profile</a>
                    </div>
                    <div class="pull-right">
                        <form action="/logout" method="post">
                        <input type="submit" value="Sign Out" class="btn btn-default btn-flat" />
                        </form>
                        <!-- 										<a href="#" >Sign out</a> -->
                    </div>
                    </li>
                </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li>
                <a href="#" data-toggle="control-sidebar">
                    <i class="fa fa-gears"></i>
                </a>
                </li>
            </ul>
            </div>
            
            </nav>
        </header>
    </div>
</template>
<script>
export default {
    name: "mainHeader",
    data:function(){
        return {

        }
    }
}
</script>
<style scoped>

</style>

