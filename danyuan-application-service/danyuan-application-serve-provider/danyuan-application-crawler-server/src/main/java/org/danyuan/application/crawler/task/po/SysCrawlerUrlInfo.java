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
@Table(name = "sys_crawler_url_info")
public class SysCrawlerUrlInfo {
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "uuid", columnDefinition = " varchar(36) COMMENT '主键'")
	private String	uuid;
	
	@Column(name = "task_uuid", columnDefinition = " varchar(36) COMMENT ' 任务id' ")
	private String	taskUuid;
	
	@Column(name = "url_type", columnDefinition = " varchar(36) COMMENT '网站类型'")
	private String	urlType;
	
	@Column(name = "url_name", columnDefinition = " varchar(100) COMMENT '网站名称'")
	private String	urlName;
	
	@Column(name = "web_icon", columnDefinition = " varchar(1000) COMMENT '网站商标'")
	private String	webIcon;
	
	@Column(name = "url", columnDefinition = " varchar(2000) COMMENT '链接地址' ")
	private String	url;
	
	@Column(name = "request_data", columnDefinition = " varchar(2000) COMMENT '请求时间'")
	private String	requestData;
	
	@Column(name = "request_type", columnDefinition = " int COMMENT '请求方式'")
	private Integer	requestType;
	
	@Column(name = "charset", columnDefinition = " varchar(20) COMMENT '字符集'")
	private String	charset;
	
	@Column(name = "discription", columnDefinition = " varchar(200) COMMENT '资源功能描述'")
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
	 * 方法名 ： getUuid
	 * 功 能 ： 返回变量 uuid 的值
	 *
	 * @return: String
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * 方法名 ： setUuid
	 * 功 能 ： 设置变量 uuid 的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
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
	 *  方法名 ： getUrlType 
	 *  功    能 ： 返回变量 urlType 的值  
	 *  @return: String 
	 */
	public String getUrlType() {
		return urlType;
	}
	
	/**  
	 *  方法名 ： setUrlType 
	 *  功    能 ： 设置变量 urlType 的值
	 */
	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}
	
	/**  
	 *  方法名 ： getUrlName 
	 *  功    能 ： 返回变量 urlName 的值  
	 *  @return: String 
	 */
	public String getUrlName() {
		return urlName;
	}
	
	/**  
	 *  方法名 ： setUrlName 
	 *  功    能 ： 设置变量 urlName 的值
	 */
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	
	/**  
	 *  方法名 ： getWebIcon 
	 *  功    能 ： 返回变量 webIcon 的值  
	 *  @return: String 
	 */
	public String getWebIcon() {
		return webIcon;
	}
	
	/**  
	 *  方法名 ： setWebIcon 
	 *  功    能 ： 设置变量 webIcon 的值
	 */
	public void setWebIcon(String webIcon) {
		this.webIcon = webIcon;
	}
	
	/**  
	 *  方法名 ： getUrl 
	 *  功    能 ： 返回变量 url 的值  
	 *  @return: String 
	 */
	public String getUrl() {
		return url;
	}
	
	/**  
	 *  方法名 ： setUrl 
	 *  功    能 ： 设置变量 url 的值
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**  
	 *  方法名 ： getRequestType 
	 *  功    能 ： 返回变量 requestType 的值  
	 *  @return: Integer 
	 */
	public Integer getRequestType() {
		return requestType;
	}
	
	/**  
	 *  方法名 ： setRequestType 
	 *  功    能 ： 设置变量 requestType 的值
	 */
	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}
	
	/**  
	 *  方法名 ： getRequestData 
	 *  功    能 ： 返回变量 requestData 的值  
	 *  @return: String 
	 */
	public String getRequestData() {
		return requestData;
	}
	
	/**  
	 *  方法名 ： setRequestData 
	 *  功    能 ： 设置变量 requestData 的值
	 */
	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	
	/**  
	 *  方法名 ： getCharset 
	 *  功    能 ： 返回变量 charset 的值  
	 *  @return: String 
	 */
	public String getCharset() {
		return charset;
	}
	
	/**  
	 *  方法名 ： setCharset 
	 *  功    能 ： 设置变量 charset 的值
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	/**
	 * 方法名 ： getDiscription
	 * 功 能 ： 返回变量 discription 的值
	 *
	 * @return: String
	 */
	public String getDiscription() {
		return discription;
	}
	
	/**
	 * 方法名 ： setDiscription
	 * 功 能 ： 设置变量 discription 的值
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	/**
	 * 方法名 ： getUpdateTime
	 * 功 能 ： 返回变量 updateTime 的值
	 *
	 * @return: Date
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 方法名 ： setUpdateTime
	 * 功 能 ： 设置变量 updateTime 的值
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 方法名 ： getUpdateUser
	 * 功 能 ： 返回变量 updateUser 的值
	 *
	 * @return: String
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * 方法名 ： setUpdateUser
	 * 功 能 ： 设置变量 updateUser 的值
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
	 * 方法名 ： getDeleteFlag
	 * 功 能 ： 返回变量 deleteFlag 的值
	 *
	 * @return: Integer
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	
	/**
	 * 方法名 ： setDeleteFlag
	 * 功 能 ： 设置变量 deleteFlag 的值
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	
}
