//package com.te.lms.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//import com.te.lms.controller.AdminController;
//import com.te.lms.dto.BatchDTO;
//import com.te.lms.dto.ResponseDTO;
//
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc(addFilters = false)
//@WebMvcTest(controllers = AdminController.class)
//public class ControllerTest {
//
//	@Autowired
//	MockMvc mockMvc;
//	
//	@MockBean
//	AdminController controller;
//	
//	
//	@Test
//	@WithMockUser(roles = "Admin")
//	public void getAllBatchDetailsTest() throws Exception {
//		when(controller.getAllBatchDetails()).thenReturn(new ResponseEntity<ResponseDTO>(HttpStatus.OK));
//		RequestBuilder accept = MockMvcRequestBuilders.get("/lms/v1/admin/batch").accept(MediaType.APPLICATION_JSON_VALUE);
//		MvcResult andReturn = mockMvc.perform(accept).andExpect(status().isOk()).andReturn();
//		assertEquals(HttpStatus.ACCEPTED.value(), andReturn.getResponse().getStatus());
//	}
//	
//	@Test
//	@WithMockUser(roles = "Admin")
//	public void addBatchDetails() throws Exception {
//		when(controller.addBatch(any(BatchDTO.class))).thenReturn(new ResponseEntity<ResponseDTO>(HttpStatus.OK));
////		AddBatchDTO build = AddBatchDTO.builder().batchName("skjdhf").batchNumber(1)
////				.build();
////	    System.out.println(new ObjectMapper().writeValueAsString(build));
//	    String s = "{\"batchNumber\":1,\"batchName\":\"skjdhf\",\"mentorId\":null,\"techId\":null,\"startDate\":null,\"endDate\":null}";
//		RequestBuilder accept = MockMvcRequestBuilders.post("/lms/v1/admin/batch").contentType(MediaType.APPLICATION_JSON_VALUE).content(s);
//		
//		MvcResult result = mockMvc.perform(accept).andExpect(status().isOk()).andReturn();
//		
//		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//	}
//}	
//
