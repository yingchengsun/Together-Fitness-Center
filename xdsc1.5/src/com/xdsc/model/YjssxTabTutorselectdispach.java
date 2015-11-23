package com.xdsc.model;

/**
 * YjssxTabTutorselectdispach entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class YjssxTabTutorselectdispach implements java.io.Serializable {

	// Fields

	private Integer id;
	private TabTeachers tabTeachers;
	private TabPostgraduate tabPostgraduate;

	// Constructors

	/** default constructor */
	public YjssxTabTutorselectdispach() {
	}

	/** full constructor */
	public YjssxTabTutorselectdispach(TabTeachers tabTeachers,
			TabPostgraduate tabPostgraduate) {
		this.tabTeachers = tabTeachers;
		this.tabPostgraduate = tabPostgraduate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabPostgraduate getTabPostgraduate() {
		return this.tabPostgraduate;
	}

	public void setTabPostgraduate(TabPostgraduate tabPostgraduate) {
		this.tabPostgraduate = tabPostgraduate;
	}

}