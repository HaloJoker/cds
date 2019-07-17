package com.bfgy.cds.common.exception;

@SuppressWarnings("serial")
public class RuntimeServiceException extends RuntimeException {

	public RuntimeServiceException() {
		super();
	}

	public RuntimeServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeServiceException(String message) {
		super(message);
	}

	public RuntimeServiceException(Throwable cause) {
		super(cause);
	}

}
