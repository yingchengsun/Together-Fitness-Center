package com.xdsc.model;

/**
 * BksxTabAchievement entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabAchievement implements java.io.Serializable {

	// Fields

	private Integer FSubStuGuiId;
	private BksxTabSubstugui bksxTabSubstugui;
	private Float FFirstScore;
	private Float FSecondScore;
	private Float FThirdScore;
	private Float FWorksScore;
	private String FFinalScore;

	// Constructors

	/** default constructor */
	public BksxTabAchievement() {
	}

	/** minimal constructor */
	public BksxTabAchievement(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	/** full constructor */
	public BksxTabAchievement(BksxTabSubstugui bksxTabSubstugui,
			Float FFirstScore, Float FSecondScore, Float FThirdScore,
			Float FWorksScore, String FFinalScore) {
		this.bksxTabSubstugui = bksxTabSubstugui;
		this.FFirstScore = FFirstScore;
		this.FSecondScore = FSecondScore;
		this.FThirdScore = FThirdScore;
		this.FWorksScore = FWorksScore;
		this.FFinalScore = FFinalScore;
	}

	// Property accessors
	public BksxTabAchievement(Integer subStuGuiId, Float firstScore,
			Float secondScore, Float thirdScore, Float worksScore,
			String finalScore) {
		this.FSubStuGuiId = subStuGuiId;
		this.FFirstScore = firstScore;
		this.FSecondScore = secondScore;
		this.FThirdScore = thirdScore;
		this.FWorksScore = worksScore;
		this.FFinalScore = finalScore;
	}

	public Integer getFSubStuGuiId() {
		return this.FSubStuGuiId;
	}

	public void setFSubStuGuiId(Integer FSubStuGuiId) {
		this.FSubStuGuiId = FSubStuGuiId;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return this.bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public Float getFFirstScore() {
		return this.FFirstScore;
	}

	public void setFFirstScore(Float FFirstScore) {
		this.FFirstScore = FFirstScore;
	}

	public Float getFSecondScore() {
		return this.FSecondScore;
	}

	public void setFSecondScore(Float FSecondScore) {
		this.FSecondScore = FSecondScore;
	}

	public Float getFThirdScore() {
		return this.FThirdScore;
	}

	public void setFThirdScore(Float FThirdScore) {
		this.FThirdScore = FThirdScore;
	}

	public Float getFWorksScore() {
		return this.FWorksScore;
	}

	public void setFWorksScore(Float FWorksScore) {
		this.FWorksScore = FWorksScore;
	}

	public String getFFinalScore() {
		return this.FFinalScore;
	}

	public void setFFinalScore(String FFinalScore) {
		this.FFinalScore = FFinalScore;
	}

}