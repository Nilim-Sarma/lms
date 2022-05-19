package com.te.lms.dto;

import lombok.Data;

@Data
public class EmployeeStatusDTO {
	
	private int empId;
	private String empName;
	private int mocksTaken;
	private int attendance;
	private String status;
	
}
