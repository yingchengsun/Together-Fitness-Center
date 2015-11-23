package com.xdsc.model;

/**
 * XsglTabJiangzhu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabJiangzhu implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabStudents tabStudents;
	private String FName;
	private String FYear;
	private Integer FAmount;

	// Constructors

	/** default constructor */
	public XsglTabJiangzhu() {
	}

	/** full constructor */
	public XsglTabJiangzhu(TabStudents tabStudents, String FName, String FYear,
			Integer FAmount) {
		this.tabStudents = tabStudents;
		this.FName = FName;
		this.FYear = FYear;
		this.FAmount = FAmount;
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

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getFYear() {
		return this.FYear;
	}

	public void setFYear(String FYear) {
		this.FYear = FYear;
	}

	public Integer getFAmount() {
		return this.FAmount;
	}

	public void setFAmount(Integer FAmount) {
		this.FAmount = FAmount;
	}

}