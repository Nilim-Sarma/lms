package com.te.lms.pojo.mentor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.te.lms.pojo.admin.BatchDetails;
import com.te.lms.pojo.employee.Technologies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mentorName;
	private String empId;
	private String email;
	@ManyToMany(targetEntity = Technologies.class)
	private List<Technologies> technologies;
	@OneToMany(mappedBy = "mentor")
	@JsonBackReference
	private List<BatchDetails> batchDetails;
	private LocalDate lastLogin;
	private String status;
}
