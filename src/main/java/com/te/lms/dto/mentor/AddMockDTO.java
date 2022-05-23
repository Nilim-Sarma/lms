package com.te.lms.dto.mentor;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AddMockDTO {
	
	@NotNull(message = "Batch Id is missing")
	private int batchId;
	@NotNull(message = "MockNo is missing")
	private int mockNo;
	@NotNull(message = "MockNo Id is missing")
	private int techId;
	@NotNull(message = "MockNo Id is missing")
	private List<String> mentorId;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@NotEmpty(message =  "date cannot not be empty")
	@NotNull(message = "date is missing")
	private LocalDateTime dateTime;
	
}
