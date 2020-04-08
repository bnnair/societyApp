package com.society.societymgmt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SocietyTenant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Size(max = 2)
	private String building;

	@Size(max = 3)
	private String flatNo;

	@Size(max=2)
	private String shopNo;
	
	@Id
	private String primeKey;
	
	private boolean isDeleted;
	
	@NotNull
	private String ownerName;
	@NotNull
	private String tenantName1;
	
	private String tenantName2;
	private String tenantName3;
	private String tenantName4;
	private String tenantName5;
	private String tenantName6;
	private String tenantName7;
	private String tenantName8;
	private String tenantName9;
	
	@Size(max = 15)
	private String mobileNo;
	@Size(max = 15)
	private String alternateMobileNo;
	
	@Email
	private String primaryEmail;
	@Email
	private String secondaryEmail;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date contractStartDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date contractEnddate;
	
	public SocietyTenant() {

	}

	public SocietyTenant(@Size(max = 2) String building, @Size(max = 3) String flatNo, @Size(max = 2) String shopNo) {

		this.building = building;
		this.flatNo = flatNo;
		this.shopNo = shopNo;
		this.primeKey= calcPrimeKey();
	}
	
	public SocietyTenant(@Size(max = 2) String building, @Size(max = 3) String flatNo, @Size(max = 2) String shopNo, boolean isDeleted,
			@NotNull String ownerName, @NotNull String tenantName1, @Size(max = 15) String mobileNo, @Email String primaryEmail) {

		this.building = building;
		this.flatNo = flatNo;
		this.shopNo = shopNo;
		this.isDeleted = isDeleted;
		this.ownerName = ownerName;
		this.tenantName1 = tenantName1;
		this.mobileNo = mobileNo;
		this.primaryEmail = primaryEmail;
		this.primeKey= calcPrimeKey();
	}

	
	private String calcPrimeKey() {
		System.out.print("inside calc prime key method---");
		
		String prime="";
		if("".equals(this.building))
			prime = this.building+this.flatNo;
		else
			prime = "SH"+this.shopNo;
		
		System.out.print("prime key ---" + prime);
		return prime;
	}
	
	public void setPrimeKey(String building, String flatNo, String shopNo) {
		String prime="";
		if(!building.equals(null))
			prime = building+flatNo;
		else
			prime = "SH"+shopNo;
		this.primeKey= prime;
	}	
	
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getTenantName1() {
		return tenantName1;
	}

	public void setTenantName1(String tenantName1) {
		this.tenantName1 = tenantName1;
	}

	public String getTenantName2() {
		return tenantName2;
	}

	public void setTenantName2(String tenantName2) {
		this.tenantName2 = tenantName2;
	}

	public String getTenantName3() {
		return tenantName3;
	}

	public void setTenantName3(String tenantName3) {
		this.tenantName3 = tenantName3;
	}

	public String getTenantName4() {
		return tenantName4;
	}

	public void setTenantName4(String tenantName4) {
		this.tenantName4 = tenantName4;
	}

	public String getTenantName5() {
		return tenantName5;
	}

	public void setTenantName5(String tenantName5) {
		this.tenantName5 = tenantName5;
	}

	public String getTenantName6() {
		return tenantName6;
	}

	public void setTenantName6(String tenantName6) {
		this.tenantName6 = tenantName6;
	}

	public String getTenantName7() {
		return tenantName7;
	}

	public void setTenantName7(String tenantName7) {
		this.tenantName7 = tenantName7;
	}

	public String getTenantName8() {
		return tenantName8;
	}

	public void setTenantName8(String tenantName8) {
		this.tenantName8 = tenantName8;
	}

	public String getTenantName9() {
		return tenantName9;
	}

	public void setTenantName9(String tenantName9) {
		this.tenantName9 = tenantName9;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAlternateMobileNo() {
		return alternateMobileNo;
	}

	public void setAlternateMobileNo(String alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getContractEnddate() {
		return contractEnddate;
	}

	public void setContractEnddate(Date contractEnddate) {
		this.contractEnddate = contractEnddate;
	}

	/**
	 * @return the shopNo
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * @param shopNo the shopNo to set
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	
	

}
