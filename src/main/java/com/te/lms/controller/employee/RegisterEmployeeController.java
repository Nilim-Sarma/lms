package com.te.lms.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.ResponseDTO;
import com.te.lms.dto.employee.AddEmployeeDTO;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.service.employee.EmployeeService;

@RestController
@RequestMapping("lms/v1/api/")
@CrossOrigin(origins = "*")
public class RegisterEmployeeController {

	@Autowired
	private EmployeeService service;
	
	/*
	 * Employee Registration
	 */
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody AddEmployeeDTO employee) {
		Employee addEmployee = service.addEmployee(employee);
		return new ResponseEntity<>(new ResponseDTO(false, "Successfully registered employee", addEmployee),
				HttpStatus.OK);
	}

}
