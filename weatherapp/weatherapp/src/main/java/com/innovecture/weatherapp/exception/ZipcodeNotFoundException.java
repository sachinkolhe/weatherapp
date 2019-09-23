package com.innovecture.weatherapp.exception;

public class ZipcodeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZipcodeNotFoundException() {
	}

	public ZipcodeNotFoundException(String var1, Throwable var2) {
		super(var1, var2);
	}

	public ZipcodeNotFoundException(Throwable var1) {
		super(var1);
	}

	public ZipcodeNotFoundException(String message) {
		super(message);
	}

}
