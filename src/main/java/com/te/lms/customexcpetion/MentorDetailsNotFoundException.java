package com.te.lms.customexcpetion;

public class MentorDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8692550146900759642L;

	public MentorDetailsNotFoundException(String message) {

		super(message);
	}
}
