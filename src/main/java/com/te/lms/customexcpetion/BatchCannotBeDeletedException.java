package com.te.lms.customexcpetion;

public class BatchCannotBeDeletedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3291353018722824625L;

	public BatchCannotBeDeletedException(String message) {
		super(message);
	}
}
