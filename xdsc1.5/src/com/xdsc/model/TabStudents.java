package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TabStudents entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabStudents implements java.io.Serializable {

	// Fields

	private String FStudentNumber;
	private TabClasses tabClasses;
	private TabDirection tabDirection;
	private MhqxTabUser mhqxTabUser;
	private String FStudentName;
	private String FIsLocked;
	private String FStudentSex;
	private Date FStudentBirthday;
	private String FStudentIdCard;
	private String FStudentNation;
	private Date FStudentRegData;
	private String FStudentTel;
	private String FStudentEmail;
	private String FStudentPostcode;
	private String FStudentNativeplace;
	private String FHomeTel;
	private String FStudentAddress;
	private String FStudentPoliStatus;
	private String FStudentDormitory;
	private String FStudentMajor;
	private String FRewardPunish;
	private String FQuXiang;
	private String FCardNumber;
	private Set jfptTabStudentassociates = new HashSet(0);
	private Set xsglTabParties = new HashSet(0);
	private Set bksxTabSubstuguis = new HashSet(0);
	private Set sjjxTabTests = new HashSet(0);
	private Set jfptTabHomenoticetoreceives = new HashSet(0);
	private Set jfptTabUsualscores = new HashSet(0);
	private Set jfptTabHomeuploads = new HashSet(0);
	private Set xsglTabParentses = new HashSet(0);
	private Set bksxTabGanttplans = new HashSet(0);
	private Set tabUndergraduates = new HashSet(0);
	private Set sjjxTabUsualexperiments = new HashSet(0);
	private Set tabPostgraduates = new HashSet(0);
	private Set gzfkTabOtherstudents = new HashSet(0);
	private Set xsglTabJiangzhus = new HashSet(0);
	private Set jfptTabCourseaskquestions = new HashSet(0);
	private Set xsglTabStuorgadeparts = new HashSet(0);
	private Set gzfkTabKaoyanstudents = new HashSet(0);
	private Set bksxTabSubjectapplies = new HashSet(0);
	private Set bksxTabProjectapplies = new HashSet(0);
	private Set xsglTabKaoqins = new HashSet(0);
	private Set bksxTabTeamapplies = new HashSet(0);
	private Set jfptTabChooseassociates = new HashSet(0);
	private Set xsglTabJiaofeis = new HashSet(0);
	private Set sjjxTabAttendances = new HashSet(0);
	private Set bksxTabMembers = new HashSet(0);
	private Set gzfkTabWorkstudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabStudents() {
	}

	/** minimal constructor */
	public TabStudents(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public TabStudents(TabClasses tabClasses, TabDirection tabDirection,
			MhqxTabUser mhqxTabUser, String FStudentName, String FIsLocked,
			String FStudentSex, Date FStudentBirthday, String FStudentIdCard,
			String FStudentNation, Date FStudentRegData, String FStudentTel,
			String FStudentEmail, String FStudentPostcode,
			String FStudentNativeplace, String FHomeTel,
			String FStudentAddress, String FStudentPoliStatus,
			String FStudentDormitory, String FStudentMajor,
			String FRewardPunish, String FQuXiang, String FCardNumber,
			Set jfptTabStudentassociates, Set xsglTabParties,
			Set bksxTabSubstuguis, Set sjjxTabTests,
			Set jfptTabHomenoticetoreceives, Set jfptTabUsualscores,
			Set jfptTabHomeuploads, Set xsglTabParentses,
			Set bksxTabGanttplans, Set tabUndergraduates,
			Set sjjxTabUsualexperiments, Set tabPostgraduates,
			Set gzfkTabOtherstudents, Set xsglTabJiangzhus,
			Set jfptTabCourseaskquestions, Set xsglTabStuorgadeparts,
			Set gzfkTabKaoyanstudents, Set bksxTabSubjectapplies,
			Set bksxTabProjectapplies, Set xsglTabKaoqins,
			Set bksxTabTeamapplies, Set jfptTabChooseassociates,
			Set xsglTabJiaofeis, Set sjjxTabAttendances, Set bksxTabMembers,
			Set gzfkTabWorkstudents) {
		this.tabClasses = tabClasses;
		this.tabDirection = tabDirection;
		this.mhqxTabUser = mhqxTabUser;
		this.FStudentName = FStudentName;
		this.FIsLocked = FIsLocked;
		this.FStudentSex = FStudentSex;
		this.FStudentBirthday = FStudentBirthday;
		this.FStudentIdCard = FStudentIdCard;
		this.FStudentNation = FStudentNation;
		this.FStudentRegData = FStudentRegData;
		this.FStudentTel = FStudentTel;
		this.FStudentEmail = FStudentEmail;
		this.FStudentPostcode = FStudentPostcode;
		this.FStudentNativeplace = FStudentNativeplace;
		this.FHomeTel = FHomeTel;
		this.FStudentAddress = FStudentAddress;
		this.FStudentPoliStatus = FStudentPoliStatus;
		this.FStudentDormitory = FStudentDormitory;
		this.FStudentMajor = FStudentMajor;
		this.FRewardPunish = FRewardPunish;
		this.FQuXiang = FQuXiang;
		this.FCardNumber = FCardNumber;
		this.jfptTabStudentassociates = jfptTabStudentassociates;
		this.xsglTabParties = xsglTabParties;
		this.bksxTabSubstuguis = bksxTabSubstuguis;
		this.sjjxTabTests = sjjxTabTests;
		this.jfptTabHomenoticetoreceives = jfptTabHomenoticetoreceives;
		this.jfptTabUsualscores = jfptTabUsualscores;
		this.jfptTabHomeuploads = jfptTabHomeuploads;
		this.xsglTabParentses = xsglTabParentses;
		this.bksxTabGanttplans = bksxTabGanttplans;
		this.tabUndergraduates = tabUndergraduates;
		this.sjjxTabUsualexperiments = sjjxTabUsualexperiments;
		this.tabPostgraduates = tabPostgraduates;
		this.gzfkTabOtherstudents = gzfkTabOtherstudents;
		this.xsglTabJiangzhus = xsglTabJiangzhus;
		this.jfptTabCourseaskquestions = jfptTabCourseaskquestions;
		this.xsglTabStuorgadeparts = xsglTabStuorgadeparts;
		this.gzfkTabKaoyanstudents = gzfkTabKaoyanstudents;
		this.bksxTabSubjectapplies = bksxTabSubjectapplies;
		this.bksxTabProjectapplies = bksxTabProjectapplies;
		this.xsglTabKaoqins = xsglTabKaoqins;
		this.bksxTabTeamapplies = bksxTabTeamapplies;
		this.jfptTabChooseassociates = jfptTabChooseassociates;
		this.xsglTabJiaofeis = xsglTabJiaofeis;
		this.sjjxTabAttendances = sjjxTabAttendances;
		this.bksxTabMembers = bksxTabMembers;
		this.gzfkTabWorkstudents = gzfkTabWorkstudents;
	}

	// Property accessors

	public String getFStudentNumber() {
		return this.FStudentNumber;
	}

	public void setFStudentNumber(String FStudentNumber) {
		this.FStudentNumber = FStudentNumber;
	}

	public TabClasses getTabClasses() {
		return this.tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public TabDirection getTabDirection() {
		return this.tabDirection;
	}

	public void setTabDirection(TabDirection tabDirection) {
		this.tabDirection = tabDirection;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFStudentName() {
		return this.FStudentName;
	}

	public void setFStudentName(String FStudentName) {
		this.FStudentName = FStudentName;
	}

	public String getFIsLocked() {
		return this.FIsLocked;
	}

	public void setFIsLocked(String FIsLocked) {
		this.FIsLocked = FIsLocked;
	}

	public String getFStudentSex() {
		return this.FStudentSex;
	}

	public void setFStudentSex(String FStudentSex) {
		this.FStudentSex = FStudentSex;
	}

	public Date getFStudentBirthday() {
		return this.FStudentBirthday;
	}

	public void setFStudentBirthday(Date FStudentBirthday) {
		this.FStudentBirthday = FStudentBirthday;
	}

	public String getFStudentIdCard() {
		return this.FStudentIdCard;
	}

	public void setFStudentIdCard(String FStudentIdCard) {
		this.FStudentIdCard = FStudentIdCard;
	}

	public String getFStudentNation() {
		return this.FStudentNation;
	}

	public void setFStudentNation(String FStudentNation) {
		this.FStudentNation = FStudentNation;
	}

	public Date getFStudentRegData() {
		return this.FStudentRegData;
	}

	public void setFStudentRegData(Date FStudentRegData) {
		this.FStudentRegData = FStudentRegData;
	}

	public String getFStudentTel() {
		return this.FStudentTel;
	}

	public void setFStudentTel(String FStudentTel) {
		this.FStudentTel = FStudentTel;
	}

	public String getFStudentEmail() {
		return this.FStudentEmail;
	}

	public void setFStudentEmail(String FStudentEmail) {
		this.FStudentEmail = FStudentEmail;
	}

	public String getFStudentPostcode() {
		return this.FStudentPostcode;
	}

	public void setFStudentPostcode(String FStudentPostcode) {
		this.FStudentPostcode = FStudentPostcode;
	}

	public String getFStudentNativeplace() {
		return this.FStudentNativeplace;
	}

	public void setFStudentNativeplace(String FStudentNativeplace) {
		this.FStudentNativeplace = FStudentNativeplace;
	}

	public String getFHomeTel() {
		return this.FHomeTel;
	}

	public void setFHomeTel(String FHomeTel) {
		this.FHomeTel = FHomeTel;
	}

	public String getFStudentAddress() {
		return this.FStudentAddress;
	}

	public void setFStudentAddress(String FStudentAddress) {
		this.FStudentAddress = FStudentAddress;
	}

	public String getFStudentPoliStatus() {
		return this.FStudentPoliStatus;
	}

	public void setFStudentPoliStatus(String FStudentPoliStatus) {
		this.FStudentPoliStatus = FStudentPoliStatus;
	}

	public String getFStudentDormitory() {
		return this.FStudentDormitory;
	}

	public void setFStudentDormitory(String FStudentDormitory) {
		this.FStudentDormitory = FStudentDormitory;
	}

	public String getFStudentMajor() {
		return this.FStudentMajor;
	}

	public void setFStudentMajor(String FStudentMajor) {
		this.FStudentMajor = FStudentMajor;
	}

	public String getFRewardPunish() {
		return this.FRewardPunish;
	}

	public void setFRewardPunish(String FRewardPunish) {
		this.FRewardPunish = FRewardPunish;
	}

	public String getFQuXiang() {
		return this.FQuXiang;
	}

	public void setFQuXiang(String FQuXiang) {
		this.FQuXiang = FQuXiang;
	}

	public String getFCardNumber() {
		return this.FCardNumber;
	}

	public void setFCardNumber(String FCardNumber) {
		this.FCardNumber = FCardNumber;
	}

	public Set getJfptTabStudentassociates() {
		return this.jfptTabStudentassociates;
	}

	public void setJfptTabStudentassociates(Set jfptTabStudentassociates) {
		this.jfptTabStudentassociates = jfptTabStudentassociates;
	}

	public Set getXsglTabParties() {
		return this.xsglTabParties;
	}

	public void setXsglTabParties(Set xsglTabParties) {
		this.xsglTabParties = xsglTabParties;
	}

	public Set getBksxTabSubstuguis() {
		return this.bksxTabSubstuguis;
	}

	public void setBksxTabSubstuguis(Set bksxTabSubstuguis) {
		this.bksxTabSubstuguis = bksxTabSubstuguis;
	}

	public Set getSjjxTabTests() {
		return this.sjjxTabTests;
	}

	public void setSjjxTabTests(Set sjjxTabTests) {
		this.sjjxTabTests = sjjxTabTests;
	}

	public Set getJfptTabHomenoticetoreceives() {
		return this.jfptTabHomenoticetoreceives;
	}

	public void setJfptTabHomenoticetoreceives(Set jfptTabHomenoticetoreceives) {
		this.jfptTabHomenoticetoreceives = jfptTabHomenoticetoreceives;
	}

	public Set getJfptTabUsualscores() {
		return this.jfptTabUsualscores;
	}

	public void setJfptTabUsualscores(Set jfptTabUsualscores) {
		this.jfptTabUsualscores = jfptTabUsualscores;
	}

	public Set getJfptTabHomeuploads() {
		return this.jfptTabHomeuploads;
	}

	public void setJfptTabHomeuploads(Set jfptTabHomeuploads) {
		this.jfptTabHomeuploads = jfptTabHomeuploads;
	}

	public Set getXsglTabParentses() {
		return this.xsglTabParentses;
	}

	public void setXsglTabParentses(Set xsglTabParentses) {
		this.xsglTabParentses = xsglTabParentses;
	}

	public Set getBksxTabGanttplans() {
		return this.bksxTabGanttplans;
	}

	public void setBksxTabGanttplans(Set bksxTabGanttplans) {
		this.bksxTabGanttplans = bksxTabGanttplans;
	}

	public Set getTabUndergraduates() {
		return this.tabUndergraduates;
	}

	public void setTabUndergraduates(Set tabUndergraduates) {
		this.tabUndergraduates = tabUndergraduates;
	}

	public Set getSjjxTabUsualexperiments() {
		return this.sjjxTabUsualexperiments;
	}

	public void setSjjxTabUsualexperiments(Set sjjxTabUsualexperiments) {
		this.sjjxTabUsualexperiments = sjjxTabUsualexperiments;
	}

	public Set getTabPostgraduates() {
		return this.tabPostgraduates;
	}

	public void setTabPostgraduates(Set tabPostgraduates) {
		this.tabPostgraduates = tabPostgraduates;
	}

	public Set getGzfkTabOtherstudents() {
		return this.gzfkTabOtherstudents;
	}

	public void setGzfkTabOtherstudents(Set gzfkTabOtherstudents) {
		this.gzfkTabOtherstudents = gzfkTabOtherstudents;
	}

	public Set getXsglTabJiangzhus() {
		return this.xsglTabJiangzhus;
	}

	public void setXsglTabJiangzhus(Set xsglTabJiangzhus) {
		this.xsglTabJiangzhus = xsglTabJiangzhus;
	}

	public Set getJfptTabCourseaskquestions() {
		return this.jfptTabCourseaskquestions;
	}

	public void setJfptTabCourseaskquestions(Set jfptTabCourseaskquestions) {
		this.jfptTabCourseaskquestions = jfptTabCourseaskquestions;
	}

	public Set getXsglTabStuorgadeparts() {
		return this.xsglTabStuorgadeparts;
	}

	public void setXsglTabStuorgadeparts(Set xsglTabStuorgadeparts) {
		this.xsglTabStuorgadeparts = xsglTabStuorgadeparts;
	}

	public Set getGzfkTabKaoyanstudents() {
		return this.gzfkTabKaoyanstudents;
	}

	public void setGzfkTabKaoyanstudents(Set gzfkTabKaoyanstudents) {
		this.gzfkTabKaoyanstudents = gzfkTabKaoyanstudents;
	}

	public Set getBksxTabSubjectapplies() {
		return this.bksxTabSubjectapplies;
	}

	public void setBksxTabSubjectapplies(Set bksxTabSubjectapplies) {
		this.bksxTabSubjectapplies = bksxTabSubjectapplies;
	}

	public Set getBksxTabProjectapplies() {
		return this.bksxTabProjectapplies;
	}

	public void setBksxTabProjectapplies(Set bksxTabProjectapplies) {
		this.bksxTabProjectapplies = bksxTabProjectapplies;
	}

	public Set getXsglTabKaoqins() {
		return this.xsglTabKaoqins;
	}

	public void setXsglTabKaoqins(Set xsglTabKaoqins) {
		this.xsglTabKaoqins = xsglTabKaoqins;
	}

	public Set getBksxTabTeamapplies() {
		return this.bksxTabTeamapplies;
	}

	public void setBksxTabTeamapplies(Set bksxTabTeamapplies) {
		this.bksxTabTeamapplies = bksxTabTeamapplies;
	}

	public Set getJfptTabChooseassociates() {
		return this.jfptTabChooseassociates;
	}

	public void setJfptTabChooseassociates(Set jfptTabChooseassociates) {
		this.jfptTabChooseassociates = jfptTabChooseassociates;
	}

	public Set getXsglTabJiaofeis() {
		return this.xsglTabJiaofeis;
	}

	public void setXsglTabJiaofeis(Set xsglTabJiaofeis) {
		this.xsglTabJiaofeis = xsglTabJiaofeis;
	}

	public Set getSjjxTabAttendances() {
		return this.sjjxTabAttendances;
	}

	public void setSjjxTabAttendances(Set sjjxTabAttendances) {
		this.sjjxTabAttendances = sjjxTabAttendances;
	}

	public Set getBksxTabMembers() {
		return this.bksxTabMembers;
	}

	public void setBksxTabMembers(Set bksxTabMembers) {
		this.bksxTabMembers = bksxTabMembers;
	}

	public Set getGzfkTabWorkstudents() {
		return this.gzfkTabWorkstudents;
	}

	public void setGzfkTabWorkstudents(Set gzfkTabWorkstudents) {
		this.gzfkTabWorkstudents = gzfkTabWorkstudents;
	}

}