package com.society.societymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.societymgmt.model.SocietyArchiveMember;
import com.society.societymgmt.repositories.MemberArchiveRepository;
import com.society.societymgmt.service.MemberArchiveService;

@Service

public class MemberArchiveServiceImpl implements MemberArchiveService {

	@Autowired
	private MemberArchiveRepository memberArchiveRepository;
	
	@Override
	
	public SocietyArchiveMember saveArchiveMember(SocietyArchiveMember member) {
		// TODO Auto-generated method stub
		return memberArchiveRepository.save(member);
	}

	@Override
	public List<SocietyArchiveMember> getAllArchiveMembers() {
		// TODO Auto-generated method stub
		return memberArchiveRepository.findAll();
	}

	@Override
	public List<SocietyArchiveMember> findByBuilding(String building) {
		// TODO Auto-generated method stub
		return memberArchiveRepository.findByBuilding(building);
	}

	@Override
	public Optional<SocietyArchiveMember> getArchiveMember(String primeKey) {
		// TODO Auto-generated method stub
		return memberArchiveRepository.findById(primeKey);
	}



	

}
