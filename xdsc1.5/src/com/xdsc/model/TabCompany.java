package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TabCompany entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabCompany implements java.io.Serializable {

	// Fields

	private String FCompanyNumber;
	private MhqxTabUser mhqxTabUser;
	private String FCompanyName;
	private String FTelephone;
	private String FEmailAddress;
	private String FCooperateInfo;
	private String FCooperate;
	private String FAddress;
	private String FInformation;
	private String FProperty;
	private String FConnectPerson;
	private Date FRegisterTime;
	private Set gzfkTabWorkstudents = new HashSet(0);
	private Set tabPostgraduates = new HashSet(0);
	private Set yjssxTabResumes = new HashSet(0);
	private Set gzfkTabComnumses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabCompany() {
	}

	/** minimal constructor */
	public TabCompany(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public TabCompany(MhqxTabUser mhqxTabUser, String FCompanyName,
			String FTelephone, String FEmailAddress, String FCooperateInfo,
			String FCooperate, String FAddress, String FInformation,
			String FProperty, String FConnectPerson, Date FRegisterTime,
			Set gzfkTabWorkstudents, Set tabPostgraduates, Set yjssxTabResumes,
			Set gzfkTabComnumses) {
		this.mhqxTabUser = mhqxTabUser;
		this.FCompanyName = FCompanyName;
		this.FTelephone = FTelephone;
		this.FEmailAddress = FEmailAddress;
		this.FCooperateInfo = FCooperateInfo;
		this.FCooperate = FCooperate;
		this.FAddress = FAddress;
		this.FInformation = FInformation;
		this.FProperty = FProperty;
		this.FConnectPerson = FConnectPerson;
		this.FRegisterTime = FRegisterTime;
		this.gzfkTabWorkstudents = gzfkTabWorkstudents;
		this.tabPostgraduates = tabPostgraduates;
		this.yjssxTabResumes = yjssxTabResumes;
		this.gzfkTabComnumses = gzfkTabComnumses;
	}

	// Property accessors

	public String getFCompanyNumber() {
		return this.FCompanyNumber;
	}

	public void setFCompanyNumber(String FCompanyNumber) {
		this.FCompanyNumber = FCompanyNumber;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFCompanyName() {
		return this.FCompanyName;
	}

	public void setFCompanyName(String FCompanyName) {
		this.FCompanyName = FCompanyName;
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

	public String getFCooperateInfo() {
		return this.FCooperateInfo;
	}

	public void setFCooperateInfo(String FCooperateInfo) {
		this.FCooperateInfo = FCooperateInfo;
	}

	public String getFCooperate() {
		return this.FCooperate;
	}

	public void setFCooperate(String FCooperate) {
		this.FCooperate = FCooperate;
	}

	public String getFAddress() {
		return this.FAddress;
	}

	public void setFAddress(String FAddress) {
		this.FAddress = FAddress;
	}

	public String getFInformation() {
		return this.FInformation;
	}

	public void setFInformation(String FInformation) {
		this.FInformation = FInformation;
	}

	public String getFProperty() {
		return this.FProperty;
	}

	public void setFProperty(String FProperty) {
		this.FProperty = FProperty;
	}

	public String getFConnectPerson() {
		return this.FConnectPerson;
	}

	public void setFConnectPerson(String FConnectPerson) {
		this.FConnectPerson = FConnectPerson;
	}

	public Date getFRegisterTime() {
		return this.FRegisterTime;
	}

	public void setFRegisterTime(Date FRegisterTime) {
		this.FRegisterTime = FRegisterTime;
	}

	public Set getGzfkTabWorkstudents() {
		return this.gzfkTabWorkstudents;
	}

	public void setGzfkTabWorkstudents(Set gzfkTabWorkstudents) {
		this.gzfkTabWorkstudents = gzfkTabWorkstudents;
	}

	public Set getTabPostgraduates() {
		return this.tabPostgraduates;
	}

	public void setTabPostgraduates(Set tabPostgraduates) {
		this.tabPostgraduates = tabPostgraduates;
	}

	public Set getYjssxTabResumes() {
		return this.yjssxTabResumes;
	}

	public void setYjssxTabResumes(Set yjssxTabResumes) {
		this.yjssxTabResumes = yjssxTabResumes;
	}

	public Set getGzfkTabComnumses() {
		return this.gzfkTabComnumses;
	}

	public void setGzfkTabComnumses(Set gzfkTabComnumses) {
		this.gzfkTabComnumses = gzfkTabComnumses;
	}

}