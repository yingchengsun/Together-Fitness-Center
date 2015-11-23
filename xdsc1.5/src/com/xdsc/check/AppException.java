package com.xdsc.check;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


/**
 * ���ɴ����б�
 * @author �·�
 *
 */
public class AppException {
	/**
	 * �������������б�session
	 * @param error
	 */
	public AppException(String error) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		/**���ô���ʱ�����ʽ*/
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
 * ��մ����б�
 */
	public static void clear() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("errorlist", new ArrayList<String>());
	}
}
