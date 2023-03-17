package com.universitycourseproject.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
   private int courseId;
	
	private String courseName;
	
	private LocalDate courseStartDate;
	
	private String courseDuration;
	
	private LocalDate courseEndDate;
	
       private String courseFee;

}
