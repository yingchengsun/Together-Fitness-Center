package com.xdsc.model;

/**
 * WsbmTabExamresult entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabExamresult implements java.io.Serializable {

	// Fields

	private Integer FId;
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	private WsbmTabExamsubject wsbmTabExamsubject;
	private Integer FScore;

	// Constructors

	/** default constructor */
	public WsbmTabExamresult() {
	}

	/** full constructor */
	public WsbmTabExamresult(WsbmTabRegapplicant wsbmTabRegapplicant,
			WsbmTabExamsubject wsbmTabExamsubject, Integer FScore) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
		this.wsbmTabExamsubject = wsbmTabExamsubject;
		this.FScore = FScore;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return this.wsbmTabRegapplicant;
	}

	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public WsbmTabExamsubject getWsbmTabExamsubject() {
		return this.wsbmTabExamsubject;
	}

	public void setWsbmTabExamsubject(WsbmTabExamsubject wsbmTabExamsubject) {
		this.wsbmTabExamsubject = wsbmTabExamsubject;
	}

	public Integer getFScore() {
		return this.FScore;
	}

	public void setFScore(Integer FScore) {
		this.FScore = FScore;
	}

}