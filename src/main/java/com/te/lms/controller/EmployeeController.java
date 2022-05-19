package com.te.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.AddEmployeeDTO;
import com.te.lms.dto.ResponseDTO;
import com.te.lms.pojo.Employee;
import com.te.lms.pojo.MockRatings;
import com.te.lms.service.EmployeeService;

@RestController
@RequestMapping("/lms/v1/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	

	
	/*
	 * Fetching mock details
	 */
	@GetMapping("/mockratings/{name}")
	public ResponseEntity<ResponseDTO> getMockDetails(@PathVariable String name){
		List<MockRatings> mockDetails = service.getMockDetails(name);
		return new ResponseEntity<>(new ResponseDTO(false, "success", mockDetails), HttpStatus.OK);
	}
	
	/*
	 * Fetching employee Details
	 */
	@GetMapping("/employee/{name}")
	public ResponseEntity<ResponseDTO> getDetails(@PathVariable String name){
		Employee details = service.getDetails(name);
		return new ResponseEntity<>(new ResponseDTO(false, "success", details), HttpStatus.OK);
	}
	
	/*
	 * Updating employee Details
	 */
	@PutMapping("/")
	public ResponseEntity<ResponseDTO> updateEmployeeDetails(@RequestBody Employee employee,@PathVariable Integer id){
		if(id==null) {
			throw new RuntimeException();
		}
		Employee updateEmployeeDeatils = service.updateEmployeeDeatils(employee,id);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "success", updateEmployeeDeatils), HttpStatus.OK);
	}
	
}
