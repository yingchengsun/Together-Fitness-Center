package com.xdsc.model;

/**
 * JfptTabTeacherassociate entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabTeacherassociate implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabClasses tabClasses;
	private TabTeachers tabTeachers;
	private TabCourse tabCourse;

	// Constructors

	/** default constructor */
	public JfptTabTeacherassociate() {
	}

	/** full constructor */
	public JfptTabTeacherassociate(TabClasses tabClasses,
			TabTeachers tabTeachers, TabCourse tabCourse) {
		this.tabClasses = tabClasses;
		this.tabTeachers = tabTeachers;
		this.tabCourse = tabCourse;
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

}