package com.te.lms.dto;

import java.util.List;

import lombok.Data;

@Data
public class DashBoardDTO {
	
	private Integer gender;
	private List<Integer> yop;
	private List<Integer> experience;
	private List<Integer> employeeDegree;
	private List<Integer> batchPerformance;
	
}
