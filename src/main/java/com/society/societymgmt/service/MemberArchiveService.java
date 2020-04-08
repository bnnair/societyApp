package com.society.societymgmt.service;

import java.util.List;
import java.util.Optional;

import com.society.societymgmt.model.SocietyArchiveMember;

public interface MemberArchiveService {

	SocietyArchiveMember saveArchiveMember(SocietyArchiveMember member);
	
	List<SocietyArchiveMember> getAllArchiveMembers();
	
	List<SocietyArchiveMember> findByBuilding(String building);

	public Optional<SocietyArchiveMember> getArchiveMember(String primeKey);
		
}
