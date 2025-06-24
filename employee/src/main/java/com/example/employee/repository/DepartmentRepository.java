package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.dto.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
