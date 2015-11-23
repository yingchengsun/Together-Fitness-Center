package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.xsgl_system.LoginManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;
import com.xdsc.service.xsgl_system.XsglTabParentsManager;

public class LoginAction extends ActionSupport {
	private LoginManager loginManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabTeachersManager xsglTabTeachersManager;
	private XsglTabParentsManager xsglTabParentsManager;

	private String FUserNumber;
	private String FUserPassword;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginManager getLoginManager() {
		return loginManager;
	}


	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}



	public XsglTabTeachersManager getXsglTabTeachersManager() {
		return xsglTabTeachersManager;
	}

	public void setXsglTabTeachersManager(
			XsglTabTeachersManager xsglTabTeachersManager) {
		this.xsglTabTeachersManager = xsglTabTeachersManager;
	}

	public String userLogin() {
		Map session = ActionContext.getContext().getSession();
		
		 if (role.equals("teacher")) {
			if (loginManager.userLogin(FUserNumber, FUserPassword)) {
				if (loginManager.teacherConfirm(FUserNumber)) {
					session.put("teacher", xsglTabTeachersManager.getTeacherByTeaNum(FUserNumber).get(0));
					session.put("role", "TEACHER");
					return "teacherLogin";
				}
			}
		}else if(role.equals("parent")){
			if(loginManager.userLogin(FUserNumber, FUserPassword)){
				if(loginManager.parentConfirm(FUserNumber)){
					session.put("parent", xsglTabParentsManager.getParentById(FUserNumber));
					session.put("role", "PARENT");
					return "parentLogin";
				}
			}
		} else if (role.equals("manager")) {
			if (loginManager.userLogin(FUserNumber, FUserPassword)) {
				session.put("role", "ADMIN");
				return "managerLogin";
			}
		} 
		return ERROR;
	}

	public XsglTabParentsManager getXsglTabParentsManager() {
		return xsglTabParentsManager;
	}

	public void setXsglTabParentsManager(XsglTabParentsManager xsglTabParentsManager) {
		this.xsglTabParentsManager = xsglTabParentsManager;
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
}
