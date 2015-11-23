package com.xdsc.model;

/**
 * XsglTabXiaoyou entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabXiaoyou implements java.io.Serializable {

	// Fields

	private String FXiaoYouId;
	private MhqxTabUser mhqxTabUser;
	private String FXiaoYouName;
	private String FXiaoYouSex;
	private String FWorkPlace;
	private String FHistory;
	private String FPosition;
	private String FEmail;
	private String FRegion;
	private String FGraduateYear;

	// Constructors

	/** default constructor */
	public XsglTabXiaoyou() {
	}

	/** minimal constructor */
	public XsglTabXiaoyou(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public XsglTabXiaoyou(MhqxTabUser mhqxTabUser, String FXiaoYouName,
			String FXiaoYouSex, String FWorkPlace, String FHistory,
			String FPosition, String FEmail, String FRegion,
			String FGraduateYear) {
		this.mhqxTabUser = mhqxTabUser;
		this.FXiaoYouName = FXiaoYouName;
		this.FXiaoYouSex = FXiaoYouSex;
		this.FWorkPlace = FWorkPlace;
		this.FHistory = FHistory;
		this.FPosition = FPosition;
		this.FEmail = FEmail;
		this.FRegion = FRegion;
		this.FGraduateYear = FGraduateYear;
	}

	// Property accessors

	public String getFXiaoYouId() {
		return this.FXiaoYouId;
	}

	public void setFXiaoYouId(String FXiaoYouId) {
		this.FXiaoYouId = FXiaoYouId;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFXiaoYouName() {
		return this.FXiaoYouName;
	}

	public void setFXiaoYouName(String FXiaoYouName) {
		this.FXiaoYouName = FXiaoYouName;
	}

	public String getFXiaoYouSex() {
		return this.FXiaoYouSex;
	}

	public void setFXiaoYouSex(String FXiaoYouSex) {
		this.FXiaoYouSex = FXiaoYouSex;
	}

	public String getFWorkPlace() {
		return this.FWorkPlace;
	}

	public void setFWorkPlace(String FWorkPlace) {
		this.FWorkPlace = FWorkPlace;
	}

	public String getFHistory() {
		return this.FHistory;
	}

	public void setFHistory(String FHistory) {
		this.FHistory = FHistory;
	}

	public String getFPosition() {
		return this.FPosition;
	}

	public void setFPosition(String FPosition) {
		this.FPosition = FPosition;
	}

	public String getFEmail() {
		return this.FEmail;
	}

	public void setFEmail(String FEmail) {
		this.FEmail = FEmail;
	}

	public String getFRegion() {
		return this.FRegion;
	}

	public void setFRegion(String FRegion) {
		this.FRegion = FRegion;
	}

	public String getFGraduateYear() {
		return this.FGraduateYear;
	}

	public void setFGraduateYear(String FGraduateYear) {
		this.FGraduateYear = FGraduateYear;
	}

}