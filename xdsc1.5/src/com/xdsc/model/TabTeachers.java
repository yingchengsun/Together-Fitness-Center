package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TabTeachers entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabTeachers implements java.io.Serializable {

	// Fields

	private String FTeacherNumber;
	private TabGrade tabGrade;
	private MhqxTabUser mhqxTabUser;
	private String FTeacherName;
	private String FIsLocked;
	private String FTeacherSex;
	private Date FTeacherBirthday;
	private String FTeacherIdCard;
	private String FTeacherNation;
	private Date FTeacherRegData;
	private String FTeacherTel;
	private String FTeacherPhone;
	private String FTeacherEmail;
	private String FTeacherPostcode;
	private String FTeacherNativeplace;
	private String FTeacherAddress;
	private String FTeacherPoliStatus;
	private String FTeacherXueLi;
	private String FTeacherWorkPlace;
	private String FTeacherResearch;
	private String FTeacherAchieve;
	private String FTeacherPosition;
	private String FTeacherZhiCheng;
	private String FTeacherHistory;
	private String FTeacherXueYuan;
	private Set yjssxTabTutorselectdispachs = new HashSet(0);
	private Set sjjxTabCourselabs = new HashSet(0);
	private Set yjssxTabTutorselectsForFSecondWish = new HashSet(0);
	private Set jfptTabTeacherassociates = new HashSet(0);
	private Set yjssxTabTutorselectsForFThirdWish = new HashSet(0);
	private Set bksxTabProjectapplies = new HashSet(0);
	private Set jfptTabChooseassociates = new HashSet(0);
	private Set yjssxTabReturnthesises = new HashSet(0);
	private Set tabTeacherstotypes = new HashSet(0);
	private Set yjssxTabTutorselectsForFFirstWish = new HashSet(0);
	private Set yjssxTabSubmitthesises = new HashSet(0);
	private Set tabPostgraduates = new HashSet(0);
	private Set jfptTabAssistantapplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabTeachers() {
	}

	/** minimal constructor */
	public TabTeachers(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public TabTeachers(TabGrade tabGrade, MhqxTabUser mhqxTabUser,
			String FTeacherName, String FIsLocked, String FTeacherSex,
			Date FTeacherBirthday, String FTeacherIdCard,
			String FTeacherNation, Date FTeacherRegData, String FTeacherTel,
			String FTeacherPhone, String FTeacherEmail,
			String FTeacherPostcode, String FTeacherNativeplace,
			String FTeacherAddress, String FTeacherPoliStatus,
			String FTeacherXueLi, String FTeacherWorkPlace,
			String FTeacherResearch, String FTeacherAchieve,
			String FTeacherPosition, String FTeacherZhiCheng,
			String FTeacherHistory, String FTeacherXueYuan,
			Set yjssxTabTutorselectdispachs, Set sjjxTabCourselabs,
			Set yjssxTabTutorselectsForFSecondWish,
			Set jfptTabTeacherassociates,
			Set yjssxTabTutorselectsForFThirdWish, Set bksxTabProjectapplies,
			Set jfptTabChooseassociates, Set yjssxTabReturnthesises,
			Set tabTeacherstotypes, Set yjssxTabTutorselectsForFFirstWish,
			Set yjssxTabSubmitthesises, Set tabPostgraduates,
			Set jfptTabAssistantapplies) {
		this.tabGrade = tabGrade;
		this.mhqxTabUser = mhqxTabUser;
		this.FTeacherName = FTeacherName;
		this.FIsLocked = FIsLocked;
		this.FTeacherSex = FTeacherSex;
		this.FTeacherBirthday = FTeacherBirthday;
		this.FTeacherIdCard = FTeacherIdCard;
		this.FTeacherNation = FTeacherNation;
		this.FTeacherRegData = FTeacherRegData;
		this.FTeacherTel = FTeacherTel;
		this.FTeacherPhone = FTeacherPhone;
		this.FTeacherEmail = FTeacherEmail;
		this.FTeacherPostcode = FTeacherPostcode;
		this.FTeacherNativeplace = FTeacherNativeplace;
		this.FTeacherAddress = FTeacherAddress;
		this.FTeacherPoliStatus = FTeacherPoliStatus;
		this.FTeacherXueLi = FTeacherXueLi;
		this.FTeacherWorkPlace = FTeacherWorkPlace;
		this.FTeacherResearch = FTeacherResearch;
		this.FTeacherAchieve = FTeacherAchieve;
		this.FTeacherPosition = FTeacherPosition;
		this.FTeacherZhiCheng = FTeacherZhiCheng;
		this.FTeacherHistory = FTeacherHistory;
		this.FTeacherXueYuan = FTeacherXueYuan;
		this.yjssxTabTutorselectdispachs = yjssxTabTutorselectdispachs;
		this.sjjxTabCourselabs = sjjxTabCourselabs;
		this.yjssxTabTutorselectsForFSecondWish = yjssxTabTutorselectsForFSecondWish;
		this.jfptTabTeacherassociates = jfptTabTeacherassociates;
		this.yjssxTabTutorselectsForFThirdWish = yjssxTabTutorselectsForFThirdWish;
		this.bksxTabProjectapplies = bksxTabProjectapplies;
		this.jfptTabChooseassociates = jfptTabChooseassociates;
		this.yjssxTabReturnthesises = yjssxTabReturnthesises;
		this.tabTeacherstotypes = tabTeacherstotypes;
		this.yjssxTabTutorselectsForFFirstWish = yjssxTabTutorselectsForFFirstWish;
		this.yjssxTabSubmitthesises = yjssxTabSubmitthesises;
		this.tabPostgraduates = tabPostgraduates;
		this.jfptTabAssistantapplies = jfptTabAssistantapplies;
	}

	// Property accessors

	public String getFTeacherNumber() {
		return this.FTeacherNumber;
	}

	public void setFTeacherNumber(String FTeacherNumber) {
		this.FTeacherNumber = FTeacherNumber;
	}

	public TabGrade getTabGrade() {
		return this.tabGrade;
	}

	public void setTabGrade(TabGrade tabGrade) {
		this.tabGrade = tabGrade;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFTeacherName() {
		return this.FTeacherName;
	}

	public void setFTeacherName(String FTeacherName) {
		this.FTeacherName = FTeacherName;
	}

	public String getFIsLocked() {
		return this.FIsLocked;
	}

	public void setFIsLocked(String FIsLocked) {
		this.FIsLocked = FIsLocked;
	}

	public String getFTeacherSex() {
		return this.FTeacherSex;
	}

	public void setFTeacherSex(String FTeacherSex) {
		this.FTeacherSex = FTeacherSex;
	}

	public Date getFTeacherBirthday() {
		return this.FTeacherBirthday;
	}

	public void setFTeacherBirthday(Date FTeacherBirthday) {
		this.FTeacherBirthday = FTeacherBirthday;
	}

	public String getFTeacherIdCard() {
		return this.FTeacherIdCard;
	}

	public void setFTeacherIdCard(String FTeacherIdCard) {
		this.FTeacherIdCard = FTeacherIdCard;
	}

	public String getFTeacherNation() {
		return this.FTeacherNation;
	}

	public void setFTeacherNation(String FTeacherNation) {
		this.FTeacherNation = FTeacherNation;
	}

	public Date getFTeacherRegData() {
		return this.FTeacherRegData;
	}

	public void setFTeacherRegData(Date FTeacherRegData) {
		this.FTeacherRegData = FTeacherRegData;
	}

	public String getFTeacherTel() {
		return this.FTeacherTel;
	}

	public void setFTeacherTel(String FTeacherTel) {
		this.FTeacherTel = FTeacherTel;
	}

	public String getFTeacherPhone() {
		return this.FTeacherPhone;
	}

	public void setFTeacherPhone(String FTeacherPhone) {
		this.FTeacherPhone = FTeacherPhone;
	}

	public String getFTeacherEmail() {
		return this.FTeacherEmail;
	}

	public void setFTeacherEmail(String FTeacherEmail) {
		this.FTeacherEmail = FTeacherEmail;
	}

	public String getFTeacherPostcode() {
		return this.FTeacherPostcode;
	}

	public void setFTeacherPostcode(String FTeacherPostcode) {
		this.FTeacherPostcode = FTeacherPostcode;
	}

	public String getFTeacherNativeplace() {
		return this.FTeacherNativeplace;
	}

	public void setFTeacherNativeplace(String FTeacherNativeplace) {
		this.FTeacherNativeplace = FTeacherNativeplace;
	}

	public String getFTeacherAddress() {
		return this.FTeacherAddress;
	}

	public void setFTeacherAddress(String FTeacherAddress) {
		this.FTeacherAddress = FTeacherAddress;
	}

	public String getFTeacherPoliStatus() {
		return this.FTeacherPoliStatus;
	}

	public void setFTeacherPoliStatus(String FTeacherPoliStatus) {
		this.FTeacherPoliStatus = FTeacherPoliStatus;
	}

	public String getFTeacherXueLi() {
		return this.FTeacherXueLi;
	}

	public void setFTeacherXueLi(String FTeacherXueLi) {
		this.FTeacherXueLi = FTeacherXueLi;
	}

	public String getFTeacherWorkPlace() {
		return this.FTeacherWorkPlace;
	}

	public void setFTeacherWorkPlace(String FTeacherWorkPlace) {
		this.FTeacherWorkPlace = FTeacherWorkPlace;
	}

	public String getFTeacherResearch() {
		return this.FTeacherResearch;
	}

	public void setFTeacherResearch(String FTeacherResearch) {
		this.FTeacherResearch = FTeacherResearch;
	}

	public String getFTeacherAchieve() {
		return this.FTeacherAchieve;
	}

	public void setFTeacherAchieve(String FTeacherAchieve) {
		this.FTeacherAchieve = FTeacherAchieve;
	}

	public String getFTeacherPosition() {
		return this.FTeacherPosition;
	}

	public void setFTeacherPosition(String FTeacherPosition) {
		this.FTeacherPosition = FTeacherPosition;
	}

	public String getFTeacherZhiCheng() {
		return this.FTeacherZhiCheng;
	}

	public void setFTeacherZhiCheng(String FTeacherZhiCheng) {
		this.FTeacherZhiCheng = FTeacherZhiCheng;
	}

	public String getFTeacherHistory() {
		return this.FTeacherHistory;
	}

	public void setFTeacherHistory(String FTeacherHistory) {
		this.FTeacherHistory = FTeacherHistory;
	}

	public String getFTeacherXueYuan() {
		return this.FTeacherXueYuan;
	}

	public void setFTeacherXueYuan(String FTeacherXueYuan) {
		this.FTeacherXueYuan = FTeacherXueYuan;
	}

	public Set getYjssxTabTutorselectdispachs() {
		return this.yjssxTabTutorselectdispachs;
	}

	public void setYjssxTabTutorselectdispachs(Set yjssxTabTutorselectdispachs) {
		this.yjssxTabTutorselectdispachs = yjssxTabTutorselectdispachs;
	}

	public Set getSjjxTabCourselabs() {
		return this.sjjxTabCourselabs;
	}

	public void setSjjxTabCourselabs(Set sjjxTabCourselabs) {
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

	public Set getYjssxTabTutorselectsForFSecondWish() {
		return this.yjssxTabTutorselectsForFSecondWish;
	}

	public void setYjssxTabTutorselectsForFSecondWish(
			Set yjssxTabTutorselectsForFSecondWish) {
		this.yjssxTabTutorselectsForFSecondWish = yjssxTabTutorselectsForFSecondWish;
	}

	public Set getJfptTabTeacherassociates() {
		return this.jfptTabTeacherassociates;
	}

	public void setJfptTabTeacherassociates(Set jfptTabTeacherassociates) {
		this.jfptTabTeacherassociates = jfptTabTeacherassociates;
	}

	public Set getYjssxTabTutorselectsForFThirdWish() {
		return this.yjssxTabTutorselectsForFThirdWish;
	}

	public void setYjssxTabTutorselectsForFThirdWish(
			Set yjssxTabTutorselectsForFThirdWish) {
		this.yjssxTabTutorselectsForFThirdWish = yjssxTabTutorselectsForFThirdWish;
	}

	public Set getBksxTabProjectapplies() {
		return this.bksxTabProjectapplies;
	}

	public void setBksxTabProjectapplies(Set bksxTabProjectapplies) {
		this.bksxTabProjectapplies = bksxTabProjectapplies;
	}

	public Set getJfptTabChooseassociates() {
		return this.jfptTabChooseassociates;
	}

	public void setJfptTabChooseassociates(Set jfptTabChooseassociates) {
		this.jfptTabChooseassociates = jfptTabChooseassociates;
	}

	public Set getYjssxTabReturnthesises() {
		return this.yjssxTabReturnthesises;
	}

	public void setYjssxTabReturnthesises(Set yjssxTabReturnthesises) {
		this.yjssxTabReturnthesises = yjssxTabReturnthesises;
	}

	public Set getTabTeacherstotypes() {
		return this.tabTeacherstotypes;
	}

	public void setTabTeacherstotypes(Set tabTeacherstotypes) {
		this.tabTeacherstotypes = tabTeacherstotypes;
	}

	public Set getYjssxTabTutorselectsForFFirstWish() {
		return this.yjssxTabTutorselectsForFFirstWish;
	}

	public void setYjssxTabTutorselectsForFFirstWish(
			Set yjssxTabTutorselectsForFFirstWish) {
		this.yjssxTabTutorselectsForFFirstWish = yjssxTabTutorselectsForFFirstWish;
	}

	public Set getYjssxTabSubmitthesises() {
		return this.yjssxTabSubmitthesises;
	}

	public void setYjssxTabSubmitthesises(Set yjssxTabSubmitthesises) {
		this.yjssxTabSubmitthesises = yjssxTabSubmitthesises;
	}

	public Set getTabPostgraduates() {
		return this.tabPostgraduates;
	}

	public void setTabPostgraduates(Set tabPostgraduates) {
		this.tabPostgraduates = tabPostgraduates;
	}

	public Set getJfptTabAssistantapplies() {
		return this.jfptTabAssistantapplies;
	}

	public void setJfptTabAssistantapplies(Set jfptTabAssistantapplies) {
		this.jfptTabAssistantapplies = jfptTabAssistantapplies;
	}

}