package org.danyuan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

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
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServerApp.class, args);
	}

}
