package com.te.lms.repo.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.admin.BatchDetails;
import com.te.lms.pojo.mentor.Mentor;

public interface BatchDetailsRepo extends JpaRepository<BatchDetails, Integer>{
	
	public BatchDetails findIdByBatchName(String batchname);
	
	public List<BatchDetails> findByMentor(Mentor id);
}
