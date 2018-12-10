/**
 * 文件名：SysDicNameService.java 版本信息： 日期：2018年5月16日 Copyright 足下 Corporation 2018 版权所有
 */
package org.danyuan.application.common.dic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.common.dic.dao.SysDicKeyListDao;
import org.danyuan.application.common.dic.dao.SysDicNameDao;
import org.danyuan.application.common.dic.po.SysDicKeyList;
import org.danyuan.application.common.dic.po.SysDicName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： SysDicNameService.java
 * 包 名 ： com.shumeng.application.softm.dic.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月16日 上午9:35:09
 * 版 本 ： V1.0
 */
@Service
public class SysDicNameService implements BaseService<SysDicName> {
	@Autowired
	private SysDicNameDao		sysDicNameDao;
	@Autowired
	private SysDicKeyListDao	sysDicKeyListDao;

	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public SysDicName findOne(SysDicName info) {
		Example<SysDicName> example = Example.of(info);
		Optional<SysDicName> t = sysDicNameDao.findOne(example);
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
	public List<SysDicName> findAll(SysDicName info) {
		Example<SysDicName> example = Example.of(info);
		return sysDicNameDao.findAll(example);
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
	public Page<SysDicName> page(Pagination<SysDicName> vo) {
		List<Order> orders = new ArrayList<>();
		if (vo.getSortName() != null) {
			orders = vo.getOrders();
		} else {
			Order order = new Order(Direction.DESC, "createTime");
			orders.add(order);
		}
		if (vo.getInfo() == null) {
			vo.setInfo(new SysDicName());
		}

		Sort sort = Sort.by(orders);
		PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
		return sysDicNameDao.findAll((Specification<SysDicName>) (root, query, cb) -> {
			if (vo.getInfo().getName() != null) {
				return cb.like(root.get("name").as(String.class), "%" + vo.getInfo().getName() + "%");
			} else {
				return null;
			}
		}, request);
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#save(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public void save(SysDicName info) {
		sysDicNameDao.save(info);
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#save(java.util.List)
	 * 作 者 ： Administrator
	 */

	@Override
	public void saveAll(List<SysDicName> list) {
		sysDicNameDao.saveAll(list);
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#delete(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public void delete(SysDicName info) {
		sysDicNameDao.delete(info);
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see com.shumeng.application.common.base.BaseService#delete(java.util.List)
	 * 作 者 ： Administrator
	 */

	@Override
	public void deleteAll(List<SysDicName> list) {
		sysDicNameDao.deleteAll(list);
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
		sysDicNameDao.deleteAllInBatch();
	}

	/**
	 * 方法名： checkCode
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param url
	 * 参 数： @return
	 * 返 回： boolean
	 * 作 者 ： Administrator
	 * @throws
	 */
	public boolean checkCode(String code) {
		SysDicName info = new SysDicName();
		info.setCode(code);
		Example<SysDicName> example = Example.of(info);
		List<SysDicName> list = sysDicNameDao.findAll(example);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 方法名： findkeyList
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param code
	 * 参 数： @return
	 * 返 回： boolean
	 * 作 者 ： Administrator
	 * @throws
	 */
	public List<SysDicKeyList> findkeyList(SysDicName info) {
		Example<SysDicName> example = Example.of(info);
		Optional<SysDicName> reinfo = sysDicNameDao.findOne(example);
		if (reinfo.isPresent()) {
			info = reinfo.get();
			SysDicKeyList key = new SysDicKeyList();
			key.setNameUuid(info.getUuid());

			Example<SysDicKeyList> ke = Example.of(key);
			Order[] order = { new Order(Direction.ASC, "keyOrder"), new Order(Direction.ASC, "createTime") };
			Sort sort = Sort.by(order);
			return sysDicKeyListDao.findAll(ke, sort);
		} else {
			return null;
		}
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
	public List<SysDicName> findAll(Pagination<SysDicName> vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
