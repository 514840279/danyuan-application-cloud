package org.danyuan.application.oauth2;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	TokenStore				tokenStore;
	@Autowired
	JwtAccessTokenConverter	jwtAccessTokenConverter;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().regexMatchers("^/(?:oauth/authorize|(?!(?:oauth|actuator|management|users)/)).*").and()//
		        .requestMatchers().antMatchers("/api/**").and().authorizeRequests().antMatchers("/api/**").authenticated();
		// http.addFilterBefore(authenticationFilter(), BasicAuthenticationFilter.class);
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}
	
	// @Bean
	public Filter authenticationFilter() {
		// 这里配置的 URL 就是认证服务认证后回调的地址
		OAuth2ClientAuthenticationProcessingFilter authFilter = new OAuth2ClientAuthenticationProcessingFilter("http://localhost:82/index");
		// 在这里配置客户端信息
		OAuth2ProtectedResourceDetails details = new BaseOAuth2ProtectedResourceDetails();
		OAuth2RestTemplate template = new OAuth2RestTemplate(details, new DefaultOAuth2ClientContext());
		authFilter.setRestTemplate(template);
		// ... other configuration ...
		return authFilter;
	}
}