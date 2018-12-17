
$(function() {
	init();
	// 绑定添加事件
	$("#submit_add_group_id").bind("click",function(){
		var param={
				uuid:$("#add_ruler_group_uuid").val(),
			taskUuid:group_param.taskUuid,
			type:group_param.groupType,
			name:$("#add_ruler_group_name").val(),
			ruler:$("#add_ruler_group_ruler").val(),
			itemsRuler:$("#add_ruler_group_items").val(),
			nextpageRuler:$("#add_ruler_group_nextpage").val(),
			parentUuid:group_param.parrentId
		}
		var url="/crawler/sysCrawlerRulerInfo/save";
		ajaxPost(url,param,successedSaveRulerGroup)
	})
});

function successedSaveRulerGroup(result){
	$("#add_rule_group_table").modal('hide');
	$('#crawler_rule_group_config_table_datagrid').bootstrapTable('refresh');
}

function init(){
	// select 初始化
	group_param.urlType = null;
	var url = "/crawler/sysCrawlerTaskInfo/findUrlType";
	ajaxPost(url,{},addloadUrlType);
	$("#add_search_task_urlType").select2({
	    tags: true,
	    placeholder: "请选择",
	}).on('select2:select', function (evt) {
		group_param.urlType = evt.params.data.id;
		if(add_search_task_urlType == "请选择"){
			group_param.urlType = null;
		}
		var url = "/crawler/sysCrawlerTaskInfo/findAll";
		ajaxPost(url,{urlType:group_param.urlType},addloadParrentId);
	});
	
	// select 初始化 任务
	group_param.taskUuid=null;
	var url = "/crawler/sysCrawlerTaskInfo/findAll";
	ajaxPost(url,{urlType:group_param.urlType},addloadTaskName);
	$("#add_search_task_taskUuid").select2({
	    tags: true,
	    placeholder: "请选择",
	}).on('select2:select', function (evt) {
		group_param.taskUuid = evt.params.data.id;
		if(group_param.taskUuid == "请选择"){
			group_param.taskUuid = null;
		}
		var url = "/crawler/sysCrawlerRulerInfo/findAll";
		ajaxPost(url,{urlType:group_param.urlType,taskUuid:group_param.taskUuid},addloadParrentId);

	});
	
	// select 初始化 上一次层
	$("#add_ruler_parrentId").select2({
	    tags: true,
	    placeholder: "请选择",
	}).on('select2:select', function (evt) {
		group_param.parrentId = evt.params.data.id;
		if(group_param.parrentId == "请选择"){
			group_param.parrentId = null;
		}
		
	});
	
	// select 初始化 组类型
	group_param.groupType=null;
	var url = "/crawler/sysDicName/findkeyList";
	ajaxPost(url,{code:"crawler_group_type"},addloadGroupType);
	$("#add_ruler_groupType").select2({
	    tags: true,
	    placeholder: "请选择",
	}).on('select2:select', function (evt) {
		group_param.groupType = evt.params.data.id;
		if(group_param.groupType == "请选择"){
			group_param.groupType = null;
		}
		switch(group_param.groupType){
			case('listPage'):
				$(".listpageGroupshow").css({"display":""});
				break;
			default:
				$(".listpageGroupshow").css({"display":"none"});
				break;
		}
	});
	
}

// 下拉框数据加载
function addloadGroupType(result){
	var data = [{id:'请选择',text:'请选择'}];
	$.each(result,function(index,value){
		data.push({id:value.keyValue,text:value.keyword});
	})
	$("#add_ruler_groupType").empty();
	$("#add_ruler_groupType").select2({
	    data: data
	});
}


//下拉框 网站类型 加载
function addloadUrlType(result){
	var data = [{id:'请选择',text:'请选择'}];
	$.each(result,function(index,value){
		data.push({id:value,text:value});
	})
	$("#add_search_task_urlType").empty();
	$("#add_search_task_urlType").select2({
	    data: data
	});
}

//任务名称 加载
function addloadTaskName(result){
	var data = [{id:'请选择',text:'请选择'}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.taskName});
	});
	$("#add_search_task_taskUuid").empty();
	$("#add_search_task_taskUuid").select2({
	    data: data
	});
}

function addloadParrentId(result){
	var data = [{id:'请选择',text:'请选择'}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.name});
	});
	$("#add_ruler_parrentId").empty();
	$("#add_ruler_parrentId").select2({
	    data: data
	});
}





