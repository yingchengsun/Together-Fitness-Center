package com.xdsc.model;

import java.util.Date;

/**
 * BksxTabGanttplan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabGanttplan implements java.io.Serializable {

	// Fields

	private Integer FTaskId;
	private BksxTabProject bksxTabProject;
	private TabStudents tabStudents;
	private String FTaskName;
	private Date FStartDate;
	private Date FFinishDate;
	private Double FCompletePercent;

	// Constructors

	/** default constructor */
	public BksxTabGanttplan() {
	}

	/** full constructor */
	public BksxTabGanttplan(BksxTabProject bksxTabProject,
			TabStudents tabStudents, String FTaskName, Date FStartDate,
			Date FFinishDate, Double FCompletePercent) {
		this.bksxTabProject = bksxTabProject;
		this.tabStudents = tabStudents;
		this.FTaskName = FTaskName;
		this.FStartDate = FStartDate;
		this.FFinishDate = FFinishDate;
		this.FCompletePercent = FCompletePercent;
	}

	// Property accessors

	public Integer getFTaskId() {
		return this.FTaskId;
	}

	public void setFTaskId(Integer FTaskId) {
		this.FTaskId = FTaskId;
	}

	public BksxTabProject getBksxTabProject() {
		return this.bksxTabProject;
	}

	public void setBksxTabProject(BksxTabProject bksxTabProject) {
		this.bksxTabProject = bksxTabProject;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFTaskName() {
		return this.FTaskName;
	}

	public void setFTaskName(String FTaskName) {
		this.FTaskName = FTaskName;
	}

	public Date getFStartDate() {
		return this.FStartDate;
	}

	public void setFStartDate(Date FStartDate) {
		this.FStartDate = FStartDate;
	}

	public Date getFFinishDate() {
		return this.FFinishDate;
	}

	public void setFFinishDate(Date FFinishDate) {
		this.FFinishDate = FFinishDate;
	}

	public Double getFCompletePercent() {
		return this.FCompletePercent;
	}

	public void setFCompletePercent(Double FCompletePercent) {
		this.FCompletePercent = FCompletePercent;
	}

}