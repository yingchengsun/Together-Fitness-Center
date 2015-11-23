package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * WsbmTabInstruction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabInstruction implements java.io.Serializable {

	// Fields

	private Integer FStageNum;
	private String FStageAbout;
	private Set wsbmTabProgresses = new HashSet(0);

	// Constructors

	/** default constructor */
	public WsbmTabInstruction() {
	}

	/** full constructor */
	public WsbmTabInstruction(String FStageAbout, Set wsbmTabProgresses) {
		this.FStageAbout = FStageAbout;
		this.wsbmTabProgresses = wsbmTabProgresses;
	}

	// Property accessors

	public Integer getFStageNum() {
		return this.FStageNum;
	}

	public void setFStageNum(Integer FStageNum) {
		this.FStageNum = FStageNum;
	}

	public String getFStageAbout() {
		return this.FStageAbout;
	}

	public void setFStageAbout(String FStageAbout) {
		this.FStageAbout = FStageAbout;
	}

	public Set getWsbmTabProgresses() {
		return this.wsbmTabProgresses;
	}

	public void setWsbmTabProgresses(Set wsbmTabProgresses) {
		this.wsbmTabProgresses = wsbmTabProgresses;
	}

}