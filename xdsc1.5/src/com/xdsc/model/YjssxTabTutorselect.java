package com.xdsc.model;

/**
 * YjssxTabTutorselect entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class YjssxTabTutorselect implements java.io.Serializable {

	// Fields

	private String FStudentNumber;
	private TabTeachers tabTeachersByFSecondWish;
	private TabTeachers tabTeachersByFThirdWish;
	private TabTeachers tabTeachersByFFirstWish;
	private TabPostgraduate tabPostgraduate;
	private String FComment;

	// Constructors

	/** default constructor */
	public YjssxTabTutorselect() {
	}

	/** minimal constructor */
	public YjssxTabTutorselect(TabPostgraduate tabPostgraduate) {
		this.tabPostgraduate = tabPostgraduate;
	}

	/** full constructor */
	public YjssxTabTutorselect(TabTeachers tabTeachersByFSecondWish,
			TabTeachers tabTeachersByFThirdWish,
			TabTeachers tabTeachersByFFirstWish,
			TabPostgraduate tabPostgraduate, String FComment) {
		this.tabTeachersByFSecondWish = tabTeachersByFSecondWish;
		this.tabTeachersByFThirdWish = tabTeachersByFThirdWish;
		this.tabTeachersByFFirstWish = tabTeachersByFFirstWish;
		this.tabPostgraduate = tabPostgraduate;
		this.FComment = FComment;
	}

	// Property accessors

	public String getFStudentNumber() {
		return this.FStudentNumber;
	}

	public void setFStudentNumber(String FStudentNumber) {
		this.FStudentNumber = FStudentNumber;
	}

	public TabTeachers getTabTeachersByFSecondWish() {
		return this.tabTeachersByFSecondWish;
	}

	public void setTabTeachersByFSecondWish(TabTeachers tabTeachersByFSecondWish) {
		this.tabTeachersByFSecondWish = tabTeachersByFSecondWish;
	}

	public TabTeachers getTabTeachersByFThirdWish() {
		return this.tabTeachersByFThirdWish;
	}

	public void setTabTeachersByFThirdWish(TabTeachers tabTeachersByFThirdWish) {
		this.tabTeachersByFThirdWish = tabTeachersByFThirdWish;
	}

	public TabTeachers getTabTeachersByFFirstWish() {
		return this.tabTeachersByFFirstWish;
	}

	public void setTabTeachersByFFirstWish(TabTeachers tabTeachersByFFirstWish) {
		this.tabTeachersByFFirstWish = tabTeachersByFFirstWish;
	}

	public TabPostgraduate getTabPostgraduate() {
		return this.tabPostgraduate;
	}

	public void setTabPostgraduate(TabPostgraduate tabPostgraduate) {
		this.tabPostgraduate = tabPostgraduate;
	}

	public String getFComment() {
		return this.FComment;
	}

	public void setFComment(String FComment) {
		this.FComment = FComment;
	}

}