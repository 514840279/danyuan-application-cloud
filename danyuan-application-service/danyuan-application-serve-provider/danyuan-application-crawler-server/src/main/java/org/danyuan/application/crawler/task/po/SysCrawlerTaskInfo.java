package org.danyuan.application.crawler.task.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 文件名 ： SysSeedInfo.java
 * 包 名 ： tk.ainiyue.danyuan.application.crawler.task.po
 * 描 述 ： 采集种子配置
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年7月10日 下午5:21:51
 * 版 本 ： V1.0
 */
@Entity
@Table(name = "sys_crawler_task_info")
public class SysCrawlerTaskInfo {
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "uuid", columnDefinition = " varchar(36) COMMENT '主键'")
	private String	uuid;
	
	@Column(name = "task_name", columnDefinition = " varchar(50) COMMENT '主键'")
	private String	taskName;
	
	@Column(name = "start_time", columnDefinition = " timestamp COMMENT ' 任务执行开始时间' ")
	private Date	startTime;
	
	@Column(name = "last_excute_time", columnDefinition = " timestamp COMMENT '最近一次执行时间'")
	private Date	lastExcuteTime;
	
	@Column(name = "surplus_num", columnDefinition = " int COMMENT '预计剩余采集数量'")
	private Integer	surplusNum;
	
	@Column(name = "success_num", columnDefinition = " int COMMENT '完成数量'")
	private Integer	successNum;
	
	@Column(name = "task_flag", columnDefinition = " int COMMENT '采集通用标识' ")
	private Integer	taskFlag;
	
	@Column(name = "error_num", columnDefinition = " int COMMENT '采集出错数量'")
	private Integer	errorNum;
	
	@Column(name = "excute_flag", columnDefinition = " int COMMENT '执行状态'")
	private Integer	excuteFlag;
	
	@Column(name = "excute_batch", columnDefinition = " varchar(500) COMMENT '执行的命令'")
	private String	excuteBatch;
	
	@Column(name = "discription", columnDefinition = "varchar(200) COMMENT '资源功能描述'")
	private String	discription;
	
	@Column(name = "create_time", updatable = false, columnDefinition = " timestamp default CURRENT_TIMESTAMP COMMENT '录入时间'")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Date	createTime;
	
	@Column(name = "create_user", updatable = false, columnDefinition = " varchar(50) default 'system' COMMENT '录入人员'")
	private String	createUser;
	
	@Column(name = "update_time", insertable = false, columnDefinition = " timestamp default CURRENT_TIMESTAMP   COMMENT '更新时间'")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Date	updateTime;	 // updata_time 更新时间
	
	@Column(name = "update_user", insertable = false, columnDefinition = " varchar(50) default 'system'  COMMENT '更新人员'")
	private String	updateUser;	 // updata_user 更新人
	
	@Column(name = "delete_flag", columnDefinition = " int default 0 COMMENT '停用标记'")
	private Integer	deleteFlag;
	
	/**  
	 *  方法名 ： getUuid 
	 *  功    能 ： 返回变量 uuid 的值  
	 *  @return: String 
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**  
	 *  方法名 ： setUuid 
	 *  功    能 ： 设置变量 uuid 的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**  
	 *  方法名 ： getTaskName 
	 *  功    能 ： 返回变量 taskName 的值  
	 *  @return: String 
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**  
	 *  方法名 ： setTaskName 
	 *  功    能 ： 设置变量 taskName 的值
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	/**  
	 *  方法名 ： getStartTime 
	 *  功    能 ： 返回变量 startTime 的值  
	 *  @return: Date 
	 */
	public Date getStartTime() {
		return startTime;
	}
	
	/**  
	 *  方法名 ： setStartTime 
	 *  功    能 ： 设置变量 startTime 的值
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**  
	 *  方法名 ： getLastExcuteTime 
	 *  功    能 ： 返回变量 lastExcuteTime 的值  
	 *  @return: Date 
	 */
	public Date getLastExcuteTime() {
		return lastExcuteTime;
	}
	
	/**  
	 *  方法名 ： setLastExcuteTime 
	 *  功    能 ： 设置变量 lastExcuteTime 的值
	 */
	public void setLastExcuteTime(Date lastExcuteTime) {
		this.lastExcuteTime = lastExcuteTime;
	}
	
	/**  
	 *  方法名 ： getSurplusNum 
	 *  功    能 ： 返回变量 surplusNum 的值  
	 *  @return: Integer 
	 */
	public Integer getSurplusNum() {
		return surplusNum;
	}
	
	/**  
	 *  方法名 ： setSurplusNum 
	 *  功    能 ： 设置变量 surplusNum 的值
	 */
	public void setSurplusNum(Integer surplusNum) {
		this.surplusNum = surplusNum;
	}
	
	/**  
	 *  方法名 ： getSuccessNum 
	 *  功    能 ： 返回变量 successNum 的值  
	 *  @return: Integer 
	 */
	public Integer getSuccessNum() {
		return successNum;
	}
	
	/**  
	 *  方法名 ： setSuccessNum 
	 *  功    能 ： 设置变量 successNum 的值
	 */
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}
	
	/**  
	 *  方法名 ： getTaskFlag 
	 *  功    能 ： 返回变量 taskFlag 的值  
	 *  @return: Integer 
	 */
	public Integer getTaskFlag() {
		return taskFlag;
	}
	
	/**  
	 *  方法名 ： setTaskFlag 
	 *  功    能 ： 设置变量 taskFlag 的值
	 */
	public void setTaskFlag(Integer taskFlag) {
		this.taskFlag = taskFlag;
	}
	
	/**  
	 *  方法名 ： getErrorNum 
	 *  功    能 ： 返回变量 errorNum 的值  
	 *  @return: Integer 
	 */
	public Integer getErrorNum() {
		return errorNum;
	}
	
	/**  
	 *  方法名 ： setErrorNum 
	 *  功    能 ： 设置变量 errorNum 的值
	 */
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}
	
	/**  
	 *  方法名 ： getExcuteFlag 
	 *  功    能 ： 返回变量 excuteFlag 的值  
	 *  @return: Integer 
	 */
	public Integer getExcuteFlag() {
		return excuteFlag;
	}
	
	/**  
	 *  方法名 ： setExcuteFlag 
	 *  功    能 ： 设置变量 excuteFlag 的值
	 */
	public void setExcuteFlag(Integer excuteFlag) {
		this.excuteFlag = excuteFlag;
	}
	
	/**  
	 *  方法名 ： getExcuteBatch 
	 *  功    能 ： 返回变量 excuteBatch 的值  
	 *  @return: String 
	 */
	public String getExcuteBatch() {
		return excuteBatch;
	}
	
	/**  
	 *  方法名 ： setExcuteBatch 
	 *  功    能 ： 设置变量 excuteBatch 的值
	 */
	public void setExcuteBatch(String excuteBatch) {
		this.excuteBatch = excuteBatch;
	}
	
	/**  
	 *  方法名 ： getDiscription 
	 *  功    能 ： 返回变量 discription 的值  
	 *  @return: String 
	 */
	public String getDiscription() {
		return discription;
	}
	
	/**  
	 *  方法名 ： setDiscription 
	 *  功    能 ： 设置变量 discription 的值
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	/**  
	 *  方法名 ： getCreateTime 
	 *  功    能 ： 返回变量 createTime 的值  
	 *  @return: Date 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**  
	 *  方法名 ： setCreateTime 
	 *  功    能 ： 设置变量 createTime 的值
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**  
	 *  方法名 ： getCreateUser 
	 *  功    能 ： 返回变量 createUser 的值  
	 *  @return: String 
	 */
	public String getCreateUser() {
		return createUser;
	}
	
	/**  
	 *  方法名 ： setCreateUser 
	 *  功    能 ： 设置变量 createUser 的值
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	/**  
	 *  方法名 ： getUpdateTime 
	 *  功    能 ： 返回变量 updateTime 的值  
	 *  @return: Date 
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**  
	 *  方法名 ： setUpdateTime 
	 *  功    能 ： 设置变量 updateTime 的值
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**  
	 *  方法名 ： getUpdateUser 
	 *  功    能 ： 返回变量 updateUser 的值  
	 *  @return: String 
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	
	/**  
	 *  方法名 ： setUpdateUser 
	 *  功    能 ： 设置变量 updateUser 的值
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	/**  
	 *  方法名 ： getDeleteFlag 
	 *  功    能 ： 返回变量 deleteFlag 的值  
	 *  @return: Integer 
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	
	/**  
	 *  方法名 ： setDeleteFlag 
	 *  功    能 ： 设置变量 deleteFlag 的值
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
