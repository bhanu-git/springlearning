package com.sb.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import com.sb.dao.EmployeeRepo;
import com.sb.model.Employee;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeService {

	@InjectMocks
	EmployeeService empService;
	
	@Mock
	EmployeeRepo empRepo;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void findAllEmployeeTest() {
		
		List<Employee> empList = new ArrayList<>();
			empList.add(new Employee(101,"bhanu",24));
			empList.add(new Employee(102,"kolli",24));
			empList.add(new Employee(103,"prakash",24));
			
			when(empRepo.findAll()).thenReturn(empList);
			
			//Test
			List<Employee> empSerList = empService.findAllEmployee();
			assertEquals(3,empSerList.size());
			verify(empRepo, times(1)).findAll();
	}
	 	@Test
	    public void getEmployeeByIdTest()
	    {
	        when(empRepo.findById(101).orElse(new Employee())).thenReturn(new Employee(101,"bhanu",24));
	         
	        Employee emp = empService.findByEmployeeId(101).orElse(new Employee());
	         
	        assertEquals("bhanu", emp.getEname());
	        assertEquals(24, emp.getEage());
	        
	    }
	     
	    @Test
	    public void createEmployeeTest()
	    {
	        Employee emp = new Employee(101,"bhanu",24);
	         
	        empService.addEmployee(emp);
	         
	        verify(empRepo, times(1)).save(emp);
	    }
}
