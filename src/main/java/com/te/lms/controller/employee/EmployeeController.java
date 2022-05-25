package com.te.lms.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.ResponseDTO;
import com.te.lms.dto.admin.ChangePasswordDTO;
import com.te.lms.dto.employee.AddEmployeeDTO;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.mentor.MockRatings;
import com.te.lms.service.employee.EmployeeService;

@RestController
@RequestMapping("/lms/v1/")
@CrossOrigin(origins = "*")
public class EmployeeController {

	private static final String MESSAGE = "Success";

	@Autowired
	private EmployeeService service;

	/*
	 * Fetching mock details
	 */
	@GetMapping("/mockratings/{name}")
	public ResponseEntity<ResponseDTO> getMockDetails(@PathVariable String name) {
		List<MockRatings> mockDetails = service.getMockDetails(name);
		return new ResponseEntity<>(new ResponseDTO(false, MESSAGE, mockDetails), HttpStatus.OK);
	}

	/*
	 * Fetching employee Details
	 */
	@GetMapping("/employee/{name}")
	public ResponseEntity<ResponseDTO> getDetails(@PathVariable String name) {
		Employee details = service.getDetails(name);
		return new ResponseEntity<>(new ResponseDTO(false, MESSAGE, details), HttpStatus.OK);
	}

	/*
	 * Updating employee Details
	 */
	@PutMapping("/employee/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeeDetails(@RequestBody AddEmployeeDTO employee,
			@PathVariable Integer id) {
		if (id == null) {
			throw new RuntimeException();
		}
		Employee updateEmployeeDeatils = service.updateEmployeeDetails(employee, id);
		return new ResponseEntity<>(new ResponseDTO(false, MESSAGE, updateEmployeeDeatils), HttpStatus.OK);
	}

	@PostMapping("/password")
	public ResponseEntity<ResponseDTO> changeEmployeePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		service.changePassword(changePasswordDTO);
		return new ResponseEntity<>(new ResponseDTO(false, "Password changed successfully", "new password"),
				HttpStatus.OK);

	}

}
