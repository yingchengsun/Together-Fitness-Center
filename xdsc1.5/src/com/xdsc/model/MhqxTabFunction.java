package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MhqxTabFunction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabFunction implements java.io.Serializable {

	// Fields

	private Integer FFunctionId;
	private MhqxTabModule mhqxTabModule;
	private String FFunctionName;
	private Integer FSuperFunctionId;
	private String FFunctionMark;
	private String FFilePath;
	private Integer FPriority;
	private String FIsLeaf;
	private Set mhqxTabUserfunctions = new HashSet(0);
	private Set mhqxTabRolefunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public MhqxTabFunction() {
	}

	/** full constructor */
	public MhqxTabFunction(MhqxTabModule mhqxTabModule, String FFunctionName,
			Integer FSuperFunctionId, String FFunctionMark, String FFilePath,
			Integer FPriority, String FIsLeaf, Set mhqxTabUserfunctions,
			Set mhqxTabRolefunctions) {
		this.mhqxTabModule = mhqxTabModule;
		this.FFunctionName = FFunctionName;
		this.FSuperFunctionId = FSuperFunctionId;
		this.FFunctionMark = FFunctionMark;
		this.FFilePath = FFilePath;
		this.FPriority = FPriority;
		this.FIsLeaf = FIsLeaf;
		this.mhqxTabUserfunctions = mhqxTabUserfunctions;
		this.mhqxTabRolefunctions = mhqxTabRolefunctions;
	}

	// Property accessors

	public Integer getFFunctionId() {
		return this.FFunctionId;
	}

	public void setFFunctionId(Integer FFunctionId) {
		this.FFunctionId = FFunctionId;
	}

	public MhqxTabModule getMhqxTabModule() {
		return this.mhqxTabModule;
	}

	public void setMhqxTabModule(MhqxTabModule mhqxTabModule) {
		this.mhqxTabModule = mhqxTabModule;
	}

	public String getFFunctionName() {
		return this.FFunctionName;
	}

	public void setFFunctionName(String FFunctionName) {
		this.FFunctionName = FFunctionName;
	}

	public Integer getFSuperFunctionId() {
		return this.FSuperFunctionId;
	}

	public void setFSuperFunctionId(Integer FSuperFunctionId) {
		this.FSuperFunctionId = FSuperFunctionId;
	}

	public String getFFunctionMark() {
		return this.FFunctionMark;
	}

	public void setFFunctionMark(String FFunctionMark) {
		this.FFunctionMark = FFunctionMark;
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

	public String getFIsLeaf() {
		return this.FIsLeaf;
	}

	public void setFIsLeaf(String FIsLeaf) {
		this.FIsLeaf = FIsLeaf;
	}

	public Set getMhqxTabUserfunctions() {
		return this.mhqxTabUserfunctions;
	}

	public void setMhqxTabUserfunctions(Set mhqxTabUserfunctions) {
		this.mhqxTabUserfunctions = mhqxTabUserfunctions;
	}

	public Set getMhqxTabRolefunctions() {
		return this.mhqxTabRolefunctions;
	}

	public void setMhqxTabRolefunctions(Set mhqxTabRolefunctions) {
		this.mhqxTabRolefunctions = mhqxTabRolefunctions;
	}

}