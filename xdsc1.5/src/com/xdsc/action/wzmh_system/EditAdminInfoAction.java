package com.xdsc.action.wzmh_system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.check.PhoneCheck;
import com.xdsc.dao.wzmh_system.impl.AdminInfoDAOImpl;
import com.xdsc.model.TabAdministrator;
import com.xdsc.wzmh_system.util.AItem;
/**
 * 编辑管理员基本信息
 * @author 陈丰
 */
public class EditAdminInfoAction extends ActionSupport{
	private String Name;
	private String Sex;
	private String Age;
	private String Boss;
	private String Telephone;
	private String EmailAddress;
	private AdminInfoDAOImpl  adminInfoDAO;

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
	public String getBoss() {
		return Boss;
	}
	public void setBoss(String boss) {
		Boss = boss;
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
	public AdminInfoDAOImpl getAdminInfoDAO() {
		return adminInfoDAO;
	}
	public void setAdminInfoDAO(AdminInfoDAOImpl adminInfoDAO) {
		this.adminInfoDAO = adminInfoDAO;
	}
	/**
	 * 验证电话号码合法性
	 * @param 电话号码
	 * @return 结果验证
	 */
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
	
	
	
	/**
	 * 更新管理员基本信息
	 * @return 更新结果
	 */
	public String updateAdmin(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String id = session.getAttribute("FUserNumber").toString();
		boolean flag =false;
	
		TabAdministrator admin=adminInfoDAO.findAdminByNum(id);
        if(admin==null)
        {
        	admin = new TabAdministrator();
        	admin.setFAdminNumber(id);
        	flag = true;
        }
		AppException.clear();
		
		
		if(!checkEmail(EmailAddress))
		{
			new AppException("邮件格式错误");
			return ERROR;
		}
		
		if(phoneValidation(Telephone)){
		admin.setFName(Name);
		admin.setFSex(Sex);
		admin.setFBoss(Boss);
		admin.setFTelephone(Telephone);
		admin.setFEmailAddress(EmailAddress);
		if(flag){
			adminInfoDAO.insertAdminInfo(admin);
		}
		else{
		adminInfoDAO.updateAdminInfo(admin);
		}
		return SUCCESS;
		}
		else
			return ERROR;
	}
}
