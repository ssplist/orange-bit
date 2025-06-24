package com.example.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee.dto.Department;
import com.example.employee.repository.DepartmentRepository;

@RestController
public class DepartmentController
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/department")
	public List<Department> getAllDeployement() 
	{
		List<Department> departments = departmentRepository.findAll();
        return departments;
    }
}