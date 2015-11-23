package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * BksxTabProject entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabProject implements java.io.Serializable {

	// Fields

	private Integer FProjId;
	private BksxTabTeam bksxTabTeam;
	private String FProjectName;
	private String FProjectCategory;
	private String FProjectDescription;
	private Set bksxTabGanttplans = new HashSet(0);
	private Set bksxTabStagereports = new HashSet(0);
	private Set bksxTabSubstuguis = new HashSet(0);

	// Constructors

	/** default constructor */
	public BksxTabProject() {
	}

	/** full constructor */
	public BksxTabProject(BksxTabTeam bksxTabTeam, String FProjectName,
			String FProjectCategory, String FProjectDescription,
			Set bksxTabGanttplans, Set bksxTabStagereports,
			Set bksxTabSubstuguis) {
		this.bksxTabTeam = bksxTabTeam;
		this.FProjectName = FProjectName;
		this.FProjectCategory = FProjectCategory;
		this.FProjectDescription = FProjectDescription;
		this.bksxTabGanttplans = bksxTabGanttplans;
		this.bksxTabStagereports = bksxTabStagereports;
		this.bksxTabSubstuguis = bksxTabSubstuguis;
	}

	// Property accessors

	public Integer getFProjId() {
		return this.FProjId;
	}

	public void setFProjId(Integer FProjId) {
		this.FProjId = FProjId;
	}

	public BksxTabTeam getBksxTabTeam() {
		return this.bksxTabTeam;
	}

	public void setBksxTabTeam(BksxTabTeam bksxTabTeam) {
		this.bksxTabTeam = bksxTabTeam;
	}

	public String getFProjectName() {
		return this.FProjectName;
	}

	public void setFProjectName(String FProjectName) {
		this.FProjectName = FProjectName;
	}

	public String getFProjectCategory() {
		return this.FProjectCategory;
	}

	public void setFProjectCategory(String FProjectCategory) {
		this.FProjectCategory = FProjectCategory;
	}

	public String getFProjectDescription() {
		return this.FProjectDescription;
	}

	public void setFProjectDescription(String FProjectDescription) {
		this.FProjectDescription = FProjectDescription;
	}

	public Set getBksxTabGanttplans() {
		return this.bksxTabGanttplans;
	}

	public void setBksxTabGanttplans(Set bksxTabGanttplans) {
		this.bksxTabGanttplans = bksxTabGanttplans;
	}

	public Set getBksxTabStagereports() {
		return this.bksxTabStagereports;
	}

	public void setBksxTabStagereports(Set bksxTabStagereports) {
		this.bksxTabStagereports = bksxTabStagereports;
	}

	public Set getBksxTabSubstuguis() {
		return this.bksxTabSubstuguis;
	}

	public void setBksxTabSubstuguis(Set bksxTabSubstuguis) {
		this.bksxTabSubstuguis = bksxTabSubstuguis;
	}

}