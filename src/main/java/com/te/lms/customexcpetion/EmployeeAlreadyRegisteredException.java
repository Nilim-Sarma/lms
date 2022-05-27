package com.te.lms.customexcpetion;

public class EmployeeAlreadyRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8655492882912400644L;

	public EmployeeAlreadyRegisteredException(String message) {
		super(message);
	}
}
