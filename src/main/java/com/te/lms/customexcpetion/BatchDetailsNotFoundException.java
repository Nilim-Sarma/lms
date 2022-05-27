package com.te.lms.customexcpetion;

public class BatchDetailsNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1001430450406556127L;

	public BatchDetailsNotFoundException(String message) {
		super(message);
	}

}
