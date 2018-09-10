# 数据库管理设计


### 描述	数据库管理表结构


|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|

#### 用户查询配置	sys_dbms_user_index_info	说明	用户索引配置说明	

|唯一约束建|	配置列信息|	提示信息|	排序|	多条件配置|	图表配置|	描述|	插入时间|	插入人|	更新时间|	更新人|	标记|
|---------|-------------|--------|-------| ---------- | ------ |------| --------- |--------- | -------| ------ | --- |									
|uuid	|user_desc|	user_index|	user_placeholder|	user_order|	multeity|	chart|	discription	|create_time|	create_user	|updata_time|	updata_user|	delete_flag|									
|varchar（36）|	varchar（100）|	varchar（15）|	varchar(36)|	int	|int|	int|	varchar（140）|	date|	varchar|	date|	varchar	|int	|															
																						
#### 数据库信息	sys_dbms_tabs_jdbc_info	说明	转换换数据库连接的配置表																			
	唯一主键	数据库类型	数据库名称	数据库说明	端口	用户名	密码	驱动类	描述	插入时间	插入人	更新时间	更新人	标记								
	uuid	type	database_name	ip	port	username	password 	driver	discription	create_time	create_user	updata_time	updata_user	delete_flag								
	varchar（32）	varchar（50）	varchar（30）	varchar（120）	varchar（6）	varchar（30）	varchar（30）	varchar（240）	varchar（140）	date	varchar	date	varchar	int								
	UUID（）													删除标志								
																						
#### 数据库表分类	sys_dbms_tabs_type_info	说明	表分类																			
	唯一主键	类型名称	类型代码	排序	样式	描述	插入时间	插入人	更新时间	更新人	标记											
	uuid	type_name	type_class	type_order	type_icon	discription	create_time	create_user	updata_time	updata_user	delete_flag											
	varchar（36）	varchar（30）	varchar（30）	int	varchar（140）	varchar（140）	date	varchar	date	varchar	int											
	UUID（）										删除标志											
																						
#### 表信息	sys_dbms_tabs_info	说明	表的注释说明																			
	唯一约束建	数据库名称id	表类型ID	数据库表名称	表的翻译	表数据量	空间大小	排序	描述	插入时间	插入人	更新时间	更新人	标记								
	uuid	jdbc_uuid	type_uuid	tabs_name	tabs_desc	tabs_rows	tabs_space	tabs_order	discription	create_time	create_user	updata_time	updata_user	delete_flag								
	varchar（36）	varchar（36）	varchar（36）	varchar（30）	varchar（50）	varchar（1020）	varchar(100)	int	varchar（140）	date	varchar	date	varchar	int								
	UUID（）	外键												删除标志								
																						
#### 字段信息	sys_dbms_tabs_cols_info	说明	列的注释说明																			
	唯一约束建	表名称id	字段名	字段的翻译	字段的长度	字段展示时排序	字段类型	列表展示	对齐方式	对齐方式	每列的宽度	列项目隐藏	列项目的选项卡隐藏	用户查询列配置	图表	字段最大长度	描述	插入时间	插入人	更新时间	更新人	标记
	uuid	table_uuid	cols_name	cols_desc	cols_length	cols_order	cols_type	page_list	colsAlign	colsValign	colsWidth	colsVisible	colsSwitchable	colsIndex	userIcon	maxLength	discription	create_time	create_user	updata_time	updata_user	delete_flag
	varchar（36）	varchar（36）	varchar（30）	varchar（100）	int	int	int	int	varchar(36)	varchar(36)	varchar(36)	varchar(36)	varchar(36)	varchar(36)	varchar(36)	int	varchar（140）	date	varchar	date	varchar	int
	UUID（）	外键			删除标志																	删除标志
																						
#### 用户维护建议信息	sys_dbms_advi_mess_info	说明	系统维护建议说明																			
	唯一约束建	分类	建议消息	建议执行语句	针对的表名	针对的表名	针对的数据库	描述	插入时间	插入人	标记											
	uuid	type	message	execute_sql	table_desc	table_name	jdbc_uuid	discription	create_time	create_user	delete_flag											
	varchar（36）	varchar（100）	varchar（2000）	varchar（2000）	varchar（50）	varchar（36）	varchar（36）	varchar（140）	date	varchar	int											
	UUID（）										删除标志											
																						
#### 数据统计表	sys_dbms_cout_info	说明	每天每个表的增量输出信息																			
	唯一约束建	表名称id	表名名	数据量	增量	插入时间	插入人	标记														
	uuid	table_id	table_name	all_count	inc_number	create_time	create_user	delete_flag														
	varchar（36）	varchar（36）	varchar（30）	int	int	date	varchar	int														
	UUID()	外键						删除标志														
																						
#### 数据分析组	sys_dbms_chart_dime_group																					
	唯一约束建	标题	主题	排序	描述	描述	插入时间	插入人	更新时间	更新人	标记											
	uuid	title	theme	group_order	discription	discription	create_time	create_user	updata_time	updata_user	delete_flag											
	varchar（36）	varchar(36)	varchar(36)	varchar(200)	varchar（140）	date	date	varchar	date	varchar	int											
	UUID()										删除标志											
																						
#### 数据分析分类	sys_dbms_chart_dime																					
	唯一约束建	唯一约束建	标题	排序	统计类型	主题	图表种类	开始数据	返回结果结束数据	宽	高	表id	统计的字段	统计字段2	描述	插入时间	插入人	更新时间	更新人	标记		
	uuid	group_uuid	title	dimeOrder	countType	theme	chartType	startNum	endNum	width	heigth	table_uuid	column_uuid1	column_uuid2	discription	create_time	create_user	updata_time	updata_user	delete_flag		
	varchar（36）	varchar（36）	varchar（140）	int	varchar（140）	varchar（140）	varchar（140）	int	int	int	int	varchar（30）	varchar（30）	varchar（30）	varchar（140）	date	varchar	date	varchar	int		
	UUID()	UUID()																		删除标志		
																						
#### 数据分析详细条件	sys_dbms_chart_dime_data																					
	唯一约束建	唯一约束建	列id	列含义	符号	值	排序	描述	插入时间	插入人	更新时间	更新人	标记									
	uuid	dimeUuid	colsUuid	colsDesc	symbol	conditions	table_order	discription	create_time	create_user	updata_time	updata_user	delete_flag									
	varchar（36）	varchar（36）	varchar（36）	varchar（140）	varchar（140）	varchar（140）	int	varchar（140）	date	varchar	date	varchar	int									
	UUID()	UUID()											删除标志									
