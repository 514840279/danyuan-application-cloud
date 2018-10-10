<template>
    <div>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
            <div class="pull-left image">
                <img src="../../static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
                <a href="#">
                <i class="fa fa-circle text-success"></i> Online</a>
            </div>
            </div>

            <ul class="sidebar-menu tree" data-widget="tree">
              <li class="header">MAIN NAVIGATION</li>
              <!-- 1 -->
              <li class='treeview'>
                <a href='#'><i class='fa  fa-database'></i><span>数据库管理</span>
                  <span class='pull-right-container'><span class='label label-primary pull-right'></span>
                  </span>
                </a>
                <ul class='treeview-menu'>
                  <li><router-link to='/addrIndexPath'  ><i class='fa  fa-database'></i> 数据连接管理 </router-link></li>
                  <li><router-link to='/typeIndexPath'  ><i class='fa  fa-database'></i> 数据种类管理 </router-link></li>
                  <li><router-link to='/userIndexPath'  ><i class='fa  fa-database'></i> 查询种类管理 </router-link></li>
                </ul>
              </li>
            </ul>
        </section>
        <!-- /.sidebar -->
        </aside>
    </div>
</template>
<script>
export default {
    name: "test",
    created: function () {
      //this.$axios.post('/oauth2/sysMenuInfo/findzTreeByUser',"test").then(res =>{
        // loadMenu(res.data);
      //}).catch(error=>{

     // })
    },
    data:function(){
        return {

        }
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

function findError() {
};


</script>
<style scoped>

</style>

