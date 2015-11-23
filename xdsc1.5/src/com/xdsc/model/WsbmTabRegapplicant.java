package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * WsbmTabRegapplicant entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabRegapplicant implements java.io.Serializable {

	// Fields

	private String FAppRegNum;
	private MhqxTabUser mhqxTabUser;
	private String FAppRegName;
	private String FAppRegSex;
	private Date FAppRegBirthday;
	private String FAppRegIdCard;
	private String FAppRegPolitical;
	private String FAppRegLocation;
	private String FAppRegWorkDuty;
	private String FAppRegWorkTitle;
	private String FAppRegTel;
	private String FAppRegAddress;
	private String FAppRegPostCode;
	private Date FAppRegLastGraduDate;
	private String FAppRegLastGraduInstitu;
	private String FAppRegLastGraduMajor;
	private Date FAppRegLastBacheDegreeDate;
	private String FAppRegXueWeiZhengNum;
	private String FAppRegBiYeZhengNum;
	private String FAppRegEmail;
	private Integer FAppRegCet4;
	private Integer FAppRegCet6;
	private String FAppRegNation;
	private String FAppRegQgtkao;
	private String FAppRegCv;
	private String FAppRegHomeTown;
	private String FAppRegPassPreAd;
	private String FAppRegPassFinAd;
	private String FAppRegPassAuth;
	private String FAppRegQgtkaoNum;
	private String FAppRegBaoMingFei;
	private String FAppRegFuDaoBan;
	private String FAppRegZhuanYeKe;
	private Integer FAppRegQgtkaoZhengzhi;
	private Integer FAppRegQgtkaoEnglish;
	private Integer FAppRegQgtkaoZhuanYeKe;
	private String FAppRegCv1;
	private String FAppRegCv2;
	private String FAppRegCv3;
	private String FAppRegCv4;
	private String FAppRegCv5;
	private String FAppRegZhunKaoZhengHao;
	private String FAppRegBackUpChar;
	private String FAppRegBackUpText;
	private Integer FAppRegBackUpInt;
	private Set wsbmTabExamresults = new HashSet(0);
	private Set wsbmTabFinadnots = new HashSet(0);
	private Set wsbmTabProgresses = new HashSet(0);
	private Set wsbmTabPreadnots = new HashSet(0);

	// Constructors

	/** default constructor */
	public WsbmTabRegapplicant() {
	}

	/** minimal constructor */
	public WsbmTabRegapplicant(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	/** full constructor */
	public WsbmTabRegapplicant(MhqxTabUser mhqxTabUser, String FAppRegName,
			String FAppRegSex, Date FAppRegBirthday, String FAppRegIdCard,
			String FAppRegPolitical, String FAppRegLocation,
			String FAppRegWorkDuty, String FAppRegWorkTitle, String FAppRegTel,
			String FAppRegAddress, String FAppRegPostCode,
			Date FAppRegLastGraduDate, String FAppRegLastGraduInstitu,
			String FAppRegLastGraduMajor, Date FAppRegLastBacheDegreeDate,
			String FAppRegXueWeiZhengNum, String FAppRegBiYeZhengNum,
			String FAppRegEmail, Integer FAppRegCet4, Integer FAppRegCet6,
			String FAppRegNation, String FAppRegQgtkao, String FAppRegCv,
			String FAppRegHomeTown, String FAppRegPassPreAd,
			String FAppRegPassFinAd, String FAppRegPassAuth,
			String FAppRegQgtkaoNum, String FAppRegBaoMingFei,
			String FAppRegFuDaoBan, String FAppRegZhuanYeKe,
			Integer FAppRegQgtkaoZhengzhi, Integer FAppRegQgtkaoEnglish,
			Integer FAppRegQgtkaoZhuanYeKe, String FAppRegCv1,
			String FAppRegCv2, String FAppRegCv3, String FAppRegCv4,
			String FAppRegCv5, String FAppRegZhunKaoZhengHao,
			String FAppRegBackUpChar, String FAppRegBackUpText,
			Integer FAppRegBackUpInt, Set wsbmTabExamresults,
			Set wsbmTabFinadnots, Set wsbmTabProgresses, Set wsbmTabPreadnots) {
		this.mhqxTabUser = mhqxTabUser;
		this.FAppRegName = FAppRegName;
		this.FAppRegSex = FAppRegSex;
		this.FAppRegBirthday = FAppRegBirthday;
		this.FAppRegIdCard = FAppRegIdCard;
		this.FAppRegPolitical = FAppRegPolitical;
		this.FAppRegLocation = FAppRegLocation;
		this.FAppRegWorkDuty = FAppRegWorkDuty;
		this.FAppRegWorkTitle = FAppRegWorkTitle;
		this.FAppRegTel = FAppRegTel;
		this.FAppRegAddress = FAppRegAddress;
		this.FAppRegPostCode = FAppRegPostCode;
		this.FAppRegLastGraduDate = FAppRegLastGraduDate;
		this.FAppRegLastGraduInstitu = FAppRegLastGraduInstitu;
		this.FAppRegLastGraduMajor = FAppRegLastGraduMajor;
		this.FAppRegLastBacheDegreeDate = FAppRegLastBacheDegreeDate;
		this.FAppRegXueWeiZhengNum = FAppRegXueWeiZhengNum;
		this.FAppRegBiYeZhengNum = FAppRegBiYeZhengNum;
		this.FAppRegEmail = FAppRegEmail;
		this.FAppRegCet4 = FAppRegCet4;
		this.FAppRegCet6 = FAppRegCet6;
		this.FAppRegNation = FAppRegNation;
		this.FAppRegQgtkao = FAppRegQgtkao;
		this.FAppRegCv = FAppRegCv;
		this.FAppRegHomeTown = FAppRegHomeTown;
		this.FAppRegPassPreAd = FAppRegPassPreAd;
		this.FAppRegPassFinAd = FAppRegPassFinAd;
		this.FAppRegPassAuth = FAppRegPassAuth;
		this.FAppRegQgtkaoNum = FAppRegQgtkaoNum;
		this.FAppRegBaoMingFei = FAppRegBaoMingFei;
		this.FAppRegFuDaoBan = FAppRegFuDaoBan;
		this.FAppRegZhuanYeKe = FAppRegZhuanYeKe;
		this.FAppRegQgtkaoZhengzhi = FAppRegQgtkaoZhengzhi;
		this.FAppRegQgtkaoEnglish = FAppRegQgtkaoEnglish;
		this.FAppRegQgtkaoZhuanYeKe = FAppRegQgtkaoZhuanYeKe;
		this.FAppRegCv1 = FAppRegCv1;
		this.FAppRegCv2 = FAppRegCv2;
		this.FAppRegCv3 = FAppRegCv3;
		this.FAppRegCv4 = FAppRegCv4;
		this.FAppRegCv5 = FAppRegCv5;
		this.FAppRegZhunKaoZhengHao = FAppRegZhunKaoZhengHao;
		this.FAppRegBackUpChar = FAppRegBackUpChar;
		this.FAppRegBackUpText = FAppRegBackUpText;
		this.FAppRegBackUpInt = FAppRegBackUpInt;
		this.wsbmTabExamresults = wsbmTabExamresults;
		this.wsbmTabFinadnots = wsbmTabFinadnots;
		this.wsbmTabProgresses = wsbmTabProgresses;
		this.wsbmTabPreadnots = wsbmTabPreadnots;
	}

	// Property accessors

	public String getFAppRegNum() {
		return this.FAppRegNum;
	}

	public void setFAppRegNum(String FAppRegNum) {
		this.FAppRegNum = FAppRegNum;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFAppRegName() {
		return this.FAppRegName;
	}

	public void setFAppRegName(String FAppRegName) {
		this.FAppRegName = FAppRegName;
	}

	public String getFAppRegSex() {
		return this.FAppRegSex;
	}

	public void setFAppRegSex(String FAppRegSex) {
		this.FAppRegSex = FAppRegSex;
	}

	public Date getFAppRegBirthday() {
		return this.FAppRegBirthday;
	}

	public void setFAppRegBirthday(Date FAppRegBirthday) {
		this.FAppRegBirthday = FAppRegBirthday;
	}

	public String getFAppRegIdCard() {
		return this.FAppRegIdCard;
	}

	public void setFAppRegIdCard(String FAppRegIdCard) {
		this.FAppRegIdCard = FAppRegIdCard;
	}

	public String getFAppRegPolitical() {
		return this.FAppRegPolitical;
	}

	public void setFAppRegPolitical(String FAppRegPolitical) {
		this.FAppRegPolitical = FAppRegPolitical;
	}

	public String getFAppRegLocation() {
		return this.FAppRegLocation;
	}

	public void setFAppRegLocation(String FAppRegLocation) {
		this.FAppRegLocation = FAppRegLocation;
	}

	public String getFAppRegWorkDuty() {
		return this.FAppRegWorkDuty;
	}

	public void setFAppRegWorkDuty(String FAppRegWorkDuty) {
		this.FAppRegWorkDuty = FAppRegWorkDuty;
	}

	public String getFAppRegWorkTitle() {
		return this.FAppRegWorkTitle;
	}

	public void setFAppRegWorkTitle(String FAppRegWorkTitle) {
		this.FAppRegWorkTitle = FAppRegWorkTitle;
	}

	public String getFAppRegTel() {
		return this.FAppRegTel;
	}

	public void setFAppRegTel(String FAppRegTel) {
		this.FAppRegTel = FAppRegTel;
	}

	public String getFAppRegAddress() {
		return this.FAppRegAddress;
	}

	public void setFAppRegAddress(String FAppRegAddress) {
		this.FAppRegAddress = FAppRegAddress;
	}

	public String getFAppRegPostCode() {
		return this.FAppRegPostCode;
	}

	public void setFAppRegPostCode(String FAppRegPostCode) {
		this.FAppRegPostCode = FAppRegPostCode;
	}

	public Date getFAppRegLastGraduDate() {
		return this.FAppRegLastGraduDate;
	}

	public void setFAppRegLastGraduDate(Date FAppRegLastGraduDate) {
		this.FAppRegLastGraduDate = FAppRegLastGraduDate;
	}

	public String getFAppRegLastGraduInstitu() {
		return this.FAppRegLastGraduInstitu;
	}

	public void setFAppRegLastGraduInstitu(String FAppRegLastGraduInstitu) {
		this.FAppRegLastGraduInstitu = FAppRegLastGraduInstitu;
	}

	public String getFAppRegLastGraduMajor() {
		return this.FAppRegLastGraduMajor;
	}

	public void setFAppRegLastGraduMajor(String FAppRegLastGraduMajor) {
		this.FAppRegLastGraduMajor = FAppRegLastGraduMajor;
	}

	public Date getFAppRegLastBacheDegreeDate() {
		return this.FAppRegLastBacheDegreeDate;
	}

	public void setFAppRegLastBacheDegreeDate(Date FAppRegLastBacheDegreeDate) {
		this.FAppRegLastBacheDegreeDate = FAppRegLastBacheDegreeDate;
	}

	public String getFAppRegXueWeiZhengNum() {
		return this.FAppRegXueWeiZhengNum;
	}

	public void setFAppRegXueWeiZhengNum(String FAppRegXueWeiZhengNum) {
		this.FAppRegXueWeiZhengNum = FAppRegXueWeiZhengNum;
	}

	public String getFAppRegBiYeZhengNum() {
		return this.FAppRegBiYeZhengNum;
	}

	public void setFAppRegBiYeZhengNum(String FAppRegBiYeZhengNum) {
		this.FAppRegBiYeZhengNum = FAppRegBiYeZhengNum;
	}

	public String getFAppRegEmail() {
		return this.FAppRegEmail;
	}

	public void setFAppRegEmail(String FAppRegEmail) {
		this.FAppRegEmail = FAppRegEmail;
	}

	public Integer getFAppRegCet4() {
		return this.FAppRegCet4;
	}

	public void setFAppRegCet4(Integer FAppRegCet4) {
		this.FAppRegCet4 = FAppRegCet4;
	}

	public Integer getFAppRegCet6() {
		return this.FAppRegCet6;
	}

	public void setFAppRegCet6(Integer FAppRegCet6) {
		this.FAppRegCet6 = FAppRegCet6;
	}

	public String getFAppRegNation() {
		return this.FAppRegNation;
	}

	public void setFAppRegNation(String FAppRegNation) {
		this.FAppRegNation = FAppRegNation;
	}

	public String getFAppRegQgtkao() {
		return this.FAppRegQgtkao;
	}

	public void setFAppRegQgtkao(String FAppRegQgtkao) {
		this.FAppRegQgtkao = FAppRegQgtkao;
	}

	public String getFAppRegCv() {
		return this.FAppRegCv;
	}

	public void setFAppRegCv(String FAppRegCv) {
		this.FAppRegCv = FAppRegCv;
	}

	public String getFAppRegHomeTown() {
		return this.FAppRegHomeTown;
	}

	public void setFAppRegHomeTown(String FAppRegHomeTown) {
		this.FAppRegHomeTown = FAppRegHomeTown;
	}

	public String getFAppRegPassPreAd() {
		return this.FAppRegPassPreAd;
	}

	public void setFAppRegPassPreAd(String FAppRegPassPreAd) {
		this.FAppRegPassPreAd = FAppRegPassPreAd;
	}

	public String getFAppRegPassFinAd() {
		return this.FAppRegPassFinAd;
	}

	public void setFAppRegPassFinAd(String FAppRegPassFinAd) {
		this.FAppRegPassFinAd = FAppRegPassFinAd;
	}

	public String getFAppRegPassAuth() {
		return this.FAppRegPassAuth;
	}

	public void setFAppRegPassAuth(String FAppRegPassAuth) {
		this.FAppRegPassAuth = FAppRegPassAuth;
	}

	public String getFAppRegQgtkaoNum() {
		return this.FAppRegQgtkaoNum;
	}

	public void setFAppRegQgtkaoNum(String FAppRegQgtkaoNum) {
		this.FAppRegQgtkaoNum = FAppRegQgtkaoNum;
	}

	public String getFAppRegBaoMingFei() {
		return this.FAppRegBaoMingFei;
	}

	public void setFAppRegBaoMingFei(String FAppRegBaoMingFei) {
		this.FAppRegBaoMingFei = FAppRegBaoMingFei;
	}

	public String getFAppRegFuDaoBan() {
		return this.FAppRegFuDaoBan;
	}

	public void setFAppRegFuDaoBan(String FAppRegFuDaoBan) {
		this.FAppRegFuDaoBan = FAppRegFuDaoBan;
	}

	public String getFAppRegZhuanYeKe() {
		return this.FAppRegZhuanYeKe;
	}

	public void setFAppRegZhuanYeKe(String FAppRegZhuanYeKe) {
		this.FAppRegZhuanYeKe = FAppRegZhuanYeKe;
	}

	public Integer getFAppRegQgtkaoZhengzhi() {
		return this.FAppRegQgtkaoZhengzhi;
	}

	public void setFAppRegQgtkaoZhengzhi(Integer FAppRegQgtkaoZhengzhi) {
		this.FAppRegQgtkaoZhengzhi = FAppRegQgtkaoZhengzhi;
	}

	public Integer getFAppRegQgtkaoEnglish() {
		return this.FAppRegQgtkaoEnglish;
	}

	public void setFAppRegQgtkaoEnglish(Integer FAppRegQgtkaoEnglish) {
		this.FAppRegQgtkaoEnglish = FAppRegQgtkaoEnglish;
	}

	public Integer getFAppRegQgtkaoZhuanYeKe() {
		return this.FAppRegQgtkaoZhuanYeKe;
	}

	public void setFAppRegQgtkaoZhuanYeKe(Integer FAppRegQgtkaoZhuanYeKe) {
		this.FAppRegQgtkaoZhuanYeKe = FAppRegQgtkaoZhuanYeKe;
	}

	public String getFAppRegCv1() {
		return this.FAppRegCv1;
	}

	public void setFAppRegCv1(String FAppRegCv1) {
		this.FAppRegCv1 = FAppRegCv1;
	}

	public String getFAppRegCv2() {
		return this.FAppRegCv2;
	}

	public void setFAppRegCv2(String FAppRegCv2) {
		this.FAppRegCv2 = FAppRegCv2;
	}

	public String getFAppRegCv3() {
		return this.FAppRegCv3;
	}

	public void setFAppRegCv3(String FAppRegCv3) {
		this.FAppRegCv3 = FAppRegCv3;
	}

	public String getFAppRegCv4() {
		return this.FAppRegCv4;
	}

	public void setFAppRegCv4(String FAppRegCv4) {
		this.FAppRegCv4 = FAppRegCv4;
	}

	public String getFAppRegCv5() {
		return this.FAppRegCv5;
	}

	public void setFAppRegCv5(String FAppRegCv5) {
		this.FAppRegCv5 = FAppRegCv5;
	}

	public String getFAppRegZhunKaoZhengHao() {
		return this.FAppRegZhunKaoZhengHao;
	}

	public void setFAppRegZhunKaoZhengHao(String FAppRegZhunKaoZhengHao) {
		this.FAppRegZhunKaoZhengHao = FAppRegZhunKaoZhengHao;
	}

	public String getFAppRegBackUpChar() {
		return this.FAppRegBackUpChar;
	}

	public void setFAppRegBackUpChar(String FAppRegBackUpChar) {
		this.FAppRegBackUpChar = FAppRegBackUpChar;
	}

	public String getFAppRegBackUpText() {
		return this.FAppRegBackUpText;
	}

	public void setFAppRegBackUpText(String FAppRegBackUpText) {
		this.FAppRegBackUpText = FAppRegBackUpText;
	}

	public Integer getFAppRegBackUpInt() {
		return this.FAppRegBackUpInt;
	}

	public void setFAppRegBackUpInt(Integer FAppRegBackUpInt) {
		this.FAppRegBackUpInt = FAppRegBackUpInt;
	}

	public Set getWsbmTabExamresults() {
		return this.wsbmTabExamresults;
	}

	public void setWsbmTabExamresults(Set wsbmTabExamresults) {
		this.wsbmTabExamresults = wsbmTabExamresults;
	}

	public Set getWsbmTabFinadnots() {
		return this.wsbmTabFinadnots;
	}

	public void setWsbmTabFinadnots(Set wsbmTabFinadnots) {
		this.wsbmTabFinadnots = wsbmTabFinadnots;
	}

	public Set getWsbmTabProgresses() {
		return this.wsbmTabProgresses;
	}

	public void setWsbmTabProgresses(Set wsbmTabProgresses) {
		this.wsbmTabProgresses = wsbmTabProgresses;
	}

	public Set getWsbmTabPreadnots() {
		return this.wsbmTabPreadnots;
	}

	public void setWsbmTabPreadnots(Set wsbmTabPreadnots) {
		this.wsbmTabPreadnots = wsbmTabPreadnots;
	}

}