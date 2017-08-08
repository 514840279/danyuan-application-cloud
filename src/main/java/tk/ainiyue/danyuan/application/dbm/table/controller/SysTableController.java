package tk.ainiyue.danyuan.application.dbm.table.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.ainiyue.danyuan.application.dbm.table.po.SysTableInfo;
import tk.ainiyue.danyuan.application.dbm.table.service.SysTableService;

/**
 * 文件名 ： SysTableController.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.table.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:54:36
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysTableInfo")
public class SysTableController {
	//
	private static final Logger	logger = LoggerFactory.getLogger(SysTableController.class);

	//
	@Autowired
	private SysTableService		sysTableService;
	
//	@Autowired
//	JdbcTemplate				jdbcTemplate;

	/**
	 * 方法名： findAll
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @return
	 * 返 回： List<SysSeedInfo>
	 * 作 者 ： Tenghui.Wang
	 * @throws
	 */
	@RequestMapping("/findAll")
	public List<SysTableInfo> findAll() {
		logger.info("findAll", SysTableController.class);
//		jdbcTemplate.execute("DROP TABLE IF EXISTS customers ");
//		jdbcTemplate.execute("CREATE TABLE customers(" +
//		        "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
		return sysTableService.findAll();
	}
}
