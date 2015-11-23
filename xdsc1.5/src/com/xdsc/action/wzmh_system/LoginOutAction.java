package com.xdsc.action.wzmh_system;
import com.xdsc.util.*;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 安全退出
 * @author 陈丰
 *
 */
public class LoginOutAction extends ActionSupport{
	public String loginOut()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		//session.setAttribute(Constant.Welcome, "请先登入");
		return SUCCESS;
	}
}
