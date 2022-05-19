package com.te.lms.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.lms.customexcpetion.UserNotFoundExcpertion;
import com.te.lms.dto.ResponseDTO;

@RestControllerAdvice
public class PublicControllerAdvice {
	
	@ExceptionHandler(UserNotFoundExcpertion.class)
	public ResponseEntity<ResponseDTO> usernotFound(UserNotFoundExcpertion user){
		return new ResponseEntity<>(new ResponseDTO(false, user.getMessage(), getClass()), HttpStatus.NOT_FOUND);
	}
	
}
