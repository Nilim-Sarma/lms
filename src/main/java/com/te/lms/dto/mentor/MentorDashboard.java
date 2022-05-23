package com.te.lms.dto.mentor;

import java.util.List;

import lombok.Data;

@Data
public class MentorDashboard {
	
	private Integer gender;
	private List<Integer> yop;
	private List<Integer> experience;
	private List<Integer> employeeDegree;
	private List<Integer> batchPerformance;
	
}
