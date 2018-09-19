package org.danyuan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2App {
	public static void main(String[] args) {
		SpringApplication.run(OAuth2App.class, args);
	}
}
