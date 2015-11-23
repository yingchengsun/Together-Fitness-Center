package com.xdsc.action.wzmh_system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.check.PhoneCheck;
import com.xdsc.dao.yjssx_system.impl.CompanyInfoDaoImpl;
import com.xdsc.model.TabCompany;
import com.xdsc.wzmh_system.util.AItem;
/**
 * 更新
 * @author Administrator
 *
 */
public class EditCompanyInfoAction extends ActionSupport{
	private String CompanyNumber;
	private String CompanyName;
	private String ConnectPerson;
	private String Telephone;
	private String EmailAddress;
	private String CooperateInfo;
	private String Address;
	private String Information;
private CompanyInfoDaoImpl companyInfoDao;
public String getCompanyNumber() {
	return CompanyNumber;
}
public void setCompanyNumber(String companyNumber) {
	CompanyNumber = companyNumber;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}
public String getConnectPerson() {
	return ConnectPerson;
}
public void setConnectPerson(String connectPerson) {
	ConnectPerson = connectPerson;
}
public String getTelephone() {
	return Telephone;
}
public void setTelephone(String telephone) {
	Telephone = telephone;
}
public String getEmailAddress() {
	return EmailAddress;
}
public void setEmailAddress(String emailAddress) {
	EmailAddress = emailAddress;
}
public String getCooperateInfo() {
	return CooperateInfo;
}
public void setCooperateInfo(String cooperateInfo) {
	CooperateInfo = cooperateInfo;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getInformation() {
	return Information;
}
public void setInformation(String information) {
	Information = information;
}
public CompanyInfoDaoImpl getCompanyInfoDao() {
	return companyInfoDao;
}
public void setCompanyInfoDao(CompanyInfoDaoImpl companyInfoDao) {
	this.companyInfoDao = companyInfoDao;
}


public boolean phoneValidation(String tel)
{	
	boolean flag=true;
	if(tel!=null&&tel!="")
		if(!PhoneCheck.phoneCheck(tel))
			flag= false;
	return flag;
}
public boolean checkEmail(String mail){   
	if(mail==null||mail.equals(""))
		return true;
    String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";   
    Pattern   p   =   Pattern.compile(regex);   
    Matcher   m   =   p.matcher(mail);   
    return m.find();   
}  
public String updateCompany(){
	HttpSession session=ServletActionContext.getRequest().getSession();
	String id = session.getAttribute("FUserNumber").toString();
	TabCompany company = companyInfoDao.findCompanyByNum(id);
	boolean flag = false;
	if(company==null)
	{
		company = new TabCompany();
		company.setFCompanyNumber(id);
		flag = true;
	}
	AppException.clear();
	if(!checkEmail(EmailAddress))
	{
		new AppException("邮件格式错误");
		return ERROR;
	}
	if(phoneValidation(Telephone)){
	company.setFCompanyName(CompanyName);
	company.setFConnectPerson(ConnectPerson);
	company.setFTelephone(Telephone);
	company.setFEmailAddress(EmailAddress);
	company.setFCooperateInfo(CooperateInfo);
	company.setFAddress(Address);
	//company.setFInformation(Information);
	if(flag)
	companyInfoDao.addCompanyInfo(company);
	companyInfoDao.updateCompanyInfo(company);
	return SUCCESS;
	}
	else
		return ERROR;
}
}
