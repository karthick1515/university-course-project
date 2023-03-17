package com.universitycourseproject.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AdmissionNotGrantedException.class)
	public String handleAdmissionNotGrantedException(Exception e) {
		return e.getMessage();
	}	
	
	@ExceptionHandler(ApplicantNotFoundException.class)
	public String handleApplicantNotFoundException(Exception e) {
		return e.getMessage();
	}	
	
	@ExceptionHandler(CourseNotFoundException.class)
	public String handleCourseNotFoundException(Exception e) {
		return e.getMessage();
	}	
	
	@ExceptionHandler(LoginFailedException.class)
	public String handleLoginFailedException(Exception e) {
		return e.getMessage();
	}	
}