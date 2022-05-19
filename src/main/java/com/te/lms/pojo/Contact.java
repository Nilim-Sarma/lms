package com.te.lms.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_contact_info")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int id;
	private String contactType;
	private	long contactNumber;
}
