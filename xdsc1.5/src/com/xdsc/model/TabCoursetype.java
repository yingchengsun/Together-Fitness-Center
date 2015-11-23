package com.xdsc.model;

/**
 * TabCoursetype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabCoursetype implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabDirection tabDirection;
	private TabCourse tabCourse;
	private String FCourseType;

	// Constructors

	/** default constructor */
	public TabCoursetype() {
	}

	/** full constructor */
	public TabCoursetype(TabDirection tabDirection, TabCourse tabCourse,
			String FCourseType) {
		this.tabDirection = tabDirection;
		this.tabCourse = tabCourse;
		this.FCourseType = FCourseType;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public TabDirection getTabDirection() {
		return this.tabDirection;
	}

	public void setTabDirection(TabDirection tabDirection) {
		this.tabDirection = tabDirection;
	}

	public TabCourse getTabCourse() {
		return this.tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public String getFCourseType() {
		return this.FCourseType;
	}

	public void setFCourseType(String FCourseType) {
		this.FCourseType = FCourseType;
	}

}