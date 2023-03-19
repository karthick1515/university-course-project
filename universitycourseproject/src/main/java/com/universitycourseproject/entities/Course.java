package com.universitycourseproject.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="Course")
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
