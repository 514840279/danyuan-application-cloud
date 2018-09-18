/**
 * 文件名：SysPlantChartDimensionController.java
 *
 * 版本信息：
 * 日期：2018年5月22日
 * Copyright 足下 Corporation 2018
 * 版权所有
 */
package org.danyuan.application.dbms.chart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.dbms.chart.po.SysPlantChartDimensionGroup;
import org.danyuan.application.dbms.chart.service.SysPlantChartDimensionGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件名 ： SysPlantChartDimensionController.java
 * 包 名 ： com.shumeng.application.application.plant.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月22日 下午2:48:38
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysPlantChartDimensionGroup")
public class SysPlantChartDimensionGroupController {
	private static final Logger			logger	= LoggerFactory.getLogger(SysPlantChartDimensionGroupController.class);
	@Autowired
	SysPlantChartDimensionGroupService	sysPlantChartDimensionGroupService;

	/**
	 * 方法名 ： page
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/page", method = RequestMethod.POST)
	public Page<SysPlantChartDimensionGroup> page(@RequestBody Pagination<SysPlantChartDimensionGroup> vo) {
		logger.info("page", SysPlantChartDimensionGroupController.class);
		Order order = new Order(Direction.ASC, "createTime");
		if (vo.getSortName() != null) {
			order = new Order(vo.getOrder(), vo.getSortName());
		}
		if (vo.getInfo() == null) {
			vo.setInfo(new SysPlantChartDimensionGroup());
		}
		return sysPlantChartDimensionGroupService.page(vo.getPageNumber(), vo.getPageSize(), vo.getInfo(), vo.getMap(), order);
	}

	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/findAll", method = RequestMethod.POST)
	public List<SysPlantChartDimensionGroup> findAll(@RequestBody SysPlantChartDimensionGroup info) {
		logger.info("findAll", SysPlantChartDimensionGroupController.class);
		return sysPlantChartDimensionGroupService.findAll(info);
	}

	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/findOne", method = RequestMethod.POST)
	public SysPlantChartDimensionGroup findOne(@RequestBody SysPlantChartDimensionGroup info) {
		logger.info("findOne", SysPlantChartDimensionGroupController.class);
		return sysPlantChartDimensionGroupService.findOne(info);
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public Map<String, String> save(@RequestBody SysPlantChartDimensionGroup info) {
		logger.info("save", SysPlantChartDimensionGroupController.class);
		if (info.getUuid() == null || "".equals(info.getUuid())) {
			info.setUuid(UUID.randomUUID().toString());
		}
		sysPlantChartDimensionGroupService.save(info);
		Map<String, String> map = new HashMap<>();
		map.put("uuid", info.getUuid());
		return map;
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/saveAll", method = RequestMethod.POST)
	public String save(@RequestBody Pagination<SysPlantChartDimensionGroup> vo) {
		logger.info("save", SysPlantChartDimensionGroupController.class);
		sysPlantChartDimensionGroupService.save(vo.getList());
		return "1";
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/deleteAll", method = RequestMethod.POST)
	public String delete(@RequestBody Pagination<SysPlantChartDimensionGroup> vo) {
		logger.info("delete", SysPlantChartDimensionGroupController.class);
		sysPlantChartDimensionGroupService.delete(vo.getList());
		return "1";
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody SysPlantChartDimensionGroup info) {
		logger.info("delete", SysPlantChartDimensionGroupController.class);
		sysPlantChartDimensionGroupService.delete(info);
		return "1";
	}

	/**
	 * 方法名 ： trunc
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	@RequestMapping(path = "/trunc", method = RequestMethod.POST)
	public String trunc() {
		logger.info("trunc", SysPlantChartDimensionGroupController.class);
		sysPlantChartDimensionGroupService.trunc();
		return "1";
	}
	
	@RequestMapping(path = "/addBefor", method = RequestMethod.GET)
	public ModelAndView addBefor(HttpServletRequest request) {
		logger.info("addBefor", SysPlantChartDimensionGroupController.class);
		ModelAndView view = new ModelAndView("plant/group/add");
		SysPlantChartDimensionGroup group = new SysPlantChartDimensionGroup();
		group.setUuid(request.getParameter("uuid"));
		if (group.getUuid() == null || "".equals(group.getUuid())) {
			view.addObject("sysPlantChartDimensionGroup", group);
		} else {
			group = sysPlantChartDimensionGroupService.findOne(group);
			view.addObject("sysPlantChartDimensionGroup", group);
		}
		System.err.println(group.toString());
		return view;
	}

}
