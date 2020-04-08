package com.society.societymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.society.societymgmt.model.SocietyMember;
import com.society.societymgmt.repositories.MemberRepository;
import com.society.societymgmt.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	
	@Override
	public SocietyMember saveMember(SocietyMember member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	@Override
	public SocietyMember updateMember(SocietyMember member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	
	@Override
	public Page<SocietyMember> getAllSocietyMembers(@DefaultValue("10") Integer limit,
													@DefaultValue("0") Integer page,
													@DefaultValue("asc") String order,
													@DefaultValue("building") String sortBy, String name) {
		// TODO Auto-generated method stub
		String[] sortByList = {sortBy};

		Pageable paging = null;
		if (order.equalsIgnoreCase("asc")) {
			paging = PageRequest.of(page, limit, Direction.ASC, sortByList);
			
		}else {
			paging = PageRequest.of(page, limit, Direction.DESC, sortByList);
		}

//		if(name.equals(null) || name.equals("") )
//			return memberRepository.findAll(paging);
//		else
			return memberRepository.findByMemberNameContaining(name,paging);
	}

	
	@Override
	public Iterable<SocietyMember> getAllSocietyMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	
	@Override
	public Optional<SocietyMember> getMember(String primeKey) {
		// TODO Auto-generated method stub
		return memberRepository.findById(primeKey);
	}

	@Override
	public void deleteMember(String primeKey) {
		// TODO Auto-generated method stub
		memberRepository.deleteById(primeKey);
	}

	//find all the members by building
	@Override
	public List<SocietyMember> findByBuilding(String building) {
		// TODO Auto-generated method stub
		return memberRepository.findByBuilding(building);
	}

	@Override
	public List<SocietyMember> findByMember(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}

}
