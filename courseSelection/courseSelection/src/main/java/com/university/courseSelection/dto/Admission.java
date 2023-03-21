package com.university.courseSelection.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admission {
	
	private int courseId;
	private int applicationId;
	private LocalDate admissionDate;
	@Enumerated(EnumType.STRING)
	private AdmissionStatus admissionStatus;
	private LocalDate appliedDate;	
}
