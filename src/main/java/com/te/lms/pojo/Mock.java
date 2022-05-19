package com.te.lms.pojo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Mock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int mockNo;
	@ManyToOne
	private Technologies tech;
	@ManyToMany
	private List<Mentor> panel;
	private LocalDateTime date;
	@OneToOne
	private MockRatings ratings;
	
}
