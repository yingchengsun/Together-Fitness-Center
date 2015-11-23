package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabDirection entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabDirection implements java.io.Serializable {

	// Fields

	private Integer FDirectionId;
	private String FDirectionName;
	private Set tabCoursetypes = new HashSet(0);
	private Set sjjxTabCourselabs = new HashSet(0);
	private Set tabStudentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabDirection() {
	}

	/** full constructor */
	public TabDirection(String FDirectionName, Set tabCoursetypes,
			Set sjjxTabCourselabs, Set tabStudentses) {
		this.FDirectionName = FDirectionName;
		this.tabCoursetypes = tabCoursetypes;
		this.sjjxTabCourselabs = sjjxTabCourselabs;
		this.tabStudentses = tabStudentses;
	}

	// Property accessors

	public Integer getFDirectionId() {
		return this.FDirectionId;
	}

	public void setFDirectionId(Integer FDirectionId) {
		this.FDirectionId = FDirectionId;
	}

	public String getFDirectionName() {
		return this.FDirectionName;
	}

	public void setFDirectionName(String FDirectionName) {
		this.FDirectionName = FDirectionName;
	}

	public Set getTabCoursetypes() {
		return this.tabCoursetypes;
	}

	public void setTabCoursetypes(Set tabCoursetypes) {
		this.tabCoursetypes = tabCoursetypes;
	}

	public Set getSjjxTabCourselabs() {
		return this.sjjxTabCourselabs;
	}

	public void setSjjxTabCourselabs(Set sjjxTabCourselabs) {
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

	public Set getTabStudentses() {
		return this.tabStudentses;
	}

	public void setTabStudentses(Set tabStudentses) {
		this.tabStudentses = tabStudentses;
	}

}