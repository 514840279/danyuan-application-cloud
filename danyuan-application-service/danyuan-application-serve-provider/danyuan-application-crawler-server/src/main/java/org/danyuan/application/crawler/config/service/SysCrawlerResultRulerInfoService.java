package org.danyuan.application.crawler.config.service;

import java.util.List;
import java.util.Optional;

import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.crawler.config.dao.SysCrawlerResultRulerInfoDao;
import org.danyuan.application.crawler.config.po.SysCrawlerResultRulerInfo;
import org.danyuan.application.crawler.config.vo.SysCrawlerResultRulerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： SysCrawlerResultRulerInfoService.java
 * 包 名 ： org.danyuan.application.crawler.config.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2018年11月1日 下午8:46:46
 * 版 本 ： V1.0
 */
@Service
public class SysCrawlerResultRulerInfoService implements BaseService<SysCrawlerResultRulerInfo> {
	
	@Autowired
	SysCrawlerResultRulerInfoDao sysCrawlerResultRulerInfoDao;
	
	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public SysCrawlerResultRulerInfo findOne(SysCrawlerResultRulerInfo info) {
		Example<SysCrawlerResultRulerInfo> example = Example.of(info);
		Optional<SysCrawlerResultRulerInfo> t = sysCrawlerResultRulerInfoDao.findOne(example);
		if (t.isPresent()) {
			info = t.get();
		}
		return info;
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findAll(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public List<SysCrawlerResultRulerInfo> findAll(SysCrawlerResultRulerInfo info) {
		Example<SysCrawlerResultRulerInfo> example = Example.of(info);
		Sort sort = Sort.by(new Order(Direction.DESC, "createTime"));
		return sysCrawlerResultRulerInfoDao.findAll(example, sort);
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#save(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public void save(SysCrawlerResultRulerInfo entity) {
		sysCrawlerResultRulerInfoDao.save(entity);
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#save(java.util.List)
	 * 作 者 ： wang
	 */
	
	@Override
	public void saveAll(List<SysCrawlerResultRulerInfo> list) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#delete(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public void delete(SysCrawlerResultRulerInfo info) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#delete(java.util.List)
	 * 作 者 ： wang
	 */
	
	@Override
	public void deleteAll(List<SysCrawlerResultRulerInfo> list) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return
	 * 方法名： saveResultRulerInfo
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param vo
	 * 返 回： void
	 * 作 者 ： wang
	 * @throws
	 */
	public List<SysCrawlerResultRulerInfo> saveResultRulerInfo(SysCrawlerResultRulerVo vo) {
		SysCrawlerResultRulerInfo info = new SysCrawlerResultRulerInfo();
		info.setTableUuid(vo.getTableUuid());
		info.setRulerUuid(vo.getRulerUuid());
		Example<SysCrawlerResultRulerInfo> example = Example.of(info);
		sysCrawlerResultRulerInfoDao.deleteAll(sysCrawlerResultRulerInfoDao.findAll(example));
		if (vo.getList() != null) {
			for (SysCrawlerResultRulerInfo iterable_element : vo.getList()) {
				iterable_element.setTableUuid(vo.getTableUuid());
				iterable_element.setRulerUuid(vo.getRulerUuid());
				sysCrawlerResultRulerInfoDao.save(iterable_element);
			}
		}
		return sysCrawlerResultRulerInfoDao.findAll(example);
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findAll(org.danyuan.application.common.base.Pagination)
	 * 作 者 ： wang
	 */
	
	@Override
	public List<SysCrawlerResultRulerInfo> findAll(Pagination<SysCrawlerResultRulerInfo> vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 方法名 ： page
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#page(org.danyuan.application.common.base.Pagination)
	 * 作 者 ： wang
	 */
	
	@Override
	public Page<SysCrawlerResultRulerInfo> page(Pagination<SysCrawlerResultRulerInfo> vo) {
		Example<SysCrawlerResultRulerInfo> example = Example.of(vo.getInfo());
		Sort sort = Sort.by(vo.getOrders());
		PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
		return sysCrawlerResultRulerInfoDao.findAll(example, request);
	}
	
}
