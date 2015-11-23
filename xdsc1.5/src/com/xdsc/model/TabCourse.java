package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabCourse entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabCourse implements java.io.Serializable {

	// Fields

	private String FCourseNumber;
	private String FCourseName;
	private Double FCourseScore;
	private String FCourseXueShi;
	private String FRemark;
	private Set jfptTabExaminations = new HashSet(0);
	private Set sjjxTabAttendances = new HashSet(0);
	private Set jfptTabChooseassociates = new HashSet(0);
	private Set jfptTabHomeuploads = new HashSet(0);
	private Set xsglTabKaoqins = new HashSet(0);
	private Set jfptTabStudentassociates = new HashSet(0);
	private Set sjjxTabCourselabs = new HashSet(0);
	private Set xsglTabKaoqingathers = new HashSet(0);
	private Set jfptTabTeacherassociates = new HashSet(0);
	private Set jfptTabCourseaskquestions = new HashSet(0);
	private Set jfptTabAssistantapplies = new HashSet(0);
	private Set jfptTabUsualscores = new HashSet(0);
	private Set jfptTabHomenotices = new HashSet(0);
	private Set jfptTabUploadfiles = new HashSet(0);
	private Set tabCoursetypes = new HashSet(0);
	private Set sjjxTabTests = new HashSet(0);
	private Set jfptTabCoursenotices = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabCourse() {
	}

	/** full constructor */
	public TabCourse(String FCourseName, Double FCourseScore,
			String FCourseXueShi, String FRemark, Set jfptTabExaminations,
			Set sjjxTabAttendances, Set jfptTabChooseassociates,
			Set jfptTabHomeuploads, Set xsglTabKaoqins,
			Set jfptTabStudentassociates, Set sjjxTabCourselabs,
			Set xsglTabKaoqingathers, Set jfptTabTeacherassociates,
			Set jfptTabCourseaskquestions, Set jfptTabAssistantapplies,
			Set jfptTabUsualscores, Set jfptTabHomenotices,
			Set jfptTabUploadfiles, Set tabCoursetypes, Set sjjxTabTests,
			Set jfptTabCoursenotices) {
		this.FCourseName = FCourseName;
		this.FCourseScore = FCourseScore;
		this.FCourseXueShi = FCourseXueShi;
		this.FRemark = FRemark;
		this.jfptTabExaminations = jfptTabExaminations;
		this.sjjxTabAttendances = sjjxTabAttendances;
		this.jfptTabChooseassociates = jfptTabChooseassociates;
		this.jfptTabHomeuploads = jfptTabHomeuploads;
		this.xsglTabKaoqins = xsglTabKaoqins;
		this.jfptTabStudentassociates = jfptTabStudentassociates;
		this.sjjxTabCourselabs = sjjxTabCourselabs;
		this.xsglTabKaoqingathers = xsglTabKaoqingathers;
		this.jfptTabTeacherassociates = jfptTabTeacherassociates;
		this.jfptTabCourseaskquestions = jfptTabCourseaskquestions;
		this.jfptTabAssistantapplies = jfptTabAssistantapplies;
		this.jfptTabUsualscores = jfptTabUsualscores;
		this.jfptTabHomenotices = jfptTabHomenotices;
		this.jfptTabUploadfiles = jfptTabUploadfiles;
		this.tabCoursetypes = tabCoursetypes;
		this.sjjxTabTests = sjjxTabTests;
		this.jfptTabCoursenotices = jfptTabCoursenotices;
	}

	// Property accessors

	public String getFCourseNumber() {
		return this.FCourseNumber;
	}

	public void setFCourseNumber(String FCourseNumber) {
		this.FCourseNumber = FCourseNumber;
	}

	public String getFCourseName() {
		return this.FCourseName;
	}

	public void setFCourseName(String FCourseName) {
		this.FCourseName = FCourseName;
	}

	public Double getFCourseScore() {
		return this.FCourseScore;
	}

	public void setFCourseScore(Double FCourseScore) {
		this.FCourseScore = FCourseScore;
	}

	public String getFCourseXueShi() {
		return this.FCourseXueShi;
	}

	public void setFCourseXueShi(String FCourseXueShi) {
		this.FCourseXueShi = FCourseXueShi;
	}

	public String getFRemark() {
		return this.FRemark;
	}

	public void setFRemark(String FRemark) {
		this.FRemark = FRemark;
	}

	public Set getJfptTabExaminations() {
		return this.jfptTabExaminations;
	}

	public void setJfptTabExaminations(Set jfptTabExaminations) {
		this.jfptTabExaminations = jfptTabExaminations;
	}

	public Set getSjjxTabAttendances() {
		return this.sjjxTabAttendances;
	}

	public void setSjjxTabAttendances(Set sjjxTabAttendances) {
		this.sjjxTabAttendances = sjjxTabAttendances;
	}

	public Set getJfptTabChooseassociates() {
		return this.jfptTabChooseassociates;
	}

	public void setJfptTabChooseassociates(Set jfptTabChooseassociates) {
		this.jfptTabChooseassociates = jfptTabChooseassociates;
	}

	public Set getJfptTabHomeuploads() {
		return this.jfptTabHomeuploads;
	}

	public void setJfptTabHomeuploads(Set jfptTabHomeuploads) {
		this.jfptTabHomeuploads = jfptTabHomeuploads;
	}

	public Set getXsglTabKaoqins() {
		return this.xsglTabKaoqins;
	}

	public void setXsglTabKaoqins(Set xsglTabKaoqins) {
		this.xsglTabKaoqins = xsglTabKaoqins;
	}

	public Set getJfptTabStudentassociates() {
		return this.jfptTabStudentassociates;
	}

	public void setJfptTabStudentassociates(Set jfptTabStudentassociates) {
		this.jfptTabStudentassociates = jfptTabStudentassociates;
	}

	public Set getSjjxTabCourselabs() {
		return this.sjjxTabCourselabs;
	}

	public void setSjjxTabCourselabs(Set sjjxTabCourselabs) {
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

	public Set getXsglTabKaoqingathers() {
		return this.xsglTabKaoqingathers;
	}

	public void setXsglTabKaoqingathers(Set xsglTabKaoqingathers) {
		this.xsglTabKaoqingathers = xsglTabKaoqingathers;
	}

	public Set getJfptTabTeacherassociates() {
		return this.jfptTabTeacherassociates;
	}

	public void setJfptTabTeacherassociates(Set jfptTabTeacherassociates) {
		this.jfptTabTeacherassociates = jfptTabTeacherassociates;
	}

	public Set getJfptTabCourseaskquestions() {
		return this.jfptTabCourseaskquestions;
	}

	public void setJfptTabCourseaskquestions(Set jfptTabCourseaskquestions) {
		this.jfptTabCourseaskquestions = jfptTabCourseaskquestions;
	}

	public Set getJfptTabAssistantapplies() {
		return this.jfptTabAssistantapplies;
	}

	public void setJfptTabAssistantapplies(Set jfptTabAssistantapplies) {
		this.jfptTabAssistantapplies = jfptTabAssistantapplies;
	}

	public Set getJfptTabUsualscores() {
		return this.jfptTabUsualscores;
	}

	public void setJfptTabUsualscores(Set jfptTabUsualscores) {
		this.jfptTabUsualscores = jfptTabUsualscores;
	}

	public Set getJfptTabHomenotices() {
		return this.jfptTabHomenotices;
	}

	public void setJfptTabHomenotices(Set jfptTabHomenotices) {
		this.jfptTabHomenotices = jfptTabHomenotices;
	}

	public Set getJfptTabUploadfiles() {
		return this.jfptTabUploadfiles;
	}

	public void setJfptTabUploadfiles(Set jfptTabUploadfiles) {
		this.jfptTabUploadfiles = jfptTabUploadfiles;
	}

	public Set getTabCoursetypes() {
		return this.tabCoursetypes;
	}

	public void setTabCoursetypes(Set tabCoursetypes) {
		this.tabCoursetypes = tabCoursetypes;
	}

	public Set getSjjxTabTests() {
		return this.sjjxTabTests;
	}

	public void setSjjxTabTests(Set sjjxTabTests) {
		this.sjjxTabTests = sjjxTabTests;
	}

	public Set getJfptTabCoursenotices() {
		return this.jfptTabCoursenotices;
	}

	public void setJfptTabCoursenotices(Set jfptTabCoursenotices) {
		this.jfptTabCoursenotices = jfptTabCoursenotices;
	}

}