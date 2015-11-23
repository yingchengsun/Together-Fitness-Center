package com.xdsc.model;

/**
 * JfptTabStudentassociate entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabStudentassociate implements java.io.Serializable {

	// Fields

	private Integer FInt;
	private TabClasses tabClasses;
	private TabCourse tabCourse;
	private TabStudents tabStudents;

	// Constructors

	/** default constructor */
	public JfptTabStudentassociate() {
	}

	/** full constructor */
	public JfptTabStudentassociate(TabClasses tabClasses, TabCourse tabCourse,
			TabStudents tabStudents) {
		this.tabClasses = tabClasses;
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
	}

	// Property accessors

	public Integer getFInt() {
		return this.FInt;
	}

	public void setFInt(Integer FInt) {
		this.FInt = FInt;
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

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

}