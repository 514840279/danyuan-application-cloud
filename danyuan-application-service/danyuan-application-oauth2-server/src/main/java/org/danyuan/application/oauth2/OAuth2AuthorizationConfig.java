package org.danyuan.application.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory() // 使用in-memory存储客户端信息
		        .withClient("wth")// 客户端ID
		        .secret("wth") // 客户端连接
		        .autoApprove("true") // 自动确认授权不展示页面
		        .authorizedGrantTypes("password", "refresh_token", "authorization_code")// 设置验证方式
		        .scopes("all")// 允许的授权范围
		        .accessTokenValiditySeconds(10000) // token过期时间
		        .refreshTokenValiditySeconds(10000); // refresh过期时间
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManager);
		
//		.userDetailsService(userService); // 配置userService 这样每次认证的时候会去检验用户是否锁定，有效等
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

	@Bean
	public TokenStore tokenStore() {
		// 使用内存的tokenStore
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("wth"); // TODO
		return converter;
	}
}