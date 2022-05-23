package com.te.lms.pojo.admin;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.employee.Technologies;
import com.te.lms.pojo.mentor.Mentor;
import com.te.lms.pojo.mentor.Mock;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class BatchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String batchName;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate startDate;

	private String status;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate endDate;

	@ManyToOne
//	@JsonManagedReference
	private Mentor mentor;

	@OneToMany
	private List<Technologies> technologies;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Mock> mock;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employees;

}
