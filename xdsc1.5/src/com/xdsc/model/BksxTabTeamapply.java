package com.xdsc.model;

/**
 * BksxTabTeamapply entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabTeamapply implements java.io.Serializable {

	// Fields

	private Integer FAid;
	private BksxTabTeam bksxTabTeam;
	private TabStudents tabStudents;
	private String FResult;

	// Constructors

	/** default constructor */
	public BksxTabTeamapply() {
	}

	/** full constructor */
	public BksxTabTeamapply(BksxTabTeam bksxTabTeam, TabStudents tabStudents,
			String FResult) {
		this.bksxTabTeam = bksxTabTeam;
		this.tabStudents = tabStudents;
		this.FResult = FResult;
	}

	// Property accessors

	public Integer getFAid() {
		return this.FAid;
	}

	public void setFAid(Integer FAid) {
		this.FAid = FAid;
	}

	public BksxTabTeam getBksxTabTeam() {
		return this.bksxTabTeam;
	}

	public void setBksxTabTeam(BksxTabTeam bksxTabTeam) {
		this.bksxTabTeam = bksxTabTeam;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFResult() {
		return this.FResult;
	}

	public void setFResult(String FResult) {
		this.FResult = FResult;
	}

}