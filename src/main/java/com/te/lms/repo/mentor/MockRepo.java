package com.te.lms.repo.mentor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.pojo.mentor.Mentor;
import com.te.lms.pojo.mentor.Mock;

@Repository
public interface MockRepo extends JpaRepository<Mock, Integer>{
	
	public Mock findByPanel(Mentor mentor);
	
}
