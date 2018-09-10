# 权限管理设计


项目信息	sys_system_info	说明	项目表									
	唯一主键	系统	描述	开发人	插入时间	插入人	更新时间	更新人	标记		后台程序	99c74ada3a1411e6bdcb10bf48e1d36a
	uuid	system_name	discription	developer	create_time	create_user	updata_time	updata_user	delete_flag			
	varchar（36）	varchar（100）	varchar（200）	varchar（50）	date	varchar	date	varchar	varchar（30）			
	UUID（）								删除标志			
												
菜单信息	sys_menu_info	说明	网页动态加载模块的辅助表，配置系统请求地址									
	唯一主键	系统	上一级id	名称	uri地址	类样式	描述	插入时间	插入人	更新时间	更新人	标记
	uuid	system_id	parents_id	name	uri	icon	discription	create_time	create_user	updata_time	updata_user	delete_flag
	varchar（36）	varchar（36）	varchar（36）	varchar（50）	varchar（1020）	varchar(100)	varchar（140）	date	varchar	date	varchar	varchar（30）
	UUID（）	外链接系统	自连接外键									删除标志
												
机构管理												
机构信息	sys_organization_info	说明	机构描述									
	唯一主键	机构名称	机构描述	插入时间	插入人	更新时间	更新人	标记				
	uuid	organization_name	organization_discription	create_time	create_user	updata_time	updata_user	delete_flag				
	varchar（36）	varchar（50）	varchar（1020）	date	varchar	date	varchar	varchar（30）				
	UUID（）							删除标志				
												
部门管理												
部门信息	sys_department_info	说明	部门描述									
	唯一主键	机构id	部门名称	部门描述	插入时间	插入人	更新时间	更新人	标记			
	uuid	organization_id	department_name	department_discription	create_time	create_user	updata_time	updata_user	delete_flag			
	varchar（36）	varchar（36）	varchar（50）	varchar（1020）	date	varchar	date	varchar	varchar（30）			
	UUID（）	外键机构id							删除标志			
角色管理												
角色信息	sys_roles_info	说明	角色描述									
	唯一主键	部门id	角色名称	描述	插入时间	插入人	更新时间	更新人	标记			
	uuid	department_id	role_name	role_discription	create_time	create_user	updata_time	updata_user	delete_flag			
	varchar（36）	varchar（36）	varchar（50）	varchar（1020）	date	varchar	date	varchar	varchar（30）			
	UUID（）	外键部门id							删除标志			
												
角色菜单信息	sys_roles_jurisdiction_info	说明	角色权限表									
	唯一主键	角色id	菜单id	插入时间	插入人	更新时间	更新人	标记				
	uuid	role_id	menu_id	create_time	create_user	updata_time	updata_user	delete_flag				
	varchar（36）	varchar（36）	varchar（36）	date	varchar	date	varchar	varchar（30）				
	UUID（）	合并键						删除标志				
												
用户管理												
用户信息	sys_user_base_info	说明	用户信息									
	唯一主键	登录名	密码	姓名	性别	年龄	头像	插入时间	插入人	更新时间	更新人	标记
	uuid	user_name	password	persion_name	sex	age	head_pic	create_time	create_user	updata_time	updata_user	delete_flag
	varchar（36）	varchar（50）	varchar（50）	varchar（50）	varchar(2)	namber	varchar(1000)	date	varchar	date	varchar	varchar（30）
	UUID（）	唯一										删除标志
权限管理												
用户角色权限信息	sys_user_roles_info	说明	用户角色									
	唯一主键	用户id	角色id	插入时间	插入人	更新时间	更新人	标记				
	uuid	user_id	roles_id	create_time	create_user	updata_time	updata_user	delete_flag				
	varchar（36）	varchar（36）	varchar（36）	date	varchar	date	varchar	varchar（30）				
	UUID（）	联合建						删除标志				
