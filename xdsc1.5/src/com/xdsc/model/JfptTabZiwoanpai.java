package com.xdsc.model;

import java.util.Date;

/**
 * JfptTabZiwoanpai entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabZiwoanpai implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabUser mhqxTabUser;
	private Date FDataTime;
	private String FBeiZhu;
	private String FTitle;

	// Constructors

	/** default constructor */
	public JfptTabZiwoanpai() {
	}

	/** full constructor */
	public JfptTabZiwoanpai(MhqxTabUser mhqxTabUser, Date FDataTime,
			String FBeiZhu, String FTitle) {
		this.mhqxTabUser = mhqxTabUser;
		this.FDataTime = FDataTime;
		this.FBeiZhu = FBeiZhu;
		this.FTitle = FTitle;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public Date getFDataTime() {
		return this.FDataTime;
	}

	public void setFDataTime(Date FDataTime) {
		this.FDataTime = FDataTime;
	}

	public String getFBeiZhu() {
		return this.FBeiZhu;
	}

	public void setFBeiZhu(String FBeiZhu) {
		this.FBeiZhu = FBeiZhu;
	}

	public String getFTitle() {
		return this.FTitle;
	}

	public void setFTitle(String FTitle) {
		this.FTitle = FTitle;
	}

}