package com.commons;

import lombok.Getter;

public class UserDuplicateException extends RuntimeException {

	@Getter
	String userName;
	
	public UserDuplicateException(String userName) {
		this.userName = userName;
	}
	
}
