package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * WsbmTabExamsubject entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabExamsubject implements java.io.Serializable {

	// Fields

	private Integer FSubjectNumber;
	private String FSubjectName;
	private String FSubjectTime;
	private String FSubjectAddress;
	private Set wsbmTabExamresults = new HashSet(0);

	// Constructors

	/** default constructor */
	public WsbmTabExamsubject() {
	}

	/** full constructor */
	public WsbmTabExamsubject(String FSubjectName, String FSubjectTime,
			String FSubjectAddress, Set wsbmTabExamresults) {
		this.FSubjectName = FSubjectName;
		this.FSubjectTime = FSubjectTime;
		this.FSubjectAddress = FSubjectAddress;
		this.wsbmTabExamresults = wsbmTabExamresults;
	}

	// Property accessors

	public Integer getFSubjectNumber() {
		return this.FSubjectNumber;
	}

	public void setFSubjectNumber(Integer FSubjectNumber) {
		this.FSubjectNumber = FSubjectNumber;
	}

	public String getFSubjectName() {
		return this.FSubjectName;
	}

	public void setFSubjectName(String FSubjectName) {
		this.FSubjectName = FSubjectName;
	}

	public String getFSubjectTime() {
		return this.FSubjectTime;
	}

	public void setFSubjectTime(String FSubjectTime) {
		this.FSubjectTime = FSubjectTime;
	}

	public String getFSubjectAddress() {
		return this.FSubjectAddress;
	}

	public void setFSubjectAddress(String FSubjectAddress) {
		this.FSubjectAddress = FSubjectAddress;
	}

	public Set getWsbmTabExamresults() {
		return this.wsbmTabExamresults;
	}

	public void setWsbmTabExamresults(Set wsbmTabExamresults) {
		this.wsbmTabExamresults = wsbmTabExamresults;
	}

}