package com.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype") //default scope is singleton. if scope is prototype, Employee obj created for each time when u are calling emp object. 
public class Employee {

	private int eid;
	private String name;
	
	//based on autowired tag, spring container will inject the laptop values to Employee.
	//Autowird by default look for type of object . i.e Laptop.class
	// Autowired can be set based on Qualifer name
	@Autowired
	@Qualifier(value="lap1")
	private Laptop lap;
	
	public Employee() {
		super();
		System.out.println("Object created Employee");
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void show() {
		System.out.println("Employee Object details");
		lap.lapOsDetails();
	}
}
