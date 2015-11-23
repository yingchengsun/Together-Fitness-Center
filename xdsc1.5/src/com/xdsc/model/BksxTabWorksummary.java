package com.xdsc.model;

import java.util.Date;

/**
 * BksxTabWorksummary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabWorksummary implements java.io.Serializable {

	// Fields

	private Integer FWid;
	private BksxTabSubstugui bksxTabSubstugui;
	private String FSummaryStage;
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
	public BksxTabWorksummary() {
	}

	/** full constructor */
	public BksxTabWorksummary(BksxTabSubstugui bksxTabSubstugui,
			String FSummaryStage, Date FStartTime, Date FFinishTime,
			String FStageGoal, String FCompletedWork, String FPercentage,
			String FProblem, String FSolution, String FTeacherAdvice,
			String FManagerAdvice, String FAcquisition) {
		this.bksxTabSubstugui = bksxTabSubstugui;
		this.FSummaryStage = FSummaryStage;
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

	public Integer getFWid() {
		return this.FWid;
	}

	public void setFWid(Integer FWid) {
		this.FWid = FWid;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return this.bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public String getFSummaryStage() {
		return this.FSummaryStage;
	}

	public void setFSummaryStage(String FSummaryStage) {
		this.FSummaryStage = FSummaryStage;
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