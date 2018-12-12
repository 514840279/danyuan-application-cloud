window.operateEvents = {
	// 修改
	'click #clickA ': function (e, value, row, index) {
		// 打开modal
		modals.openWin({
	    	winId:"add_rule_group_table",
	    	title:'添加规则组',
	    	width:'800px',
	    	url:"/pages/crawler/rule/addgroup.html"
	    });
		
		// 反填数据
		setTimeout(function(){
			$("#add_ruler_group_ruler").val(row.ruler);
			$("#add_ruler_group_name").val(row.name);
			group_param.taskUuid = row.taskUuid;
			$("#add_search_task_taskUuid").select2().val(row.taskUuid).trigger("change");
			group_param.groupType= row.type;
			$("#add_ruler_groupType").select2().val(row.type).trigger("change"); 
			group_param.parrentId= row.parentUuid;
			$("#add_ruler_parrentId").select2().val(row.parentUuid).trigger("change");  
		}, 300);
		
	
	},
	'click #clickB ': function (e, value, row, index) {
	},
	'click #clickC ': function (e, value, row, index) {
	},
	'click #clickD ': function (e, value, row, index) {
	}
}
$(function() {
	init();
});
var search_task_urlType = null;
var search_task_taskUuid=null;
// 初始化 
function init(){
	// select 初始化
	search_task_urlType = null;
	var url = "/crawler/sysCrawlerTaskInfo/findUrlType";
	ajaxPost(url,{},loadUrlType);
	$("#search_task_urlType").select2({
	    tags: true,
	    placeholder: "请选择",
	}).on('select2:select', function (evt) {
		search_task_urlType = evt.params.data.id;
		if(search_task_urlType == "请选择"){
			search_task_urlType = null;
		}
		var url = "/crawler/sysCrawlerTaskInfo/findAll";
		ajaxPost(url,{urlType:search_task_urlType},loadTaskName);
	});
	
	// select 初始化
	search_task_taskUuid=null;
	var url = "/crawler/sysCrawlerTaskInfo/findAll";
	ajaxPost(url,{urlType:search_task_urlType},loadTaskName);
	$("#search_task_taskUuid").select2({
	    tags: true,
	    placeholder: "请选择",
	}).on('select2:select', function (evt) {
		search_task_taskUuid = evt.params.data.id;
		if(search_task_taskUuid == "请选择"){
			search_task_taskUuid = null;
		}
		$('#crawler_rule_group_config_table_datagrid').bootstrapTable('refresh');
	});
	
	
	// 初始化规则组
	loadRuleGroup();
	// 初始化 规则 
	//loadRule();
	
	// 绑定按钮事件
	bindClick();
}

// 绑定按钮事件
function bindClick(){
	// 组添加按钮点击
	$("#add_crawler_rule_group_config_btn").bind("click",function(){
		// 打开添加窗口
		modals.openWin({
	    	winId:"add_rule_group_table",
	    	title:'添加规则组',
	    	width:'800px',
	    	url:"/pages/crawler/rule/addgroup.html"
	    });
	})
	// 组删除事件点击
	$("#del_crawler_rule_group_config_btn").bind("click",function(){
		var rows = $('#crawler_rule_group_config_table_datagrid').bootstrapTable("getAllSelections");
		if(rows.length >= 1){
			bootbox.setLocale("zh_CN");
			bootbox.confirm({
			message : "确定要删除选定行",
			title : "系统提示",
			callback : function(result) {
					if (result) {
						var submiturl = "/crawler/sysCrawlerRulerInfo/deleteAll";
						ajaxPost(submiturl, {list:rows}, refreshGroupTable, 5000, findError);
					}
				}
			});
			
		}
	})
	
	// 规则添加点击事件
	$("#add_crawler_rule_config_btn").bind("click",function(){
		// 打开添加窗口
		modals.openWin({
	    	winId:"add_rule_modal",
	    	title:'添加规则',
	    	width:'800px',
	    	url:"/pages/crawler/rule/addrule.html"
	    });
	})
	
	// 删除点击事件
	$("#del_crawler_rule_config_btn").bind("click",function(){
		var rows = $('#crawler_rule_config_table_datagrid').bootstrapTable("getAllSelections");
		if(rows.length >= 1){
			bootbox.setLocale("zh_CN");
			bootbox.confirm({
			message : "确定要删除选定行",
			title : "系统提示",
			callback : function(result) {
					if (result) {
						var submiturl = "/crawler/sysCrawlerRulerColumInfo/deleteAll";
						ajaxPost(submiturl, {list:rows}, refreshRuleTable, 5000, findError);
					}
				}
			});
			
		}
	})
}
function refreshGroupTable(){
	$('#crawler_rule_group_config_table_datagrid').bootstrapTable('refresh');
}
function refreshRuleTable(){
	$('#crawler_rule_config_table_datagrid').bootstrapTable('refresh');
}
// 下拉框 网站类型 加载
function loadUrlType(result){
	var data = [{id:'请选择',text:'请选择'}];
	$.each(result,function(index,value){
		data.push({id:value,text:value});
	})
	$("#search_task_urlType").empty();
	$("#search_task_urlType").select2({
	    data: data
	});
}

// 任务名称 加载
function loadTaskName(result){
	var data = [{id:'请选择',text:'请选择'}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.taskName});
	});
	$("#search_task_taskUuid").empty();
	$("#search_task_taskUuid").select2({
	    data: data
	});
}

// 初始化规则组
function loadRuleGroup(){

	// bootstrap table
	$('#crawler_rule_group_config_table_datagrid').bootstrapTable({
		class: 'table table-hover table-bordered',
		url : "/crawler/sysCrawlerRulerInfo/findAll",
		dataType : "json",
		toolbar : '#crawler_rule_group_table_toolbar', // 工具按钮用哪个容器
		cache : true, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : true, // 是否启用排序
		sortOrder : "asc", // 排序方式
		pagination : false, // 分页
//		pageNumber : 1, // 初始化加载第一页，默认第一页
//		pageSize : 10, // 每页的记录行数（*）
//		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
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
//		showExport: true,                    
//        exportDataType: 'all',
//        exportTypes:[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],  //导出文件类型
		singleSelect : false,
		locales : "zh-CN", // 表格汉化
//		search : true, // 显示搜索框
//		sidePagination: "server", // 服务端处理分页 server
		//设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
        //设置为limit可以获取limit, offset, search, sort, order  
        queryParamsType : "undefined",
        contentType: "application/json",
		method: "post",  //使用get请求到服务器获取数据  
	    treeView: true,//是否开启树视图
	    treeId: "uuid",//id字段
	    treeField: "name",//展示树的字段
	    parentIdField: 'parentUuid',
		filter: true,
		queryParams: function queryParams(params) {  
		    var param = {  
	    		taskUuid:search_task_taskUuid
            }; 
		    console.log(param)
            return param;
		},
		columns : [
			{title : '全选',checkbox : true,align : 'center',valign : 'middle'},
			{title : '.',field : 'uuid',align : 'center',sortable : true,valign : 'top',visible:false},
			{title : '规则名称',field : 'name',align : 'center',sortable : true,valign : 'top'},
			{title : '规则类型',field : 'type',sortable : true,align : 'center',valign : 'top', sortable: true},
			{title : '修改时间',field : 'updateTime',sortable : true,align : 'center',valign : 'top',formatter:dateTimeFormatter},
		],
		responseHandler: function(result){  // 成功时执行
			console.log(result)
			return {data:result};
		}, 
		onClickRow:function(row,index){
//			$("#crawler_rule_config_table_datagrid").bootstrapTable("destroy");
		    if(!index[0].children[0].children[0].checked){
		    	loadRule(row);
		    }
		    $("#show_crawler_rule_group_config").attr("class","col-lg-4 col-xs-4");
	    },
	});
}

// 初始化 规则 
function loadRule(row){
	$("#crawler_rule_config_table_datagrid").bootstrapTable("destroy");
	// bootstrap table
	$('#crawler_rule_config_table_datagrid').bootstrapTable({
		url : "/crawler/sysCrawlerRulerColumInfo/page",
		dataType : "json",
		toolbar : '#crawler_rule_config_table_toolbar', // 工具按钮用哪个容器
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
		height : 550, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
		filter: true,
		queryParams: function queryParams(params) {  
//			console.log(params);
		    var param = {  
                 pageNumber: params.pageNumber,    
                 pageSize: params.pageSize,
                 info:{rulerUuid:row.uuid },
                 sortOrder:params.sortOrder,
                 sortName:params.sortName,
                 filter:params.filter
             }; 
             return param;
		},
		columns : [
			{title : '全选',checkbox : true,align : 'center',valign : 'middle'},
			{title : 'id',field : 'uuid',align : 'center',sortable : true,valign : 'top',visible:false},
			{title : '规则名称',field : 'columName',align : 'center',sortable : true,valign : 'top'},
			{title : '规则类型',field : 'type',sortable : true,align : 'center',valign : 'top', sortable: true},
			{title : '规则内容',field : 'ruler',sortable : true,align : 'center',valign : 'top'},
			{title : '开始位置',field : 'start',sortable : true,align : 'center',valign : 'top'},
			{title : '结束位置',field : 'end',sortable : true,align : 'center',valign : 'top'},
			{title : '拼接字符（需要替换的、分割符）',field : 'param',sortable : true,align : 'center',valign : 'top'},
			{title : '替换成',field : 'paramNew',sortable : true,align : 'center',valign : 'top'},
			{title : '修改时间',field : 'updateTime',sortable : true,align : 'center',valign : 'top',formatter:dateTimeFormatter},
		],
		responseHandler: function(result){  // 成功时执行
			return {rows:result.content,total:result.totalElements};
		}, 
	});
}

// 窗口大小改变时 重设表头
$(window).resize(function() {
	$('#dbm_rule_table_datagrid').bootstrapTable('resetView');
});



function addRuleSuccess(result){
	$('#dbm_rule_table_datagrid').bootstrapTable('refresh');
}