package org.danyuan.application.crawler.seed.controller;

import org.danyuan.application.crawler.seed.service.SysSeedUrlInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 文件名 ： SysSeedController.java
 * 包 名 ： tk.ainiyue.admin.roles.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Tenghui.Wang
 * 时 间 ： 2016年7月17日 下午3:54:27
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysSeedUrlInfo")
@Api(value = "/SysSeedUrlInfo", description = "采集地址管理")
public class SysSeedUrlInfoController {
	//
	private static final Logger		logger	= LoggerFactory.getLogger(SysSeedUrlInfoController.class);
	
	//
	@Autowired
	private SysSeedUrlInfoService	sysSeedUrlInfoService;
	
}
