package com.xdsc.model;

/**
 * MhqxTabRolemodule entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabRolemodule implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabRole mhqxTabRole;
	private MhqxTabModule mhqxTabModule;

	// Constructors

	/** default constructor */
	public MhqxTabRolemodule() {
	}

	/** full constructor */
	public MhqxTabRolemodule(MhqxTabRole mhqxTabRole,
			MhqxTabModule mhqxTabModule) {
		this.mhqxTabRole = mhqxTabRole;
		this.mhqxTabModule = mhqxTabModule;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public MhqxTabRole getMhqxTabRole() {
		return this.mhqxTabRole;
	}

	public void setMhqxTabRole(MhqxTabRole mhqxTabRole) {
		this.mhqxTabRole = mhqxTabRole;
	}

	public MhqxTabModule getMhqxTabModule() {
		return this.mhqxTabModule;
	}

	public void setMhqxTabModule(MhqxTabModule mhqxTabModule) {
		this.mhqxTabModule = mhqxTabModule;
	}

}