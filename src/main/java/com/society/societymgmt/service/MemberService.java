package com.society.societymgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.society.societymgmt.model.SocietyMember;

public interface MemberService {

	SocietyMember saveMember(SocietyMember member);
	
	SocietyMember updateMember(SocietyMember member);
	
	Page<SocietyMember> getAllSocietyMembers(Integer limit, Integer page, String order, String sortBy, String name );
	
	Iterable<SocietyMember> getAllSocietyMembers();
	
	List<SocietyMember> findByBuilding(String building);
	
	List<SocietyMember> findByMember(String memberName);

	public Optional<SocietyMember> getMember(String primeKey);
	
	//ideally should be archived into another table to get history
	void deleteMember(String primeKey);
	
}
