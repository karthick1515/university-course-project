package com.university.courseSelection.entiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "staff")
@Data @ToString
public class UniversityStaffMemberEntity {
	@Id
	@SequenceGenerator(name="STAFF_SEQ_GEN", sequenceName="STAFF_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STAFF_SEQ_GEN")
	private int staffId;
	private String email;
	private String password;
	private String role;

}
