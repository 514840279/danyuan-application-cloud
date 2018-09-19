package org.danyuan.application.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//
//		// 允许所有用户访问"/"和"/home"
//		http.csrf().disable().authorizeRequests()
//		        // 不需要验证就可以访问的路径
//		        .antMatchers("/dist/*/**", "/login", "/info", "/oauth/**").permitAll()
//		        // 限制所有请求都需要验证
//		        .anyRequest().authenticated().and().formLogin()
//		        // 登录页
//		        .defaultSuccessUrl("/").loginPage("/login").failureUrl("/login?error").permitAll().and().logout().permitAll();
//
//	}
}