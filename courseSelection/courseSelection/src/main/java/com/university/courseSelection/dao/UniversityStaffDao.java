package com.university.courseSelection.dao;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UniversityStaffDao {

	@Length(min = 3, max = 15)
	private String password;
	private String role;
	@Email
	private String email;
}
