package com.te.lms.pojo.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_secondary_info")
public class SecondaryInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String panNo;
	private String adharNo;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private String passportNo;
	private String martialStatus;
}
