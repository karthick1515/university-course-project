package com.university.courseSelection.dto;

import java.time.LocalDate;

import javax.persistence.Enumerated;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admission {

	private int courseId;
	private int applicantId;
	private LocalDate admissionDate;
	@Enumerated
	private AdmissionStatus admissionStatus;
	private LocalDate appliedDate;
}
