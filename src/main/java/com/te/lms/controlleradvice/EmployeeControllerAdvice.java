package com.te.lms.controlleradvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.te.lms.customexcpetion.EmployeeAlreadyRegisteredException;
import com.te.lms.customexcpetion.EmployeeCannotBeAddedToBatchException;
import com.te.lms.dto.ResponseDTO;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseDTO> duplicateEntryOfEmpId() {
		return new ResponseEntity<>(new ResponseDTO(true, "Duplicate entry of empId", null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ResponseDTO> invalidDateFormat() {
		return new ResponseEntity<>(new ResponseDTO(true, "Invalid date format", Exception.class),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseDTO> noSuchElement() {
		return new ResponseEntity<>(new ResponseDTO(true, "No Such element", getClass()), HttpStatus.OK);
	}

	@ExceptionHandler(EmployeeCannotBeAddedToBatchException.class)
	public ResponseEntity<ResponseDTO> employeeCannotBeAddedToBatch(
			EmployeeCannotBeAddedToBatchException addedToBatchException) {
		return new ResponseEntity<>(
				new ResponseDTO(true, addedToBatchException.getMessage(), addedToBatchException.getClass()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeAlreadyRegisteredException.class)
	public ResponseEntity<ResponseDTO> employeeCannotBeAddedToBatch(
			EmployeeAlreadyRegisteredException alreadyRegisteredException) {
		return new ResponseEntity<>(
				new ResponseDTO(true, alreadyRegisteredException.getMessage(), alreadyRegisteredException.getClass()),
				HttpStatus.BAD_REQUEST);
	}

}
