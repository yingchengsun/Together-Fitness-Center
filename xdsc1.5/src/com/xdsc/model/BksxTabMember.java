package com.xdsc.model;

/**
 * BksxTabMember entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabMember implements java.io.Serializable {

	// Fields

	private String FStudentNumber;
	private BksxTabTeam bksxTabTeam;
	private TabStudents tabStudents;
	private String FTeamRole;
	private String FMemberDescription;

	// Constructors

	/** default constructor */
	public BksxTabMember() {
	}

	/** minimal constructor */
	public BksxTabMember(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	/** full constructor */
	public BksxTabMember(BksxTabTeam bksxTabTeam, TabStudents tabStudents,
			String FTeamRole, String FMemberDescription) {
		this.bksxTabTeam = bksxTabTeam;
		this.tabStudents = tabStudents;
		this.FTeamRole = FTeamRole;
		this.FMemberDescription = FMemberDescription;
	}

	// Property accessors

	public BksxTabMember(String studentNumber, BksxTabTeam bksxTabTeam,
			String FTeamRole, String FMemberDescription) {
		this.FStudentNumber = studentNumber;
		this.bksxTabTeam = bksxTabTeam;
		this.FTeamRole = FTeamRole;
		this.FMemberDescription = FMemberDescription;
	}

	public String getFStudentNumber() {
		return this.FStudentNumber;
	}

	public void setFStudentNumber(String FStudentNumber) {
		this.FStudentNumber = FStudentNumber;
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

	public String getFTeamRole() {
		return this.FTeamRole;
	}

	public void setFTeamRole(String FTeamRole) {
		this.FTeamRole = FTeamRole;
	}

	public String getFMemberDescription() {
		return this.FMemberDescription;
	}

	public void setFMemberDescription(String FMemberDescription) {
		this.FMemberDescription = FMemberDescription;
	}

}