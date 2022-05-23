package com.te.lms.dto.admin;

import java.util.List;

import lombok.Data;

@Data
public class RequestApproveDTO {
	
	private String batchName;
	private int batchId;
	private List<Integer> employeesId;

}
