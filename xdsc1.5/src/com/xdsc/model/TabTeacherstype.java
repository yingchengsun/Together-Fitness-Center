package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabTeacherstype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabTeacherstype implements java.io.Serializable {

	// Fields

	private Integer FTypeNumber;
	private String FTypeName;
	private Set tabTeacherstotypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabTeacherstype() {
	}

	/** full constructor */
	public TabTeacherstype(String FTypeName, Set tabTeacherstotypes) {
		this.FTypeName = FTypeName;
		this.tabTeacherstotypes = tabTeacherstotypes;
	}

	// Property accessors

	public Integer getFTypeNumber() {
		return this.FTypeNumber;
	}

	public void setFTypeNumber(Integer FTypeNumber) {
		this.FTypeNumber = FTypeNumber;
	}

	public String getFTypeName() {
		return this.FTypeName;
	}

	public void setFTypeName(String FTypeName) {
		this.FTypeName = FTypeName;
	}

	public Set getTabTeacherstotypes() {
		return this.tabTeacherstotypes;
	}

	public void setTabTeacherstotypes(Set tabTeacherstotypes) {
		this.tabTeacherstotypes = tabTeacherstotypes;
	}

}