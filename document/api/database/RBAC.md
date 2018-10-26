# 权限管理设计

#### 系统管理
###### 项目信息
项目信息	sys_system_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |system_name|系统||varchar|100|| | |
|9 |developer|开发人||varchar|50|| | ||

###### 菜单信息
菜单信息	sys_menu_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |system_id|系统||varchar|100|| | |
|9 |parents_id|上一级id||varchar|50|| | |
|10 |uri|uri地址||varchar|50|| | |
|11 |icon|类样式||varchar|50|| | ||


#### 机构管理
###### 机构信息
机构信息	sys_organization_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |org_name|机构名称||varchar|100|| | |
|9 |org_addr|机构地址||varchar|500|| | |
|10|org_email|机构邮箱||varchar|120|| | ||


###### 部门信息
部门信息	sys_department_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |org_id|机构id||varchar|100|| | |
|9 |department_name|部门名称||varchar|500|| | ||

												
###### 角色信息
角色信息	sys_roles_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |department_id|部门id||varchar|100|| | |
|9 |role_name|角色名称||varchar|500|| | ||

###### 角色菜单信息
角色菜单信息	sys_roles_jurisdiction_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |role_id|角色id||varchar|100|| | |
|9 |menu_id|菜单id||varchar|500|| | ||

#### 用户管理
###### 用户登录信息
用户信息	sys_user_base_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |user_name|登录名||varchar|100|| | |
|9 |password|密码||varchar|500|| | |
|10 |salt|加盐||varchar|6|| | ||

												
###### 用户角色权限信息
用户角色权限信息	sys_user_roles_info

|No|字段名|字段中文名|PKEY|数据类型|位数|NOT NULL|初期値|内容说明|
|--|-----|---------|----|--------|---|---------|-----|-------|
|1 |uuid|唯一约束建|true|varchar|36|true|UUID（）|主键|
|2 |create_time|插入时间||datetime||true| | |
|3 |create_user|插入人||varchar|50|true| | |
|4 |updata_time|更新时间||datetime||true| | |
|5 |updata_user|更新人||varchar|50|true| | |
|6 |delete_flag|标记||int||true| | |
|7 |discription|描述||varchar|200|| | |
|8 |user_id|用户id||varchar|100|| | |
|9 |roles_id|角色id||varchar|500|| | ||
