# 数据库管理设计

#### 数据库配置
###### 用户查询配置
用户查询配置	sys_dbms_user_index_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |user_desc|配置列信息||varchar|100|| | |
|9 |user_index|配置列信息||varchar|100|| | |
|10 |user_placeholder|提示信息||varchar|15|| | |
|11 |user_order|排序||int||| | |
|12 |multeity|多条件配置||int||| | |
|13 |chart|图表配置||int||| | ||


####### 数据库信息
数据库信息	sys_dbms_tabs_jdbc_info	

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |type|数据库类型||varchar|30|| | 人为进行分类|
|9 |database_name|数据库名称||varchar|50|| | |
|10 |ip|地址||varchar|22|| | |
|11 |port|端口||varchar|6|| | |
|12 |username|用户名||varchar|30|| | |
|13 |password|密码||varchar|30|| | |
|14 |driver|驱动类||varchar|240|| | ||


###### 数据库表分类	
数据库表分类	sys_dbms_tabs_type_info	

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |type_name|类型名称||varchar|30|| | |
|9 |type_class|类型代码||varchar|50|| | |
|10 |type_order|排序||varchar|22|| | |
|11 |type_icon|样式||varchar|6|| | ||



###### 表信息
表信息	sys_dbms_tabs_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |jdbc_uuid|数据库id||varchar|36|| |数据库类型id|
|9 |type_uuid|表类型ID||varchar|36|| | 表类型id|
|10 |tabs_name|数据库表名称||varchar|30|| | |
|11 |tabs_desc|表的翻译||varchar|30|| | |
|12 |tabs_rows|表数据量||int||| | |
|13 |tabs_space|空间大小||int||| | |
|14 |tabs_order|排序||int|6|| | ||



###### 字段信息
字段信息	sys_dbms_tabs_cols_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |table_uuid|表名称id||varchar|36|| ||
|9 |cols_name|字段名||varchar|30|| | |
|10 |cols_desc|字段的翻译||varchar|50|| | |
|11 |cols_length|字段的长度||int||| | |
|12 |cols_order|字段排序||int||| | |
|13 |cols_type|字段类型||varchar|30|| | |
|14 |colsAlign|对齐方式||varchar||30| | |
|15 |colsValign|对齐方式||varchar|30|| | |
|16 |colsWidth|列宽度||varchar|30|| | |
|17 |colsVisible|列项目隐藏||int||| | |
|18 |colsSwitchable|列项目的选项卡隐藏||int||| | |
|19 |colsIndex|用户查询列配置||varchar|30|| | |
|20 |colsIcon|icon||varchar|30|| | |
|21 |colsColor|背景色||varchar|150|| | ||


###### 用户维护建议信息
用户维护建议信息	sys_dbms_advi_mess_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |type|分类||varchar|36|| ||
|9 |message|建议消息||varchar|30|| | |
|10 |execute_sql|建议执行语句||varchar|50|| | |
|11 |table_name|针对的表名||int||| | |
|12 |jdbc_uuid|针对的数据库||int||| | ||


#### 数据统计
###### 数据统计表
数据统计表	sys_dbms_cout_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |table_id|表名称id||varchar|36|| ||
|9 |table_name|表名名||varchar|30|| | |
|10 |all_count|数据量||int||| | |
|11 |inc_number|增量||int||| | ||

#### 数据分析

###### 数据分析组
数据分析组	sys_dbms_chart_dime_group

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |title|标题||varchar|36|| ||
|9 |theme|主题||varchar|30|| | |
|10 |group_order|排序||int||| | ||




###### 数据分析分类
数据分析分类	sys_dbms_chart_dime

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |group_uuid|唯一约束建||varchar|36|| ||
|9 |title|标题||varchar|30|| | |
|10 |dimeOrder|排序||int||| | |
|11 |countType|统计类型||varchar|30|| | |
|12 |theme|主题||varchar|30|| | |
|13 |chartType|图表种类||varchar|30|| | |
|14 |startNum|开始数据||int||| | |
|15 |endNum|结束数据||int||| | |
|16 |width|宽||int||| | |
|17 |heigth|高||int||| | |
|18 |table_uuid|表id||varchar|36|| | |
|19 |column_uuid|统计的字段||varchar|36|| | |



###### 数据分析详细条件
数据分析详细条件	sys_dbms_chart_dime_data

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |dimeUuid|唯一约束建||varchar|36|| ||
|9 |colsUuid|列id||varchar|30|| | |
|10 |colsDesc|列含义||int||| | |
|11 |symbol|符号||varchar|30|| | |
|12 |conditions|值||varchar|30|| | |
|13 |table_order|排序||varchar|30|| | |