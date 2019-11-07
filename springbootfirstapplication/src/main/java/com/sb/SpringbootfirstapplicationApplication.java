package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootfirstapplicationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootfirstapplicationApplication.class, args);
		System.out.println("Hello Spring boot");
		
		Employee e = context.getBean(Employee.class);
		e.show();
		
		//if we use scope is prototype , new instane created for employee for eachtime
		/*Employee e1 = context.getBean(Employee.class);
		e1.show();*/
	}

}
