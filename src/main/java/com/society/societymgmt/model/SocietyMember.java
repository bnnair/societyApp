package com.society.societymgmt.model;

/* This class holds all the owners of flats in the society.
 * 
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class SocietyMember implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6662779204144588302L;
	
	
	@Size(max=2)
	private String building;

	@Size(max=3)
	private String flatNo;
	
	@Size(max=2)
	private String shopNo;
	
	@Id
	private String primeKey;
	
	@NotNull
	private String memberName;
	private String coMemberName1;
	private String coMemberName2;
	private String coMemberName3;
	
	private String mobileNo;
	private String alternateMobileNo;
	@Email
	private String primaryEmail;
	@Email
	private String secondaryEmail;
	
	private boolean isCurrentlyStaying;
	
	
	public SocietyMember() {
		
	}
		
	public SocietyMember(@Size(max = 2) String building, @Size(max = 3) String flatNo, @Size(max = 2) String shopNo) {
		this.building = building;
		this.flatNo = flatNo;
		this.shopNo = shopNo;	
		this.primeKey = calcPrimeKey();
	}
	
	
	public SocietyMember(@Size(max = 2) String building, @Size(max = 3) String flatNo, @Size(max = 2) String shopNo,
			@NotNull String memberName, String mobileNo, @Email String primaryEmail, 
			boolean isCurrentlyStaying) {
		super();
		this.building = building;
		this.flatNo = flatNo;
		this.shopNo = shopNo;
		this.memberName = memberName;
		this.mobileNo = mobileNo;
		this.primaryEmail = primaryEmail;
		this.isCurrentlyStaying = isCurrentlyStaying;
		this.primeKey = calcPrimeKey();
	}

	private String calcPrimeKey() {
		String prime="";
		if(!this.building.equals(null))
			prime = this.building+this.flatNo;
		else
			prime = "SH"+this.shopNo;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCoMemberName1() {
		return coMemberName1;
	}

	public void setCoMemberName1(String coMemberName1) {
		this.coMemberName1 = coMemberName1;
	}

	public String getCoMemberName2() {
		return coMemberName2;
	}

	public void setCoMemberName2(String coMemberName2) {
		this.coMemberName2 = coMemberName2;
	}

	public String getCoMemberName3() {
		return coMemberName3;
	}

	public void setCoMemberName3(String coMemberName3) {
		this.coMemberName3 = coMemberName3;
	}

	public boolean isCurrentlyStaying() {
		return isCurrentlyStaying;
	}

	public void setCurrentlyStaying(boolean isCurrentlyStaying) {
		this.isCurrentlyStaying = isCurrentlyStaying;
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

	/**
	 * @return the primeKey
	 */
	public String getPrimeKey() {
		return primeKey;
	}



}
