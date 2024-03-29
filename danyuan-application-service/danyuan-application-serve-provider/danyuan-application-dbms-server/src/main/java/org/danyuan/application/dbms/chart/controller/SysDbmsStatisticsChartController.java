/**
 * 文件名：SysDbmsStatisticsChartController.java
 *
 * 版本信息：
 * 日期：2018年5月21日
 * Copyright 足下 Corporation 2018
 * 版权所有
 */
package org.danyuan.application.dbms.chart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.danyuan.application.common.utils.StringUtil;
import org.danyuan.application.dbms.chart.po.SysDbmsChartDimension;
import org.danyuan.application.dbms.chart.po.SysDbmsChartDimensionData;
import org.danyuan.application.dbms.chart.po.SysPlantBindConf;
import org.danyuan.application.dbms.chart.service.SysDbmsChartDimensionDataService;
import org.danyuan.application.dbms.chart.service.SysDbmsChartDimensionService;
import org.danyuan.application.dbms.chart.service.SysPlantBarOrLineStatisticsChartService;
import org.danyuan.application.dbms.chart.service.SysPlantBindConfService;
import org.danyuan.application.dbms.chart.service.SysPlantMapStatisticsChartService;
import org.danyuan.application.dbms.chart.service.SysPlantPieStatisticsChartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名 ： SysDbmsStatisticsChartController.java
 * 包 名 ： com.shumeng.application.application.plant.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月21日 下午3:52:22
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysDbmsStatisticsChart")
public class SysDbmsStatisticsChartController {
	//
	private static final Logger				logger	= LoggerFactory.getLogger(SysDbmsStatisticsChartController.class);

	@Autowired
	SysDbmsChartDimensionService			sysPlantChartDimensionService;
	@Autowired
	SysDbmsChartDimensionDataService		sysPlantChartDimensionDataService;
	@Autowired
	SysPlantBarOrLineStatisticsChartService	sysPlantBarOrLineStatisticsChartService;
	@Autowired
	SysPlantPieStatisticsChartService		sysPlantPieStatisticsChartService;
	@Autowired
	SysPlantMapStatisticsChartService		sysPlantMapStatisticsChartService;
	
	@Autowired
	SysPlantBindConfService					sysPlantBindConfService;
	
	@RequestMapping(path = "/build", method = RequestMethod.POST)
	public Map<String, Object> build(@RequestBody SysDbmsChartDimension info) {
		logger.info("build", SysDbmsStatisticsChartController.class);
		
		info = sysPlantChartDimensionService.findOne(info);
		
		SysDbmsChartDimensionData sysPlantChartDimensionData = new SysDbmsChartDimensionData();
		sysPlantChartDimensionData.setDimeUuid(info.getUuid());
		List<SysDbmsChartDimensionData> listParam = sysPlantChartDimensionDataService.findAll(sysPlantChartDimensionData);
		
		SysPlantBindConf conf = new SysPlantBindConf();
		List<org.danyuan.application.dbms.chart.po.SysPlantBindConf> confs = sysPlantBindConfService.findAll(conf);

		String type3 = findTypeName(info.getLableUuid3(), confs);
		String type2 = findTypeName(info.getLableUuid2(), confs);
		String type1 = findTypeName(info.getLableUuid(), confs);
		
		if (type3 != null && type2 == null) {
			type2 = type3;
			type3 = null;
		}
		if (type2 != null && type1 == null) {
			type1 = type2;
			type2 = type3;
			type3 = null;
		}
		Map<String, Object> map = new HashMap<>();
		if (type1 == null && !"map".equals(info.getChartType())) {
			return map;
		}
		
		// 组织条件语句
		StringBuilder sbWhere = new StringBuilder();
		buildWhereSql(listParam, confs, sbWhere);
		
		switch (info.getChartType()) {
			case "pie":
			case "rompie":
			case "nanpie":
				// 饼图
				sysPlantPieStatisticsChartService.buildPie(map, info, sbWhere, type1);
				break;
			case "bar":
			case "tbar":
			case "line":
				// 柱图、线图 param map返回结果 info 图表属性 ，list 图表条件
				sysPlantBarOrLineStatisticsChartService.buildBarOrLine(map, info, sbWhere, type1, type2, type3);
				break;
			case "map":
				// 地图
				sysPlantMapStatisticsChartService.buildMap(map, info, sbWhere, type1);
				break;
			case "tree":
				// 树图
				buildTree(map, info, listParam);
				break;
			case "sunburst":
				// 旭日图
				buildSunburst(map, info, listParam);
				break;
			default:
				break;
		}

		return map;

	}

	/**
	 * @param list
	 * 方法名： buildSunburst
	 * 功 能： 旭日图
	 * 参 数： @param map
	 * 参 数： @param info
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void buildSunburst(Map<String, Object> map, SysDbmsChartDimension info, List<SysDbmsChartDimensionData> list) {

		map.put("series_data", "");
	}

	/**
	 * @param list
	 * 方法名： buildTree
	 * 功 能： 树图
	 * 参 数： @param map
	 * 参 数： @param info
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void buildTree(Map<String, Object> map, SysDbmsChartDimension info, List<SysDbmsChartDimensionData> list) {

	}
	
	/**
	 * 方法名： findTypeName
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param lableUuid2
	 * 参 数： @param confs
	 * 参 数： @return
	 * 返 回： String
	 * 作 者 ： Administrator
	 * @throws
	 */
	private String findTypeName(String lableUuid2, List<SysPlantBindConf> confs) {
		if (StringUtil.isNullOrNone(lableUuid2)) {
			return null;
		}
		for (SysPlantBindConf sysPlantBindConf : confs) {
			if (lableUuid2.equals(sysPlantBindConf.getUuid())) {
				return sysPlantBindConf.getColsName();
			}
		}
		return null;
	}
	
	/**
	 * 方法名： buildWhereSql
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param list
	 * 参 数： @param confs
	 * 参 数： @param sbWhere
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void buildWhereSql(List<SysDbmsChartDimensionData> list, List<SysPlantBindConf> confs, StringBuilder sbWhere) {
		if (list.size() == 0) {
			return;
		}
		// 参数分组
		List<List<SysDbmsChartDimensionData>> pList = new ArrayList<>();
		for (SysDbmsChartDimensionData data : list) {
			if (data.getConditions() == null || "".equals(data.getConditions().trim())) {
				continue;
			}
			if ("in".equals(data.getSymbol())) {
				if (pList.size() == 0) {
					List<SysDbmsChartDimensionData> temlist = new ArrayList<>();
					temlist.add(data);
					pList.add(temlist);
					continue;
				}
				boolean check = true;
				for (int i = 0; i < pList.size(); i++) {
					if (data.getColsUuid().equals(pList.get(i).get(0).getColsUuid())) {
						pList.get(i).add(data);
						check = false;
					}
				}
				if (check) {
					List<SysDbmsChartDimensionData> temlist = new ArrayList<>();
					temlist.add(data);
					pList.add(temlist);
				}

			} else {
				List<SysDbmsChartDimensionData> temlist = new ArrayList<>();
				temlist.add(data);
				pList.add(temlist);
			}
			
		}

		// 组织条件语句
		for (List<SysDbmsChartDimensionData> list2 : pList) {
			String colsUuid = list2.get(0).getColsUuid();
			String colsName = "";
			if ("keyword".equals(colsUuid)) {
				colsName = "keyword";
			} else {
				for (SysPlantBindConf conf : confs) {
					if (colsUuid.equals(conf.getUuid())) {
						colsName = conf.getColsName();
						break;
					}
				}
			}
			StringBuilder regexps = new StringBuilder();
			for (int i = 0; i < list2.size(); i++) {
				if (i > 0) {
					regexps.append("|");
				}
				regexps.append(list2.get(i).getConditions().trim());
			}
			// 根据smbol 组织 条件
			String symbol = list2.get(0).getSymbol();
			if ("in".equals(symbol)) {
				if (colsName.equals("keyword")) {
					sbWhere.append(" and DLSM_UUID in (select DLSM_UUID from bids_bx_display_content where title  REGEXP '" + regexps.toString() + "' )");
				} else {
					sbWhere.append(" and " + colsName + " REGEXP '" + regexps.toString() + "' ");
				}
			} else if ("lt".equals(symbol)) {
				sbWhere.append(" and " + colsName + " < '" + regexps.toString() + "' ");
			} else if ("gt".equals(symbol)) {
				sbWhere.append(" and " + colsName + " > '" + regexps.toString() + "' ");
			}

		}
		
	}
}
