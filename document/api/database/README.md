# 数据库设计

###### 数据库表设计遵循数据结构规范

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | ||

###### 数据库设计

 1. rbac 标准权限管理系统
 2. dbms 数据库维护管理检索系统
 3. 

