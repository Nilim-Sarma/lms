package com.te.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.pojo.Mentor;
import com.te.lms.pojo.Mock;

@Repository
public interface MockRepo extends JpaRepository<Mock, Integer>{
	
	public Mock findByPanel(Mentor mentor);
	
}
