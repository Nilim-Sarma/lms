package com.te.lms.dto.mentor;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class MentorBatchResDto {

	private Integer batchNo;
	private Integer batchId;
	private String batchName;
	private List<String> technologies;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	private Long batchStrength;
	
}
