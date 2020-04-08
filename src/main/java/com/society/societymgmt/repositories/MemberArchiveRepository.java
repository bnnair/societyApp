package com.society.societymgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.societymgmt.model.SocietyArchiveMember;

@Repository
public interface MemberArchiveRepository extends JpaRepository<SocietyArchiveMember, String> {

	List<SocietyArchiveMember> findByBuilding(String building);
}
