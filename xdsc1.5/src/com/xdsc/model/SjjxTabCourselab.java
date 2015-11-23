package com.xdsc.model;

import java.util.Date;

/**
 * SjjxTabCourselab entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabCourselab implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabGrade tabGrade;
	private TabClasses tabClasses;
	private TabDirection tabDirection;
	private SjjxTabLab sjjxTabLab;
	private TabTeachers tabTeachers;
	private TabCourse tabCourse;
	private Date FDate;
	private String FExactTime;

	// Constructors

	/** default constructor */
	public SjjxTabCourselab() {
	}

	/** full constructor */
	public SjjxTabCourselab(TabGrade tabGrade, TabClasses tabClasses,
			TabDirection tabDirection, SjjxTabLab sjjxTabLab,
			TabTeachers tabTeachers, TabCourse tabCourse, Date FDate,
			String FExactTime) {
		this.tabGrade = tabGrade;
		this.tabClasses = tabClasses;
		this.tabDirection = tabDirection;
		this.sjjxTabLab = sjjxTabLab;
		this.tabTeachers = tabTeachers;
		this.tabCourse = tabCourse;
		this.FDate = FDate;
		this.FExactTime = FExactTime;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public TabGrade getTabGrade() {
		return this.tabGrade;
	}

	public void setTabGrade(TabGrade tabGrade) {
		this.tabGrade = tabGrade;
	}

	public TabClasses getTabClasses() {
		return this.tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public TabDirection getTabDirection() {
		return this.tabDirection;
	}

	public void setTabDirection(TabDirection tabDirection) {
		this.tabDirection = tabDirection;
	}

	public SjjxTabLab getSjjxTabLab() {
		return this.sjjxTabLab;
	}

	public void setSjjxTabLab(SjjxTabLab sjjxTabLab) {
		this.sjjxTabLab = sjjxTabLab;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabCourse getTabCourse() {
		return this.tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public Date getFDate() {
		return this.FDate;
	}

	public void setFDate(Date FDate) {
		this.FDate = FDate;
	}

	public String getFExactTime() {
		return this.FExactTime;
	}

	public void setFExactTime(String FExactTime) {
		this.FExactTime = FExactTime;
	}

}