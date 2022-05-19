package com.te.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.BatchDetails;
import com.te.lms.pojo.Mentor;

public interface BatchDetailsRepo extends JpaRepository<BatchDetails, Integer>{
	
	public BatchDetails findIdByBatchName(String batchname);
	
	public List<BatchDetails> findByMentor(Mentor id);
}
