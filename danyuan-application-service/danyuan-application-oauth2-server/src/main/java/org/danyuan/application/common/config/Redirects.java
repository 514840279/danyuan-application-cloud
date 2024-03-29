package org.danyuan.application.common.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件名 ： Redirects.java
 * 包 名 ： tk.ainiyue.danyuan.application.common.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2017年10月10日 上午10:13:43
 * 版 本 ： V1.0
 */
@Controller
public class Redirects {

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) {
		System.err.println(request.getParameter("useraname"));
		return "login";
	}
	
	@RequestMapping(path = { "/index", "/", "/home" })
	public String index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.err.println(auth.getAuthorities().toString());
		return "index";// 如果是后台管理人员登录
	}

	@RequestMapping("/templates/{path1}/{path2}/{page}")
	public String templates(@PathVariable("path1") String path1, @PathVariable("path2") String path2, @PathVariable("page") String page) {
		return path1 + "/" + path2 + "/" + page;
	}

}
