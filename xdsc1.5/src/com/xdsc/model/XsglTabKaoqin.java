package com.xdsc.model;

import java.util.Date;

/**
 * XsglTabKaoqin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabKaoqin implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private Date FData;
	private String FAbsence;
	private String FRemark;

	// Constructors

	/** default constructor */
	public XsglTabKaoqin() {
	}

	/** full constructor */
	public XsglTabKaoqin(TabCourse tabCourse, TabStudents tabStudents,
			Date FData, String FAbsence, String FRemark) {
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
		this.FData = FData;
		this.FAbsence = FAbsence;
		this.FRemark = FRemark;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabCourse getTabCourse() {
		return this.tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public Date getFData() {
		return this.FData;
	}

	public void setFData(Date FData) {
		this.FData = FData;
	}

	public String getFAbsence() {
		return this.FAbsence;
	}

	public void setFAbsence(String FAbsence) {
		this.FAbsence = FAbsence;
	}

	public String getFRemark() {
		return this.FRemark;
	}

	public void setFRemark(String FRemark) {
		this.FRemark = FRemark;
	}

}