package org.danyuan.application.dbms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名 ： ZhcxController.java
 * 包 名 ： com.shumeng.application.zhcx.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年3月9日 上午11:15:38
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/zhcx")
public class ZhcxController {
	
	private static final Logger logger = LoggerFactory.getLogger(ZhcxController.class);
	
	//	@RequestMapping(path = "/forwardYjcx", method = RequestMethod.POST)
	//	public ModelAndView forwardYjcx(SysDbmsTabsInfoVo vo) {
	//		logger.info("forwardYjcx", ZhcxController.class);
	//		ModelAndView view = new ModelAndView("zhcx/search/yjcx");
	//		List<SysDbmsUserIndexInfo> list = sysDbmsUserIndexInfoService.findAll();
	//		view.addObject("type", vo.getType());
	//		view.addObject("list", list);
	//		view.addObject("paramString", vo.getParamString());
	//		return view;
	//	}
	//	
	//	@RequestMapping(path = "/forwardZhlb", method = RequestMethod.POST)
	//	public ModelAndView forwardZhlb(SysDbmsTabsInfoVo vo) {
	//		logger.info("forwardZhlb", ZhcxController.class);
	//		ModelAndView view = new ModelAndView("zhcx/search/zhlb");
	//		view.addObject("tabsuuid", vo.getTabsuuid());
	//		view.addObject("tabsDesc", vo.getTabsDesc());
	//		view.addObject("tabsName", vo.getTabsName());
	//		view.addObject("dbType", vo.getDbType());
	//		view.addObject("esName", vo.getEsName());
	//		view.addObject("tabsRows", vo.getTabsRows());
	//		view.addObject("type", vo.getType());
	//		view.addObject("paramString", vo.getParamString());
	//		return view;
	//	}
	//	
	//	@RequestMapping(path = "/forwardZhxx", method = RequestMethod.POST)
	//	public ModelAndView forwardZhxx(SysDbmsTabsColsInfoVo vo) {
	//		logger.info("forwardZhxx", ZhcxController.class);
	//		ModelAndView view = new ModelAndView("zhcx/search/zhxx");
	//		view.addObject("mapString", vo.getMapString());
	//		view.addObject("tabsName", vo.getTabsName());
	//		view.addObject("tabsDesc", vo.getTabsDesc());
	//		view.addObject("paramString", vo.getParamString());
	//		return view;
	//	}
	//	
	//	@RequestMapping(path = "/forwardChart", method = RequestMethod.POST)
	//	public ModelAndView forwardChart(SysDbmsTabsColsInfoVo vo) {
	//		logger.info("forwardChart", ZhcxController.class);
	//		ModelAndView view = new ModelAndView("zhcx/search/chart");
	//		view.addObject("paramString", vo.getParamString());
	//		return view;
	//	}
	
}
