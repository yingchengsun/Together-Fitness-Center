package com.xdsc.action.wzmh_system;
import com.xdsc.util.*;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ȫ�˳�
 * @author �·�
 *
 */
public class LoginOutAction extends ActionSupport{
	public String loginOut()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		//session.setAttribute(Constant.Welcome, "���ȵ���");
		return SUCCESS;
	}
}
