package com.sb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Employee;
import com.sb.service.EmployeeService;


//if we are making RestController it will work for RESTfull data. 
@RestController
@RequestMapping("/v1")
public class EmployeeRestController {
	

	@Autowired
	private EmployeeService empService;
	
	//url: localhost:8080/v1/home
	@RequestMapping("/home")
	public String getHome() {
		
		return "Hello Restfull Spring boot application";
	}
	
	//Need to send the data from Postman client using post request
	//url: localhost:8080/v1/employees
	//sending raw data using postman, actual data is sending with default values. 
	//if u use the requestbody annotation, raw data will process with actual data 
	@PostMapping(path="/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		empService.addEmployee(employee);
		return employee;
	}
	
	//localhost:8080/v1/employees
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
	
		
		return empService.findAllEmployee(); 
	}
	
	//localhost:8080/v1/employees/101
	@GetMapping("/employees/{eid}")
	public Optional<Employee> getEmployee(@PathVariable("eid") int eid) {
	
		return empService.findByEmployeeId(eid);
		
	}

	@DeleteMapping("/employees/{eid}")
	public void deleteEmployee(@PathVariable("eid") int eid) {
		
		empService.deleteByEmployeeId(eid);
		
		
	}
	
	@PutMapping(path="/employee")
	public Employee updateEmployee( Employee employee) {
		
		empService.updateByEmployee(employee);
		return employee;
	}
	
}
