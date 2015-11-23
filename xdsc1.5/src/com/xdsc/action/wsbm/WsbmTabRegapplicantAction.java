package com.xdsc.action.wsbm;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.RegAppliManager;


/**游客注册系统账号
 * @author 苟小龙
 * @version 1.2
 */
public class WsbmTabRegapplicantAction extends ActionSupport{

	/**
	 * 考生个人信息相关属性
	 */
	private String FAppRegName;
	private String FAppRegNum;
	private String FUserNumber;
	private String FUserPassword;
	private String FAppRegSex;//
	private Date FAppRegBirthday;//
	private String FAppRegIdCard;//
	private String FAppRegPolitical;//
	private String FAppRegLocation;//
	private String FAppRegWorkDuty;//
	private String FAppRegWorkTitle;//
	private String FAppRegTel;//
	private String FAppRegAddress;//
	private String FAppRegPostCode;//
	private Date FAppRegLastGraduDate;//
	private String FAppRegLastGraduInstitu;//
	private String FAppRegLastGraduMajor;//
	private Date FAppRegLastBacheDegreeDate;//
	private String FAppRegXueWeiZhengNum;//
	private String FAppRegBiYeZhengNum;//
	private String FAppRegEmail;//
	private Integer FAppRegCet4;
	private Integer FAppRegCet6;
	private String FAppRegNation;//
	private String FAppRegQgtkao;//
	private String FAppRegCv;//
	private String FAppRegHomeTown;//
	private String FAppRegPassPreAd;
	private String FAppRegPassFinAd;
	private String FAppRegPassAuth;
	private String FAppRegQgtkaoNum;
	
	private String FAppRegBaoMingFei;
	private String FAppRegFuDaoBan;
	private String FAppRegZhuanYeKe;
	private int FAppRegQgtkaoZhengzhi;
	private int FAppRegQgtkaoEnglish;
	private int FAppRegQgtkaoZhuanYeKe;
	private String FAppRegCv1;
	private String FAppRegCv2;
	private String FAppRegCv3;
	private String FAppRegCv4;
	private String FAppRegCv5;
	private String FAppRegZhunKaoZhengHao;
	private String FAppRegBackUpChar;
	private String FAppRegBackUpText;
	private int FAppRegBackUpInt;
	
	/**
	 * 暂时储存考生个人信息相关属性
	 */
	private String AppRegName;
	private String UserNumber;
	private String UserPassword;
	private String AppRegSex;//
	private Date AppRegBirthday;//
	private String AppRegIdCard;//
	private String AppRegPolitical;//
	private String AppRegLocation;//
	private String AppRegWorkDuty;//
	private String AppRegWorkTitle;//
	private String AppRegTel;//
	private String AppRegAddress;//
	private String AppRegPostCode;//
	private Date AppRegLastGraduDate;//
	private String AppRegLastGraduInstitu;//
	private String AppRegLastGraduMajor;//
	private Date AppRegLastBacheDegreeDate;//
	private String AppRegXueWeiZhengNum;//
	private String AppRegBiYeZhengNum;//
	private String AppRegEmail;//
	private Integer AppRegCet4;
	private Integer AppRegCet6;
	private String AppRegNation;//
	private String AppRegQgtkao;//
	private String AppRegCv;//
	private String AppRegHomeTown;//
	private String AppRegQgtkaoNum;
	
	/**
	 * 注册考生账号service层对象
	 */
	private RegAppliManager raml;
	public WsbmTabRegapplicantAction() {
		super();
	}
	
	public String getFAppRegName() {
		return FAppRegName;
	}

	public void setFAppRegName(String appRegName) {
		FAppRegName = appRegName;
	}
	
	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public RegAppliManager getRaml() {
		return raml;
	}

	public void setRaml(RegAppliManager raml) {
		this.raml = raml;
	}
	
	/**获得考生个人基本信息并暂时储存
	 * @return valuesGot1 获得值
	 */
	public String getvalue1()
	{
		FAppRegName=AppRegName;
		FAppRegSex=AppRegSex;
		FAppRegBirthday=AppRegBirthday;
		FAppRegNation=AppRegNation;
		FAppRegHomeTown=AppRegHomeTown;
		FAppRegIdCard=AppRegIdCard;
		FUserNumber=UserNumber;
		FUserPassword=UserPassword;
		return "valuesGot1";
	}
	/**获得考生工作信息
	 * @return valuesGot2 获值成功
	 */
	public String getvalue2()
	{
		FAppRegLocation=AppRegLocation;
		FAppRegWorkDuty=AppRegWorkDuty;
		FAppRegWorkTitle=AppRegWorkTitle;
		FAppRegTel=AppRegTel;
		FAppRegEmail=AppRegEmail;
		FAppRegAddress=AppRegAddress;
		FAppRegPostCode=AppRegPostCode;
		FAppRegPolitical=AppRegPolitical;
		return "valuesGot2";
	}
	/** 获得考生学历信息
	 * @return valuesGot3 获值成功
	 */
	public String getvalue3()
	{
		FAppRegLastGraduInstitu=AppRegLastGraduInstitu;
		FAppRegLastGraduDate=AppRegLastGraduDate;
		FAppRegLastGraduMajor=AppRegLastGraduMajor;
		FAppRegLastBacheDegreeDate=AppRegLastBacheDegreeDate;
		FAppRegXueWeiZhengNum=AppRegXueWeiZhengNum;
		FAppRegBiYeZhengNum=AppRegBiYeZhengNum;
		return "valuesGot3";
	}
	/** 获得考生考试信息并调用将考生所有个人信息写入数据库的函数
	 * @return valuesGot4 储存成功
	 */
	public String getvalue4()
	{
		FAppRegQgtkaoNum=AppRegQgtkaoNum;
		FAppRegQgtkao=AppRegQgtkao;
		FAppRegCet4=AppRegCet4;
		FAppRegCet6=AppRegCet6;
		FAppRegCv=AppRegCv;
		execute();
		return "valuesGot4";
	}
	
	/**注册帐号
	 * 
	 * @return register 注册成功
	 */
	public String register(){
		Date a=new Date();
		WsbmTabRegapplicant wtr=new WsbmTabRegapplicant();
		MhqxTabUser mtu = new MhqxTabUser();
		mtu.setFUserNumber(FUserNumber);
		mtu.setFUserPassword(FUserPassword);
		wtr.setFAppRegNum(mtu.getFUserNumber());
		wtr.setFAppRegName(FAppRegName);
		wtr.setFAppRegSex(FAppRegSex);
		wtr.setFAppRegHomeTown(FAppRegHomeTown);
		wtr.setFAppRegLocation(FAppRegLocation);
		wtr.setFAppRegBirthday(FAppRegBirthday);
		wtr.setFAppRegNation(FAppRegNation);
		wtr.setFAppRegIdCard(FAppRegIdCard);
		
		wtr.setFAppRegAddress("0");
		wtr.setFAppRegBiYeZhengNum("0");
		wtr.setFAppRegCet4(0);
		wtr.setFAppRegCet6(0);
		wtr.setFAppRegCv("0");
		wtr.setFAppRegEmail("0");
		wtr.setFAppRegLastBacheDegreeDate(a);
		wtr.setFAppRegLastGraduDate(a);
		wtr.setFAppRegLastGraduInstitu("0");
		wtr.setFAppRegLastGraduMajor("0");
		wtr.setFAppRegLocation("0");
		wtr.setFAppRegPolitical("0");
		wtr.setFAppRegPostCode("0");
		wtr.setFAppRegQgtkao("0");
		wtr.setFAppRegQgtkaoNum("0");
		wtr.setFAppRegTel("0");
		wtr.setFAppRegWorkDuty("0");
		wtr.setFAppRegWorkTitle("0");
		wtr.setFAppRegLocation("0");
		wtr.setFAppRegXueWeiZhengNum("0");
		wtr.setFAppRegPassAuth("N");
		wtr.setFAppRegPassPreAd("N");
		wtr.setFAppRegPassFinAd("N");
		
		wtr.setFAppRegBaoMingFei("N");
		wtr.setFAppRegFuDaoBan("N");
		wtr.setFAppRegZhuanYeKe("0");
		wtr.setFAppRegQgtkaoZhengzhi(0);
		wtr.setFAppRegQgtkaoEnglish(0);
		wtr.setFAppRegQgtkaoZhuanYeKe(0);
		wtr.setFAppRegCv1("0");
		wtr.setFAppRegCv2("0");
		wtr.setFAppRegCv3("0");
		wtr.setFAppRegCv4("0");
		wtr.setFAppRegCv5("0");
		wtr.setFAppRegZhunKaoZhengHao("0");
		wtr.setFAppRegBackUpChar("0");
		wtr.setFAppRegBackUpText("0");
		wtr.setFAppRegBackUpInt(0);

		raml.addRegAppli(mtu);
		raml.addRegAppli(wtr);
		return "register";
	}

	/** 将考生所有个人信息写入数据库
	 * @return success 成功写入
	 * @Input 输入数据出错
	 */
	public String execute(){
		try {
			WsbmTabRegapplicant wtr=new WsbmTabRegapplicant();
			MhqxTabUser mtu = new MhqxTabUser();
			//FAppRegNum = UUID.randomUUID().toString();
			mtu.setFUserNumber(FUserNumber);
			mtu.setFUserPassword(FUserPassword);
			wtr.setFAppRegNum(mtu.getFUserNumber());
			wtr.setFAppRegName(FAppRegName);
			wtr.setFAppRegAddress(FAppRegAddress);
			wtr.setFAppRegBirthday(FAppRegBirthday);
			wtr.setFAppRegBiYeZhengNum(FAppRegBiYeZhengNum);
			wtr.setFAppRegCet4(FAppRegCet4);
			wtr.setFAppRegCet6(FAppRegCet6);
			wtr.setFAppRegCv(FAppRegCv);
			wtr.setFAppRegEmail(FAppRegEmail);
			wtr.setFAppRegIdCard(FAppRegIdCard);
			wtr.setFAppRegLastBacheDegreeDate(FAppRegLastBacheDegreeDate);
			wtr.setFAppRegLastGraduDate(FAppRegLastGraduDate);
			wtr.setFAppRegLastGraduInstitu(FAppRegLastGraduInstitu);
			wtr.setFAppRegLastGraduMajor(FAppRegLastGraduMajor);
			wtr.setFAppRegLocation(FAppRegLocation);
			wtr.setFAppRegNation(FAppRegNation);
			wtr.setFAppRegPolitical(FAppRegPolitical);
			wtr.setFAppRegPostCode(FAppRegPostCode);
			wtr.setFAppRegQgtkao(FAppRegQgtkao);
			wtr.setFAppRegQgtkaoNum(FAppRegQgtkaoNum);
			wtr.setFAppRegSex(FAppRegSex);
			wtr.setFAppRegTel(FAppRegTel);
			wtr.setFAppRegWorkDuty(FAppRegWorkDuty);
			wtr.setFAppRegWorkTitle(FAppRegWorkTitle);
			wtr.setFAppRegHomeTown(FAppRegHomeTown);
			wtr.setFAppRegXueWeiZhengNum(FAppRegXueWeiZhengNum);
			wtr.setFAppRegPassAuth("N");
			wtr.setFAppRegPassPreAd("N");
			wtr.setFAppRegPassFinAd("N");
			wtr.setFAppRegBackUpChar("1");
			wtr.setFAppRegCv1("0");
			wtr.setFAppRegCv2("0");
			wtr.setFAppRegCv3("0");
			wtr.setFAppRegCv4("0");
			wtr.setFAppRegCv5("0");
			wtr.setFAppRegZhunKaoZhengHao("0");
			wtr.setFAppRegBackUpChar("0");
			wtr.setFAppRegBackUpText("0");
			wtr.setFAppRegBackUpInt(0);
			wtr.setFAppRegBaoMingFei("N");
			wtr.setFAppRegFuDaoBan("N");
			wtr.setFAppRegZhuanYeKe("0");
			wtr.setFAppRegQgtkaoZhengzhi(0);
			wtr.setFAppRegQgtkaoEnglish(0);
			wtr.setFAppRegQgtkaoZhuanYeKe(0);
			System.out.println("*****************************2");
			raml.addRegAppli(mtu);
			raml.addRegAppli(wtr);
			System.out.println("*****************************3");
			return "success";
		} catch (Exception e) {
			return INPUT;
		}
	}



	public String getFUserPassword() {
		return FUserPassword;
	}

	public void setFUserPassword(String userPassword) {
		FUserPassword = userPassword;
	}

	public String getFAppRegNum() {
		return FAppRegNum;
	}

	public void setFAppRegNum(String appRegNum) {
		FAppRegNum = appRegNum;
	}

	public String getFAppRegSex() {
		return FAppRegSex;
	}

	public void setFAppRegSex(String appRegSex) {
		FAppRegSex = appRegSex;
	}

	public Date getFAppRegBirthday() {
		return FAppRegBirthday;
	}

	public void setFAppRegBirthday(Date appRegBirthday) {
		FAppRegBirthday = appRegBirthday;
	}

	public String getFAppRegIdCard() {
		return FAppRegIdCard;
	}

	public void setFAppRegIdCard(String appRegIdCard) {
		FAppRegIdCard = appRegIdCard;
	}

	public String getFAppRegPolitical() {
		return FAppRegPolitical;
	}

	public void setFAppRegPolitical(String appRegPolitical) {
		FAppRegPolitical = appRegPolitical;
	}

	public String getFAppRegLocation() {
		return FAppRegLocation;
	}

	public void setFAppRegLocation(String appRegLocation) {
		FAppRegLocation = appRegLocation;
	}

	public String getFAppRegWorkDuty() {
		return FAppRegWorkDuty;
	}

	public void setFAppRegWorkDuty(String appRegWorkDuty) {
		FAppRegWorkDuty = appRegWorkDuty;
	}

	public String getFAppRegWorkTitle() {
		return FAppRegWorkTitle;
	}

	public void setFAppRegWorkTitle(String appRegWorkTitle) {
		FAppRegWorkTitle = appRegWorkTitle;
	}

	public String getFAppRegTel() {
		return FAppRegTel;
	}

	public void setFAppRegTel(String appRegTel) {
		FAppRegTel = appRegTel;
	}

	public String getFAppRegAddress() {
		return FAppRegAddress;
	}

	public void setFAppRegAddress(String appRegAddress) {
		FAppRegAddress = appRegAddress;
	}

	public String getFAppRegPostCode() {
		return FAppRegPostCode;
	}

	public void setFAppRegPostCode(String appRegPostCode) {
		FAppRegPostCode = appRegPostCode;
	}

	public Date getFAppRegLastGraduDate() {
		return FAppRegLastGraduDate;
	}

	public void setFAppRegLastGraduDate(Date appRegLastGraduDate) {
		FAppRegLastGraduDate = appRegLastGraduDate;
	}

	public String getFAppRegLastGraduInstitu() {
		return FAppRegLastGraduInstitu;
	}

	public void setFAppRegLastGraduInstitu(String appRegLastGraduInstitu) {
		FAppRegLastGraduInstitu = appRegLastGraduInstitu;
	}

	public String getFAppRegLastGraduMajor() {
		return FAppRegLastGraduMajor;
	}

	public void setFAppRegLastGraduMajor(String appRegLastGraduMajor) {
		FAppRegLastGraduMajor = appRegLastGraduMajor;
	}

	public Date getFAppRegLastBacheDegreeDate() {
		return FAppRegLastBacheDegreeDate;
	}

	public void setFAppRegLastBacheDegreeDate(Date appRegLastBacheDegreeDate) {
		FAppRegLastBacheDegreeDate = appRegLastBacheDegreeDate;
	}

	public String getFAppRegXueWeiZhengNum() {
		return FAppRegXueWeiZhengNum;
	}

	public void setFAppRegXueWeiZhengNum(String appRegXueWeiZhengNum) {
		FAppRegXueWeiZhengNum = appRegXueWeiZhengNum;
	}

	public String getFAppRegBiYeZhengNum() {
		return FAppRegBiYeZhengNum;
	}

	public void setFAppRegBiYeZhengNum(String appRegBiYeZhengNum) {
		FAppRegBiYeZhengNum = appRegBiYeZhengNum;
	}

	public String getFAppRegEmail() {
		return FAppRegEmail;
	}

	public void setFAppRegEmail(String appRegEmail) {
		FAppRegEmail = appRegEmail;
	}

	public Integer getFAppRegCet4() {
		return FAppRegCet4;
	}

	public void setFAppRegCet4(Integer appRegCet4) {
		FAppRegCet4 = appRegCet4;
	}

	public Integer getFAppRegCet6() {
		return FAppRegCet6;
	}

	public void setFAppRegCet6(Integer appRegCet6) {
		FAppRegCet6 = appRegCet6;
	}

	public String getFAppRegNation() {
		return FAppRegNation;
	}

	public void setFAppRegNation(String appRegNation) {
		FAppRegNation = appRegNation;
	}

	public String getFAppRegQgtkao() {
		return FAppRegQgtkao;
	}

	public void setFAppRegQgtkao(String appRegQgtkao) {
		FAppRegQgtkao = appRegQgtkao;
	}

	public String getFAppRegCv() {
		return FAppRegCv;
	}

	public void setFAppRegCv(String appRegCv) {
		FAppRegCv = appRegCv;
	}

	public String getFAppRegHomeTown() {
		return FAppRegHomeTown;
	}

	public void setFAppRegHomeTown(String appRegHomeTown) {
		FAppRegHomeTown = appRegHomeTown;
	}

	public String getFAppRegPassPreAd() {
		return FAppRegPassPreAd;
	}

	public void setFAppRegPassPreAd(String appRegPassPreAd) {
		FAppRegPassPreAd = appRegPassPreAd;
	}

	public String getFAppRegPassFinAd() {
		return FAppRegPassFinAd;
	}

	public void setFAppRegPassFinAd(String appRegPassFinAd) {
		FAppRegPassFinAd = appRegPassFinAd;
	}

	public String getFAppRegPassAuth() {
		return FAppRegPassAuth;
	}

	public void setFAppRegPassAuth(String appRegPassAuth) {
		FAppRegPassAuth = appRegPassAuth;
	}

	public String getFAppRegQgtkaoNum() {
		return FAppRegQgtkaoNum;
	}

	public void setFAppRegQgtkaoNum(String appRegQgtkaoNum) {
		FAppRegQgtkaoNum = appRegQgtkaoNum;
	}

	public String getAppRegName() {
		return AppRegName;
	}

	public void setAppRegName(String appRegName) {
		AppRegName = appRegName;
	}

	public String getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getAppRegSex() {
		return AppRegSex;
	}

	public void setAppRegSex(String appRegSex) {
		AppRegSex = appRegSex;
	}

	public Date getAppRegBirthday() {
		return AppRegBirthday;
	}

	public void setAppRegBirthday(Date appRegBirthday) {
		AppRegBirthday = appRegBirthday;
	}

	public String getAppRegIdCard() {
		return AppRegIdCard;
	}

	public void setAppRegIdCard(String appRegIdCard) {
		AppRegIdCard = appRegIdCard;
	}

	public String getAppRegLocation() {
		return AppRegLocation;
	}

	public void setAppRegLocation(String appRegLocation) {
		AppRegLocation = appRegLocation;
	}

	public String getAppRegNation() {
		return AppRegNation;
	}

	public void setAppRegNation(String appRegNation) {
		AppRegNation = appRegNation;
	}

	public String getAppRegPolitical() {
		return AppRegPolitical;
	}

	public void setAppRegPolitical(String appRegPolitical) {
		AppRegPolitical = appRegPolitical;
	}

	public String getAppRegWorkDuty() {
		return AppRegWorkDuty;
	}

	public void setAppRegWorkDuty(String appRegWorkDuty) {
		AppRegWorkDuty = appRegWorkDuty;
	}

	public String getAppRegWorkTitle() {
		return AppRegWorkTitle;
	}

	public void setAppRegWorkTitle(String appRegWorkTitle) {
		AppRegWorkTitle = appRegWorkTitle;
	}

	public String getAppRegTel() {
		return AppRegTel;
	}

	public void setAppRegTel(String appRegTel) {
		AppRegTel = appRegTel;
	}

	public String getAppRegAddress() {
		return AppRegAddress;
	}

	public void setAppRegAddress(String appRegAddress) {
		AppRegAddress = appRegAddress;
	}

	public String getAppRegPostCode() {
		return AppRegPostCode;
	}

	public void setAppRegPostCode(String appRegPostCode) {
		AppRegPostCode = appRegPostCode;
	}

	public Date getAppRegLastGraduDate() {
		return AppRegLastGraduDate;
	}

	public void setAppRegLastGraduDate(Date appRegLastGraduDate) {
		AppRegLastGraduDate = appRegLastGraduDate;
	}

	public String getAppRegLastGraduInstitu() {
		return AppRegLastGraduInstitu;
	}

	public void setAppRegLastGraduInstitu(String appRegLastGraduInstitu) {
		AppRegLastGraduInstitu = appRegLastGraduInstitu;
	}

	public String getAppRegLastGraduMajor() {
		return AppRegLastGraduMajor;
	}

	public void setAppRegLastGraduMajor(String appRegLastGraduMajor) {
		AppRegLastGraduMajor = appRegLastGraduMajor;
	}

	public Date getAppRegLastBacheDegreeDate() {
		return AppRegLastBacheDegreeDate;
	}

	public void setAppRegLastBacheDegreeDate(Date appRegLastBacheDegreeDate) {
		AppRegLastBacheDegreeDate = appRegLastBacheDegreeDate;
	}

	public String getAppRegXueWeiZhengNum() {
		return AppRegXueWeiZhengNum;
	}

	public void setAppRegXueWeiZhengNum(String appRegXueWeiZhengNum) {
		AppRegXueWeiZhengNum = appRegXueWeiZhengNum;
	}

	public String getAppRegBiYeZhengNum() {
		return AppRegBiYeZhengNum;
	}

	public void setAppRegBiYeZhengNum(String appRegBiYeZhengNum) {
		AppRegBiYeZhengNum = appRegBiYeZhengNum;
	}

	public String getAppRegEmail() {
		return AppRegEmail;
	}

	public void setAppRegEmail(String appRegEmail) {
		AppRegEmail = appRegEmail;
	}

	public Integer getAppRegCet4() {
		return AppRegCet4;
	}

	public void setAppRegCet4(Integer appRegCet4) {
		AppRegCet4 = appRegCet4;
	}

	public Integer getAppRegCet6() {
		return AppRegCet6;
	}

	public void setAppRegCet6(Integer appRegCet6) {
		AppRegCet6 = appRegCet6;
	}

	public String getAppRegQgtkao() {
		return AppRegQgtkao;
	}

	public void setAppRegQgtkao(String appRegQgtkao) {
		AppRegQgtkao = appRegQgtkao;
	}

	public String getAppRegCv() {
		return AppRegCv;
	}

	public void setAppRegCv(String appRegCv) {
		AppRegCv = appRegCv;
	}

	public String getAppRegHomeTown() {
		return AppRegHomeTown;
	}

	public void setAppRegHomeTown(String appRegHomeTown) {
		AppRegHomeTown = appRegHomeTown;
	}

	public String getAppRegQgtkaoNum() {
		return AppRegQgtkaoNum;
	}

	public void setAppRegQgtkaoNum(String appRegQgtkaoNum) {
		AppRegQgtkaoNum = appRegQgtkaoNum;
	}

	public String getFAppRegBaoMingFei() {
		return FAppRegBaoMingFei;
	}

	public void setFAppRegBaoMingFei(String appRegBaoMingFei) {
		FAppRegBaoMingFei = appRegBaoMingFei;
	}

	public String getFAppRegFuDaoBan() {
		return FAppRegFuDaoBan;
	}

	public void setFAppRegFuDaoBan(String appRegFuDaoBan) {
		FAppRegFuDaoBan = appRegFuDaoBan;
	}

	public String getFAppRegZhuanYeKe() {
		return FAppRegZhuanYeKe;
	}

	public void setFAppRegZhuanYeKe(String appRegZhuanYeKe) {
		FAppRegZhuanYeKe = appRegZhuanYeKe;
	}

	public int getFAppRegQgtkaoZhengzhi() {
		return FAppRegQgtkaoZhengzhi;
	}

	public void setFAppRegQgtkaoZhengzhi(int appRegQgtkaoZhengzhi) {
		FAppRegQgtkaoZhengzhi = appRegQgtkaoZhengzhi;
	}

	public int getFAppRegQgtkaoEnglish() {
		return FAppRegQgtkaoEnglish;
	}

	public void setFAppRegQgtkaoEnglish(int appRegQgtkaoEnglish) {
		FAppRegQgtkaoEnglish = appRegQgtkaoEnglish;
	}

	public int getFAppRegQgtkaoZhuanYeKe() {
		return FAppRegQgtkaoZhuanYeKe;
	}

	public void setFAppRegQgtkaoZhuanYeKe(int appRegQgtkaoZhuanYeKe) {
		FAppRegQgtkaoZhuanYeKe = appRegQgtkaoZhuanYeKe;
	}

	public String getFAppRegCv1() {
		return FAppRegCv1;
	}

	public void setFAppRegCv1(String appRegCv1) {
		FAppRegCv1 = appRegCv1;
	}

	public String getFAppRegCv2() {
		return FAppRegCv2;
	}

	public void setFAppRegCv2(String appRegCv2) {
		FAppRegCv2 = appRegCv2;
	}

	public String getFAppRegCv3() {
		return FAppRegCv3;
	}

	public void setFAppRegCv3(String appRegCv3) {
		FAppRegCv3 = appRegCv3;
	}

	public String getFAppRegCv4() {
		return FAppRegCv4;
	}

	public void setFAppRegCv4(String appRegCv4) {
		FAppRegCv4 = appRegCv4;
	}

	public String getFAppRegCv5() {
		return FAppRegCv5;
	}

	public void setFAppRegCv5(String appRegCv5) {
		FAppRegCv5 = appRegCv5;
	}

	public String getFAppRegZhunKaoZhengHao() {
		return FAppRegZhunKaoZhengHao;
	}

	public void setFAppRegZhunKaoZhengHao(String appRegZhunKaoZhengHao) {
		FAppRegZhunKaoZhengHao = appRegZhunKaoZhengHao;
	}

	public String getFAppRegBackUpChar() {
		return FAppRegBackUpChar;
	}

	public void setFAppRegBackUpChar(String appRegBackUpChar) {
		FAppRegBackUpChar = appRegBackUpChar;
	}

	public String getFAppRegBackUpText() {
		return FAppRegBackUpText;
	}

	public void setFAppRegBackUpText(String appRegBackUpText) {
		FAppRegBackUpText = appRegBackUpText;
	}

	public int getFAppRegBackUpInt() {
		return FAppRegBackUpInt;
	}

	public void setFAppRegBackUpInt(int appRegBackUpInt) {
		FAppRegBackUpInt = appRegBackUpInt;
	}



}
