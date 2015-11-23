package com.xdsc.model;

/**
 * MhqxTabRolefunction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabRolefunction implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabFunction mhqxTabFunction;
	private MhqxTabRole mhqxTabRole;

	// Constructors

	/** default constructor */
	public MhqxTabRolefunction() {
	}

	/** full constructor */
	public MhqxTabRolefunction(MhqxTabFunction mhqxTabFunction,
			MhqxTabRole mhqxTabRole) {
		this.mhqxTabFunction = mhqxTabFunction;
		this.mhqxTabRole = mhqxTabRole;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public MhqxTabFunction getMhqxTabFunction() {
		return this.mhqxTabFunction;
	}

	public void setMhqxTabFunction(MhqxTabFunction mhqxTabFunction) {
		this.mhqxTabFunction = mhqxTabFunction;
	}

	public MhqxTabRole getMhqxTabRole() {
		return this.mhqxTabRole;
	}

	public void setMhqxTabRole(MhqxTabRole mhqxTabRole) {
		this.mhqxTabRole = mhqxTabRole;
	}

}