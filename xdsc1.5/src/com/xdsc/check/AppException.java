package com.xdsc.check;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


/**
 * 生成错误列表
 * @author 陈丰
 *
 */
public class AppException {
	/**
	 * 将错误加入错误列表session
	 * @param error
	 */
	public AppException(String error) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		/**设置传参时编码格式*/
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ArrayList<String> errorlist = new ArrayList<String>();
		if (session.getAttribute("errorlist") != null) {
			errorlist = (ArrayList<String>) session.getAttribute("errorlist");
		}
		errorlist.add(error);
		session.setAttribute("errorlist", errorlist);
	}
/**
 * 清空错误列表
 */
	public static void clear() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("errorlist", new ArrayList<String>());
	}
}
