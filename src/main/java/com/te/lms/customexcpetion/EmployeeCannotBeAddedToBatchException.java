package com.te.lms.customexcpetion;

public class EmployeeCannotBeAddedToBatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6219042697471169028L;

	public EmployeeCannotBeAddedToBatchException(String message) {
		super(message);
	}
}
