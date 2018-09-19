package org.danyuan.application.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 文件名 ： WebSecurityConfig.java
 * 包 名 ： tk.ainiyue.danyuan.application.common.config
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年10月8日 上午9:08:08
 * 版 本 ： V1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().csrf().disable().httpBasic();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
	
//		// 允许所有用户访问"/"和"/home"
//		http.csrf().disable().authorizeRequests()
//		        // 不需要验证就可以访问的路径
//		        .antMatchers("/dist/*/**", "/login", "/info", "/oauth/**").permitAll()
//		        // 限制所有请求都需要验证
//		        .anyRequest().authenticated().and().formLogin()
//		        // 登录页
//		        .defaultSuccessUrl("/index").loginPage("/login").failureUrl("/login?error").permitAll().and().logout().permitAll();

//	}

	/**
	 * 自定义UserDetailsService，从数据库中读取用户信息
	 *
	 * @return
	 */
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}

}