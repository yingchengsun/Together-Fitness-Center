package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BksxTabTeam entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabTeam implements java.io.Serializable {

	// Fields

	private Integer FTeamId;
	private String FTeamName;
	private Integer FTeamMemberNum;
	private String FTeamDescription;
	private String FTeamCreator;
	private Date FTeamCreateDate;
	private Set bksxTabProjects = new HashSet(0);
	private Set bksxTabMembers = new HashSet(0);
	private Set bksxTabTeamapplies = new HashSet(0);
	private Set bksxTabProjectapplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public BksxTabTeam() {
	}

	/** full constructor */
	public BksxTabTeam(String FTeamName, Integer FTeamMemberNum,
			String FTeamDescription, String FTeamCreator, Date FTeamCreateDate,
			Set bksxTabProjects, Set bksxTabMembers, Set bksxTabTeamapplies,
			Set bksxTabProjectapplies) {
		this.FTeamName = FTeamName;
		this.FTeamMemberNum = FTeamMemberNum;
		this.FTeamDescription = FTeamDescription;
		this.FTeamCreator = FTeamCreator;
		this.FTeamCreateDate = FTeamCreateDate;
		this.bksxTabProjects = bksxTabProjects;
		this.bksxTabMembers = bksxTabMembers;
		this.bksxTabTeamapplies = bksxTabTeamapplies;
		this.bksxTabProjectapplies = bksxTabProjectapplies;
	}

	// Property accessors

	public Integer getFTeamId() {
		return this.FTeamId;
	}

	public void setFTeamId(Integer FTeamId) {
		this.FTeamId = FTeamId;
	}

	public String getFTeamName() {
		return this.FTeamName;
	}

	public void setFTeamName(String FTeamName) {
		this.FTeamName = FTeamName;
	}

	public Integer getFTeamMemberNum() {
		return this.FTeamMemberNum;
	}

	public void setFTeamMemberNum(Integer FTeamMemberNum) {
		this.FTeamMemberNum = FTeamMemberNum;
	}

	public String getFTeamDescription() {
		return this.FTeamDescription;
	}

	public void setFTeamDescription(String FTeamDescription) {
		this.FTeamDescription = FTeamDescription;
	}

	public String getFTeamCreator() {
		return this.FTeamCreator;
	}

	public void setFTeamCreator(String FTeamCreator) {
		this.FTeamCreator = FTeamCreator;
	}

	public Date getFTeamCreateDate() {
		return this.FTeamCreateDate;
	}

	public void setFTeamCreateDate(Date FTeamCreateDate) {
		this.FTeamCreateDate = FTeamCreateDate;
	}

	public Set getBksxTabProjects() {
		return this.bksxTabProjects;
	}

	public void setBksxTabProjects(Set bksxTabProjects) {
		this.bksxTabProjects = bksxTabProjects;
	}

	public Set getBksxTabMembers() {
		return this.bksxTabMembers;
	}

	public void setBksxTabMembers(Set bksxTabMembers) {
		this.bksxTabMembers = bksxTabMembers;
	}

	public Set getBksxTabTeamapplies() {
		return this.bksxTabTeamapplies;
	}

	public void setBksxTabTeamapplies(Set bksxTabTeamapplies) {
		this.bksxTabTeamapplies = bksxTabTeamapplies;
	}

	public Set getBksxTabProjectapplies() {
		return this.bksxTabProjectapplies;
	}

	public void setBksxTabProjectapplies(Set bksxTabProjectapplies) {
		this.bksxTabProjectapplies = bksxTabProjectapplies;
	}

}