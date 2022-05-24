package com.te.lms.pojo.employee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.te.lms.pojo.mentor.Attendance;
import com.te.lms.pojo.mentor.MockRatings;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_primary_info")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String empId;
	private String empName;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate doj;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dob;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String status;
	private LocalDate lastLogin;

	@OneToOne(cascade = CascadeType.ALL)
	private SecondaryInfo info;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;

	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> exp;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contact;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private List<MockRatings> ratings;

	@OneToMany(mappedBy = "employee")
	private List<Attendance> attendances;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TechnicalSkills> technicalSkills;

}
