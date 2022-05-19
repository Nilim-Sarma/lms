package com.ajay.lms.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.te.lms.pojo.Mentor;
import com.te.lms.pojo.Mentor.MentorBuilder;
import com.te.lms.repo.MentorRepo;

@DataJpaTest
public class MentorRepoTest {
	
	@MockBean
	MentorRepo mentorRepo;

	@Test
	public void findByEmpIdTest() {
		//given
		Mentor build = Mentor.builder().empId("TYC081234").build();
		mentorRepo.save(build); 
		//when
		Mentor empId = mentorRepo.findByEmpId(build.getEmpId());
		//then
		assertEquals("TYC081234", build.getEmpId());
	}
	
	
	
}
