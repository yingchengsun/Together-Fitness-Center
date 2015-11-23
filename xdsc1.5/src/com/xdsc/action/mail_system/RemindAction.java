package com.xdsc.action.mail_system;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.ManagerDao;
import com.xdsc.dao.mail_system.ManagerDaoInterface;
import com.xdsc.dao.mail_system.RemindDao;
import com.xdsc.dao.mail_system.RemindDaoInterface;
import com.xdsc.model.*;
import com.xdsc.util.mail_system.DateConvert;

/** ˽�����ѵ�action��
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class RemindAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ˽������Dao ��װ���̨��ݿ⽻���ķ���
	 */
	RemindDaoInterface remindDao;
	/**
	 * �û���¼Dao ��װ���̨��ݿ�ķ���
	 */
	ManagerDaoInterface managerDao;
	
	
	/**
	 * ������Ķ��󣬴�JSP�?ע��ֵ
	 */
	Remind remind;

	
	public ManagerDaoInterface getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDaoInterface managerDao) {
		this.managerDao = managerDao;
	}

	public Remind getRemind() {
		return remind;
	}

	public void setRemind(Remind remind) {
		this.remind = remind;
	}
	
	public RemindDaoInterface getRemindDao() {
		return remindDao;
	}

	public void setRemindDao(RemindDaoInterface remindDao) {
		this.remindDao = remindDao;
	}

	
	/**�鿴����δ���ڵ�����
	 * @return ���ص�˽�������б�
	 * @throws ParseException ��ʽת���쳣
	 */
	public String selectAll() throws ParseException{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username =(String) request.getSession().getAttribute("username");
		//ת��ʱ���õ�
		DateConvert dateConvert = new DateConvert();
		
		List<Remind> remindList1 = new ArrayList<Remind>();
		List<Remind> remindList = new ArrayList<Remind>();
		Date nowDate = new Date();
	
		//֮ǰѡ�õ�ת����Ϊlong����4�Ƚ� ��ʱ������ݿ��ʱ����û��ʱ����ģ�
		//���Լ����ǵ������������Ҳ�����˵���...
		long nowTime = nowDate.getTime();
		java.sql.Date nowTime_sql = new java.sql.Date(nowTime);
		String nowTime_str = nowTime_sql.toString();
		System.out.println("look the string of nowtime"+nowTime_str);
		nowTime = dateConvert.convertDate(nowTime_str).getTime();
		System.out.println("&*%^*&^*&"+nowTime);
		
		remindList1 = remindDao.findRemind(username);
		Iterator<Remind> it = remindList1.iterator();
		while(it.hasNext()){
			Remind tempRemind = it.next();
			long remindTime = dateConvert.convertDate(tempRemind.getRTime()).getTime();
			//for testing...
			System.out.println(remindTime);
			
			if(nowTime<=remindTime){
				remindList.add(tempRemind);
			}
		}
		
		if(remindList.isEmpty()){
			request.setAttribute("isempty", new String("1"));
		}
		else{
			System.out.println("execute query the remind database...");
			request.setAttribute("remindList", remindList);
		}
		return SUCCESS;
	}
	
	/** �½��µ�˽������
	 * @return ��ʾ�½��ɹ�
	 */
	public String addNewRemind(){
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(remind.getRTask());
		
		remind.setRUserid((String)request.getSession().getAttribute("username"));
		
		remindDao.addRemind(remind);
		return SUCCESS;
	}
	
	
	/**ɾ���ض�����
	 * @return ˽�������б�
	 */
	public String deleteRemind(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		remindDao.deleteRemind(remindDao.findById(r_id));
		return SUCCESS;
	}
	

}
