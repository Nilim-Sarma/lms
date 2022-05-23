package com.te.lms.service.employee;

import java.util.List;

import com.te.lms.dto.employee.AddEmployeeDTO;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.mentor.MockRatings;

public interface EmployeeService {
	
	public Employee addEmployee(AddEmployeeDTO employee);

	public List<MockRatings> getMockDetails(String name);

	public Employee getDetails(String name);

	public Employee updateEmployeeDeatils(AddEmployeeDTO employee, Integer id);
	
}
