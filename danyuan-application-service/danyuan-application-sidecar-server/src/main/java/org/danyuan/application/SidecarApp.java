package org.danyuan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Hello world!
 */
@EnableSidecar
@SpringBootApplication
public class SidecarApp {
	public static void main(String[] args) {
		SpringApplication.run(SidecarApp.class, args);
	}
}
