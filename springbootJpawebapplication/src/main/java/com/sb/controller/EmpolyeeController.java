package com.sb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sb.dao.EmployeeRepo;
import com.sb.model.Employee;

@Controller
public class EmpolyeeController {
	
	@Autowired
	EmployeeRepo empRepo;
	
	@RequestMapping("/")
	public String home() {
		return "Home";
	}

	@RequestMapping("/addEmployee")
	public String addEmployee(Employee emp) {
		empRepo.save(emp);
		return "Home";
	}
	
	@RequestMapping("/getEmployee")
	public ModelAndView getEmployee(@RequestParam(name="eid") int id) {
		Optional<Employee> optional = empRepo.findById(id);
		Employee emp = optional.get();
		//Employee emp = empRepo.findById(id).orElse(new Employee());
		
		//Display age = 23 
		System.out.println("emp age eq 23"+empRepo.findByeage(23));
		
		System.out.println("emp age gt 24 \n"+empRepo.findByeageGreaterThan(24));
		
		System.out.println("emp age lt 24 \n"+empRepo.findByeageLessThan(24));
		
		System.out.println("emp age eq 24 sorted \n"+empRepo.findByeageSorted(24));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", emp);
		mv.setViewName("DisplayEmployee");
		return mv;
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam(name="eid") int id) {
	
				empRepo.deleteById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Employee details deleted "+id);
		mv.setViewName("DisplayEmployee");
		return mv;
	}
}
