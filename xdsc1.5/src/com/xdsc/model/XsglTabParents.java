package com.xdsc.model;

/**
 * XsglTabParents entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabParents implements java.io.Serializable {

	// Fields

	private String FParentId;
	private TabStudents tabStudents;
	private MhqxTabUser mhqxTabUser;
	private String FParentName;

	// Constructors

	/** default constructor */
	public XsglTabParents() {
	}

	/** minimal constructor */
	public XsglTabParents(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public XsglTabParents(TabStudents tabStudents, MhqxTabUser mhqxTabUser,
			String FParentName) {
		this.tabStudents = tabStudents;
		this.mhqxTabUser = mhqxTabUser;
		this.FParentName = FParentName;
	}

	// Property accessors

	public String getFParentId() {
		return this.FParentId;
	}

	public void setFParentId(String FParentId) {
		this.FParentId = FParentId;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFParentName() {
		return this.FParentName;
	}

	public void setFParentName(String FParentName) {
		this.FParentName = FParentName;
	}

}