package com.te.lms.customexcpetion;

public class UserNotFoundExcpetion extends RuntimeException {
	private static final long serialVersionUID = 6543783307779601407L;

	public UserNotFoundExcpetion(String message) {
		super(message);
	}
}
