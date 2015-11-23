package com.xdsc.model;

/**
 * GzfkTabWorkstudent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GzfkTabWorkstudent implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabCompany tabCompany;
	private TabStudents tabStudents;
	private Integer FSalary;
	private String FPosition;
	private String FEmail;
	private String FWorkCity;
	private String FWorkAdd;

	// Constructors

	/** default constructor */
	public GzfkTabWorkstudent() {
	}

	/** full constructor */
	public GzfkTabWorkstudent(TabCompany tabCompany, TabStudents tabStudents,
			Integer FSalary, String FPosition, String FEmail, String FWorkCity,
			String FWorkAdd) {
		this.tabCompany = tabCompany;
		this.tabStudents = tabStudents;
		this.FSalary = FSalary;
		this.FPosition = FPosition;
		this.FEmail = FEmail;
		this.FWorkCity = FWorkCity;
		this.FWorkAdd = FWorkAdd;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public TabCompany getTabCompany() {
		return this.tabCompany;
	}

	public void setTabCompany(TabCompany tabCompany) {
		this.tabCompany = tabCompany;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public Integer getFSalary() {
		return this.FSalary;
	}

	public void setFSalary(Integer FSalary) {
		this.FSalary = FSalary;
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

	public String getFWorkCity() {
		return this.FWorkCity;
	}

	public void setFWorkCity(String FWorkCity) {
		this.FWorkCity = FWorkCity;
	}

	public String getFWorkAdd() {
		return this.FWorkAdd;
	}

	public void setFWorkAdd(String FWorkAdd) {
		this.FWorkAdd = FWorkAdd;
	}

}