package com.example.employee_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping 
	public Employee create(@RequestBody Employee emp) {
		return service.save(emp);
	}
	
	@GetMapping
	public List<Employee> getAll(){
		return service.findAll();
	}

}
