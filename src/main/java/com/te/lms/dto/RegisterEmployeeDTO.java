package com.te.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.lms.pojo.Address;
import com.te.lms.pojo.BankDetails;
import com.te.lms.pojo.Contact;
import com.te.lms.pojo.EducationDetails;
import com.te.lms.pojo.Experience;
import com.te.lms.pojo.SecondaryInfo;
import com.te.lms.pojo.Technologies;

import lombok.Data;

@Data
public class RegisterEmployeeDTO {
	private String empId;
	private String empName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate doj;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String status;

	private SecondaryInfo info;

	private List<EducationDetails> details;

	private List<Address> address;

	private BankDetails bankDetails;

	private List<Technologies> tech;

	private List<Experience> exp;

	private List<Contact> contact;

}
