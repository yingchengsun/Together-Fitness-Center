package com.xdsc.model;

/**
 * GzfkTabOtherstudent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GzfkTabOtherstudent implements java.io.Serializable {

	// Fields

	private Integer FOtherId;
	private TabStudents tabStudents;
	private String FEmail;
	private String FWorkAdd;
	private String FRecord;

	// Constructors

	/** default constructor */
	public GzfkTabOtherstudent() {
	}

	/** full constructor */
	public GzfkTabOtherstudent(TabStudents tabStudents, String FEmail,
			String FWorkAdd, String FRecord) {
		this.tabStudents = tabStudents;
		this.FEmail = FEmail;
		this.FWorkAdd = FWorkAdd;
		this.FRecord = FRecord;
	}

	// Property accessors

	public Integer getFOtherId() {
		return this.FOtherId;
	}

	public void setFOtherId(Integer FOtherId) {
		this.FOtherId = FOtherId;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFEmail() {
		return this.FEmail;
	}

	public void setFEmail(String FEmail) {
		this.FEmail = FEmail;
	}

	public String getFWorkAdd() {
		return this.FWorkAdd;
	}

	public void setFWorkAdd(String FWorkAdd) {
		this.FWorkAdd = FWorkAdd;
	}

	public String getFRecord() {
		return this.FRecord;
	}

	public void setFRecord(String FRecord) {
		this.FRecord = FRecord;
	}

}