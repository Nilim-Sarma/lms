package com.te.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.AddEmployeeDTO;
import com.te.lms.dto.ResponseDTO;
import com.te.lms.pojo.Employee;
import com.te.lms.service.EmployeeService;

@RestController
@RequestMapping("lms/api/public")
public class PublicController {

	@Autowired
	EmployeeService service;
	
	/*
	 * EMployee Registration
	 */
	@PostMapping("/")
	public ResponseEntity<ResponseDTO> register(@RequestBody AddEmployeeDTO employee) {
		Employee addEmployee = service.addEmployee(employee);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Successfully registered employee", addEmployee),
				HttpStatus.OK);
	}

}
