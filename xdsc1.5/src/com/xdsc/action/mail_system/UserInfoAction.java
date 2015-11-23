package com.xdsc.action.mail_system;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.*;
import com.xdsc.model.UserInfo;


/** ����������Ϣ��action�� 
 * @author ֣��˫ 2010-04-30
 *
 */
public class UserInfoAction extends ActionSupport {
	
	/**
	 * �漰��������Ϣ���̨���ݿ⽻�������ʵ�� 
	 */
	UserInfoDaoInterface userinfoDao;
	/**
	 * ������Ϣ����Ķ��� ��JSPҳ����ע��ֵ
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


	
	/** �鿴���˵���Ϣ
	 * @return ������ҳ����ͼ �����޸�
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

	
	/** �鿴�Լ�����Ϣ
	 * @return ���ص��Լ���ҳ����ͼ �����޸�
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
	
	
	/** �鿴��Ϣ
	 * @return �޸�ҳ�� ����ע��ֵ
	 */
	public String modifyInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int info_id = Integer.parseInt(request.getParameter("info_id"));
		UserInfo userInfo = userinfoDao.selectById(info_id);
		request.setAttribute("userInfo", userInfo);
		return SUCCESS;
	}
	
	
	/** �޸���Ϣ ͬ������̨���ݿ�
	 * @return ������ҳ����ͼ
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
