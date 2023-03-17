package com.universitycourseproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "university_staffdetails")
public class UniversityStaffMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	private String email;
	private String password;
	private String role;
	
}
