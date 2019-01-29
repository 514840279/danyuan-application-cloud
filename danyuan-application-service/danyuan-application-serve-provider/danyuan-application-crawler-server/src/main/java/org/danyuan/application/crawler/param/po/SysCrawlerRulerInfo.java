package org.danyuan.application.crawler.param.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.danyuan.application.common.base.BaseEntity;

/**
 * 文件名 ： SysRolerInfo.java
 * 包 名 ： tk.ainiyue.danyuan.application.crawler.param.po
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年7月20日 下午2:51:48
 * 版 本 ： V1.0
 */
@Entity
@Table(name = "sys_crawler_ruler_info")
public class SysCrawlerRulerInfo extends BaseEntity {

	@Column(name = "task_uuid", columnDefinition = " varchar(36) not null COMMENT '任务id'")
	private String	taskUuid;

	@Column(name = "type", columnDefinition = " varchar(200) COMMENT '规则类别'")
	private String	type;

	@Column(name = "name", columnDefinition = " varchar(200) COMMENT '名称'")
	private String	name;										// name 名称

	@Column(name = "parent_uuid", columnDefinition = " varchar(36) COMMENT '上一层id'")
	private String	parentUuid;

	@Column(name = "statue", columnDefinition = " varchar(36) COMMENT '状态'")
	private String	statue;
	
	/**
	 *  方法名 ： getTaskUuid
	 *  功    能 ： 返回变量 taskUuid 的值
	 *  @return: String
	 */
	public String getTaskUuid() {
		return taskUuid;
	}
	
	/**
	 *  方法名 ： setTaskUuid
	 *  功    能 ： 设置变量 taskUuid 的值
	 */
	public void setTaskUuid(String taskUuid) {
		this.taskUuid = taskUuid;
	}
	
	/**
	 *  方法名 ： getType
	 *  功    能 ： 返回变量 type 的值
	 *  @return: String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 *  方法名 ： setType
	 *  功    能 ： 设置变量 type 的值
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 *  方法名 ： getName
	 *  功    能 ： 返回变量 name 的值
	 *  @return: String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 *  方法名 ： setName
	 *  功    能 ： 设置变量 name 的值
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  方法名 ： getParentUuid
	 *  功    能 ： 返回变量 parentUuid 的值
	 *  @return: String
	 */
	public String getParentUuid() {
		return parentUuid;
	}
	
	/**
	 *  方法名 ： setParentUuid
	 *  功    能 ： 设置变量 parentUuid 的值
	 */
	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}
	
	/**
	 *  方法名 ： getStatue
	 *  功    能 ： 返回变量 statue 的值
	 *  @return: String
	 */
	public String getStatue() {
		return statue;
	}
	
	/**
	 *  方法名 ： setStatue
	 *  功    能 ： 设置变量 statue 的值
	 */
	public void setStatue(String statue) {
		this.statue = statue;
	}
	
}
