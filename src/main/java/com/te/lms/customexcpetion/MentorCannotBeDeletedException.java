package com.te.lms.customexcpetion;

public class MentorCannotBeDeletedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5923455921971567624L;

	public MentorCannotBeDeletedException(String message) {
		super(message);
	}
}
