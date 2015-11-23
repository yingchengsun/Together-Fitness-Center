package com.xdsc.model;

/**
 * XsglTabStuorgadepart entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabStuorgadepart implements java.io.Serializable {

	// Fields

	private Integer FId;
	private XsglTabDepartment xsglTabDepartment;
	private XsglTabOrganizations xsglTabOrganizations;
	private TabStudents tabStudents;
	private String FPosition;

	// Constructors

	/** default constructor */
	public XsglTabStuorgadepart() {
	}

	/** full constructor */
	public XsglTabStuorgadepart(XsglTabDepartment xsglTabDepartment,
			XsglTabOrganizations xsglTabOrganizations, TabStudents tabStudents,
			String FPosition) {
		this.xsglTabDepartment = xsglTabDepartment;
		this.xsglTabOrganizations = xsglTabOrganizations;
		this.tabStudents = tabStudents;
		this.FPosition = FPosition;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public XsglTabDepartment getXsglTabDepartment() {
		return this.xsglTabDepartment;
	}

	public void setXsglTabDepartment(XsglTabDepartment xsglTabDepartment) {
		this.xsglTabDepartment = xsglTabDepartment;
	}

	public XsglTabOrganizations getXsglTabOrganizations() {
		return this.xsglTabOrganizations;
	}

	public void setXsglTabOrganizations(
			XsglTabOrganizations xsglTabOrganizations) {
		this.xsglTabOrganizations = xsglTabOrganizations;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFPosition() {
		return this.FPosition;
	}

	public void setFPosition(String FPosition) {
		this.FPosition = FPosition;
	}

}