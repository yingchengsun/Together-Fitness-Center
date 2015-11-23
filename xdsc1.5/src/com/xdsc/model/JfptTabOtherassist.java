package com.xdsc.model;

/**
 * JfptTabOtherassist entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabOtherassist implements java.io.Serializable {

	// Fields

	private String FAssistantId;
	private MhqxTabUser mhqxTabUser;
	private String FName;
	private String FSex;
	private Integer FAge;
	private String FTelephone;
	private String FEmailAddress;
	private String FBeizhu;

	// Constructors

	/** default constructor */
	public JfptTabOtherassist() {
	}

	/** minimal constructor */
	public JfptTabOtherassist(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public JfptTabOtherassist(MhqxTabUser mhqxTabUser, String FName,
			String FSex, Integer FAge, String FTelephone, String FEmailAddress,
			String FBeizhu) {
		this.mhqxTabUser = mhqxTabUser;
		this.FName = FName;
		this.FSex = FSex;
		this.FAge = FAge;
		this.FTelephone = FTelephone;
		this.FEmailAddress = FEmailAddress;
		this.FBeizhu = FBeizhu;
	}

	// Property accessors

	public String getFAssistantId() {
		return this.FAssistantId;
	}

	public void setFAssistantId(String FAssistantId) {
		this.FAssistantId = FAssistantId;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
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

	public String getFBeizhu() {
		return this.FBeizhu;
	}

	public void setFBeizhu(String FBeizhu) {
		this.FBeizhu = FBeizhu;
	}

}