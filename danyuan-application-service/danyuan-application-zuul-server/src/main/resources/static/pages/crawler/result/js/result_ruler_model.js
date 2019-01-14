// 初始化种子下拉框
$('#result_seed_select').select2({
    placeholder: "选择种子网站",
    allowClear: true,
    tags: true,
}).on('select2:select', function (evt) {
	var id = evt.params.data.id;
	if (id=="请选择"){
		id=null;
	}
	var url = '/crawler/sysCrawlerRulerInfo/findAll';
	 var param = {  
    		taskUuid:id
         }; 
	ajaxPost(url, param, sucessLoadRulerSelect2, 1000, findError);
});
// 初始化规则下拉框
$('#result_seed_ruler_select').select2({
    placeholder: "选择模板",
    allowClear: true,
    tags: true,
}).on('select2:select', function (evt) {
	var id = evt.params.data.id;
	if(id=="请选择"){
		id=null;
	}
	var url = '/crawler/sysCrawlerRulerColumInfo/findAll';
    var param ={
    		rulerUuid:id
    }
    _result_config_ruler_uuid = id;
	ajaxPost(url, param, sucessLoadSeedRulerColumnSelect2, 1000, findError);
});

$(function(){
	var url = '/crawler/sysCrawlerTaskInfo/findAll';
	ajaxPost(url, {}, sucessLoadTaskSelect2, 1000, findError);
	
	$('#result_ruler_modal_next_div_btn').bind('click',function(){
		$("#result-tab").data("tabs").showTab('result_db_tables');
	})
	
});
// 网站种子下拉框
function sucessLoadTaskSelect2(result){
	var data = [{id:"请选择",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.taskName});
	});
	$('#result_seed_select').select2({data:data});
}
// 种子下拉点击事件
 // 规则下拉数据
function sucessLoadRulerSelect2(result){
	var data = [{id:"请选择",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.name});
	});
	$('#result_seed_ruler_select').empty();
	$('#result_seed_ruler_select').select2({data:data});
}
// 规则下拉点击事件
// 规则字段下拉数据
function sucessLoadSeedRulerColumnSelect2(result){
	var data = [{id:"请选择",text:"请选择"}];
	$('#result_config_column').empty();
	$.each(result,function(index,value){
		var option= "<option id="+value.uuid+">"+value.columName+"</option>"
		$('#result_config_column').append(option);
	});
	
	loadResultConfig();
}




