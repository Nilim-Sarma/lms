package com.te.lms.customexcpetion;

public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360173849963319184L;

	public IdNotFoundException(String message) {
		super(message);
	}
}
