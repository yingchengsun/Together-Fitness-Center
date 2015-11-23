package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MhqxTabRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabRole implements java.io.Serializable {

	// Fields

	private Integer FRoleId;
	private String FRoleName;
	private Set mhqxTabRolemodules = new HashSet(0);
	private Set mhqxTabRolefunctions = new HashSet(0);
	private Set mhqxTabRoleusers = new HashSet(0);

	// Constructors

	/** default constructor */
	public MhqxTabRole() {
	}

	/** full constructor */
	public MhqxTabRole(String FRoleName, Set mhqxTabRolemodules,
			Set mhqxTabRolefunctions, Set mhqxTabRoleusers) {
		this.FRoleName = FRoleName;
		this.mhqxTabRolemodules = mhqxTabRolemodules;
		this.mhqxTabRolefunctions = mhqxTabRolefunctions;
		this.mhqxTabRoleusers = mhqxTabRoleusers;
	}

	// Property accessors

	public Integer getFRoleId() {
		return this.FRoleId;
	}

	public void setFRoleId(Integer FRoleId) {
		this.FRoleId = FRoleId;
	}

	public String getFRoleName() {
		return this.FRoleName;
	}

	public void setFRoleName(String FRoleName) {
		this.FRoleName = FRoleName;
	}

	public Set getMhqxTabRolemodules() {
		return this.mhqxTabRolemodules;
	}

	public void setMhqxTabRolemodules(Set mhqxTabRolemodules) {
		this.mhqxTabRolemodules = mhqxTabRolemodules;
	}

	public Set getMhqxTabRolefunctions() {
		return this.mhqxTabRolefunctions;
	}

	public void setMhqxTabRolefunctions(Set mhqxTabRolefunctions) {
		this.mhqxTabRolefunctions = mhqxTabRolefunctions;
	}

	public Set getMhqxTabRoleusers() {
		return this.mhqxTabRoleusers;
	}

	public void setMhqxTabRoleusers(Set mhqxTabRoleusers) {
		this.mhqxTabRoleusers = mhqxTabRoleusers;
	}

}