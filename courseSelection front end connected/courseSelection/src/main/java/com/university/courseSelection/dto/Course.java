package com.university.courseSelection.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Course {
	
	private String courseName;
	private String courseDuration;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	private double courseFee;
	
}
