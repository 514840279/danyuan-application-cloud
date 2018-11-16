package org.danyuan.application.crawler.param.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.crawler.param.dao.SysCrawlerRulerInfoDao;
import org.danyuan.application.crawler.param.po.SysCrawlerRulerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： SysCrawlerRulerInfoService.java
 * 包 名 ： org.danyuan.application.crawler.param.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2018年11月1日 下午9:20:50
 * 版 本 ： V1.0
 */
@Service
public class SysCrawlerRulerInfoService implements BaseService<SysCrawlerRulerInfo> {
	
	@Autowired
	SysCrawlerRulerInfoDao sysCrawlerRulerInfoDao;
	
	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param entity
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public SysCrawlerRulerInfo findOne(SysCrawlerRulerInfo entity) {
		Example<SysCrawlerRulerInfo> example = Example.of(entity);
		Optional<SysCrawlerRulerInfo> t = sysCrawlerRulerInfoDao.findOne(example);
		if (t.isPresent()) {
			entity = t.get();
		}
		return entity;
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param entities
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findAll(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public List<SysCrawlerRulerInfo> findAll(SysCrawlerRulerInfo entities) {
		Example<SysCrawlerRulerInfo> example = Example.of(entities);
		return sysCrawlerRulerInfoDao.findAll(example);
	}
	
	/**
	 * 方法名 ： page
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param pageNumber
	 * 参 数 ： @param pageSize
	 * 参 数 ： @param entity
	 * 参 数 ： @param map
	 * 参 数 ： @param order
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#page(int, int, java.lang.Object, java.util.Map, org.springframework.data.domain.Sort.Order[])
	 * 作 者 ： wang
	 */
	
	@Override
	public Page<SysCrawlerRulerInfo> page(int pageNumber, int pageSize, SysCrawlerRulerInfo entity, Map<String, String> map, List<Order> order) {
		Example<SysCrawlerRulerInfo> example = Example.of(entity);
		Sort sort = Sort.by(order);
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		
		return sysCrawlerRulerInfoDao.findAll(example, request);
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param entity
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#save(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public void save(SysCrawlerRulerInfo entity) {
		sysCrawlerRulerInfoDao.save(entity);
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param entities
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#save(java.util.List)
	 * 作 者 ： wang
	 */
	
	@Override
	public void saveAll(List<SysCrawlerRulerInfo> entities) {
		sysCrawlerRulerInfoDao.saveAll(entities);
	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param entity
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#delete(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public void delete(SysCrawlerRulerInfo entity) {
		sysCrawlerRulerInfoDao.delete(entity);
	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param entities
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#delete(java.util.List)
	 * 作 者 ： wang
	 */
	
	@Override
	public void deleteAll(List<SysCrawlerRulerInfo> entities) {
		sysCrawlerRulerInfoDao.deleteAll(entities);
	}
	
	/**
	 * 方法名 ： trunc
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ：
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#trunc()
	 * 作 者 ： wang
	 */
	
	@Override
	public void trunc() {
		sysCrawlerRulerInfoDao.deleteAllInBatch();
	}
	
}
