package com.university.courseSelection.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdmissionCommiteeMember {
	
	private String name;
	@Column(length = 10)
	private String adminContact;
	@Email(message="Please enter valid email")
	private String email;
	@Length(min = 3, max = 15)
	private String password;
}
