package org.danyuan.application;

import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

// @Component//被spring容器管理
// @Order(1)//如果多个自定义ApplicationRunner，用来标明执行顺序
public class MyApplicationRunner implements ApplicationRunner {
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("启动web.py");
		//test.bat中的命令是ipconfig/all 
		//		String pathString = System.getProperty("user.dir");
		String cmd = "python  ../../danyuan-application-crawler-pythonweb.py";
		//        String cmd="jarsigner -verify -verbose -certs C:\\Users\\Administrator\\Desktop\\PandaClient.apk";
		System.out.println(cmd);
		try {
			//执行命令  
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}