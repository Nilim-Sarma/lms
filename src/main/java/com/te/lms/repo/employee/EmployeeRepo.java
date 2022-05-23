package com.te.lms.repo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.employee.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public Employee findByEmpName(String name);
	public Employee findByEmpId(String empId);
}
