package com.te.lms.pojo.employee;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_experience_info")
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private int eop;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate doj;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dor;
	private String designation;
	private String location;
}
