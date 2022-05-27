package com.te.lms.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.lms.customexcpetion.MentorCannotBeDeletedException;
import com.te.lms.customexcpetion.MentorDetailsNotFoundException;
import com.te.lms.dto.ResponseDTO;

@RestControllerAdvice
public class MentorControllerAdvice {

	@ExceptionHandler(MentorCannotBeDeletedException.class)
	public ResponseEntity<ResponseDTO> mentorCannotBeDeleted(MentorCannotBeDeletedException beDeletedException) {
		return new ResponseEntity<>(
				new ResponseDTO(true, beDeletedException.getMessage(), beDeletedException.getClass()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MentorDetailsNotFoundException.class)
	public ResponseEntity<ResponseDTO> mentorDetailsNotFound(MentorDetailsNotFoundException detailsNotFoundException) {
		return new ResponseEntity<>(
				new ResponseDTO(true, detailsNotFoundException.getMessage(), detailsNotFoundException.getClass()),
				HttpStatus.BAD_REQUEST);
	}

}
