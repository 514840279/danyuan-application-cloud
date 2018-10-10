package org.danyuan.application.common.filter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 文件名 ： WebSecurityConfig.java
 * 包 名 ： tk.ainiyue.danyuan.application.common.config
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称： 测试开发时开启不会跳转到注册中心，正式线上开发需要关闭
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年10月8日 上午9:08:08
 * 版 本 ： V1.0
 */

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login", "/oauth2/login*").permitAll().anyRequest().authenticated();
	}
	
}