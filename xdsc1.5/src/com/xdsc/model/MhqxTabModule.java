package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MhqxTabModule entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabModule implements java.io.Serializable {

	// Fields

	private Integer FModuleId;
	private String FModuleName;
	private String FFilePath;
	private Integer FPriority;
	private Set mhqxTabModuleusers = new HashSet(0);
	private Set mhqxTabReminds = new HashSet(0);
	private Set mhqxTabFunctions = new HashSet(0);
	private Set mhqxTabRolemodules = new HashSet(0);

	// Constructors

	/** default constructor */
	public MhqxTabModule() {
	}

	/** full constructor */
	public MhqxTabModule(String FModuleName, String FFilePath,
			Integer FPriority, Set mhqxTabModuleusers, Set mhqxTabReminds,
			Set mhqxTabFunctions, Set mhqxTabRolemodules) {
		this.FModuleName = FModuleName;
		this.FFilePath = FFilePath;
		this.FPriority = FPriority;
		this.mhqxTabModuleusers = mhqxTabModuleusers;
		this.mhqxTabReminds = mhqxTabReminds;
		this.mhqxTabFunctions = mhqxTabFunctions;
		this.mhqxTabRolemodules = mhqxTabRolemodules;
	}

	// Property accessors

	public Integer getFModuleId() {
		return this.FModuleId;
	}

	public void setFModuleId(Integer FModuleId) {
		this.FModuleId = FModuleId;
	}

	public String getFModuleName() {
		return this.FModuleName;
	}

	public void setFModuleName(String FModuleName) {
		this.FModuleName = FModuleName;
	}

	public String getFFilePath() {
		return this.FFilePath;
	}

	public void setFFilePath(String FFilePath) {
		this.FFilePath = FFilePath;
	}

	public Integer getFPriority() {
		return this.FPriority;
	}

	public void setFPriority(Integer FPriority) {
		this.FPriority = FPriority;
	}

	public Set getMhqxTabModuleusers() {
		return this.mhqxTabModuleusers;
	}

	public void setMhqxTabModuleusers(Set mhqxTabModuleusers) {
		this.mhqxTabModuleusers = mhqxTabModuleusers;
	}

	public Set getMhqxTabReminds() {
		return this.mhqxTabReminds;
	}

	public void setMhqxTabReminds(Set mhqxTabReminds) {
		this.mhqxTabReminds = mhqxTabReminds;
	}

	public Set getMhqxTabFunctions() {
		return this.mhqxTabFunctions;
	}

	public void setMhqxTabFunctions(Set mhqxTabFunctions) {
		this.mhqxTabFunctions = mhqxTabFunctions;
	}

	public Set getMhqxTabRolemodules() {
		return this.mhqxTabRolemodules;
	}

	public void setMhqxTabRolemodules(Set mhqxTabRolemodules) {
		this.mhqxTabRolemodules = mhqxTabRolemodules;
	}

}