package com.te.lms.dto.employee;

import lombok.Data;

@Data
public class EmpRequestResDTO {
	private Integer empId;
	private String empName;
	private	int yop;
	private double percentage;
	private String experience;
	private long contactNo;
}
