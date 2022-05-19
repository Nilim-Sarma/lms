package com.te.lms.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO {
	@NotNull(message = "BatchName is  missing")
	@NotEmpty(message = "BatchName cannot be empty")
	private String batchName;
	
	@NotNull(message = "BatchName is  missing")
	@NotEmpty(message = "BatchName cannot be empty")
	private Integer batchId;

	@NotNull(message = "Mentor id is missing")
	private Integer mentorId;

	@NotNull(message = "Technology is missing")
	private List<Integer> techId;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@NotEmpty(message = "Start date cannot not be empty")
	@NotNull(message = "Start date is missing")
	private LocalDate startDate;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@NotEmpty(message = "Start date cannot not be empty")
	@NotNull(message = "Start date is missing")
	private LocalDate endDate;

	@NotNull(message = "Status cannot be null")
	@NotEmpty(message = "Status cannot be empty")
	private String status;
}
