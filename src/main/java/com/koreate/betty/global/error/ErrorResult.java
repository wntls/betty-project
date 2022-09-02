package com.koreate.betty.global.error;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

	private String message;
	private int status;
	private List<FieldError> errors;
	private String code;
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class FieldError{
		
		
	}
	
}
