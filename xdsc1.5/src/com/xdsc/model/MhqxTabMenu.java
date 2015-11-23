package com.xdsc.model;

/**
 * MhqxTabMenu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabMenu implements java.io.Serializable {

	// Fields

	private Integer FMenuId;
	private String FMenuName;
	private Integer FSuperMenuId;
	private Integer FMenuPriority;

	// Constructors

	/** default constructor */
	public MhqxTabMenu() {
	}

	/** full constructor */
	public MhqxTabMenu(String FMenuName, Integer FSuperMenuId,
			Integer FMenuPriority) {
		this.FMenuName = FMenuName;
		this.FSuperMenuId = FSuperMenuId;
		this.FMenuPriority = FMenuPriority;
	}

	// Property accessors

	public Integer getFMenuId() {
		return this.FMenuId;
	}

	public void setFMenuId(Integer FMenuId) {
		this.FMenuId = FMenuId;
	}

	public String getFMenuName() {
		return this.FMenuName;
	}

	public void setFMenuName(String FMenuName) {
		this.FMenuName = FMenuName;
	}

	public Integer getFSuperMenuId() {
		return this.FSuperMenuId;
	}

	public void setFSuperMenuId(Integer FSuperMenuId) {
		this.FSuperMenuId = FSuperMenuId;
	}

	public Integer getFMenuPriority() {
		return this.FMenuPriority;
	}

	public void setFMenuPriority(Integer FMenuPriority) {
		this.FMenuPriority = FMenuPriority;
	}

}