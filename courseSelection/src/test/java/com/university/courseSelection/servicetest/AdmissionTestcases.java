package com.university.courseSelection.servicetest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.university.courseSelection.dto.Admission;
import com.university.courseSelection.dto.AdmissionStatus;
import com.university.courseSelection.dto.Applicant;
import com.university.courseSelection.dto.Course;
import com.university.courseSelection.entity.AdmissionEntity;
import com.university.courseSelection.entity.ApplicantEntity;
import com.university.courseSelection.entity.CoursesEntity;
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
        Course course = new Course();
       
        course.setCourseName("Java Programming");
        course.setCourseDuration("3 years");
        course.setCourseFee(5000.00);
        course.setCourseStartDate(LocalDate.of(2023, 4, 1));
        course.setCourseEndDate(LocalDate.of(2023, 6, 30));
       
        CoursesEntity savedcoures=coursesService.addCourse(course);
        System.out.println(savedcoures);
        // Create an applicant
        Applicant applicant = new Applicant();
        
       
        applicant.setApplicantName("John Doe");
        applicant.setMobileNumber("1234567890");
        applicant.setEmailId("john.doe@example.com");
        applicant.setGender("Male");
        applicant.setAddress("123 Main Street, Anytown USA");
        applicant.setSchool("ABC High School");
        applicant.setPassOutYear(2010);
        applicant.setDateOfBirth(LocalDate.of(1990, 1, 1));
        applicant.setAcademicgap(0);
        ApplicantEntity savedapplicantentity=applicantService.addApplicant(applicant);

        // Create an admission
        Admission admission = new Admission();
        admission.setCourseId(savedcoures.getCourseId());
        admission.setApplicantId(savedapplicantentity.getApplicantId());
        admission.setAppliedDate(LocalDate.of(2023, 3, 25));
        admission.setAdmissionStatus(AdmissionStatus.Applied);
        admission.setAdmissionDate(null);

        // Add the admission
        
        AdmissionEntity admissionEntity = new AdmissionEntity();
        
        admissionEntity.setCourseId(savedcoures);
        admissionEntity.setApplicantId(savedapplicantentity);
        admissionEntity.setAppliedDate(LocalDate.of(2023, 3, 25));
        admissionEntity.setAdmissionStatus(AdmissionStatus.Applied);
        admissionEntity.setAdmissionDate(null);
        assertNotNull(admissionEntity);
        assertEquals(savedcoures.getCourseId(), admissionEntity.getCourseId().getCourseId());
        assertEquals(savedapplicantentity.getApplicantId(), admissionEntity.getApplicantId().getApplicantId());
        assertEquals(admission.getAppliedDate(), admissionEntity.getAppliedDate());
        assertEquals(admission.getAdmissionStatus(), admissionEntity.getAdmissionStatus());
        assertNull(admissionEntity.getAdmissionDate());
        
    }
	@Test
	void testdemo() {
		
	}
}
