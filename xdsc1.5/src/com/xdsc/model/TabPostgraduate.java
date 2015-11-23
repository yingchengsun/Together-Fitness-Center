package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabPostgraduate entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabPostgraduate implements java.io.Serializable {

	// Fields

	private String FStudentNumber;
	private TabCompany tabCompany;
	private TabTeachers tabTeachers;
	private TabStudents tabStudents;
	private String FStudentExSchool;
	private String FStudentEscore;
	private String FStudentErank;
	private String FType;
	private String FIsFirstChoice;
	private String FThesisIsSubmit;
	private String FOpenThesisIsSubmit;
	private String FMiddleThesIsSubmit;
	private Set yjssxTabSubmitthesises = new HashSet(0);
	private Set yjssxTabTutorselects = new HashSet(0);
	private Set yjssxTabTutorselectdispachs = new HashSet(0);
	private Set yjssxTabReturnthesises = new HashSet(0);
	private Set yjssxTabResumes = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabPostgraduate() {
	}

	/** minimal constructor */
	public TabPostgraduate(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	/** full constructor */
	public TabPostgraduate(TabCompany tabCompany, TabTeachers tabTeachers,
			TabStudents tabStudents, String FStudentExSchool,
			String FStudentEscore, String FStudentErank, String FType,
			String FIsFirstChoice, String FThesisIsSubmit,
			String FOpenThesisIsSubmit, String FMiddleThesIsSubmit,
			Set yjssxTabSubmitthesises, Set yjssxTabTutorselects,
			Set yjssxTabTutorselectdispachs, Set yjssxTabReturnthesises,
			Set yjssxTabResumes) {
		this.tabCompany = tabCompany;
		this.tabTeachers = tabTeachers;
		this.tabStudents = tabStudents;
		this.FStudentExSchool = FStudentExSchool;
		this.FStudentEscore = FStudentEscore;
		this.FStudentErank = FStudentErank;
		this.FType = FType;
		this.FIsFirstChoice = FIsFirstChoice;
		this.FThesisIsSubmit = FThesisIsSubmit;
		this.FOpenThesisIsSubmit = FOpenThesisIsSubmit;
		this.FMiddleThesIsSubmit = FMiddleThesIsSubmit;
		this.yjssxTabSubmitthesises = yjssxTabSubmitthesises;
		this.yjssxTabTutorselects = yjssxTabTutorselects;
		this.yjssxTabTutorselectdispachs = yjssxTabTutorselectdispachs;
		this.yjssxTabReturnthesises = yjssxTabReturnthesises;
		this.yjssxTabResumes = yjssxTabResumes;
	}

	// Property accessors

	public String getFStudentNumber() {
		return this.FStudentNumber;
	}

	public void setFStudentNumber(String FStudentNumber) {
		this.FStudentNumber = FStudentNumber;
	}

	public TabCompany getTabCompany() {
		return this.tabCompany;
	}

	public void setTabCompany(TabCompany tabCompany) {
		this.tabCompany = tabCompany;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFStudentExSchool() {
		return this.FStudentExSchool;
	}

	public void setFStudentExSchool(String FStudentExSchool) {
		this.FStudentExSchool = FStudentExSchool;
	}

	public String getFStudentEscore() {
		return this.FStudentEscore;
	}

	public void setFStudentEscore(String FStudentEscore) {
		this.FStudentEscore = FStudentEscore;
	}

	public String getFStudentErank() {
		return this.FStudentErank;
	}

	public void setFStudentErank(String FStudentErank) {
		this.FStudentErank = FStudentErank;
	}

	public String getFType() {
		return this.FType;
	}

	public void setFType(String FType) {
		this.FType = FType;
	}

	public String getFIsFirstChoice() {
		return this.FIsFirstChoice;
	}

	public void setFIsFirstChoice(String FIsFirstChoice) {
		this.FIsFirstChoice = FIsFirstChoice;
	}

	public String getFThesisIsSubmit() {
		return this.FThesisIsSubmit;
	}

	public void setFThesisIsSubmit(String FThesisIsSubmit) {
		this.FThesisIsSubmit = FThesisIsSubmit;
	}

	public String getFOpenThesisIsSubmit() {
		return this.FOpenThesisIsSubmit;
	}

	public void setFOpenThesisIsSubmit(String FOpenThesisIsSubmit) {
		this.FOpenThesisIsSubmit = FOpenThesisIsSubmit;
	}

	public String getFMiddleThesIsSubmit() {
		return this.FMiddleThesIsSubmit;
	}

	public void setFMiddleThesIsSubmit(String FMiddleThesIsSubmit) {
		this.FMiddleThesIsSubmit = FMiddleThesIsSubmit;
	}

	public Set getYjssxTabSubmitthesises() {
		return this.yjssxTabSubmitthesises;
	}

	public void setYjssxTabSubmitthesises(Set yjssxTabSubmitthesises) {
		this.yjssxTabSubmitthesises = yjssxTabSubmitthesises;
	}

	public Set getYjssxTabTutorselects() {
		return this.yjssxTabTutorselects;
	}

	public void setYjssxTabTutorselects(Set yjssxTabTutorselects) {
		this.yjssxTabTutorselects = yjssxTabTutorselects;
	}

	public Set getYjssxTabTutorselectdispachs() {
		return this.yjssxTabTutorselectdispachs;
	}

	public void setYjssxTabTutorselectdispachs(Set yjssxTabTutorselectdispachs) {
		this.yjssxTabTutorselectdispachs = yjssxTabTutorselectdispachs;
	}

	public Set getYjssxTabReturnthesises() {
		return this.yjssxTabReturnthesises;
	}

	public void setYjssxTabReturnthesises(Set yjssxTabReturnthesises) {
		this.yjssxTabReturnthesises = yjssxTabReturnthesises;
	}

	public Set getYjssxTabResumes() {
		return this.yjssxTabResumes;
	}

	public void setYjssxTabResumes(Set yjssxTabResumes) {
		this.yjssxTabResumes = yjssxTabResumes;
	}

}