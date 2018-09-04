<template>
    <!-- template 有且仅有一个子元素-->
    <div>
        <!-- 头部设计 -->
        <section class="content-header">
            <h1>
                检索类型管理 <small>类型管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="index.html"><i class="fa fa-dashboard"></i>首页</a></li>
                <li><a href="#">数据管理 </a></li>
                <li class="active">检索类型管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">类型设置</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse">
                            <i class="fa fa-minus"></i>
                        </button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove">
                            <i class="fa fa-times"></i>
                        </button>
                    </div>
                </div>
                <div class="box-body">
                    <div id="dbm_userindex_toolbar" class="btn-group">
                        <button type="button" class="btn btn-default" id="addnew_userindex" title="新增类型">
                            <i class="fa fa-plus"></i>
                        </button>
                        <button type="button" class="btn btn-default" id="editold_userindex" title="修改类型">
                            <i class="fa fa-edit"></i>
                        </button>
                        <button type="button" class="btn btn-default" id="deleteold_userindex" title="删除类型">
                            <i class="fa fa-remove"></i>
                        </button>
                    </div>
                    <table class="table table-striped table-bordered" id="dbm_userindex_datagrid" data-toggle="dbm_userindex_datagrid"></table>
                </div>
            </div>

        </section>

        <!-- 添加模态框 -->
        <div class="modal fade" id="dbm_userindex_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-type" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel-type">添加类型信息</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-bordered table-hover definewidth m10">
                            <tr style="display: none;">
                                <td class="tableleft">主键</td>
                                <td><input type="text" id="dbm_useridex_add_uuid" name="uuid" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">索引类型</td>
                                <td><input type="text" id="dbm_useridex_add_userIndex" name="userIndex" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">显示名称</td>
                                <td><input type="text" id="dbm_useridex_add_desc" name="desc" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">排序</td>
                                <td><input type="text" id="dbm_useridex_add_userOrder" name="userOrder" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">说明</td>
                                <td><input type="text" id="dbm_useridex_add_userPlaceholder" name="userPlaceholder" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">多条件查询</td>
                                <td><input type="text" id="dbm_useridex_add_multeity" name="multeity" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">图表查询</td>
                                <td><input type="text" id="dbm_useridex_add_chart" name="multeity" /></td>
                            </tr>
                            <tr>
                                <td class="tableleft">是否启用</td>
                                <td><input type="text" id="dbm_useridex_add_deleteFlag" name="deleteFlag" /></td>
                                <td>true or false</td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="dbm_userindex_add_button">提交</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>
<script>
export default {
    name: "userIndex",
    data:function(){
        return {

        }
    },
    created:function(){
        this.init();
    },
    mounted:function(){
        $('#addnew_userindex').click(function() {
            $("#dbm_useridex_add_uuid").val(this.getUuid);
            $("#dbm_useridex_add_desc").val("");
            $("#dbm_useridex_add_userOrder").val("");
            $("#dbm_useridex_add_userIndex").val("");
            $("#dbm_useridex_add_userPlaceholder").val("");
            $("#dbm_useridex_add_multeity").val("");
            $("#dbm_useridex_add_chart").val("");
            $('#dbm_userindex_add_modal').modal({
                show:true,
            });
        });
        $('#editold_userindex').click(function() {
            var data = $('#dbm_userindex_datagrid').bootstrapTable('getAllSelections');
            if(data.length == 0){
                alert("先选中一条数据");
            }else if(data.length == 1){
                $("#dbm_useridex_add_uuid").val(data[0].uuid);
                $("#dbm_useridex_add_deleteFlag").val(data[0].deleteFlag);
                $("#dbm_useridex_add_uuid").val(data[0].uuid);
                $("#dbm_useridex_add_desc").val(data[0].userDesc);
                $("#dbm_useridex_add_userOrder").val(data[0].userOrder);
                $("#dbm_useridex_add_userIndex").val(data[0].userIndex);
                $("#dbm_useridex_add_userPlaceholder").val(data[0].userPlaceholder);
                $("#dbm_useridex_add_multeity").val(data[0].multeity);
                $("#dbm_useridex_add_chart").val(data[0].chart);
                $("#dbm_userindex_add_modal").modal({
                    show:true,
                })
            }else{
                alert("只能选中一条数据");
            }
        });
        $('#deleteold_userindex').click(function() {
            var data = $('#dbm_userindex_datagrid').bootstrapTable('getAllSelections');
            
            if(data.length == 0){
                alert("先选中数据");
            }else if(data.length > 0){
                bootbox.setLocale("zh_CN");
                bootbox.confirm({
                message : "确定要删除选定行",
                title : "系统提示",
                callback : function(result) {
                        if (result) {
                            var url = "/sysDbmsUserIndexInfo/delete";
                            var param={list:data};
                            ajaxPost(url, param, this.addSysDicUserIndexCodeSuccess, 5000, findError);
                        }
                    }
                });
            }
        });
        
        $('#dbm_userindex_add_button').click(function() {
            
            var url = "/sysDbmsUserIndexInfo/save";
            var	SysDicUserIndexCode={
                    uuid:$("#dbm_useridex_add_uuid").val(),
                userDesc:$("#dbm_useridex_add_desc").val(),
                userOrder:$("#dbm_useridex_add_userOrder").val(),
                userIndex:$("#dbm_useridex_add_userIndex").val(),
                userPlaceholder:$("#dbm_useridex_add_userPlaceholder").val(),
                deleteFlag:$("#dbm_useridex_add_deleteFlag").val(),
                multeity:$("#dbm_useridex_add_multeity").val(),
                chart:$("#dbm_useridex_add_chart").val(),
                createUser:username,
                updateUser:username,
            }
            console.log(SysDicUserIndexCode);
            ajaxPost(url, SysDicUserIndexCode, this.addSysDicUserIndexCodeSuccess, 5000, findError);
            $('#dbm_userindex_add_modal').modal("hide");
        });
        
        // bootstrap table
        $('#dbm_userindex_datagrid').bootstrapTable({
            url : this.baseURL+"/crawler/sysDbmsUserIndexInfo/page",
            dataType : "json",
            toolbar : '#dbm_userindex_toolbar', // 工具按钮用哪个容器
            cache : true, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            sortable : true, // 是否启用排序
            sortOrder : "asc", // 排序方式
            pagination : true, // 分页
            pageNumber : 1, // 初始化加载第一页，默认第一页
            pageSize : 10, // 每页的记录行数（*）
            pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
            strictSearch : true,
            showColumns : true, // 是否显示所有的列
            showRefresh : true, // 是否显示刷新按钮
            minimumCountColumns : 2, // 最少允许的列数
            clickToSelect : true, // 是否启用点击选中行
            //		height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId : "uuid", // 每一行的唯一标识，一般为主键列
            showToggle : true, // 是否显示详细视图和列表视图的切换按钮
            cardView : false, // 是否显示详细视图
            detailView : false, // 是否显示父子表
            //		showExport: true,                    
            //        exportDataType: 'all',
            //        exportTypes:[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],  //导出文件类型
            singleSelect : false,
            locales : "zh-CN", // 表格汉化
            //		search : true, // 显示搜索框
            sidePagination: "server", // 服务端处理分页 server
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
            //设置为limit可以获取limit, offset, search, sort, order  
            queryParamsType : "undefined",
            contentType: "application/json",
            method: "post",  //使用get请求到服务器获取数据  
            queryParams: function queryParams(params) {  
                var param = {  
                    pageNumber: params.pageNumber,    
                    pageSize: params.pageSize,
                    searchText: params.searchText
                }; 
                return param;
            },
            columns : [
                {title : '全选',checkbox : true,align : 'center',valign : 'middle'},
                //			{title : 'uuid',field : 'uuid',align : 'left',sortable : true,valign : 'middle',switchable:false,visible:false},
                {title : '索引类型',field : 'userIndex',align : 'left',valign : 'middle'},
                {title : '显示信息',field : 'userDesc',align : 'left',valign : 'middle'},
                {title : '排序',field : 'userOrder',align : 'left',valign : 'middle'},
                {title : '说明',field : 'userPlaceholder',align : 'left',valign : 'middle'},
                {title : '更新时间',field : 'updateTime',align : 'left',valign : 'middle',formatter:this.dateTimeFormatter},
                {title : '更新人',field : 'updateUser',align : 'left',valign : 'middle'},
                {title : '多条件查询',field : 'multeity',align : 'left',valign : 'middle'},
                {title : '图表显示',field : 'chart',align : 'left',valign : 'middle'},
                {title : '标记',field : 'deleteFlag',align : 'left',valign : 'middle'}
            ],
            responseHandler: function(result){  // 成功时执行
                return {rows:result.content,total:result.totalElements};
            }, 
        });
    },
    methods:{
        init:function(){

        },
        addSysDicUserIndexCodeSuccess:function(result){
            $('#dbm_userindex_datagrid').bootstrapTable('refresh');
        }
    }
}
</script>
<style scoped>

</style>

