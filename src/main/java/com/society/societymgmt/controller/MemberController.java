package com.society.societymgmt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.society.societymgmt.model.SocietyArchiveMember;
import com.society.societymgmt.model.SocietyMember;
import com.society.societymgmt.service.MemberArchiveService;
import com.society.societymgmt.service.MemberService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("member")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberArchiveService memberArchiveService;

	@PostMapping("/saveMember")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SocietyMember save(@RequestBody @Valid SocietyMember member) {
		member.setPrimeKey(member.getBuilding(),member.getFlatNo(), member.getShopNo());
		return memberService.saveMember(member);
	}
	
	@PutMapping("/updateMember")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SocietyMember update(@RequestBody SocietyMember member) {
		return memberService.updateMember(member);
	}
	
//	, 
//	@PathVariable Integer _page, 
//	@PathVariable String _order, 
//	@PathVariable String _sort
	
	
	@GetMapping(path="/allMembersWithParams")
	public List<SocietyMember> getAllMembers(@RequestParam Integer _limit,
									@RequestParam Integer _page,
									@RequestParam String _order,
									@RequestParam String _sort,
									@RequestParam String q){
	       
		Page<SocietyMember> pagedResult = memberService.getAllSocietyMembers(_limit, _page, _order, _sort , q );
		
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<SocietyMember>();
        }
		
	}
	
	@GetMapping(path="/allMembers")
	public Iterable<SocietyMember> getAllMembers(){
		return memberService.getAllSocietyMembers();
	}
	
	
	@GetMapping("/byMember/{primeKey}")
	public ResponseEntity<SocietyMember> getMember(@PathVariable String primeKey) 
			{
		Optional<SocietyMember> opt = memberService.getMember(primeKey);
		 SocietyMember member = opt.get();
		return ResponseEntity.ok(member);
	}
	
	@DeleteMapping("/deleteMember/{primeKey}")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMember(@PathVariable String primeKey) {
		
		Optional<SocietyMember> opt = memberService.getMember(primeKey);
		SocietyMember member = opt.get();
		SocietyArchiveMember memberArchive = createArchive(member);

		memberArchiveService.saveArchiveMember(memberArchive);
		memberService.deleteMember(primeKey);
	}
	
	private SocietyArchiveMember createArchive(SocietyMember member) {
		// TODO Auto-generated method stub
		SocietyArchiveMember archiveMember = new SocietyArchiveMember(
				member.getBuilding(),
				member.getFlatNo(),
				member.getShopNo(),
				member.getMemberName(),
				member.getMobileNo(),
				member.getPrimaryEmail(),
				false);
		
		archiveMember.setLastDate(new Date());
		return archiveMember;
	}

	@GetMapping("/building/{building}")
	public List<SocietyMember> getAllByBuilding(@PathVariable(name="building") String building) {
		return memberService.findByBuilding(building);
	}
	

}
