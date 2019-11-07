package com.sb.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sb.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>{

	 
	List<Employee> findByeage(int age);
	List<Employee> findByeageGreaterThan(int age);
	List<Employee> findByeageLessThan(int age);
	
	@Query("from Employee where eage=?1 order by ename")
	List<Employee> findByeageSorted(int eage);
}
