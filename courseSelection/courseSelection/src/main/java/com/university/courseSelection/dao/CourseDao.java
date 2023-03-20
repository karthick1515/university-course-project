package com.university.courseSelection.dao;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseDao {
	
	private String courseName;
	private String courseDuration;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	private double courseFee;
	
}
