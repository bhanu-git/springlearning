package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.EmployeeRepo;
import com.sb.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		empRepo.save(employee);
		
	}

	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		
		return empRepo.findAll(); // this method will applicable if EmployeeRepo implements JpaRepository
		
	}

	public Optional<Employee> findByEmployeeId(int eid) {
		// TODO Auto-generated method stub
		return empRepo.findById(eid); // this method will applicable if EmployeeRepo implements JpaRepository

	}

	public void deleteByEmployeeId(int eid) {
		// TODO Auto-generated method stub
		
		empRepo.deleteById(eid);
	}

	public void updateByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.save(employee);
	}

	
}
