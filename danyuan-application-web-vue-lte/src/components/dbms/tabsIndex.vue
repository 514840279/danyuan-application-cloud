<template>
    <!-- template 有且仅有一个子元素-->
    <div>
        <!-- 头部设计 -->
        <section class="content-header">
            <h1>
                数据管理 <small>库表管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="index.html"><i class="fa fa-dashboard"></i>首页</a></li>
                <li><a href="#">数据库设置 </a></li>
                <li class="active">库表管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-default">
                <div class="box-header with-border">
                <h3 class="box-title">条件筛选</h3>
        
                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                </div>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class=" col-md-6 form-group">
                            <label class="col-sm-2 control-label text-right">数据库:</label>
                            <div class="col-sm-10">
                                <select style="width: 100%;" id="search_table_addrName"></select>
                            </div>
                        </div>
                        <div class=" col-md-6 form-group">
                            <label class="col-sm-2 control-label text-right">类型:</label>
                            <div class="col-sm-10">
                                <select style="width: 100%;" id="search_table_typeName"></select>
                            </div>
                        </div>
                        <div class=" col-md-6 form-group">
                            <label class="col-sm-2 control-label text-right">表名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="search_table_tableName" name="type" placeholder="数据库表名">
                            </div>
                        </div>
                        <div class=" col-md-6 form-group">
                            <label class="col-sm-2 control-label text-right">表含义:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="search_table_tableDesc" name="type" placeholder="数据库表含义">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        
        

            <div class="box">
                <div class="box-header with-border">
                <h3 class="box-title">表设置</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                </div>
                </div>
                <div class="box-body">
                    <div id="db_table_toolbar">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" id="impnew_table">
                                <i class="glyphicon glyphicon-plus"></i> 导入表配置
                            </button>
                            <button type="button" class="btn btn-default" id="editold_table">
                                <i class=" glyphicon glyphicon-pencil"></i> 编辑表配置
                            </button>
                            <button type="button" class="btn btn-default" id="delete_table">
                                <i class=" glyphicon glyphicon-pencil"></i> 删除表配置
                            </button>
                            
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" id="addnew_table">
                                <i class="glyphicon glyphicon-plus"></i> 新建表
                            </button>
                            <button type="button" disabled="disabled" class="btn btn-default" id="editold_table_column">
                                <i class=" glyphicon glyphicon-pencil"></i> 编辑列 
                            </button>
                            <button type="button" disabled="disabled" class="btn btn-default" id="deleteold_table">
                                <i class="glyphicon glyphicon-trash"></i> 清空表
                            </button>
                            <button type="button" class="btn btn-default" id="drop_table">
                                <i class="glyphicon glyphicon-remove"></i> 删除表
                            </button>
                            <button type="button" disabled="disabled" class="btn btn-default" id="analysis_table">
                                <i class="fa fa-gear"></i> 分析表
                            </button>
                        </div>
                        
                    </div>
                    <table class="table table-striped table-bordered" id="db_table_datagrid" data-toggle="db_table_datagrid">
                    </table>
                </div>
            </div>
        </section>

    </div>
</template>
<script>
export default {
    name: "test",
    data:function(){
        return {

        }
    },
    created:function(){
        this.init();
    },
    mounted:function(){
        $('#addnew_table').click(function() {
            url = "/pages/dbms/table/add_table.html";
            
            modals.openWin({
                winId:"add_tabs_id",
                title:'新建连接信息',
                width:screen.width*0.5+'px',
                url:url
            });
        });
        $('#impnew_table').click(function() {
            // 获取屏幕宽度
            url = "/pages/dbms/table/imp_table.html";
            
            modals.openWin({
                winId:"imp_tabs_id",
                title:'添加连接信息',
                width:screen.width +'px',
                url:url
            });
        });
        
        
        $('#editold_table').click(function() {
            var data = $('#db_table_datagrid').bootstrapTable('getAllSelections');
            if(data.length == 0){
                alert("先选中一条数据");
            }else if(data.length > 1){
                alert("只能选择一条");
            }else{
                var uuid =data[0].uuid;
                // 获取屏幕宽度
                url = "/sysDbmsTabsInfo/updBeforEdit?uuid="+uuid;
                
                modals.openWin({
                    winId:"upd_tabs_id",
                    title:'添加连接信息',
                    width:screen.width*0.5 +'px',
                    url:url
                });
            }
        });
        
        $('#editold_table_column').click(function() {
            var data = $('#db_table_datagrid').bootstrapTable('getAllSelections');
            if(data.length == 0){
                alert("先选中一条数据");
            }else if(data.length > 1){
                alert("只能选择一条");
            }else{
                loadPage('/sysDbmsTabsInfo/updBefor','upd_table_column_tab_id','修改表字段',data[0],'reload')
                
            }
        });
        
        
        $('#delete_table').click(function() {
            var data = $('#db_table_datagrid').bootstrapTable('getAllSelections');
            if(data.length == 0){
                alert("先选中一条数据");
            }else if(data.length > 0){
                bootbox.setLocale("zh_CN");
                bootbox.confirm({
                message : "确定要删除选定行",
                title : "系统提示",
                callback : function(result) {
                        if (result) {
                            var param = {
                                    "list":data,
                            };
                            // 重载
                            var url = "/sysDbmsTabsInfo/delete";
                            ajaxPost(url, param, successDeleteSysTableInfo, 1000, findError);
                        }
                    }
                });
            }
        });
        
        $('#drop_table').click(function() {
            var data = $('#db_table_datagrid').bootstrapTable('getAllSelections');
            if(data.length == 0){
                alert("先选中一条数据");
            }else if(data.length > 0){
                bootbox.setLocale("zh_CN");
                bootbox.confirm({
                message : "确定要删除选定行",
                title : "系统提示",
                callback : function(result) {
                        if (result) {
                            var param = {
                                    "list":data,
                            };
                            // 重载
                            var url = "/sysDbmsTabsInfo/drop";
                            ajaxPost(url, param, successDeleteSysTableInfo, 1000, findError);
                        }
                    }
                });
            }
        });

        // bootstrap table
        $('#db_table_datagrid').bootstrapTable({
            url : this.baseURL+"/dbms/sysDbmsTabsInfo/page",
            dataType : "json",
            toolbar : '#db_table_toolbar', // 工具按钮用哪个容器
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
            height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId : "uuid", // 每一行的唯一标识，一般为主键列
            showToggle : true, // 是否显示详细视图和列表视图的切换按钮
            cardView : false, // 是否显示详细视图
            detailView : false, // 是否显示父子表
            singleSelect : false,
            locales : "zh-CN", // 表格汉化
            //		search : true, // 显示搜索框
            sidePagination: "server", // 服务端处理分页
            queryParamsType : "undefined",
            contentType: "application/json",
            method: "post",  //使用get请求到服务器获取数据  
            queryParams: function queryParams(params) {  
                var param = {  
                    pageNumber: params.pageNumber,    
                    pageSize: params.pageSize,
                    info:{
                        jdbcUuid:search_table_addrName,
                        typeUuid:search_table_typeName,
                        tableName:$("#search_table_tableName").val(),
                        tableDesc:$("#search_table_tableDesc").val(),
                    }
                }; 
                return param;
            },
            columns : [
                {title : '全选',	checkbox : true,align : 'center',valign : 'middle'},
                {title : 'id',	field : 'uuid',	align : 'center',sortable : true,valign : 'middle',visible:false},
                //			{title : '数据库',field : 'jdbcUuid',sortable : true,align : 'left'},
                //			{title : '类型',field : 'typeUuid',sortable : true,align : 'left'},
                {title : '表名',field : 'tabsName',align : 'left',sortable : true,valign : 'middle'},
                {title : '表含义',field : 'tabsDesc',align : 'left',sortable : true,valign : 'middle'},
                {title : '显示顺序',field : 'tabsOrder',align : 'center',sortable : true,valign : 'middle'},
                {title : '表数据量',field : 'tabsRows',sortable : true,align : 'left'},
                {title : '数据库表大小',field : 'tabsSpace',sortable : true,align : 'left'},
                {title : '描述',field : 'discription',sortable : true,align : 'left'}
            ],responseHandler: function(result){  // 成功时执行
                return {rows:result.content,total:result.totalElements};
            },
        });
    },
    methods:{
        init:function(){

        }
    }
}
</script>
<style scoped>

</style>

