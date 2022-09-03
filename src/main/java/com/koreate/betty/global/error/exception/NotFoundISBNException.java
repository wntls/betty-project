package com.koreate.betty.global.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.koreate.betty.global.error.BettyException;

public class NotFoundISBNException extends BettyException {

	public NotFoundISBNException() {
		super();
	}

	public NotFoundISBNException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotFoundISBNException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundISBNException(String message) {
		super(message);
	}

	public NotFoundISBNException(Throwable cause) {
		super(cause);
	}

	
	
}
