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
@Table(name = "admission_commitee_member")
@Data	
@ToString
public class AdmissionCommiteeMemberEntiy {
	
	@Id
	@SequenceGenerator(name="ADMINID_SEQ_GEN", sequenceName="ADMINID_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADMINID_SEQ_GEN")
	private int adminId;
	private String name;
	private String adminContact;
	private String email;
	private String password;
	
}
