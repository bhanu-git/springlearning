package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootaccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootaccountserviceApplication.class, args);
	}

}
