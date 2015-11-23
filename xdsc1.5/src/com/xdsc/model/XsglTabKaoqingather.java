package com.xdsc.model;

import java.util.Date;

/**
 * XsglTabKaoqingather entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabKaoqingather implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabClasses tabClasses;
	private TabCourse tabCourse;
	private Date FData;
	private Integer FTnumber;
	private Integer FRnumber;
	private String FRemark;

	// Constructors

	/** default constructor */
	public XsglTabKaoqingather() {
	}

	/** full constructor */
	public XsglTabKaoqingather(TabClasses tabClasses, TabCourse tabCourse,
			Date FData, Integer FTnumber, Integer FRnumber, String FRemark) {
		this.tabClasses = tabClasses;
		this.tabCourse = tabCourse;
		this.FData = FData;
		this.FTnumber = FTnumber;
		this.FRnumber = FRnumber;
		this.FRemark = FRemark;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabClasses getTabClasses() {
		return this.tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public TabCourse getTabCourse() {
		return this.tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public Date getFData() {
		return this.FData;
	}

	public void setFData(Date FData) {
		this.FData = FData;
	}

	public Integer getFTnumber() {
		return this.FTnumber;
	}

	public void setFTnumber(Integer FTnumber) {
		this.FTnumber = FTnumber;
	}

	public Integer getFRnumber() {
		return this.FRnumber;
	}

	public void setFRnumber(Integer FRnumber) {
		this.FRnumber = FRnumber;
	}

	public String getFRemark() {
		return this.FRemark;
	}

	public void setFRemark(String FRemark) {
		this.FRemark = FRemark;
	}

}