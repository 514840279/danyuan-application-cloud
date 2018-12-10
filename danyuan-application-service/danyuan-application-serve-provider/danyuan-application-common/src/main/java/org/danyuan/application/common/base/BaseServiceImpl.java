package org.danyuan.application.common.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;

/**    
*  文件名 ： BaseServiceImpl.java  
*  包    名 ： org.danyuan.application.common.base  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年12月8日 上午9:41:12  
*  版    本 ： V1.0    
*/
@NoRepositoryBean
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	BaseDao<T> baseDao;
	
	/** 
	*  方法名 ： findOne
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param entity
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#findOne(java.lang.Object)  
	*  作    者 ： wang  
	*/
	
	@Override
	public T findOne(T entity) {
		if (entity == null) {
			return null;
		}
		Example<T> example = Example.of(entity);
		Optional<T> optional = baseDao.findOne(example);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	/** 
	*  方法名 ： findAll
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param entity
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#findAll(java.lang.Object)  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<T> findAll(T entity) {
		if (entity == null) {
			return null;
		}
		Example<T> example = Example.of(entity);
		List<T> list = baseDao.findAll(example);
		return list;
	}
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param entity  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#save(java.lang.Object)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void save(T entity) {
		if (entity == null) {
			// TODO 判断空的方法
			return;
		}
		baseDao.save(entity);
	}
	
	/** 
	*  方法名 ： saveAll
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param entities  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#saveAll(java.util.List)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void saveAll(List<T> entities) {
		baseDao.saveAll(entities);
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param entity  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#delete(java.lang.Object)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}
	
	/** 
	*  方法名 ： deleteAll
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param entities  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#deleteAll(java.util.List)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void deleteAll(List<T> entities) {
		baseDao.deleteAll(entities);
	}
	
	/** 
	*  方法名 ： trunc
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ：   
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#trunc()  
	*  作    者 ： wang  
	*/
	
	@Override
	public void trunc() {
		baseDao.deleteAllInBatch();
	}
	
	/** 
	*  方法名 ： findAll
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#findAll(org.danyuan.application.common.base.Pagination)  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<T> findAll(Pagination<T> vo) {
		return null;
	}
	
	/** 
	*  方法名 ： page
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseService#page(org.danyuan.application.common.base.Pagination)  
	*  作    者 ： wang  
	*/
	
	@Override
	public Page<T> page(Pagination<T> vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}