package com.xdsc.action.wsbm;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.mail_system.MailServer;
import com.xdsc.service.wsbm.AdAllCheckManager;
import com.xdsc.service.wsbm.RegAppliManager;

public class RegisterAction extends ActionSupport {
	private String FUserNumber;
	private String FUserPassword;
	private String FAppRegName;
	private String FAppRegSex;
	private String FAppRegHomeTown;
	private String FAppRegLocation;
	private Date FAppRegBirthday;
	private String FAppRegNation;
	private String FAppRegIdCard;
	private RegAppliManager raml;
	private AdAllCheckManager aacm;

	public AdAllCheckManager getAacm() {
		return aacm;
	}

	public void setAacm(AdAllCheckManager aacm) {
		this.aacm = aacm;
	}

	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Date a=new Date();
		WsbmTabRegapplicant wtr=new WsbmTabRegapplicant();
		MhqxTabUser f=new MhqxTabUser();
		MhqxTabUser mtu = new MhqxTabUser();
		
		
		if(session.getAttribute("FUserNumber")!=null)
		return SUCCESS;
		
		
		f=aacm.sepFindByNumInUser(FUserNumber);
		if(f==null){
		//	System.out.println("GGGGGGOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!");
			mtu.setFUserNumber(FUserNumber);
			mtu.setFUserPassword(FUserPassword);
			wtr.setFAppRegNum(mtu.getFUserNumber());
			wtr.setFAppRegName(FAppRegName);
			wtr.setFAppRegSex(FAppRegSex);
			wtr.setFAppRegHomeTown(FAppRegHomeTown);
			wtr.setFAppRegLocation("0");
			wtr.setFAppRegBirthday(a);
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
			
			//*****************
//			//向邮件服务器注册新用户
//			MailServer mailServer = new MailServer();
//			mailServer.addUser(mtu.getFUserNumber(), mtu.getFUserPassword());
			//******************
			
			raml.addRegAppli(wtr);
			
			
			
			
			session.setAttribute("userNumber", FUserNumber);
			session.setAttribute("FUserNumber", FUserNumber);
			session.setAttribute("password", FUserPassword);
			
			return SUCCESS;
			
		}
		else{
		//	System.out.println("YouLa@@@@@@@@@@@@@@@@@@@@@@@@@@@@!!!Youla!");
			return "youla";
		}
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public String getFUserPassword() {
		return FUserPassword;
	}

	public void setFUserPassword(String userPassword) {
		FUserPassword = userPassword;
	}

	public String getFAppRegName() {
		return FAppRegName;
	}

	public void setFAppRegName(String appRegName) {
		FAppRegName = appRegName;
	}

	public String getFAppRegSex() {
		return FAppRegSex;
	}

	public void setFAppRegSex(String appRegSex) {
		FAppRegSex = appRegSex;
	}

	public String getFAppRegHomeTown() {
		return FAppRegHomeTown;
	}

	public void setFAppRegHomeTown(String appRegHomeTown) {
		FAppRegHomeTown = appRegHomeTown;
	}

	public String getFAppRegLocation() {
		return FAppRegLocation;
	}

	public void setFAppRegLocation(String appRegLocation) {
		FAppRegLocation = appRegLocation;
	}

	public Date getFAppRegBirthday() {
		return FAppRegBirthday;
	}

	public void setFAppRegBirthday(Date appRegBirthday) {
		FAppRegBirthday = appRegBirthday;
	}

	public String getFAppRegNation() {
		return FAppRegNation;
	}

	public void setFAppRegNation(String appRegNation) {
		FAppRegNation = appRegNation;
	}

	public String getFAppRegIdCard() {
		return FAppRegIdCard;
	}

	public void setFAppRegIdCard(String appRegIdCard) {
		FAppRegIdCard = appRegIdCard;
	}

	public RegAppliManager getRaml() {
		return raml;
	}

	public void setRaml(RegAppliManager raml) {
		this.raml = raml;
	}

}
