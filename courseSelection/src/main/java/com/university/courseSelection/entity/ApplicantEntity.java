package com.university.courseSelection.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "applicant")
@Getter @Setter @NoArgsConstructor @ToString
public class ApplicantEntity {
	
	@Id
	@SequenceGenerator(name="APPLICANT_SEQ_GEN", sequenceName="APPLICANT_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPLICANT_SEQ_GEN")
	private int applicantId;
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
