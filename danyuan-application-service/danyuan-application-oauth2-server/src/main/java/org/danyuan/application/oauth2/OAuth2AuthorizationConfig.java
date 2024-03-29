package org.danyuan.application.oauth2;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager	authenticationManager;
	@Autowired
	TokenStore						tokenStore;
	
	@Autowired
	JwtAccessTokenConverter			jwtAccessTokenConverter;
	
	@Autowired
	PasswordEncoder					passwordEncoder;
	@Resource
	private DataSource				dataSource;
	
	@Bean
	public ClientDetailsService clientDetails() {
		return new JdbcClientDetailsService(dataSource);
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	@Bean
	public AuthorizationCodeServices authorizationCodeServices() {
		return new JdbcAuthorizationCodeServices(dataSource);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		System.err.println(passwordEncoder.encode("wth"));
		//		clients.inMemory() // 使用in-memory存储客户端信息
		//		        .withClient("wth")// 客户端ID
		//		        .secret(passwordEncoder.encode("wth")) // 客户端连接
		//		        .autoApprove("true") // 自动确认授权不展示页面
		//		        .authorizedGrantTypes("password", "refresh_token", "authorization_code")// 设置验证方式
		//		        .scopes("all")// 允许的授权范围
		//		        .redirectUris("http://localhost:82/index", "http://192.168.31.87:82/index", "http://192.168.0.16:82/index", "http://175.163.79.0:82/index")//
		//		        .accessTokenValiditySeconds(10000) // token过期时间
		//		        .refreshTokenValiditySeconds(10000); // refresh过期时间
		
		// 这个地方指的是从jdbc查出数据来存储
		clients.withClientDetails(clientDetails());
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		System.err.println("OAuth2AuthorizationConfig.AuthorizationServerEndpointsConfigurer");
		endpoints.tokenStore(tokenStore()).authorizationCodeServices(authorizationCodeServices()) // 数据库读
		        .accessTokenConverter(jwtAccessTokenConverter)// jwt 令牌
		        .authenticationManager(authenticationManager);//
		//		        .userDetailsService(userService); // 配置userService 这样每次认证的时候会去检验用户是否锁定，有效等
	}
	
	/**
	 * 方法名 ： configure
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param security
	 * 参 数 ： @throws Exception
	 * 参 考 ： @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer)
	 * 作 者 ： Administrator
	 */
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("isAuthenticated()");
	}
	
}