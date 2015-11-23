package com.xdsc.action.wzmh_system;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
/**
 * ĞŞ¸ÄÃÜÂë
 * @author ³Â·á
 *
 */
public class ChangePasswordAction extends ActionSupport{
/**¾ÉÃÜÂë*/
private String oldpassword;
/**ĞÂÃÜÂë*/
private String password;

private MhqxTabUserManager usermanager;

public MhqxTabUserManager getUsermanager() {
	return usermanager;
}
public void setUsermanager(MhqxTabUserManager usermanager) {
	this.usermanager = usermanager;
}
public String getOldpassword() {
	return oldpassword;
}
public void setOldpassword(String oldpassword) {
	this.oldpassword = oldpassword;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

/**
 * ĞŞ¸ÄÃÜÂë
 * @return ĞŞ¸Ä½á¹û
 */
public String changePassword(){
	AppException.clear();  
	HttpSession session=ServletActionContext.getRequest().getSession();
	String id = session.getAttribute("FUserNumber").toString();
	if(usermanager.findById(id).get(0).getFUserPassword().equals(oldpassword)){
		MhqxTabUser user=usermanager.findById(id).get(0);
		user.setFUserPassword(password);
		usermanager.update(user);
		return SUCCESS;
	}
	else{
		new AppException("ÃÜÂë´íÎó");
		return ERROR;
	}
	
} 
}
