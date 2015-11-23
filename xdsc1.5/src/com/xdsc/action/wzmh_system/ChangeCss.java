package com.xdsc.action.wzmh_system;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.MhqxTabRemind;
import com.xdsc.service.wzmh_system.impl.CssManagerImpl;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
/**
 * 更改CSS风格
 * @author Franklin
 *
 */
public class ChangeCss extends ActionSupport{

	private com.xdsc.service.wzmh_system.CssManager cssManagerImpl;

	private String css;
	
	public 	String insertOrUpdateCss()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		String id = session.getAttribute("FUserNumber").toString();
		String password =session.getAttribute("password").toString();	
		MhqxTabRemind c=cssManagerImpl.findbyusernumber(id);
		if(c==null)
		{
			c = new MhqxTabRemind();
			c.setFRemindType(id);
			c.setFRemindUrl(css);
			cssManagerImpl.insert(c);
		}
		else
		{
			c.setFRemindUrl(css);
			cssManagerImpl.update(c);
		}	
		session.removeAttribute("css");
		session.removeAttribute("color");
		
		return "insertOrUpdateCss";
	}
	
	public synchronized com.xdsc.service.wzmh_system.CssManager getCssManagerImpl() {
		return cssManagerImpl;
	}

	public synchronized void setCssManagerImpl(
			com.xdsc.service.wzmh_system.CssManager cssManagerImpl) {
		this.cssManagerImpl = cssManagerImpl;
	}

	public synchronized String getCss() {
		return css;
	}
	public synchronized void setCss(String css) {
		this.css = css;
	}
	
	
	
	
}
