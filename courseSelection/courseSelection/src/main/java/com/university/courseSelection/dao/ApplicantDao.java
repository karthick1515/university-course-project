package com.university.courseSelection.dao;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@ToString
public class ApplicantDao {
	
	private String applicantName;
	private String mobileNumber;
	private String applicantDegree;
	private String applicantGraduationPercentage;
	private String emailId;
	private String password;
	private String gender;
	private String address;
	private String school;
	private int passOutYear;
	private LocalDate dateOfBirth;
	private int academicgap;
	
}
