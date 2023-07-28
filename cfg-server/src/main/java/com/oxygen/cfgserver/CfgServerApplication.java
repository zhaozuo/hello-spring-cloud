package com.oxygen.cfgserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// 驱动该微服务为Config服务端
@EnableConfigServer
public class CfgServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfgServerApplication.class, args);
	}

}
