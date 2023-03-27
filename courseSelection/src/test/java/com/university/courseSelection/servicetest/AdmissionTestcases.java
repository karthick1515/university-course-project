package com.university.courseSelection.servicetest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.dto.AdmissionStatus;
import com.university.courseSelection.entity.AdmissionEntity;
import com.university.courseSelection.entity.ApplicantEntity;
import com.university.courseSelection.entity.CoursesEntity;
import com.university.courseSelection.exception.DoesnotExistsException;
import com.university.courseSelection.repository.IAdmissionRepository;
import com.university.courseSelection.repository.IApplicantRepository;
import com.university.courseSelection.repository.ICourseRepository;
import com.university.courseSelection.services.AdmissionService;
import com.university.courseSelection.services.ApplicantService;
import com.university.courseSelection.services.CoursesService;

@SpringBootTest
public class AdmissionTestcases {
	@InjectMocks
    AdmissionService admissionservice=new AdmissionService();
	@InjectMocks
	CoursesService coursesService=new CoursesService();
	@InjectMocks
	ApplicantService applicantService=new ApplicantService();
	
	@InjectMocks
     AdmissionEntity admission;
	@Mock
	CoursesEntity courses;

	@Mock
	ApplicantEntity applicants;
	@Mock
    IAdmissionRepository iadmissionrepository;
	@Mock
     ICourseRepository courseRepository;
	@Mock
    IApplicantRepository applicantRepository;
    
	
	@Mock
    BeanUtils beanUtils;
	
	@Test
	public void testAddAdmission() {
        // Create a course
        CoursesEntity course = new CoursesEntity();
       course.setCourseId(1);
        course.setCourseName("Java Programming");
        course.setCourseDuration("3 years");
        course.setCourseFee(5000.00);
        course.setCourseStartDate(LocalDate.of(2023, 4, 1));
        course.setCourseEndDate(LocalDate.of(2023, 6, 30));
       courseRepository.save(course);
       
 
        ApplicantEntity applicant = new ApplicantEntity();
        
       applicant.setApplicantId(1);
        applicant.setApplicantName("John Doe");
        applicant.setMobileNumber("1234567890");
        applicant.setEmailId("john.doe@example.com");
        applicant.setGender("Male");
        applicant.setAddress("123 Main Street, Anytown USA");
        applicant.setSchool("ABC High School");
        applicant.setPassOutYear(2010);
        applicant.setDateOfBirth(LocalDate.of(1990, 1, 1));
        applicant.setAcademicgap(0);
       
        // Create an admission
        Admission admission = new Admission();
        admission.setCourseId(course.getCourseId());
        admission.setApplicantId(applicant.getApplicantId());
        admission.setAppliedDate(LocalDate.of(2023, 3, 25));
        admission.setAdmissionStatus(AdmissionStatus.Applied);
        admission.setAdmissionDate(null);

       
        
        AdmissionEntity admissionEntity = new AdmissionEntity();
        
        admissionEntity.setCourseId(course);
        admissionEntity.setApplicantId(applicant);
        admissionEntity.setAppliedDate(LocalDate.of(2023, 3, 25));
        admissionEntity.setAdmissionStatus(AdmissionStatus.Applied);
        admissionEntity.setAdmissionDate(null);
        assertNotNull(admissionEntity);
        assertEquals(course.getCourseId(), admissionEntity.getCourseId().getCourseId());
        assertEquals(applicant.getApplicantId(), admissionEntity.getApplicantId().getApplicantId());
        assertEquals(admission.getAppliedDate(), admissionEntity.getAppliedDate());
        assertEquals(admission.getAdmissionStatus(), admissionEntity.getAdmissionStatus());
        assertNull(admissionEntity.getAdmissionDate());
        
    }
	@Test
	void testentitydata() {
		 // Create a course
        CoursesEntity course = new CoursesEntity();
       course.setCourseId(1);
        course.setCourseName("Java Programming");
        course.setCourseDuration("3 years");
        course.setCourseFee(5000.00);
        course.setCourseStartDate(LocalDate.of(2023, 4, 1));
        course.setCourseEndDate(LocalDate.of(2023, 6, 30));
       
        courseRepository.save(course);
 
        ApplicantEntity applicant = new ApplicantEntity();
        
       applicant.setApplicantId(1);
        applicant.setApplicantName("John Doe");
        applicant.setMobileNumber("1234567890");
        applicant.setEmailId("john.doe@example.com");
        applicant.setGender("Male");
        applicant.setAddress("123 Main Street, Anytown USA");
        applicant.setSchool("ABC High School");
        applicant.setPassOutYear(2010);
        applicant.setDateOfBirth(LocalDate.of(1990, 1, 1));
        applicant.setAcademicgap(0);
        applicantRepository.save(applicant);
AdmissionEntity admissionEntity = new AdmissionEntity();
        admissionEntity.setAdmissionId(1);
        admissionEntity.setCourseId(course);
        admissionEntity.setApplicantId(applicant);
        admissionEntity.setAppliedDate(LocalDate.of(2023, 3, 25));
        admissionEntity.setAdmissionStatus(AdmissionStatus.Applied);
        admissionEntity.setAdmissionDate(null);
        
Optional<AdmissionEntity> optionaladmissionEntity = Optional.of(admissionEntity);
		
		when(iadmissionrepository.findById(1)).thenReturn(optionaladmissionEntity);
		
		int admissionId = 1;		
		AdmissionEntity admission = admissionservice.showAdmissionById(admissionId);
		assertEquals(admission.getAdmissionDate(),LocalDate.of(2023, 3, 25));
		assertEquals(admission.getApplicantId(),applicant);
  	}
	@Test
	void testgetalladmission() {
when(iadmissionrepository.findById(1020)).thenThrow(DoesnotExistsException.class);
		
		assertThrows(DoesnotExistsException.class,()->admissionservice.showAdmissionByApplicantId(1020));
	}
	@Test
	void testUpdate() {
		 CoursesEntity course = new CoursesEntity();
	       course.setCourseId(1);
	        course.setCourseName("Java Programming");
	        course.setCourseDuration("3 years");
	        course.setCourseFee(5000.00);
	        course.setCourseStartDate(LocalDate.of(2023, 4, 1));
	        course.setCourseEndDate(LocalDate.of(2023, 6, 30));
	       
	        courseRepository.save(course);
	 
	        ApplicantEntity applicant = new ApplicantEntity();
	        
	       applicant.setApplicantId(1);
	        applicant.setApplicantName("John Doe");
	        applicant.setMobileNumber("1234567890");
	        applicant.setEmailId("john.doe@example.com");
	        applicant.setGender("Male");
	        applicant.setAddress("123 Main Street, Anytown USA");
	        applicant.setSchool("ABC High School");
	        applicant.setPassOutYear(2010);
	        applicant.setDateOfBirth(LocalDate.of(1990, 1, 1));
	        applicant.setAcademicgap(0);
	        applicantRepository.save(applicant);
	AdmissionEntity admissionEntity = new AdmissionEntity();
	        admissionEntity.setAdmissionId(1);
	        admissionEntity.setCourseId(course);
	        admissionEntity.setApplicantId(applicant);
	        admissionEntity.setAppliedDate(LocalDate.of(2023, 3, 25));
	        admissionEntity.setAdmissionStatus(AdmissionStatus.Applied);
	        admissionEntity.setAdmissionDate(null);
	        	      
	}
	@Test
	public void testSetAndGetAdmissionId() {
	    admission.setAdmissionId(1);
	    assertEquals(1, admission.getAdmissionId());
	}

	@Test
	public void testSetAndGetCourse() {
	    admission.setCourseId(courses);
	    assertEquals(courses, admission.getCourseId());
	}

	@Test
	public void testSetAndGetApplicant() {
	    admission.setApplicantId(applicants);
	    assertEquals(applicants, admission.getApplicantId());
	}

	@Test
	public void testSetAndGetAdmissionDate() {
	    LocalDate date = LocalDate.of(2021, 10, 1);
	    admission.setAdmissionDate(date);
	    assertEquals(date, admission.getAdmissionDate());
	}

	@Test
	public void testSetAndGetAdmissionStatus() {
	    admission.setAdmissionStatus(AdmissionStatus.Applied);
	    assertEquals(AdmissionStatus.Applied, admission.getAdmissionStatus());
	}

	@Test
	public void testSetAndGetAppliedDate() {
	    LocalDate date = LocalDate.of(2021, 9, 1);
	    admission.setAppliedDate(date);
	    assertEquals(date, admission.getAppliedDate());
	}
}
