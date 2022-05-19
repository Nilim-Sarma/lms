package com.te.lms.service;

import java.util.List;

import com.te.lms.dto.AddEmployeeDTO;
import com.te.lms.pojo.Employee;
import com.te.lms.pojo.MockRatings;

public interface EmployeeService {
	
	public Employee addEmployee(AddEmployeeDTO employee);

	public List<MockRatings> getMockDetails(String name);

	public Employee getDetails(String name);

	public Employee updateEmployeeDeatils(Employee employee, Integer id);
	
}
