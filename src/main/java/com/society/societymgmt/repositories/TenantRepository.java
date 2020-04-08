package com.society.societymgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.societymgmt.model.SocietyTenant;


@Repository
public interface TenantRepository extends JpaRepository<SocietyTenant, String> {

	
}
