package org.danyuan.application.common.base;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

/**    
*  文件名 ： BaseController.java  
*  包    名 ： tk.ainiyue.danyuan.application.common.base  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年4月3日 下午11:03:46  
*  版    本 ： V1.0    
*/
public interface BaseController<T> {
	
	public Page<T> page(Pagination<T> vo);
	
	public List<T> findAll(T info);
	
	public T findOne(T info);
	
	public T save(T info);
	
	public Map<String, Object> saveAll(Pagination<T> vo);
	
	public Map<String, Object> deleteAll(Pagination<T> vo);
	
	public Map<String, Object> delete(T info);
	
	public Map<String, Object> trunc();
	
}