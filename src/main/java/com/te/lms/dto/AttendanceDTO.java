package com.te.lms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AttendanceDTO {
	
	@NotEmpty(message =  "Date cannot not be empty")
	@NotNull(message = "Date is missing")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;
	
	private boolean morning;
	
	private boolean afternoon;

	@NotNull(message = "Employee id cannot be empty")
	private Integer eId;
}
