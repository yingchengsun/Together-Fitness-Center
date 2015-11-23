package com.xdsc.model;

/**
 * BksxTabProjectapply entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabProjectapply implements java.io.Serializable {

	// Fields

	private Integer id;
	private BksxTabTeam bksxTabTeam;
	private TabTeachers tabTeachers;
	private TabStudents tabStudents;
	private String FProjectName;
	private String FProjectCategory;
	private String FProjectDescription;
	private String FResult;

	// Constructors

	/** default constructor */
	public BksxTabProjectapply() {
	}

	/** full constructor */
	public BksxTabProjectapply(BksxTabTeam bksxTabTeam,
			TabTeachers tabTeachers, TabStudents tabStudents,
			String FProjectName, String FProjectCategory,
			String FProjectDescription, String FResult) {
		this.bksxTabTeam = bksxTabTeam;
		this.tabTeachers = tabTeachers;
		this.tabStudents = tabStudents;
		this.FProjectName = FProjectName;
		this.FProjectCategory = FProjectCategory;
		this.FProjectDescription = FProjectDescription;
		this.FResult = FResult;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BksxTabTeam getBksxTabTeam() {
		return this.bksxTabTeam;
	}

	public void setBksxTabTeam(BksxTabTeam bksxTabTeam) {
		this.bksxTabTeam = bksxTabTeam;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
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

	public String getFResult() {
		return this.FResult;
	}

	public void setFResult(String FResult) {
		this.FResult = FResult;
	}

}