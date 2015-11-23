package com.xdsc.model;

/**
 * UserInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private String infoUsername;
	private String infoRealname;
	private String infoClass;
	private Integer infoAge;
	private String infoSex;
	private String infoNotes;
	private String infoPhoto;
	private Integer infoNumber;
	private String infoPresent;
	private String infoProperty;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String infoUsername, String infoRealname, String infoClass,
			Integer infoAge, String infoSex, String infoNotes,
			String infoPhoto, Integer infoNumber, String infoPresent,
			String infoProperty) {
		this.infoUsername = infoUsername;
		this.infoRealname = infoRealname;
		this.infoClass = infoClass;
		this.infoAge = infoAge;
		this.infoSex = infoSex;
		this.infoNotes = infoNotes;
		this.infoPhoto = infoPhoto;
		this.infoNumber = infoNumber;
		this.infoPresent = infoPresent;
		this.infoProperty = infoProperty;
	}

	// Property accessors

	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoUsername() {
		return this.infoUsername;
	}

	public void setInfoUsername(String infoUsername) {
		this.infoUsername = infoUsername;
	}

	public String getInfoRealname() {
		return this.infoRealname;
	}

	public void setInfoRealname(String infoRealname) {
		this.infoRealname = infoRealname;
	}

	public String getInfoClass() {
		return this.infoClass;
	}

	public void setInfoClass(String infoClass) {
		this.infoClass = infoClass;
	}

	public Integer getInfoAge() {
		return this.infoAge;
	}

	public void setInfoAge(Integer infoAge) {
		this.infoAge = infoAge;
	}

	public String getInfoSex() {
		return this.infoSex;
	}

	public void setInfoSex(String infoSex) {
		this.infoSex = infoSex;
	}

	public String getInfoNotes() {
		return this.infoNotes;
	}

	public void setInfoNotes(String infoNotes) {
		this.infoNotes = infoNotes;
	}

	public String getInfoPhoto() {
		return this.infoPhoto;
	}

	public void setInfoPhoto(String infoPhoto) {
		this.infoPhoto = infoPhoto;
	}

	public Integer getInfoNumber() {
		return this.infoNumber;
	}

	public void setInfoNumber(Integer infoNumber) {
		this.infoNumber = infoNumber;
	}

	public String getInfoPresent() {
		return this.infoPresent;
	}

	public void setInfoPresent(String infoPresent) {
		this.infoPresent = infoPresent;
	}

	public String getInfoProperty() {
		return this.infoProperty;
	}

	public void setInfoProperty(String infoProperty) {
		this.infoProperty = infoProperty;
	}

}