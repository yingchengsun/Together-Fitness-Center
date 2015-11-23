package com.xdsc.action.wzmh_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.dao.wzmh_system.EntityDAO;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
import com.xdsc.service.wzmh_system.EditRoleInfoManage;
import com.xdsc.service.wzmh_system.RoleInfoManager;
import com.xdsc.service.wzmh_system.StudentManager;
import com.xdsc.service.wzmh_system.TeacherManager;

/**
 * 显示个人信息
 * @author 陈丰
 *
 */
public class ShowPIAction extends ActionSupport implements SessionAware {

	private RoleInfoManager roleInfoManager;
	private MhqxTabRoleUserManager roleusermanager;
	private EditRoleInfoManage editRoleInfomanager;

	public EditRoleInfoManage getEditRoleInfomanager() {
		return editRoleInfomanager;
	}


	public void setEditRoleInfomanager(EditRoleInfoManage editRoleInfomanager) {
		this.editRoleInfomanager = editRoleInfomanager;
	}


	public RoleInfoManager getRoleInfoManager() {
		return roleInfoManager;
	}


	public void setRoleInfoManager(RoleInfoManager roleInfoManager) {
		this.roleInfoManager = roleInfoManager;
	}


	public MhqxTabRoleUserManager getRoleusermanager() {
		return roleusermanager;
	}


	public void setRoleusermanager(MhqxTabRoleUserManager roleusermanager) {
		this.roleusermanager = roleusermanager;
	}


	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 显示个人信息
	 * @return 跳转字符串
	 */
	public String showPersonalInfo() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String id = session.getAttribute("FUserNumber").toString();
		List<MhqxTabRole> rolelist=new ArrayList();
		List<MhqxTabRoleuser> li=roleusermanager.findByUserNumber(id);
		for(MhqxTabRoleuser ru:li)
			rolelist.add(ru.getMhqxTabRole());
		//System.out.println("role size: "+li.size());
		session.setAttribute("PersonalInfo", roleInfoManager.getRoleInfo(id, rolelist));
		return "showPersonalInfo";
	}

	/**
	 * 编辑个人信息
	 * @return 跳转字符串
	 */
	public String editPersonalInfo(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		AppException.clear();
		String id = session.getAttribute("FUserNumber").toString();
		int roletype=Integer.parseInt(session.getAttribute("roletype").toString());
		Boolean isAdimin=Boolean.parseBoolean(session.getAttribute("isAdimin").toString());
		session.setAttribute("PersonalEditInfo",editRoleInfomanager.editRole(roletype, id, isAdimin) );
		return "editPersonalInfo";
	}
	
	
}
