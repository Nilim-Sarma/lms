package com.ajay.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.any;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.te.lms.dto.AddMentorDTO;
import com.te.lms.dto.BatchDetailsAdminDTO;
import com.te.lms.pojo.Mentor;
import com.te.lms.service.AdminService;
import com.te.lms.utility.EmailServicesLms;

@SpringBootTest
@EnableAutoConfiguration
public class AdminServiceTest {
	
	@MockBean
	AdminService adminService;
	
	@MockBean
	EmailServicesLms emailServices;
	
	@Test
	public void addMentorTest() {
		when(adminService.addMentor(any(AddMentorDTO.class))).thenReturn(Mentor.builder().mentorName("Test").build());
		
		when(emailServices.sendPassword(anyString())).thenReturn("PASS");
		
		Mentor addMentor = adminService.addMentor(new AddMentorDTO());
		
		assertEquals("Test",addMentor.getMentorName());
	}
	
	@Test
	public void addMentorExceptionTest() {
		when(adminService.addMentor(any(AddMentorDTO.class))).thenThrow(RuntimeException.class);
		
		assertThrows(RuntimeException.class, ()->adminService.addMentor(new AddMentorDTO()));
	}
	
	@Test
	public void getAllBatchDetailsTest() {
		when(adminService.getAllBatchDetails()).thenReturn(Arrays.asList(
				BatchDetailsAdminDTO.builder().batchName("TEST").build(),
				BatchDetailsAdminDTO.builder().batchName("Test2").build()
				));
		
		List<BatchDetailsAdminDTO> details = adminService.getAllBatchDetails();
		assertEquals(2,details.size());
	}

}