package com.xdsc.action.bksx_system;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.LoginManager;
import com.xdsc.service.bksx_system.TabAdministratorManager;
import com.xdsc.service.bksx_system.TabStudentsManager;
import com.xdsc.service.bksx_system.TabTeachersManager;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginManager loginManager;
	private TabStudentsManager tabStudentsManager;
	private TabTeachersManager tabTeachersManager;
	private TabAdministratorManager tabAdministratorManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	private String username;
	private String password;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginManager getLoginManager() {
		return loginManager;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

	public TabTeachersManager getTabTeachersManager() {
		return tabTeachersManager;
	}

	public void setTabTeachersManager(TabTeachersManager tabTeachersManager) {
		this.tabTeachersManager = tabTeachersManager;
	}

	public TabAdministratorManager getTabAdministratorManager() {
		return tabAdministratorManager;
	}

	public void setTabAdministratorManager(
			TabAdministratorManager tabAdministratorManager) {
		this.tabAdministratorManager = tabAdministratorManager;
	}

	public String userLogin() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		// username = (String) session.get("FUserNumber");
		// password = (String) session.get("FUserPassword");
		// role = (String) session.get("type");

		if (role.equals("student")) {
			if (loginManager.userLogin(username, password)) {
				if (loginManager.studentConfirm(username)) {
					session.put("student", tabStudentsManager
							.getStudentById(username));
					session.put("role", "STUDENT");
					session.put("name", tabStudentsManager.getStudentById(
							username).getFStudentName());
					BksxTabSubstugui substugui = bksxTabSubstuguiManager
							.getSubstuguiByStuNum(username);
					if (substugui != null) {
						BksxTabProject project = substugui.getBksxTabProject();
						if (project != null)
							session.put("subject", "project");
						else
							session.put("subject", "reaserch");
					} else {
						session.put("showAvaliable", "Y");
					}
					return "studentLogin";
				}
			}
		} else if (role.equals("teacher")) {
			if (loginManager.userLogin(username, password)) {
				if (loginManager.teacherConfirm(username)) {
					session.put("teacher", tabTeachersManager
							.getTeacherById(username));
					session.put("role", "TEACHER");
					session.put("name", tabTeachersManager.getTeacherById(
							username).getFTeacherName());
					return "teacherLogin";
				}
			}
		} else if (role.equals("manager")) {
			if (loginManager.userLogin(username, password)) {
				if (loginManager.adminConfirm(username)) {
					session.put("role", "ADMIN");
					session.put("name", tabAdministratorManager.getAdminById(
							username).getFName());
					return "managerLogin";
				}
			}
		}
		return ERROR;
	}
}
