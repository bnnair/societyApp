package com.society.societymgmt.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.society.societymgmt.model.SocietyMember;

@Repository
public interface MemberRepository extends PagingAndSortingRepository<SocietyMember, String> {

	List<SocietyMember> findByBuilding(String building);
	Page<SocietyMember> findByMemberNameContaining(String memberName, Pageable paging);
}
