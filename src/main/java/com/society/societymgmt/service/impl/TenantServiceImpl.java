package com.society.societymgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.societymgmt.model.SocietyTenant;
import com.society.societymgmt.repositories.TenantRepository;
import com.society.societymgmt.service.TenantService;

@Service
public class TenantServiceImpl implements TenantService {

	@Autowired
	TenantRepository tenantRepository;
	
	@Override
	public SocietyTenant saveTenant(SocietyTenant tenant) {
		// TODO Auto-generated method stub
		return tenantRepository.save(tenant);
	}

}
