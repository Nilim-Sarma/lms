package com.te.lms.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.lms.customexcpetion.BatchCannotBeDeletedException;
import com.te.lms.customexcpetion.BatchCreationExeption;
import com.te.lms.customexcpetion.BatchDetailsNotFoundException;
import com.te.lms.dto.ResponseDTO;

@RestControllerAdvice
public class AdminControllerAdvice {

	@ExceptionHandler(BatchCannotBeDeletedException.class)
	public ResponseEntity<ResponseDTO> batchCannotBeDeleted(
			BatchCannotBeDeletedException batchCannotBeDeletedException) {
		return new ResponseEntity<>(new ResponseDTO(true, batchCannotBeDeletedException.getMessage(),
				batchCannotBeDeletedException.getClass()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BatchCreationExeption.class)
	public ResponseEntity<ResponseDTO> batchCreationException(BatchCreationExeption batchCreationExeption) {
		return new ResponseEntity<>(
				new ResponseDTO(true, batchCreationExeption.getMessage(), batchCreationExeption.getClass()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BatchDetailsNotFoundException.class)
	public ResponseEntity<ResponseDTO> batchDetailsNotFound(
			BatchDetailsNotFoundException batchDetailsNotFoundException) {
		return new ResponseEntity<>(new ResponseDTO(true, batchDetailsNotFoundException.getMessage(),
				batchDetailsNotFoundException.getClass()), HttpStatus.BAD_REQUEST);
	}
}
