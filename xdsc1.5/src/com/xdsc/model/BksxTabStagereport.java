package com.xdsc.model;

import java.util.Date;

/**
 * BksxTabStagereport entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabStagereport implements java.io.Serializable {

	// Fields

	private Integer FSid;
	private BksxTabProject bksxTabProject;
	private String FReportAuthor;
	private String FReportMembers;
	private String FReportStage;
	private Date FStartTime;
	private Date FFinishTime;
	private String FStageGoal;
	private String FCompletedWork;
	private String FPercentage;
	private String FProblem;
	private String FSolution;
	private String FTeacherAdvice;
	private String FManagerAdvice;
	private String FAcquisition;

	// Constructors

	/** default constructor */
	public BksxTabStagereport() {
	}

	/** full constructor */
	public BksxTabStagereport(BksxTabProject bksxTabProject,
			String FReportAuthor, String FReportMembers, String FReportStage,
			Date FStartTime, Date FFinishTime, String FStageGoal,
			String FCompletedWork, String FPercentage, String FProblem,
			String FSolution, String FTeacherAdvice, String FManagerAdvice,
			String FAcquisition) {
		this.bksxTabProject = bksxTabProject;
		this.FReportAuthor = FReportAuthor;
		this.FReportMembers = FReportMembers;
		this.FReportStage = FReportStage;
		this.FStartTime = FStartTime;
		this.FFinishTime = FFinishTime;
		this.FStageGoal = FStageGoal;
		this.FCompletedWork = FCompletedWork;
		this.FPercentage = FPercentage;
		this.FProblem = FProblem;
		this.FSolution = FSolution;
		this.FTeacherAdvice = FTeacherAdvice;
		this.FManagerAdvice = FManagerAdvice;
		this.FAcquisition = FAcquisition;
	}

	// Property accessors

	public Integer getFSid() {
		return this.FSid;
	}

	public void setFSid(Integer FSid) {
		this.FSid = FSid;
	}

	public BksxTabProject getBksxTabProject() {
		return this.bksxTabProject;
	}

	public void setBksxTabProject(BksxTabProject bksxTabProject) {
		this.bksxTabProject = bksxTabProject;
	}

	public String getFReportAuthor() {
		return this.FReportAuthor;
	}

	public void setFReportAuthor(String FReportAuthor) {
		this.FReportAuthor = FReportAuthor;
	}

	public String getFReportMembers() {
		return this.FReportMembers;
	}

	public void setFReportMembers(String FReportMembers) {
		this.FReportMembers = FReportMembers;
	}

	public String getFReportStage() {
		return this.FReportStage;
	}

	public void setFReportStage(String FReportStage) {
		this.FReportStage = FReportStage;
	}

	public Date getFStartTime() {
		return this.FStartTime;
	}

	public void setFStartTime(Date FStartTime) {
		this.FStartTime = FStartTime;
	}

	public Date getFFinishTime() {
		return this.FFinishTime;
	}

	public void setFFinishTime(Date FFinishTime) {
		this.FFinishTime = FFinishTime;
	}

	public String getFStageGoal() {
		return this.FStageGoal;
	}

	public void setFStageGoal(String FStageGoal) {
		this.FStageGoal = FStageGoal;
	}

	public String getFCompletedWork() {
		return this.FCompletedWork;
	}

	public void setFCompletedWork(String FCompletedWork) {
		this.FCompletedWork = FCompletedWork;
	}

	public String getFPercentage() {
		return this.FPercentage;
	}

	public void setFPercentage(String FPercentage) {
		this.FPercentage = FPercentage;
	}

	public String getFProblem() {
		return this.FProblem;
	}

	public void setFProblem(String FProblem) {
		this.FProblem = FProblem;
	}

	public String getFSolution() {
		return this.FSolution;
	}

	public void setFSolution(String FSolution) {
		this.FSolution = FSolution;
	}

	public String getFTeacherAdvice() {
		return this.FTeacherAdvice;
	}

	public void setFTeacherAdvice(String FTeacherAdvice) {
		this.FTeacherAdvice = FTeacherAdvice;
	}

	public String getFManagerAdvice() {
		return this.FManagerAdvice;
	}

	public void setFManagerAdvice(String FManagerAdvice) {
		this.FManagerAdvice = FManagerAdvice;
	}

	public String getFAcquisition() {
		return this.FAcquisition;
	}

	public void setFAcquisition(String FAcquisition) {
		this.FAcquisition = FAcquisition;
	}

}