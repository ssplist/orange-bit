package com.example.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee.dto.Employee;
import com.example.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee()
	{
		return this.employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{dept_id}")
	public List<Employee> getEmployee(@PathVariable String dept_id)
	{
		return this.employeeRepository.findBydeptId(dept_id);
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return this.employeeRepository.save(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public Employee deleteEmployee(@PathVariable String id)
	{
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{	
			this.employeeRepository.deleteById(id);
			return employee.get();
		}
		else 
			throw new RuntimeException("Employee Not Found");
	}
}