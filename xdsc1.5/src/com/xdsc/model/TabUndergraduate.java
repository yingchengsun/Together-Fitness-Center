package com.xdsc.model;

/**
 * TabUndergraduate entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabUndergraduate implements java.io.Serializable {

	// Fields

	private String FStudentNumber;
	private TabStudents tabStudents;
	private String FStudentHighSchool;
	private String FStudentHscore;
	private String FStudentHrank;
	private String FIsFirstChoice;

	// Constructors

	/** default constructor */
	public TabUndergraduate() {
	}

	/** minimal constructor */
	public TabUndergraduate(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	/** full constructor */
	public TabUndergraduate(TabStudents tabStudents, String FStudentHighSchool,
			String FStudentHscore, String FStudentHrank, String FIsFirstChoice) {
		this.tabStudents = tabStudents;
		this.FStudentHighSchool = FStudentHighSchool;
		this.FStudentHscore = FStudentHscore;
		this.FStudentHrank = FStudentHrank;
		this.FIsFirstChoice = FIsFirstChoice;
	}

	// Property accessors

	public String getFStudentNumber() {
		return this.FStudentNumber;
	}

	public void setFStudentNumber(String FStudentNumber) {
		this.FStudentNumber = FStudentNumber;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFStudentHighSchool() {
		return this.FStudentHighSchool;
	}

	public void setFStudentHighSchool(String FStudentHighSchool) {
		this.FStudentHighSchool = FStudentHighSchool;
	}

	public String getFStudentHscore() {
		return this.FStudentHscore;
	}

	public void setFStudentHscore(String FStudentHscore) {
		this.FStudentHscore = FStudentHscore;
	}

	public String getFStudentHrank() {
		return this.FStudentHrank;
	}

	public void setFStudentHrank(String FStudentHrank) {
		this.FStudentHrank = FStudentHrank;
	}

	public String getFIsFirstChoice() {
		return this.FIsFirstChoice;
	}

	public void setFIsFirstChoice(String FIsFirstChoice) {
		this.FIsFirstChoice = FIsFirstChoice;
	}

}