package com.koreate.betty.global.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad")
public class TempException extends RuntimeException{

	public TempException() {
		super();
	}

	public TempException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TempException(String message, Throwable cause) {
		super(message, cause);
	}

	public TempException(String message) {
		super(message);
	}

	public TempException(Throwable cause) {
		super(cause);
	}

	
	
}
