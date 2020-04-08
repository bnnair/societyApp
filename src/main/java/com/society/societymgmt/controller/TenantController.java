package com.society.societymgmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.society.societymgmt.model.SocietyTenant;
import com.society.societymgmt.service.TenantService;

@RestController
@RequestMapping("tenant")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TenantController {
	
	@Autowired
	TenantService tenantService;
	
	@PostMapping("/saveTenant")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SocietyTenant save(@RequestBody @Valid SocietyTenant tenant) {
		tenant.setPrimeKey(tenant.getBuilding(),tenant.getFlatNo(), tenant.getShopNo());
		return tenantService.saveTenant(tenant);
	}
	

}
