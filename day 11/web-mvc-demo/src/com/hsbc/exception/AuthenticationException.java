package com.hsbc.exception;

public class AuthenticationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AuthenticationException () {
		super();
	}
	public AuthenticationException (String str) {
		super(str);
	}

}
