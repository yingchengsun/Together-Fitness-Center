package com.xdsc.model;

/**
 * JfptTabChooseassociate entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabChooseassociate implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabTeachers tabTeachers;
	private TabCourse tabCourse;
	private TabStudents tabStudents;

	// Constructors

	/** default constructor */
	public JfptTabChooseassociate() {
	}

	/** full constructor */
	public JfptTabChooseassociate(TabTeachers tabTeachers, TabCourse tabCourse,
			TabStudents tabStudents) {
		this.tabTeachers = tabTeachers;
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
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

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

}