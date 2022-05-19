package com.te.lms.dto;

import java.util.List;

import lombok.Data;

@Data
public class RejectDTO {
	
	private String reason;
	private List<Integer> ids;
}

