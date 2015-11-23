package com.xdsc.model;

/**
 * TabTeacherstotype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabTeacherstotype implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabTeacherstype tabTeacherstype;
	private TabTeachers tabTeachers;

	// Constructors

	/** default constructor */
	public TabTeacherstotype() {
	}

	/** full constructor */
	public TabTeacherstotype(TabTeacherstype tabTeacherstype,
			TabTeachers tabTeachers) {
		this.tabTeacherstype = tabTeacherstype;
		this.tabTeachers = tabTeachers;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabTeacherstype getTabTeacherstype() {
		return this.tabTeacherstype;
	}

	public void setTabTeacherstype(TabTeacherstype tabTeacherstype) {
		this.tabTeacherstype = tabTeacherstype;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

}