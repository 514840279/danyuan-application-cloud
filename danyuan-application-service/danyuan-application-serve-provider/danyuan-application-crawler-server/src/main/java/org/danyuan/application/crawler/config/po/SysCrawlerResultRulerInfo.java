package org.danyuan.application.crawler.config.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.danyuan.application.common.base.BaseEntity;

/**
 * The persistent class for the sys_seed_result_ruler_info database table.
 */
@Entity
@Table(name = "sys_crawler_result_ruler_info")
@NamedQuery(name = "SysCrawlerResultRulerInfo.findAll", query = "SELECT s FROM SysCrawlerResultRulerInfo s")
public class SysCrawlerResultRulerInfo extends BaseEntity implements Serializable {
	
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long	serialVersionUID	= -8550950330729844126L;
	
	@Column(name = "cols_name", columnDefinition = "varchar(30) COMMENT '表字段名'")
	private String				colsName;
	
	@Column(name = "cols_uuid", columnDefinition = "varchar(36) COMMENT '表字段id'")
	private String				colsUuid;
	
	@Column(name = "ruler_colum_name", columnDefinition = "varchar(30) COMMENT '规则字段名'")
	private String				rulerColumName;
	
	@Column(name = "ruler_colum_uuid", columnDefinition = "varchar(36) COMMENT '规则字段id'")
	private String				rulerColumUuid;
	
	@Column(name = "ruler_uuid", columnDefinition = "varchar(36) COMMENT '规则id'")
	private String				rulerUuid;
	
	@Column(name = "table_uuid", columnDefinition = "varchar(36) COMMENT '表id'")
	private String				tableUuid;

	public SysCrawlerResultRulerInfo() {
	}
	
	@Override
	public String getUuid() {
		return this.uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getColsName() {
		return this.colsName;
	}
	
	public void setColsName(String colsName) {
		this.colsName = colsName;
	}
	
	public String getColsUuid() {
		return this.colsUuid;
	}
	
	public void setColsUuid(String colsUuid) {
		this.colsUuid = colsUuid;
	}
	
	@Override
	public Date getCreateTime() {
		return this.createTime;
	}
	
	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String getCreateUser() {
		return this.createUser;
	}
	
	@Override
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	@Override
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
	
	@Override
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Override
	public String getDiscription() {
		return this.discription;
	}
	
	@Override
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public String getRulerColumName() {
		return this.rulerColumName;
	}
	
	public void setRulerColumName(String rulerColumName) {
		this.rulerColumName = rulerColumName;
	}
	
	public String getRulerColumUuid() {
		return this.rulerColumUuid;
	}
	
	public void setRulerColumUuid(String rulerColumUuid) {
		this.rulerColumUuid = rulerColumUuid;
	}
	
	public String getRulerUuid() {
		return this.rulerUuid;
	}
	
	public void setRulerUuid(String rulerUuid) {
		this.rulerUuid = rulerUuid;
	}
	
	public String getTableUuid() {
		return this.tableUuid;
	}
	
	public void setTableUuid(String tableUuid) {
		this.tableUuid = tableUuid;
	}
	
	/**
	 * 方法名 ： getUpdateTime
	 * 功 能 ： 返回变量 updateTime 的值
	 *
	 * @return: Date
	 */
	@Override
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 方法名 ： setUpdateTime
	 * 功 能 ： 设置变量 updateTime 的值
	 */
	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 方法名 ： getUpdateUser
	 * 功 能 ： 返回变量 updateUser 的值
	 *
	 * @return: String
	 */
	@Override
	public String getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * 方法名 ： setUpdateUser
	 * 功 能 ： 设置变量 updateUser 的值
	 */
	@Override
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}