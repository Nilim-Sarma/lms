package com.te.lms.dto.admin;

import java.time.LocalDate;
import java.util.List;

import com.te.lms.pojo.employee.Technologies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchDetailsAdminDTO {
	
	private Integer id;
	private String batchName;
	private String mentorName;
	private List<Technologies> technologies;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
}
