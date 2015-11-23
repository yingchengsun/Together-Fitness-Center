package com.xdsc.action.mail_system;

import java.util.Map;

import javax.mail.Folder;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.ContactDaoInterface;
import com.xdsc.dao.mail_system.MailManagerDaoInterface;
import com.xdsc.dao.mail_system.ManagerDao;
import com.xdsc.dao.mail_system.ManagerDaoInterface;
import com.xdsc.model.Contact;
import com.xdsc.service.mail_system.POP3Help;

/**�����û���¼��action
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class ManagerAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6696513464855368622L;
	/**
	 * �û���������
	 */
	private String name;
	private String password;
	
	/**
	 * �����û���¼��Dao ��װ�������ݿ�Ľ�������
	 */
	ManagerDaoInterface managerDao;
	/**
	 * ����ͨѶ¼��Dao 
	 */
	ContactDaoInterface contactDao;
	/**
	 * �����ʼ���Dao
	 */
	MailManagerDaoInterface mailmanagerDao;
	
	
	
	public MailManagerDaoInterface getMailmanagerDao() {
		return mailmanagerDao;
	}
	public void setMailmanagerDao(MailManagerDaoInterface mailmanagerDao) {
		this.mailmanagerDao = mailmanagerDao;
	}
	public ManagerDaoInterface getManagerDao() {
		return managerDao;
	}
	public void setManagerDao(ManagerDaoInterface managerDao) {
		this.managerDao = managerDao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/** (non-Javadoc)
	 * ���action��execute()�������������¼��֤���������ʼ�����
	 */
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		// TODO Auto-generated method stub
		if("".equals(name)||null==name||"".equals(password)||null==password){
			request.setAttribute("loginnull", new String("null"));
			return INPUT;
		}
		
		else if(managerDao.findManager(name, password)){
			
			//request.getSession().setAttribute("flag", "1");
			//request.getSession().setAttribute("manager", name);
			
			//������sohu��pop3������
			String host = new String("localhost");
			String smtpServer = new String("localhost");
			request.getSession().setAttribute("host",host);
			//������sohu��smtp������
			request.getSession().setAttribute("smtpServer",smtpServer);
			//�õ���Ӧ������
			Contact uniqueContact = contactDao.findContactByUsername(name);
//			request.getSession().setAttribute("realname", uniqueContact.getCName());
			
			request.getSession().setAttribute("username", name);
			request.getSession().setAttribute("password", password);
			
			POP3Help pop3 = new POP3Help();
			Folder folder = pop3.getFolder(host, name, password);
			
			//������仰�ǵõ��ʼ��������������Ѷ��ʼ�������
			int countOfSeen = mailmanagerDao.findCountOfSeen(name);
			//�õ��ʼ��������������ʼ�������
			int countOfInbox = folder.getMessageCount();
			//���������Ĳ�ֵ����δ���ʼ�������
			int countOfNew = countOfInbox - countOfSeen;
			
			System.out.println("In ManagerAction to count the number of new mails:"+countOfNew);
			request.getSession().setAttribute("countOfNew", countOfNew);
			request.getSession().setAttribute("folder", folder);
			return SUCCESS;
		}
		else{
			request.setAttribute("loginerror", new String("error"));
			return INPUT;
			
		}
	}
	public ContactDaoInterface getContactDao() {
		return contactDao;
	}
	public void setContactDao(ContactDaoInterface contactDao) {
		this.contactDao = contactDao;
	}

}
