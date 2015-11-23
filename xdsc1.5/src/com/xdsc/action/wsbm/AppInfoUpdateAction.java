package com.xdsc.action.wsbm;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AppInfoUpdateManager;

/** 考生信息更新
 * @author 苟小龙
 * @version 1.2
 */
public class AppInfoUpdateAction implements SessionAware{
	/**
	 * session 相关属性
	 */
	private Map session;
	/**
	 * 考生对象相关属性
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * service层相关属性
	 */
	private AppInfoUpdateManager appInfoUpdateManager;
	/**
	 * 考生信息相关属性
	 */
	private Date FAppRegBirthday;
	private String FAppRegSex;
	private String FAppRegName;
	private String FAppRegLocation1;
	private String FAppRegLocation2;
	private String FAppRegLocation3;
	private String FAppRegWorkDuty;
	private String FAppRegWorkTitle;
	private String FAppRegTel;
	private String FAppRegEmail;
	private String FAppRegAddress;
	private String FAppRegPostCode;
	private String FAppRegPolitical;
	private String FAppRegLastGraduInstitu;
	private Date FAppRegLastGraduDate;
	private String FAppRegLastGraduMajor;
	private Date FAppRegLastBacheDegreeDate;
	private String FAppRegXueWeiZhengNum;
	private String FAppRegBiYeZhengNum;
	private String FAppRegQgtkaoNum;
	private String FAppRegQgtkao;
	private String FAppRegBackUpText;
	private int FAppRegQGTKaoZhengzhi;
	private int FAppRegQGTKaoEnglish;
	private int FAppRegQGTKaoZhuanYeKe;
	private int FAppRegCet4;
	private int FAppRegCet6;
	private String FAppRegCv;
	private String FAppRegFuDaoBan;
	private String FAppRegZhuanYeKe;
	/**
	 * 返回页面下拉菜单选项相关属性
	 */
	private List<String> listFTypeInfo = new ArrayList<String>();
	/**
	 * 需要更改的考生信息项
	 */
	private String FType;
	/**
	 * 需要更改的值
	 */
	private String Value;
	/**
	 * 考生系统注册号
	 */
	private String Number;
	


	/**跳转到显示考生信息的可编辑表格页面
	 * @return ok 跳转成功
	 */
	public String tiaozhuan(){
		listFTypeInfo.clear();
		wsbmTabRegapplicant = appInfoUpdateManager.findAppByID((String)session.get("userNumber"));

		listFTypeInfo.add("姓名");
		listFTypeInfo.add("性别");
		listFTypeInfo.add("民族");
		listFTypeInfo.add("身份证号");
		listFTypeInfo.add("现工作单位（档案所在地）");
		listFTypeInfo.add("职务");
		listFTypeInfo.add("职称");
		listFTypeInfo.add("联系电话");
		listFTypeInfo.add("电子信箱");
		listFTypeInfo.add("");
		return "ok";
	}
	
	
	/**管理员更新考生验证信息
	 * @return UpdatedAd 更新成功
	 */
	public String adUD(){
		listFTypeInfo.clear();
		wsbmTabRegapplicant = appInfoUpdateManager.findAppByID(Number);
		System.out.println(FType);
		System.out.println(Value);
		
		if (FType.equalsIgnoreCase("资料验证")){
			wsbmTabRegapplicant.setFAppRegPassAuth(Value);
		}
		
		else if(FType.equalsIgnoreCase("预录取结果")){
			System.out.println("Begin");
			wsbmTabRegapplicant.setFAppRegPassPreAd(Value);
		}
		
		else if(FType.equalsIgnoreCase("最终录取结果")){
			wsbmTabRegapplicant.setFAppRegPassFinAd(Value);
		}

		appInfoUpdateManager.updateAppInfo(wsbmTabRegapplicant);

		return "UpdatedAd";
	}

	/**考生更改个人注册信息
	 * @return Updated 修改成功
	 */
	public String execute(){
		
		System.out.println(FType);
		System.out.println(Value);
		
		if (FType.equalsIgnoreCase("性别")){
			wsbmTabRegapplicant.setFAppRegSex(Value);
		}
		
		else if(FType.equalsIgnoreCase("姓名")){
			System.out.println("Begin");
			wsbmTabRegapplicant.setFAppRegName(Value);
		}
		
		else if(FType.equalsIgnoreCase("民族")){
			wsbmTabRegapplicant.setFAppRegNation(Value);
		}
		
		else if(FType.equalsIgnoreCase("身份证号")){
			wsbmTabRegapplicant.setFAppRegIdCard(Value);
		}
		
		else if(FType.equalsIgnoreCase("现工作单位（档案所在地）")){
			wsbmTabRegapplicant.setFAppRegLocation(Value);
		}
		
		else if(FType.equalsIgnoreCase("职务")){
			wsbmTabRegapplicant.setFAppRegWorkDuty(Value);
		}
		
		else if(FType.equalsIgnoreCase("职称")){
			wsbmTabRegapplicant.setFAppRegWorkTitle(Value);
		}	
		
		else if(FType.equalsIgnoreCase("联系电话")){
			wsbmTabRegapplicant.setFAppRegTel(Value);
		}
		
		else if(FType.equalsIgnoreCase("电子信箱")){
			wsbmTabRegapplicant.setFAppRegEmail(Value);
		}
		
		appInfoUpdateManager.updateAppInfo(wsbmTabRegapplicant);

		return "Updated";
	}
	/**完善信息
	 * 
	 * @return reg2 更新成功
	 */
	public String reg2(){
		wsbmTabRegapplicant = appInfoUpdateManager.findAppByID((String)session.get("userNumber"));
		wsbmTabRegapplicant.setFAppRegBirthday(FAppRegBirthday);
		wsbmTabRegapplicant.setFAppRegLocation(FAppRegLocation1+"省"+FAppRegLocation2+"市/县"+FAppRegLocation3);
		
		wsbmTabRegapplicant.setFAppRegWorkDuty(FAppRegWorkDuty);
		wsbmTabRegapplicant.setFAppRegWorkTitle(FAppRegWorkTitle);
		wsbmTabRegapplicant.setFAppRegTel(FAppRegTel);
		
		wsbmTabRegapplicant.setFAppRegEmail(FAppRegEmail);
		
		wsbmTabRegapplicant.setFAppRegAddress(FAppRegAddress);
		
		wsbmTabRegapplicant.setFAppRegPostCode(FAppRegPostCode);
		
		wsbmTabRegapplicant.setFAppRegPolitical(FAppRegPolitical);
		
		appInfoUpdateManager.updateAppInfo(wsbmTabRegapplicant);

		return "reg2";
	}
	/**完善信息
	 * 
	 * @return reg3 更新成功
	 */
	public String reg3(){
		wsbmTabRegapplicant = appInfoUpdateManager.findAppByID((String)session.get("userNumber"));
		
		wsbmTabRegapplicant.setFAppRegLastGraduInstitu(FAppRegLastGraduInstitu);
		
		wsbmTabRegapplicant.setFAppRegLastGraduDate(FAppRegLastGraduDate);
		
		wsbmTabRegapplicant.setFAppRegLastGraduMajor(FAppRegLastGraduMajor);
		
		wsbmTabRegapplicant.setFAppRegLastBacheDegreeDate(FAppRegLastBacheDegreeDate);
		
		wsbmTabRegapplicant.setFAppRegXueWeiZhengNum(FAppRegXueWeiZhengNum);
		
		wsbmTabRegapplicant.setFAppRegBiYeZhengNum(FAppRegBiYeZhengNum);
		
		appInfoUpdateManager.updateAppInfo(wsbmTabRegapplicant);

		return "reg3";
	}
	/**完善信息
	 * 
	 * @return reg4 更新成功
	 */
	public String reg4(){
		wsbmTabRegapplicant = appInfoUpdateManager.findAppByID((String)session.get("userNumber"));
		
		wsbmTabRegapplicant.setFAppRegQgtkaoNum(FAppRegQgtkaoNum);
		
		int a=0;
		
		a=FAppRegQGTKaoZhengzhi+FAppRegQGTKaoEnglish+FAppRegQGTKaoZhuanYeKe;
		
		wsbmTabRegapplicant.setFAppRegQgtkao(FAppRegQgtkao);
		
		wsbmTabRegapplicant.setFAppRegQgtkaoZhengzhi(FAppRegQGTKaoZhengzhi);
		
		wsbmTabRegapplicant.setFAppRegQgtkaoEnglish(FAppRegQGTKaoEnglish);
		
		wsbmTabRegapplicant.setFAppRegQgtkaoZhuanYeKe(FAppRegQGTKaoZhuanYeKe);
		
		wsbmTabRegapplicant.setFAppRegCet4(FAppRegCet4);
		
		wsbmTabRegapplicant.setFAppRegCet6(FAppRegCet6);
		
		wsbmTabRegapplicant.setFAppRegCv(FAppRegCv);

		wsbmTabRegapplicant.setFAppRegBackUpChar("1");
		
		wsbmTabRegapplicant.setFAppRegBackUpText(FAppRegBackUpText);
		
		wsbmTabRegapplicant.setFAppRegFuDaoBan(FAppRegFuDaoBan);
		
		wsbmTabRegapplicant.setFAppRegZhuanYeKe(FAppRegZhuanYeKe);
		
		appInfoUpdateManager.updateAppInfo(wsbmTabRegapplicant);

		return "reg4";
	}
	
	public String getFType() {
		return FType;
	}

	public void setFType(String type) {
		FType = type;
	}
	
	public void setFAppRegName(String appRegName) {
		FAppRegName = appRegName;
	}
	
	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return wsbmTabRegapplicant;
	}
	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}
	public AppInfoUpdateManager getAppInfoUpdateManager() {
		return appInfoUpdateManager;
	}
	public void setAppInfoUpdateManager(AppInfoUpdateManager appInfoUpdateManager) {
		this.appInfoUpdateManager = appInfoUpdateManager;
	}

	public String getFAppRegSex() {
		return FAppRegSex;
	}

	public void setFAppRegSex(String appRegSex) {
		FAppRegSex = appRegSex;
	}

	public String getFAppRegName() {
		return FAppRegName;
	}

	public void setFApRegName(String appRegName) {
		FAppRegName = appRegName;
	}

	public List<String> getListFTypeInfo() {
		return listFTypeInfo;
	}

	public void setListFTypeInfo(List<String> listFTypeInfo) {
		this.listFTypeInfo = listFTypeInfo;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}


	public String getFAppRegLocation1() {
		return FAppRegLocation1;
	}


	public void setFAppRegLocation1(String appRegLocation1) {
		FAppRegLocation1 = appRegLocation1;
	}


	public String getFAppRegLocation2() {
		return FAppRegLocation2;
	}


	public void setFAppRegLocation2(String appRegLocation2) {
		FAppRegLocation2 = appRegLocation2;
	}


	public String getFAppRegLocation3() {
		return FAppRegLocation3;
	}


	public void setFAppRegLocation3(String appRegLocation3) {
		FAppRegLocation3 = appRegLocation3;
	}


	public String getFAppRegWorkDuty() {
		return FAppRegWorkDuty;
	}


	public void setFAppRegWorkDuty(String appRegWorkDuty) {
		FAppRegWorkDuty = appRegWorkDuty;
	}


	public String getFAppRegTel() {
		return FAppRegTel;
	}


	public void setFAppRegTel(String appRegTel) {
		FAppRegTel = appRegTel;
	}


	public String getFAppRegEmail() {
		return FAppRegEmail;
	}


	public void setFAppRegEmail(String appRegEmail) {
		FAppRegEmail = appRegEmail;
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


	public String getFAppRegPolitical() {
		return FAppRegPolitical;
	}


	public void setFAppRegPolitical(String appRegPolitical) {
		FAppRegPolitical = appRegPolitical;
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


	public Date getFAppRegLastGraduDate() {
		return FAppRegLastGraduDate;
	}


	public void setFAppRegLastGraduDate(Date appRegLastGraduDate) {
		FAppRegLastGraduDate = appRegLastGraduDate;
	}


	public Date getFAppRegLastBacheDegreeDate() {
		return FAppRegLastBacheDegreeDate;
	}


	public void setFAppRegLastBacheDegreeDate(Date appRegLastBacheDegreeDate) {
		FAppRegLastBacheDegreeDate = appRegLastBacheDegreeDate;
	}


	public String getFAppRegQgtkaoNum() {
		return FAppRegQgtkaoNum;
	}


	public void setFAppRegQgtkaoNum(String appRegQgtkaoNum) {
		FAppRegQgtkaoNum = appRegQgtkaoNum;
	}


	public String getFAppRegQgtkao() {
		return FAppRegQgtkao;
	}


	public void setFAppRegQgtkao(String appRegQgtkao) {
		FAppRegQgtkao = appRegQgtkao;
	}


	public int getFAppRegQGTKaoZhengzhi() {
		return FAppRegQGTKaoZhengzhi;
	}


	public void setFAppRegQGTKaoZhengzhi(int appRegQGTKaoZhengzhi) {
		FAppRegQGTKaoZhengzhi = appRegQGTKaoZhengzhi;
	}


	public int getFAppRegQGTKaoEnglish() {
		return FAppRegQGTKaoEnglish;
	}


	public void setFAppRegQGTKaoEnglish(int appRegQGTKaoEnglish) {
		FAppRegQGTKaoEnglish = appRegQGTKaoEnglish;
	}


	public int getFAppRegQGTKaoZhuanYeKe() {
		return FAppRegQGTKaoZhuanYeKe;
	}


	public void setFAppRegQGTKaoZhuanYeKe(int appRegQGTKaoZhuanYeKe) {
		FAppRegQGTKaoZhuanYeKe = appRegQGTKaoZhuanYeKe;
	}


	public int getFAppRegCet4() {
		return FAppRegCet4;
	}


	public void setFAppRegCet4(int appRegCet4) {
		FAppRegCet4 = appRegCet4;
	}


	public int getFAppRegCet6() {
		return FAppRegCet6;
	}


	public void setFAppRegCet6(int appRegCet6) {
		FAppRegCet6 = appRegCet6;
	}


	public String getFAppRegCv() {
		return FAppRegCv;
	}


	public void setFAppRegCv(String appRegCv) {
		FAppRegCv = appRegCv;
	}


	public String getFAppRegBackUpText() {
		return FAppRegBackUpText;
	}


	public void setFAppRegBackUpText(String appRegBackUpText) {
		FAppRegBackUpText = appRegBackUpText;
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


	public Date getFAppRegBirthday() {
		return FAppRegBirthday;
	}


	public void setFAppRegBirthday(Date appRegBirthday) {
		FAppRegBirthday = appRegBirthday;
	}


	public String getFAppRegWorkTitle() {
		return FAppRegWorkTitle;
	}


	public void setFAppRegWorkTitle(String appRegWorkTitle) {
		FAppRegWorkTitle = appRegWorkTitle;
	}
}
