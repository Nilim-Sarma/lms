package com.te.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.Mentor;

public interface MentorRepo extends JpaRepository<Mentor, Integer>{
	public Mentor findByEmpId(String empId);
	public List<Mentor> findByEmpIdIn(List<String> id);
	public void deleteByEmpId(String empId);
}
