package com.example.employee_service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

	@Mock
	private EmployeeRepository repo;
	
	@InjectMocks
	private EmployeeService service;
	
	public EmployeeServiceTest() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testSaveEmployee() {
		Employee emp = new Employee("Kishan Patel", "Developer");
		when(repo.save(emp)).thenReturn(emp);
		
		Employee saved = service.save(emp);
		
		assertEquals("Kishan Patel",saved.getName());
		assertEquals("Developer", saved.getRole());
		verify(repo, times(1)).save(emp);
	}
	
	@Test
    void testFindAllEmployees() {
        List<Employee> list = Arrays.asList(
                new Employee("A", "Dev"),
                new Employee("B", "QA")
        );

        when(repo.findAll()).thenReturn(list);

        List<Employee> result = service.findAll();
        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }
}
