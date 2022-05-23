package com.te.lms.pojo.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_bank_info")
public class BankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long accountNo;
	private	String bankName;
	private	String bankType;
	private String ifscCode;
	private String branch;
	private String state;
}
