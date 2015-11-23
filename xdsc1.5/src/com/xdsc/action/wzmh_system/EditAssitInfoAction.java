package com.xdsc.action.wzmh_system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.check.PhoneCheck;
import com.xdsc.dao.wzmh_system.impl.AssitInfoDAOImpl;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.wzmh_system.util.AItem;

/**
 * 更新
 * @author Administrator
 *
 */
public class EditAssitInfoAction extends ActionSupport{
private String Name;
private String Sex;
private String Age;
private String Telephone;
private String EmailAddress;
private AssitInfoDAOImpl assitInfoDAO;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSex() {
	return Sex;
}
public void setSex(String sex) {
	Sex = sex;
}
public String getAge() {
	return Age;
}
public void setAge(String age) {
	Age = age;
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

public AssitInfoDAOImpl getAssitInfoDAO() {
	return assitInfoDAO;
}
public void setAssitInfoDAO(AssitInfoDAOImpl assitInfoDAO) {
	this.assitInfoDAO = assitInfoDAO;
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

public String updateAssit(){
	HttpSession session=ServletActionContext.getRequest().getSession();
	String id = session.getAttribute("FUserNumber").toString();
	JfptTabOtherassist assist =assitInfoDAO.findAssitByNum(id);
	AppException.clear(); 
	boolean flag =false;
	if(assist==null)
	{
		assist=new JfptTabOtherassist();
		assist.setFAssistantId(id);
		flag = true;
	}
	AppException.clear();
	if(!checkEmail(EmailAddress))
	{
		new AppException("邮件格式错误");
		return ERROR;
	}
	
	if(phoneValidation(Telephone)){
	assist.setFName(Name);
	assist.setFSex(Sex);
	assist.setFAge(Integer.parseInt(Age));
	assist.setFTelephone(Telephone);
	assist.setFEmailAddress(EmailAddress);
	if(flag)
		assitInfoDAO.insertAssitInfo(assist);
	assitInfoDAO.updateAssitInfo(assist);
	return SUCCESS;
	}
	else
		return ERROR;
}
}
