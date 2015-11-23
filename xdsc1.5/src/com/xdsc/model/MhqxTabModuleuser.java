package com.xdsc.model;

/**
 * MhqxTabModuleuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabModuleuser implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabUser mhqxTabUser;
	private MhqxTabModule mhqxTabModule;

	// Constructors

	/** default constructor */
	public MhqxTabModuleuser() {
	}

	/** full constructor */
	public MhqxTabModuleuser(MhqxTabUser mhqxTabUser,
			MhqxTabModule mhqxTabModule) {
		this.mhqxTabUser = mhqxTabUser;
		this.mhqxTabModule = mhqxTabModule;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public MhqxTabModule getMhqxTabModule() {
		return this.mhqxTabModule;
	}

	public void setMhqxTabModule(MhqxTabModule mhqxTabModule) {
		this.mhqxTabModule = mhqxTabModule;
	}

}