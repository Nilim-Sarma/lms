package com.te.lms.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.lms.customexcpetion.UserNotFoundExcpetion;
import com.te.lms.dto.ResponseDTO;

@RestControllerAdvice
public class PublicControllerAdvice {

	@ExceptionHandler(UserNotFoundExcpetion.class)
	public ResponseEntity<ResponseDTO> usernotFound(UserNotFoundExcpetion user) {
		return new ResponseEntity<>(new ResponseDTO(true, user.getMessage(), user.getClass()), HttpStatus.NOT_FOUND);
	}
	
//	@
//	public ResponseEntity<ResponseDTO> sqlViolationException() {
//		
//	}

}
