/**
 * 文件名：SysDicKeyListService.java 版本信息： 日期：2018年5月16日 Copyright 足下 Corporation 2018 版权所有
 */
package org.danyuan.application.common.dic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.common.dic.dao.SysDicKeyListDao;
import org.danyuan.application.common.dic.po.SysDicKeyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： SysDicKeyListService.java
 * 包 名 ： com.shumeng.application.softm.dic.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月16日 上午9:33:53
 * 版 本 ： V1.0
 */
@Service
public class SysDicKeyListService implements BaseService<SysDicKeyList> {

	@Autowired
	private SysDicKeyListDao sysDicKeyListDao;

	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public SysDicKeyList findOne(SysDicKeyList info) {
		Example<SysDicKeyList> example = Example.of(info);
		Optional<SysDicKeyList> t = sysDicKeyListDao.findOne(example);
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
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#findAll(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public List<SysDicKeyList> findAll(SysDicKeyList info) {
		Example<SysDicKeyList> example = Example.of(info);
		return sysDicKeyListDao.findAll(example);
	}

	/**
	 * 方法名 ： page
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param pageNumber
	 * 参 数 ： @param pageSize
	 * 参 数 ： @param info
	 * 参 数 ： @param map
	 * 参 数 ： @param order
	 * 参 数 ： @return
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#page(int, int, java.lang.Object, java.util.Map, org.springframework.data.domain.Sort.Order[])
	 * 作 者 ： Administrator
	 */

	@Override
	public Page<SysDicKeyList> page(Pagination<SysDicKeyList> vo) {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.ASC, "keyOrder"));
		if (vo.getSortName() != null) {
			orders = vo.getOrders();
		}
		if (vo.getInfo() == null) {
			vo.setInfo(new SysDicKeyList());
		}

		Example<SysDicKeyList> example = Example.of(vo.getInfo());
		Sort sort = Sort.by(orders);

		PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
		Page<SysDicKeyList> page = sysDicKeyListDao.findAll(example, request);
		return page;
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#save(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public void save(SysDicKeyList info) {
		sysDicKeyListDao.save(info);
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#save(java.util.List)
	 * 作 者 ： Administrator
	 */

	@Override
	public void saveAll(List<SysDicKeyList> list) {
		sysDicKeyListDao.saveAll(list);
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#delete(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public void delete(SysDicKeyList info) {
		sysDicKeyListDao.delete(info);
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#delete(java.util.List)
	 * 作 者 ： Administrator
	 */

	@Override
	public void deleteAll(List<SysDicKeyList> list) {
		sysDicKeyListDao.deleteInBatch(list);
	}

	/**
	 * 方法名 ： trunc
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ：
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#trunc()
	 * 作 者 ： Administrator
	 */

	@Override
	public void trunc() {
		sysDicKeyListDao.deleteAllInBatch();
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
	public List<SysDicKeyList> findAll(Pagination<SysDicKeyList> vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
