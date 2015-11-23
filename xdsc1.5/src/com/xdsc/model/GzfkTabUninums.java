package com.xdsc.model;

import java.util.Date;

/**
 * GzfkTabUninums entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GzfkTabUninums implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private GzfkTabStudyuniversity gzfkTabStudyuniversity;
	private Date FUniYear;
	private Integer FUniNum;

	// Constructors

	/** default constructor */
	public GzfkTabUninums() {
	}

	/** full constructor */
	public GzfkTabUninums(GzfkTabStudyuniversity gzfkTabStudyuniversity,
			Date FUniYear, Integer FUniNum) {
		this.gzfkTabStudyuniversity = gzfkTabStudyuniversity;
		this.FUniYear = FUniYear;
		this.FUniNum = FUniNum;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public GzfkTabStudyuniversity getGzfkTabStudyuniversity() {
		return this.gzfkTabStudyuniversity;
	}

	public void setGzfkTabStudyuniversity(
			GzfkTabStudyuniversity gzfkTabStudyuniversity) {
		this.gzfkTabStudyuniversity = gzfkTabStudyuniversity;
	}

	public Date getFUniYear() {
		return this.FUniYear;
	}

	public void setFUniYear(Date FUniYear) {
		this.FUniYear = FUniYear;
	}

	public Integer getFUniNum() {
		return this.FUniNum;
	}

	public void setFUniNum(Integer FUniNum) {
		this.FUniNum = FUniNum;
	}

}