<template>
  <div id="app">
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
                  <img src="../static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image" />
                
                </a>
                <ul class="dropdown-menu">
                  
                  <li class="user-header">
                    <img src="../static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />

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
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
      <!-- sidebar: style can be found in sidebar.less -->
      <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
          <div class="pull-left image">
            <img src="../static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
          </div>
          <div class="pull-left info">
        
            <a href="#">
              <i class="fa fa-circle text-success"></i> Online</a>
          </div>
        </div>

        <ul class="sidebar-menu" data-widget="tree">
          <li class="header">MAIN NAVIGATION</li>
        </ul>
      </section>
      <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    
    <div class="content-wrapper" id="mainDiv">
      <router-view/>
      <div id="tabContainer"></div>
      <!-- 			<div id="tab_content"></div> -->

    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
      <div class="pull-right hidden-xs">
        <b>Version</b> 2.4.0
      </div>
      <strong>Copyright &copy; 2014-2016
        <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
      <!-- Create the tabs -->
      <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        <li>
          <a href="#control-sidebar-home-tab1" data-toggle="tab">
            <i class="fa fa-wrench  active"></i>
          </a>
        </li>
        <li>
          <a href="#control-sidebar-home-tab2" data-toggle="tab">
            <i class="fa fa-home"></i>
          </a>
        </li>
        <li>
          <a href="#control-sidebar-home-tab3" data-toggle="tab">
            <i class="fa fa-gears"></i>
          </a>
        </li>
      </ul>
      <!-- Tab panes -->
      <div class="tab-content">
        <!-- Home tab content -->
        <div class="tab-pane active" id="control-sidebar-home-tab1">
          <div>
            <h4 class="control-sidebar-heading">Layout Options</h4>
            <div class="form-group">
              <label class="control-sidebar-subheading">
                <input type="checkbox" data-layout="fixed" class="pull-right" /> Fixed layout</label>
              <p>Activate the fixed layout. You can't use fixed and boxed layouts together</p>
            </div>
            <div class="form-group">
              <label class="control-sidebar-subheading">
                <input type="checkbox" data-layout="layout-boxed" class="pull-right" /> Boxed Layout</label>
              <p>Activate the boxed layout</p>
            </div>
            <div class="form-group">
              <label class="control-sidebar-subheading">
                <input type="checkbox" data-layout="sidebar-collapse" class="pull-right" /> Toggle Sidebar</label>
              <p>Toggle the left sidebar's state (open or collapse)</p>
            </div>
            <div class="form-group">
              <label class="control-sidebar-subheading">
                <input type="checkbox" data-enable="expandOnHover" class="pull-right" /> Sidebar Expand on Hover</label>
              <p>Let the sidebar mini expand on hover</p>
            </div>
            <div class="form-group">
              <label class="control-sidebar-subheading">
                <input type="checkbox" data-controlsidebar="control-sidebar-open" class="pull-right" /> Toggle Right Sidebar Slide</label>
              <p>Toggle between slide over content and push content effects</p>
            </div>
            <div class="form-group">
              <label class="control-sidebar-subheading">
                <input type="checkbox" data-sidebarskin="toggle" class="pull-right" /> Toggle Right Sidebar Skin</label>
              <p>Toggle between dark and light skins for the right sidebar</p>
            </div>
            <h4 class="control-sidebar-heading">Skins</h4>
            <ul class="list-unstyled clearfix">
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-blue" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9;"></span>
                    <span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin">Blue</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-black" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix">
                    <span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe;"></span>
                    <span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #222;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin">Black</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-purple" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span>
                    <span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin">Purple</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-green" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span>
                    <span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin">Green</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-red" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span>
                    <span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin">Red</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-yellow" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span>
                    <span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin">Yellow</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-blue-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9;"></span>
                    <span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin" style="font-size: 12px">Blue Light</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-black-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix">
                    <span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe;"></span>
                    <span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin" style="font-size: 12px">Black Light</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-purple-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span>
                    <span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin" style="font-size: 12px">Purple Light</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-green-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span>
                    <span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin" style="font-size: 12px">Green Light</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-red-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span>
                    <span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin" style="font-size: 12px">Red Light</p>
              </li>
              <li style="float:left; width: 33.33333%; padding: 5px;">
                <a href="javascript:void(0);" data-skin="skin-yellow-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)"
                  class="clearfix full-opacity-hover">
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span>
                    <span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span>
                  </div>
                  <div>
                    <span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span>
                    <span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
                  </div>
                </a>
                <p class="text-center no-margin" style="font-size: 12px;">Yellow Light</p>
              </li>
            </ul>
          </div>
        </div>
        <!-- /.tab-pane -->
        <!-- Home tab content -->
        <div class="tab-pane" id="control-sidebar-home-tab2"></div>
        <!-- /.tab-pane -->

        <!-- Settings tab content -->
        <div class="tab-pane" id="control-sidebar-home-tab3"></div>
        <!-- /.tab-pane -->
      </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
   
  </div>
</template>

<script>

export default {
  name: 'App',
  created: function () {
    this.$axios.post('http://localhost:81/crawler/sysMenuInfo/findzTreeByUser',"test")
    .then(res =>{
     loadMenu(res.data);
    }).catch(error=>{

    })
  },
  methods:{
    
  }
}
// 加载menu
function loadMenu(result) {
  // 遍历结果集
  $.each(result, function (index, value) {
    // 加载数据
    $(".sidebar-menu").append(sidebar_menu_add_li(value));
  });
  // console.log(JSON.stringify(result));
  $("a[data-url]").click(function (evt) {
    loadPage($(this).data("url"), $(this).data("id"), $(this).data("name"));
    $("ul.treeview-menu li").removeClass("active");
    $(this).parent().addClass("active");
  });
}
// 添加《li》
function  sidebar_menu_add_li(item) {
  // 返回值
  var html = '';
  if (item.children.length == 0) {
    html = "<li><a href='#' data-url='" + item.url + "' data-id='" + item.id + "' data-name='" + item.name + "' ><i class='" + item.icon + "'></i>" + item.name + "</a></li>";
    if (item.homePage) {
      //loadPage(item.url);
    }
  } else {
    html = "<li class='treeview'>" + "<a href='#'>" + "<i class='" + item.icon + "'></i>" 
    + "<span>" + item.name + "</span>" + "<span class='pull-right-container'>"
      // + "<span class='label label-primary pull-right'>" + item.children.length + "</span>" 
      + "</span>" + "</a>" + "<ul class='treeview-menu'>";
    $.each(item.children, function (index, value) {
      html = html + sidebar_menu_add_li(value);
    });
    html = html + "</ul>" + "</li>";
  }
  return html;

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
