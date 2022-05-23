package com.te.lms.dto.admin;

import java.util.List;

import lombok.Data;

@Data
public class RejectDTO {
	
	private String reason;
	private List<Integer> ids;
}

