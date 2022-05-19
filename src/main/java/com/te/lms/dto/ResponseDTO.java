package com.te.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
	
	private boolean error;
	private String msg;
	private Object data;
	
}
