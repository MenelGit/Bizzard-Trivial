package org.bliz.trivial.exception;

public class CustomTrivialException extends RuntimeException {

	private static final long serialVersionUID = -1034489571651508546L;

	public CustomTrivialException(String message) {
		super(message);
	}

	public CustomTrivialException(String message, Throwable cause) {
		super(message, cause);
	}
}
