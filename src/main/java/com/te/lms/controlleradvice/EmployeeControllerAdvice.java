package com.te.lms.controlleradvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.te.lms.dto.ResponseDTO;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseDTO> duplicateEntryOfEmpId(){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "Duplicate entry of empId", null), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidFormatException.class)
	public ResponseEntity<ResponseDTO> invalidDateFormat(){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "Invalid date format",Exception.class), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<ResponseDTO> noSuchElement(){
		return new ResponseEntity<>(new ResponseDTO(true, "No Such element", getClass()), HttpStatus.OK);
	}
	
	
	
}
