package com.universitycourseproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.universitycourseproject.entities.UniversityStaffMember;
import com.universitycourseproject.exception.AlreadyExistException;
import com.universitycourseproject.exception.DataNotFoundException;
import com.universitycourseproject.repository.UniversityStaffMemberRepo;

public class UniversityStaffMemberServiceImpl implements UniversityStaffMemberService{
	@Autowired
	private UniversityStaffMemberRepo universitystaffRepo;
	@Override
	public UniversityStaffMember addUniversityStaffMember(UniversityStaffMember universityStaffMember)
			throws AlreadyExistException {
		Optional<UniversityStaffMember> optional1=universitystaffRepo.findByEmail(universityStaffMember.getEmail());
		Optional<UniversityStaffMember> optional2=universitystaffRepo.findById(universityStaffMember.getStaffId());
		if(optional1.isPresent() || optional2.isPresent()) {
			throw new AlreadyExistException("UniversityStaffMember Already Exist");
		}else 
		{
			UniversityStaffMember addeduniversityStaffMember=universitystaffRepo.save(universityStaffMember);
			return addeduniversityStaffMember;
		}
		
	}

	@Override
	public UniversityStaffMember removeUniversityStaffMember(int universityStaffMemberId) throws DataNotFoundException {
		Optional<UniversityStaffMember> optional=universitystaffRepo.findById(universityStaffMemberId);
		if(optional.isEmpty() ) {
			throw new DataNotFoundException("There is no universityStaffMember with this Id");
		}
		else {
			universitystaffRepo.deleteById(universityStaffMemberId);
			return optional.get();
		}
	}

	@Override
	public UniversityStaffMember updateUniversityStaffMember(UniversityStaffMember universityStaffMember)
			throws DataNotFoundException {
		Optional<UniversityStaffMember> optional=universitystaffRepo.findById(universityStaffMember.getStaffId());
		if(optional.isEmpty()) {
			throw new DataNotFoundException("UniversityStaffMember is not available with the given Id");
		}else 
		{
			UniversityStaffMember updatedUniversityStaffMember=universitystaffRepo.save(universityStaffMember);
			return updatedUniversityStaffMember;
		}
	}

	@Override
	public UniversityStaffMember viewUniversityStaffMember(int universityStaffMemberid) throws DataNotFoundException {
		
		Optional<UniversityStaffMember> optional=universitystaffRepo.findById(universityStaffMemberid);
		if(optional.isEmpty()) {
			throw new DataNotFoundException("UniversityStaffMember is not available with the given Id");
		}else 
		{
			
			return optional.get();
		}
	}

	@Override
	public List<UniversityStaffMember> viewAllUniversityStaffMember() throws DataNotFoundException {
		List<UniversityStaffMember> list=universitystaffRepo.findAll();
		if(list.isEmpty()) {
			throw new DataNotFoundException("No UniversityStaffMember in the database");
		}
		else {
			return list;
		}

	}

}
