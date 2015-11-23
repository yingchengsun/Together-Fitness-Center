package com.xdsc.model;

/**
 * MhqxTabUserfunction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabUserfunction implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabFunction mhqxTabFunction;
	private MhqxTabUser mhqxTabUser;

	// Constructors

	/** default constructor */
	public MhqxTabUserfunction() {
	}

	/** full constructor */
	public MhqxTabUserfunction(MhqxTabFunction mhqxTabFunction,
			MhqxTabUser mhqxTabUser) {
		this.mhqxTabFunction = mhqxTabFunction;
		this.mhqxTabUser = mhqxTabUser;
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

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

}