package com.sb.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	//http://localhost:8080/hello-world
	@GetMapping("/hello-world")
	public String helloWorld() {
		
		return "Hello World !!!!";
	}
	
	//http://localhost:8080/hello-world-bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello World Bean");
	}
	
	//http://localhost:8080/hello-world-bean/path-variable/hcl
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World Bean, %s",name));
	}
	
	//http://localhost:8080/hello-world-bean/error
	@GetMapping("/hello-world-bean/error")
	public HelloWorldBean helloWorldBeanError() {
		
		throw new RuntimeException("Some Error happen.. contact support**** !!!!");
	}
}
