package com.sb.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sb.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
