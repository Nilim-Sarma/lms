package com.te.lms.dto;

import java.util.List;

import lombok.Data;

@Data
public class RequestApproveDTO {
	
	private String batchName;
	private int batchId;
	private List<Integer> employeesId;

}
