package com.xdsc.model;

/**
 * GzfkTabKaoyanstudent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GzfkTabKaoyanstudent implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private GzfkTabStudyuniversity gzfkTabStudyuniversity;
	private TabStudents tabStudents;
	private String FKaoyanMajor;
	private String FEmail;
	private String FStudentDegre;
	private String FWorkAdd;

	// Constructors

	/** default constructor */
	public GzfkTabKaoyanstudent() {
	}

	/** full constructor */
	public GzfkTabKaoyanstudent(GzfkTabStudyuniversity gzfkTabStudyuniversity,
			TabStudents tabStudents, String FKaoyanMajor, String FEmail,
			String FStudentDegre, String FWorkAdd) {
		this.gzfkTabStudyuniversity = gzfkTabStudyuniversity;
		this.tabStudents = tabStudents;
		this.FKaoyanMajor = FKaoyanMajor;
		this.FEmail = FEmail;
		this.FStudentDegre = FStudentDegre;
		this.FWorkAdd = FWorkAdd;
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

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFKaoyanMajor() {
		return this.FKaoyanMajor;
	}

	public void setFKaoyanMajor(String FKaoyanMajor) {
		this.FKaoyanMajor = FKaoyanMajor;
	}

	public String getFEmail() {
		return this.FEmail;
	}

	public void setFEmail(String FEmail) {
		this.FEmail = FEmail;
	}

	public String getFStudentDegre() {
		return this.FStudentDegre;
	}

	public void setFStudentDegre(String FStudentDegre) {
		this.FStudentDegre = FStudentDegre;
	}

	public String getFWorkAdd() {
		return this.FWorkAdd;
	}

	public void setFWorkAdd(String FWorkAdd) {
		this.FWorkAdd = FWorkAdd;
	}

}