package tk.ainiyue.danyuan.application.dbms.tabs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import tk.ainiyue.danyuan.application.common.base.BaseService;
import tk.ainiyue.danyuan.application.dbms.tabs.dao.SysDatabaseDao;
import tk.ainiyue.danyuan.application.dbms.tabs.po.SysDatabaseInfo;

/**
 * 文件名 ： SysDatabaseService.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.addr.service.impl
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:47:40
 * 版 本 ： V1.0
 */
@Service("sysDatabaseService")
public class SysDatabaseServiceImpl implements BaseService<SysDatabaseInfo> {
	//
	@Autowired
	private SysDatabaseDao sysDatabaseDao;

	public List<SysDatabaseInfo> findAll() {
		return sysDatabaseDao.findAll();
	}

	@Override
	public void save(SysDatabaseInfo sysDatabaseInfo) {
		sysDatabaseDao.save(sysDatabaseInfo);
	}
	
	public void deleteSysDatabaseInfo(List<SysDatabaseInfo> list) {
		sysDatabaseDao.delete(list);
	}
	
	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public SysDatabaseInfo findOne(SysDatabaseInfo info) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#findAll(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public List<SysDatabaseInfo> findAll(SysDatabaseInfo info) {
		// TODO Auto-generated method stub
		return null;
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
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#page(int, int, java.lang.Object, java.util.Map, org.springframework.data.domain.Sort.Order[])
	 * 作 者 ： Administrator
	 */

	@Override
	public Page<SysDatabaseInfo> page(int pageNumber, int pageSize, SysDatabaseInfo info, Map<String, String> map, Order... order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#save(java.util.List)
	 * 作 者 ： Administrator
	 */

	@Override
	public void save(List<SysDatabaseInfo> list) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#delete(java.lang.Object)
	 * 作 者 ： Administrator
	 */

	@Override
	public void delete(SysDatabaseInfo info) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#delete(java.util.List)
	 * 作 者 ： Administrator
	 */

	@Override
	public void delete(List<SysDatabaseInfo> list) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法名 ： trunc
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ：
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#trunc()
	 * 作 者 ： Administrator
	 */

	@Override
	public void trunc() {
		// TODO Auto-generated method stub

	}
	
}
