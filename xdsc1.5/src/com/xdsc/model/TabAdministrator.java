package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabAdministrator entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabAdministrator implements java.io.Serializable {

	// Fields

	private String FAdminNumber;
	private MhqxTabUser mhqxTabUser;
	private String FBoss;
	private String FName;
	private String FSex;
	private Integer FAge;
	private String FTelephone;
	private String FEmailAddress;
	private String FType;
	private String FBeizhu;
	private Set sjjxTabEquipmentdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabAdministrator() {
	}

	/** minimal constructor */
	public TabAdministrator(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public TabAdministrator(MhqxTabUser mhqxTabUser, String FBoss,
			String FName, String FSex, Integer FAge, String FTelephone,
			String FEmailAddress, String FType, String FBeizhu,
			Set sjjxTabEquipmentdetails) {
		this.mhqxTabUser = mhqxTabUser;
		this.FBoss = FBoss;
		this.FName = FName;
		this.FSex = FSex;
		this.FAge = FAge;
		this.FTelephone = FTelephone;
		this.FEmailAddress = FEmailAddress;
		this.FType = FType;
		this.FBeizhu = FBeizhu;
		this.sjjxTabEquipmentdetails = sjjxTabEquipmentdetails;
	}

	// Property accessors

	public String getFAdminNumber() {
		return this.FAdminNumber;
	}

	public void setFAdminNumber(String FAdminNumber) {
		this.FAdminNumber = FAdminNumber;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFBoss() {
		return this.FBoss;
	}

	public void setFBoss(String FBoss) {
		this.FBoss = FBoss;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getFSex() {
		return this.FSex;
	}

	public void setFSex(String FSex) {
		this.FSex = FSex;
	}

	public Integer getFAge() {
		return this.FAge;
	}

	public void setFAge(Integer FAge) {
		this.FAge = FAge;
	}

	public String getFTelephone() {
		return this.FTelephone;
	}

	public void setFTelephone(String FTelephone) {
		this.FTelephone = FTelephone;
	}

	public String getFEmailAddress() {
		return this.FEmailAddress;
	}

	public void setFEmailAddress(String FEmailAddress) {
		this.FEmailAddress = FEmailAddress;
	}

	public String getFType() {
		return this.FType;
	}

	public void setFType(String FType) {
		this.FType = FType;
	}

	public String getFBeizhu() {
		return this.FBeizhu;
	}

	public void setFBeizhu(String FBeizhu) {
		this.FBeizhu = FBeizhu;
	}

	public Set getSjjxTabEquipmentdetails() {
		return this.sjjxTabEquipmentdetails;
	}

	public void setSjjxTabEquipmentdetails(Set sjjxTabEquipmentdetails) {
		this.sjjxTabEquipmentdetails = sjjxTabEquipmentdetails;
	}

}