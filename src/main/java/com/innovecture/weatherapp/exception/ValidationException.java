package com.innovecture.weatherapp.exception;

public class ValidationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public ValidationException() {
	}

	public ValidationException(String var1, Throwable var2) {
		super(var1, var2);
	}

	public ValidationException(Throwable var1) {
		super(var1);
	}

	public ValidationException(String message) {
		super(message);
	}
}
