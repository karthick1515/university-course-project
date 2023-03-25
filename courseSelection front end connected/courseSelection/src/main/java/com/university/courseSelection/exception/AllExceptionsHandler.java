package com.university.courseSelection.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionsHandler {
	
	@ExceptionHandler({
		DoesnotExistsException.class,
		AlreadyExistsException.class,
		Exception.class,
		UnhandledException.class,
		InvalidCredentialsException.class
	})
	public ResponseEntity handleAddressNotFoundException(Exception ex) {
	    return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
