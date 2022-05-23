package com.te.lms.repo.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.mentor.Mentor;

public interface MentorRepo extends JpaRepository<Mentor, Integer>{
	public Mentor findByEmpId(String empId);
	public List<Mentor> findByEmpIdIn(List<String> id);
	public void deleteByEmpId(String empId);
}
