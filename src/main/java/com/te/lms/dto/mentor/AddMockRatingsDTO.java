package com.te.lms.dto.mentor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AddMockRatingsDTO {

	@NotNull(message = "Mock Type is missing")
	@NotEmpty(message = "MockType cannot be empty")
	private String mockType;

	@NotNull(message = " Employee ID is missing")
	private Integer empid;

	@NotNull(message = "Mock Type is missing")
	private String mockTakenBy;
	
	@NotNull(message = "Tech id is missing")
	private Integer techId;
	
	@NotNull(message = "Practical mask is missing")
	@Size(min = 0, max = 100)
	private double practical;
	
	@NotNull(message = "therotical marks is missing")
	@Size(min = 0, max = 100)
	private double theoretical;
	
	@NotNull
	@NotNull(message = "Overall marks is missing")
	@Size(min = 0, max = 100)
	private double overall;
	
	@NotNull(message = "Detailed feedback is missing")
	@NotEmpty(message = "Detailed feedback cannot be empty")
	private String detailedFeedBack;

}
