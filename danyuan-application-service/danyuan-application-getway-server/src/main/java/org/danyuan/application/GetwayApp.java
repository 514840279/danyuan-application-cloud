package org.danyuan.application;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名 ： App.java
 * 包 名 ： tk.ainiyue.danyuan
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Tenghui.Wang
 * 时 间 ： 2016年7月20日 下午8:24:37
 * 版 本 ： V1.0
 */
@EnableZuulProxy
@SpringBootApplication
public class GetwayApp {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(GetwayApp.class, args);
	}
	
	@RestController
	public static class SecuredController {
		@RequestMapping("/user")
		public Principal user(Principal user) {
			return user;
		}
	}
	
}
