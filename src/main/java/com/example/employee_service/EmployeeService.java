package com.example.employee_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Employee save(Employee emp) {
		return repo.save(emp);
	}
	
	public List<Employee> findAll(){
		return repo.findAll();
	}
}
