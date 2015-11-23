package com.xdsc.action.mail_system;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.*;
import com.xdsc.model.UserInfo;


/** 操作个人信息的action类 
 * @author 郑灿双 2010-04-30
 *
 */
public class UserInfoAction extends ActionSupport {
	
	/**
	 * 涉及到个人信息与后台数据库交互的类的实例 
	 */
	UserInfoDaoInterface userinfoDao;
	/**
	 * 个人信息的类的对象 从JSP页面中注入值
	 */
	UserInfo userinfo;
	
	
	public UserInfo getUserinfo() {
		return userinfo;
	}



	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}



	public UserInfoDaoInterface getUserinfoDao() {
		return userinfoDao;
	}



	public void setUserinfoDao(UserInfoDaoInterface userinfoDao) {
		this.userinfoDao = userinfoDao;
	}


	
	/** 查看被人的信息
	 * @return 别人主页的视图 不可修改
	 */
	public String find(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String[] temp = username.split(" ");
		username = temp[0];
		UserInfo userInfo = userinfoDao.selectByUsername(username);
		System.out.println("In UserInfoAction ..."+(null==userInfo));
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("isme", new String("0"));
		return SUCCESS;
	}

	
	/** 查看自己的信息
	 * @return 返回到自己主页的视图 可以修改
	 */
	public String findSelf(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username =(String) request.getSession().getAttribute("username");
		UserInfo userInfo = userinfoDao.selectByUsername(username);
		System.out.print("execcute query self_information...");
		System.out.println(null==userInfo);
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("isme", new String("1"));
		return SUCCESS;
	}
	
	
	/** 查看信息
	 * @return 修改页面 表单别注入值
	 */
	public String modifyInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int info_id = Integer.parseInt(request.getParameter("info_id"));
		UserInfo userInfo = userinfoDao.selectById(info_id);
		request.setAttribute("userInfo", userInfo);
		return SUCCESS;
	}
	
	
	/** 修改信息 同步到后台数据库
	 * @return 个人主页的视图
	 */
	public String updateInfo(){
//		System.out.println(userinfo.getInfoClass());
//		System.out.println(userinfo.getInfoNotes());
//		System.out.println(userinfo.getInfoPhoto());
//		System.out.println(userinfo.getInfoPresent());
//		System.out.println(userinfo.getInfoProperty());
//		System.out.println(userinfo.getInfoRealname());
//		System.out.println(userinfo.getInfoSex());
//		System.out.println(userinfo.getInfoUsername());
//		System.out.println(userinfo.getInfoAge());
//		System.out.println(userinfo.getInfoNumber());
//		System.out.println(userinfo.getInfoId());
		int info_id = userinfo.getInfoId();
		UserInfo userinfo_certain = userinfoDao.selectById(info_id);
		userinfo_certain = userinfo;
		
//		userinfo_certain.setInfoAge(userinfo.getInfoAge());
//		userinfo_certain.setInfoClass(userinfo.getInfoClass());
//		userinfo_certain.setInfoNotes(userinfo.getInfoNotes());
//		userinfo_certain.setInfoNumber(userinfo.getInfoNumber());
//		userinfo_certain.setInfoPhoto(userinfo.getInfoPhoto());
//		userinfo_certain.setInfoPresent(userinfo.getInfoPresent());
//		userinfo_certain.setInfoProperty(userinfo.getInfoProperty());
//		userinfo_certain.setInfoRealname(userinfo.getInfoRealname());
//		userinfo_certain.setInfoSex(userinfo.getInfoSex());
//		userinfo_certain.setInfoUsername(userinfo.getInfoUsername());
		
		userinfoDao.updateInfo(userinfo_certain);
		return SUCCESS;
	}
	
	

}
