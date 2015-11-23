package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * BksxTabSubstugui entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabSubstugui implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer FSubStuGuiId;
	private BksxTabProject bksxTabProject;
	private TabStudents tabStudents;
	private String FNo;
	private String FSubjectName;
	private String FIsSoftware;
	private String FIsHardware;
	private String FIsSoftHard;
	private String FIsDocument;
	private String FIsResearch;
	private String FIsSimulation;
	private String FIsLab;
	private String FIsOthers;
	private String FLevel;
	private String FTeacherName;
	private String FTeacherDegreen;
	private String FWorkPlace;
	private String FStudentName;
	private String FSubjectDescription;
	private String FTeacherNumber;
	private String FIsChecked;
	private String FReason;
	private Set bksxTabWorksummaries = new HashSet(0);
	private Set bksxTabAchievements = new HashSet(0);
	private Set bksxTabWorkdiaries = new HashSet(0);
	private Set bksxTabSearchplans = new HashSet(0);
	private Set bksxTabSubjectapplies = new HashSet(0);

	// Constructors

	public Set getBksxTabSubjectapplies() {
		return bksxTabSubjectapplies;
	}

	public void setBksxTabSubjectapplies(Set bksxTabSubjectapplies) {
		this.bksxTabSubjectapplies = bksxTabSubjectapplies;
	}

	/** default constructor */
	public BksxTabSubstugui() {
	}

	/** full constructor */
	public BksxTabSubstugui(BksxTabProject bksxTabProject,
			TabStudents tabStudents, String FNo, String FSubjectName,
			String FIsSoftware, String FIsHardware, String FIsSoftHard,
			String FIsDocument, String FIsResearch, String FIsSimulation,
			String FIsLab, String FIsOthers, String FLevel,
			String FTeacherName, String FTeacherDegreen, String FWorkPlace,
			String FStudentName, String FSubjectDescription,
			String FTeacherNumber, String FIsChecked, String FReason,
			Set bksxTabWorksummaries, Set bksxTabAchievements,
			Set bksxTabWorkdiaries, Set bksxTabSearchplans) {
		this.bksxTabProject = bksxTabProject;
		this.tabStudents = tabStudents;
		this.FNo = FNo;
		this.FSubjectName = FSubjectName;
		this.FIsSoftware = FIsSoftware;
		this.FIsHardware = FIsHardware;
		this.FIsSoftHard = FIsSoftHard;
		this.FIsDocument = FIsDocument;
		this.FIsResearch = FIsResearch;
		this.FIsSimulation = FIsSimulation;
		this.FIsLab = FIsLab;
		this.FIsOthers = FIsOthers;
		this.FLevel = FLevel;
		this.FTeacherName = FTeacherName;
		this.FTeacherDegreen = FTeacherDegreen;
		this.FWorkPlace = FWorkPlace;
		this.FStudentName = FStudentName;
		this.FSubjectDescription = FSubjectDescription;
		this.FTeacherNumber = FTeacherNumber;
		this.FIsChecked = FIsChecked;
		this.FReason = FReason;
		this.bksxTabWorksummaries = bksxTabWorksummaries;
		this.bksxTabAchievements = bksxTabAchievements;
		this.bksxTabWorkdiaries = bksxTabWorkdiaries;
		this.bksxTabSearchplans = bksxTabSearchplans;
	}

	// Property accessors
	public BksxTabSubstugui(TabStudents tabStudents, String FSubjectName,
			String FIsSoftware, String FIsHardware, String FIsSoftHard,
			String FIsDocument, String FIsResearch, String FIsSimulation,
			String FIsLab, String FIsOthers, String FLevel,
			String FTeacherName, String FTeacherDegreen, String FWorkPlace,
			String FStudentName, String FSubjectDescription,
			String FTeacherNumber, String FIsChecked, String FReason) {
		this.tabStudents = tabStudents;
		this.FSubjectName = FSubjectName;
		this.FIsSoftware = FIsSoftware;
		this.FIsHardware = FIsHardware;
		this.FIsSoftHard = FIsSoftHard;
		this.FIsDocument = FIsDocument;
		this.FIsResearch = FIsResearch;
		this.FIsSimulation = FIsSimulation;
		this.FIsLab = FIsLab;
		this.FIsOthers = FIsOthers;
		this.FLevel = FLevel;
		this.FTeacherName = FTeacherName;
		this.FTeacherDegreen = FTeacherDegreen;
		this.FWorkPlace = FWorkPlace;
		this.FStudentName = FStudentName;
		this.FSubjectDescription = FSubjectDescription;
		this.FTeacherNumber = FTeacherNumber;
		this.FIsChecked = FIsChecked;
		this.FReason = FReason;
	}

	public String getFReason() {
		return FReason;
	}

	public void setFReason(String reason) {
		FReason = reason;
	}

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public String getFIsChecked() {
		return FIsChecked;
	}

	public void setFIsChecked(String isChecked) {
		FIsChecked = isChecked;
	}

	public Integer getFSubStuGuiId() {
		return this.FSubStuGuiId;
	}

	public void setFSubStuGuiId(Integer FSubStuGuiId) {
		this.FSubStuGuiId = FSubStuGuiId;
	}

	public BksxTabProject getBksxTabProject() {
		return this.bksxTabProject;
	}

	public void setBksxTabProject(BksxTabProject bksxTabProject) {
		this.bksxTabProject = bksxTabProject;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFNo() {
		return this.FNo;
	}

	public void setFNo(String FNo) {
		this.FNo = FNo;
	}

	public String getFSubjectName() {
		return this.FSubjectName;
	}

	public void setFSubjectName(String FSubjectName) {
		this.FSubjectName = FSubjectName;
	}

	public String getFIsSoftware() {
		return this.FIsSoftware;
	}

	public void setFIsSoftware(String FIsSoftware) {
		this.FIsSoftware = FIsSoftware;
	}

	public String getFIsHardware() {
		return this.FIsHardware;
	}

	public void setFIsHardware(String FIsHardware) {
		this.FIsHardware = FIsHardware;
	}

	public String getFIsSoftHard() {
		return this.FIsSoftHard;
	}

	public void setFIsSoftHard(String FIsSoftHard) {
		this.FIsSoftHard = FIsSoftHard;
	}

	public String getFIsDocument() {
		return this.FIsDocument;
	}

	public void setFIsDocument(String FIsDocument) {
		this.FIsDocument = FIsDocument;
	}

	public String getFIsResearch() {
		return this.FIsResearch;
	}

	public void setFIsResearch(String FIsResearch) {
		this.FIsResearch = FIsResearch;
	}

	public String getFIsSimulation() {
		return this.FIsSimulation;
	}

	public void setFIsSimulation(String FIsSimulation) {
		this.FIsSimulation = FIsSimulation;
	}

	public String getFIsLab() {
		return this.FIsLab;
	}

	public void setFIsLab(String FIsLab) {
		this.FIsLab = FIsLab;
	}

	public String getFIsOthers() {
		return this.FIsOthers;
	}

	public void setFIsOthers(String FIsOthers) {
		this.FIsOthers = FIsOthers;
	}

	public String getFLevel() {
		return this.FLevel;
	}

	public void setFLevel(String FLevel) {
		this.FLevel = FLevel;
	}

	public String getFTeacherName() {
		return this.FTeacherName;
	}

	public void setFTeacherName(String FTeacherName) {
		this.FTeacherName = FTeacherName;
	}

	public String getFTeacherDegreen() {
		return this.FTeacherDegreen;
	}

	public void setFTeacherDegreen(String FTeacherDegreen) {
		this.FTeacherDegreen = FTeacherDegreen;
	}

	public String getFWorkPlace() {
		return this.FWorkPlace;
	}

	public void setFWorkPlace(String FWorkPlace) {
		this.FWorkPlace = FWorkPlace;
	}

	public String getFStudentName() {
		return this.FStudentName;
	}

	public void setFStudentName(String FStudentName) {
		this.FStudentName = FStudentName;
	}

	public String getFSubjectDescription() {
		return this.FSubjectDescription;
	}

	public void setFSubjectDescription(String FSubjectDescription) {
		this.FSubjectDescription = FSubjectDescription;
	}

	public Set getBksxTabWorksummaries() {
		return this.bksxTabWorksummaries;
	}

	public void setBksxTabWorksummaries(Set bksxTabWorksummaries) {
		this.bksxTabWorksummaries = bksxTabWorksummaries;
	}

	public Set getBksxTabAchievements() {
		return this.bksxTabAchievements;
	}

	public void setBksxTabAchievements(Set bksxTabAchievements) {
		this.bksxTabAchievements = bksxTabAchievements;
	}

	public Set getBksxTabWorkdiaries() {
		return this.bksxTabWorkdiaries;
	}

	public void setBksxTabWorkdiaries(Set bksxTabWorkdiaries) {
		this.bksxTabWorkdiaries = bksxTabWorkdiaries;
	}

	public Set getBksxTabSearchplans() {
		return this.bksxTabSearchplans;
	}

	public void setBksxTabSearchplans(Set bksxTabSearchplans) {
		this.bksxTabSearchplans = bksxTabSearchplans;
	}

}