package com.xdsc.model;

/**
 * XsglTabParty entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabParty implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabStudents tabStudents;
	private String FYear;
	private String FName;

	// Constructors

	/** default constructor */
	public XsglTabParty() {
	}

	/** full constructor */
	public XsglTabParty(TabStudents tabStudents, String FYear, String FName) {
		this.tabStudents = tabStudents;
		this.FYear = FYear;
		this.FName = FName;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFYear() {
		return this.FYear;
	}

	public void setFYear(String FYear) {
		this.FYear = FYear;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

}