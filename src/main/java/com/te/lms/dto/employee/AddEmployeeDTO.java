package com.te.lms.dto.employee;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.lms.pojo.employee.Address;
import com.te.lms.pojo.employee.BankDetails;
import com.te.lms.pojo.employee.Contact;
import com.te.lms.pojo.employee.EducationDetails;
import com.te.lms.pojo.employee.Experience;
import com.te.lms.pojo.employee.SecondaryInfo;

import lombok.Data;

@Data
public class AddEmployeeDTO {

	@NotEmpty(message =  "Employee Id cannot not be empty")
	@NotNull(message = "Employee is missing")
	private String empId;
	@NotNull
	@NotEmpty(message =  "Employee name cannot not be empty")
	@NotNull(message = "Employee name is missing")
	private String empName;
	
	@NotEmpty(message =  "Date of joining cannot not be empty")
	@NotNull(message = "Date of joining is missing")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate doj;

	@JsonFormat(pattern ="yyyy/MM/dd")
	@NotEmpty(message =  "Date of Birth cannot not be empty")
	@NotNull(message = "Date of birtht is missing")
	private LocalDate dob;
	
	@Email
	private String email;
	
	@NotEmpty(message =  "Blood Group cannot not be empty")
	@NotNull(message = "blood group is missing")
	private String bloodGroup;
	
	@NotEmpty(message =  "Designation cannot not be empty")
	@NotNull(message = "Designation is missing")
	private String designation;
	
	@NotEmpty(message =  "Gender cannot not be empty")
	@NotNull(message = "Gender is missing")
	private String gender;
	
	@NotEmpty(message ="Nationality cannot not be empty")
	@NotNull(message = "Nationality is missing")
	private String nationality;
	
	@NotEmpty(message =  "Date of Birth cannot not be empty")
	@NotNull(message = "Date of birtht is missing")
	private String status;
	
	private SecondaryInfo info;
	
	private List<EducationDetails> educationDetails;
	
	private List<Address> address;
	
	private BankDetails bankDetails;
	
	private List<Integer> tech;
	
	private List<Experience> exp;
	
	private List<Contact> contact;
}
