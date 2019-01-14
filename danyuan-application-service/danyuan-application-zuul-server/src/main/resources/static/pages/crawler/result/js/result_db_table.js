var _databaseid=null;
$('#result_db_addr_select').select2({
    placeholder: "选择数据库",
    allowClear: true,
    tags: true,
}).on('select2:select', function (evt) {
	_databaseid = evt.params.data.id;
	if(_databaseid=="请选择"){
		_databaseid=null;
	}
	loadTableSelect();
});

var _typeUuid=null;
$('#result_db_table_type').select2({
    placeholder: "选择类型",
    allowClear: true,
    tags: true,
}).on('select2:select', function (evt) {
	_typeUuid = evt.params.data.id;
	if(_typeUuid=="请选择"){
		_typeUuid=null;
	}
	loadTableSelect();
});

$('#result_db_table').select2({
    placeholder: "选择表",
    allowClear: true,
    tags: true,
}).on('select2:select', function (evt) {
	var id = evt.params.data.id;
	var url = '/dbms/sysDbmsTabsColsInfo/findAllBySysDbmsTabsColsInfo';
    var param = {
		tabsUuid:id
    };
    _result_config_table_uuid = id;
	ajaxPost(url, param, sucessLoadTableColumnSelect2, 1000, findError);
});


$(function(){
	_databaseid=null;
	var url = '/dbms/sysDbmsTabsJdbcInfo/findAll';
	ajaxPost(url, null, sucessLoadDatabaseSelect2, 1000, findError);
	_typeUuid=null;
	var url = '/dbms/sysDbmsTabsTypeInfo/findAll';
	ajaxPost(url, null, sucessLoadTypeSelect2, 1000, findError);
	
	$('#result_db_tables_before_div_btn').bind('click',function(){
		$("#result-tab").data("tabs").showTab('result_ruler_model');
	})
	
	$('#result_db_tables_after_div_btn').bind('click',function(){
		$("#result-tab").data("tabs").showTab('result_column_config');
	})
	// 创建新的表
	$('#addnew_table').click(function() {
		var data = $('#result_seed_ruler_select').select2('data');
		var param = {
			tabsName: data[0].text,
			tabsDesc:data[0].text,
			jdbcUuid:_databaseid,
			typeUuid:_typeUuid
		};
		// 重载
		var url = "/dbms/sysDbmsTabsInfo/save";
		ajaxPost(url, param, successSaveSysTableInfo);
	});
});

function  successSaveSysTableInfo(result){
	alert("创建表成功");
	loadTableSelect()
}
function sucessLoadDatabaseSelect2(result){
	var data = [{id:"请选择",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.databaseName});
	});
	$('#result_db_addr_select').empty();
	$('#result_db_addr_select').select2({data:data});
}

function sucessLoadTypeSelect2(result){
	var data = [{id:"请选择",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.typeName});
	});
	$('#result_db_table_type').empty();
	$('#result_db_table_type').select2({data:data});
}

function loadTableSelect(){
	var url = '/dbms/sysDbmsTabsInfo/findAllBySysTableInfo';
    var param = {
    		databaseUuid:_databaseid,
    		typeUuid:_typeUuid,
    };
	ajaxPost(url, param, sucessLoadTableSelect2, 1000, findError);
}

function sucessLoadTableSelect2(result){
	var data = [{id:"",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.uuid,text:value.tabsName});
	});
	$('#result_db_table').empty();
	$('#result_db_table').select2({data:data});
}




function sucessLoadTableColumnSelect2(result){
	var data = [{id:"",text:"请选择"}];
	$('#result_config_table_column').empty();
	$.each(result,function(index,value){
		var option= "<option id="+value.uuid+">"+value.colsName+"</option>"
		$('#result_config_table_column').append(option);
	});
	loadResultConfig();
}
