package com.xdsc.model;

/**
 * MhqxTabRoleuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabRoleuser implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabRole mhqxTabRole;
	private MhqxTabUser mhqxTabUser;

	// Constructors

	/** default constructor */
	public MhqxTabRoleuser() {
	}

	/** full constructor */
	public MhqxTabRoleuser(MhqxTabRole mhqxTabRole, MhqxTabUser mhqxTabUser) {
		this.mhqxTabRole = mhqxTabRole;
		this.mhqxTabUser = mhqxTabUser;
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

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

}