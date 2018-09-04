<template>
    <div>
        <!-- 头部设计 -->
        <section class="content-header">
            <h1>
                数据管理 <small>类型管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="index.html"><i class="fa fa-dashboard"></i>首页</a></li>
                <li><a href="#">数据管理 </a></li>
                <li class="active">类型管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div id="dbm_type_toolbar" class="btn-group">
                <button type="button" class="btn btn-default" id="addnew_type"><i class="glyphicon glyphicon-plus"></i>  新增类型 </button>
                <button type="button" class="btn btn-default" id="editold_type"><i class="glyphicon glyphicon-pencil"></i>  修改类型 </button>
                <button type="button" class="btn btn-default" id="deleteold_type"> <i class="glyphicon glyphicon-remove"></i> 删除类型 </button>
            </div>
            <div class="box">
                <div class="box-header with-border">
                <h3 class="box-title">类型设置</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                </div>
                </div>
                <div class="box-body">
                <table class="table table-striped table-bordered" id="dbm_type_datagrid" data-toggle="dbm_type_datagrid"></table>
                </div>
            </div>
            
        </section>
        
        <!-- 添加模态框 -->
        <div class="modal fade" id="dbm_type_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-type" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel-type">添加类型信息</h4>
                    </div>
                        <div class="modal-body">
                            <table class="table table-bordered table-hover definewidth m10">
                                <tr style="display:none;">
                                    <td class="tableleft">主键</td>
                                    <td><input type="text" id="dbm_type_add_uuid" name="uuid" /></td>
                                </tr>
                                <tr>
                                    <td class="tableleft">类型名</td>
                                    <td><input type="text" id="dbm_type_add_typeName" name="typeName"/></td>
                                </tr>
                                <tr>
                                    <td class="tableleft">图标</td>
                                    <td><input type="text" id="dbm_type_add_typeIcon" name="typeIcon" /></td>
                                </tr>
                                <tr>
                                    <td class="tableleft">排序</td>
                                    <td><input type="text" id="dbm_type_add_typeOrder" name="typeOrder" /></td>
                                </tr>
                                <tr>
                                    <td class="tableleft">描述</td>
                                    <td><input type="text" id="dbm_type_add_discription" name="discription" /></td>
                                </tr>
                                <tr>
                                    <td class="tableleft">是否启用</td>
                                    <td><input type="radio" id="dbm_type_add_deleteFlag" checked name="deleteFlag" value="1" /> 是  <input type="radio" id="dbm_type_add_deleteFlag" name="deleteFlag" value="0"  /> 否 </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="dbm_type_add_button">提交</button>
                        </div>
                </div>
            </div>
        </div>

    </div>
</template>
<script>
export default {
    name: "typeIndex",
    data:function(){
        return {

        }
    }, 
    created:function(){
        
    },
    mounted:function(){
        $('#addnew_type').click(function() {
            $("#dbm_type_add_uuid").val(this.getUuid);
            $('#dbm_type_add_modal').modal({
                show:true,
            });
        });
        $('#editold_type').click(function() {
            var data = $('#dbm_type_datagrid').bootstrapTable('getAllSelections');
            if(data.length == 0){
                alert("先选中一条数据");
            }else if(data.length == 1){
                $("#dbm_type_add_uuid").val(data[0].uuid);
                $("#dbm_type_add_typeName").val(data[0].typeName);
                $("#dbm_type_add_typeIcon").val(data[0].typeIcon);
                $("#dbm_type_add_typeOrder").val(data[0].typeOrder);
                $("#dbm_type_add_discription").val(data[0].discription);
                if(data[0].deleteFlag==1){
                    $('#dbm_type_add_deleteFlag[value="0"]').attr('checked',false);
                    $('#dbm_type_add_deleteFlag[value="1"]').attr('checked',true);
                }else if(data[0].deleteFlag==0){
                    $('#dbm_type_add_deleteFlag[value="0"]').attr('checked',true);
                    $('#dbm_type_add_deleteFlag[value="1"]').attr('checked',false);
                }
                $("#dbm_type_add_modal").modal({
                    show:true,
                })
            }else{
                alert("只能选中一条数据");
            }
        });
        $('#deleteold_type').click(function() {
            var data = $('#dbm_type_datagrid').bootstrapTable('getAllSelections');
            var url = this.baseURL+"/crawler/sysDbmsTabsTypeInfo/sysTableTypeDeleteAll";
            var param={list:data};
            ajaxPost(url, param, this.addSysTableTypeInfoSuccess, 5000, this.findError);
        });
        
        $('#dbm_type_add_button').click(function() {
            
            var url = "/crawler/sysDbmsTabsTypeInfo/save";
            console.log(this.baseURL)
            var	sysTableTypeInfo={
                uuid:$("#dbm_type_add_uuid").val(),
                typeName:$("#dbm_type_add_typeName").val(),
                typeIcon:$("#dbm_type_add_typeIcon").val(),
                typeOrder:$("#dbm_type_add_typeOrder").val(),
                discription:$("#dbm_type_add_discription").val(),
                deleteFlag:$('#dbm_type_add_deleteFlag:checked').val(),
            }
            console.log(sysTableTypeInfo);
            ajaxPost(url, sysTableTypeInfo, this.addSysTableTypeInfoSuccess, 5000, this.findError);
            $('#dbm_type_add_modal').modal("hide");
        });
        
        // bootstrap table init
        $('#dbm_type_datagrid').bootstrapTable({
            url : this.baseURL+"/crawler/sysDbmsTabsTypeInfo/findAllBySearchText",
            dataType : "json",
            toolbar : '#dbm_type_toolbar', // 工具按钮用哪个容器
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
            // showExport: true,                    
            // exportDataType: 'all',
            // exportTypes:[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],  //导出文件类型
            singleSelect : false,
            locales : "zh-CN", // 表格汉化
            // search : true, // 显示搜索框
            sidePagination: "server", // 服务端处理分页 server
            // 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
            // 设置为limit可以获取limit, offset, search, sort, order  
            queryParamsType : "undefined",
            contentType: "application/json",
            method: "post",  // 使用get请求到服务器获取数据  
            queryParams: function queryParams(params) {  
                var param = {  
                    pageNumber: params.pageNumber,    
                    pageSize: params.pageSize,
                    sysTableTypeInfo:{
                        
                    }
                }; 
                return param;
            },

            columns : [
                {title : '全选',checkbox : true,align : 'center',valign : 'middle'},
                {title : 'id',field : 'uuid',align : 'center',sortable : true,valign : 'middle',switchable:false,visible:false},
                {title : '类型名称',field : 'typeName',sortable : true,align : 'center'},
                {title : '类型描述',field : 'discription',align : 'center',sortable : true,valign : 'middle'},
                {title : '类型排序',field : 'typeOrder',align : 'center',sortable : true,valign : 'middle'},
                {title : '记录时间',field : 'createTime',align : 'center',sortable : true,valign : 'middle'},
                {title : '更新时间',field : 'updateTime',sortable : true,align : 'center'},
                {title : '标记',field : 'deleteFlag',sortable : true,align : 'center'}
            ],
            responseHandler: function(result){  // 成功时执行
                return {rows:result.content,total:result.totalElements};
            }, 
        });
    },
    methods:{
        addSysTableTypeInfoSuccess:function(result){
            $('#dbm_type_datagrid').bootstrapTable('refresh');
        }
    }
}
</script>
<style scoped>

</style>

