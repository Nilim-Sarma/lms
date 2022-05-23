package com.te.lms.pojo.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_address_info")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String addType;
	private int doorNo;
	private String street;
	private String locality;
	private String city;
	private String state;
	private int pincode;
	private String landmark;
}
