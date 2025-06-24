package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.employee.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>
{
	@Query("select e from Employee e where e.dept_id = :dept_id")
	public List<Employee> findBydeptId(@Param ("dept_id") String dept_id);
}