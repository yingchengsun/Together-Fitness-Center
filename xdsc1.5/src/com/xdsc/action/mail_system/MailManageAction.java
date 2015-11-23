package com.xdsc.action.mail_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.MailManagerDaoInterface;
import com.xdsc.model.Mailmanager;


/**
 * �ʼ�����ĺ���aciton��
 * 
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class MailManageAction extends ActionSupport {
	
	//���action�е����з����������ʼ�������صķ���
	/**
	 * �����ʼ��������ݿ�������
	 */
	MailManagerDaoInterface mailmanagerDao;

	public MailManagerDaoInterface getMailmanagerDao() {
		return mailmanagerDao;
	}

	public void setMailmanagerDao(MailManagerDaoInterface mailmanagerDao) {
		this.mailmanagerDao = mailmanagerDao;
	}
	
	/** ͨ�����ݿ��ѯ�ʼ����������Ѷ��ʼ����ʼ���ţ���������������
	 * @return �Ѷ��ʼ��б�
	 */
	public String seenMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Mailmanager> seenList = mailmanagerDao.findSeen((String)request.getSession().getAttribute("username"));
		
		System.out.println("In MailManageAction :"+seenList.size());
		List<Integer> msgnumContainer = new ArrayList<Integer>(0);
		if(!seenList.isEmpty()){
			Iterator<Mailmanager> it = seenList.iterator();
			while(it.hasNext()){
				Mailmanager temp = it.next();
				msgnumContainer.add(temp.getMmMsgnum());
			}
		}
		if(!msgnumContainer.isEmpty()){
			System.out.println("In MailManageAction:"+msgnumContainer.size());
			request.setAttribute("msgnumContainer", msgnumContainer);
		}
		else{
			request.setAttribute("seenmailempty", new String("1"));
		}
		return SUCCESS;
	}
	
	
	/**ɾ���ʼ��Ĳ��������ʼ�������ɾ���ʼ�����
	 * ���������ݿ��еĲ���ʱ�����ض��ʼ���ɾ����־λ ����Ϊ'1'
	 * @return ���ص��ռ����� ɾ�����ʼ���������ʾ
	 */
	public String deleteMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		String username =(String) request.getSession().getAttribute("username");
		
		Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, username);
		if(null==mm)
		{
			Mailmanager mm_new = new Mailmanager();
			mm_new.setMmDeleted(1);
			mm_new.setMmDraft(0);
			mm_new.setMmMsgnum(msgnum);
			mm_new.setMmRubbish(0);
			mm_new.setMmSeen(1);
			mm_new.setMmUsername(username);
			mailmanagerDao.addSeen(mm_new);
		}
		else{
			mm.setMmDeleted(1);
			mm.setMmSeen(1);
			mailmanagerDao.updateDeleted(mm);
		}
		
		
		return SUCCESS;
	}
	
	/**�鿴�Ѿ�ɾ�����ʼ�
	 * @return ��ɾ���ʼ��б�
	 */
	public String deletedMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Mailmanager> seenList = mailmanagerDao.findSeen((String) request
				.getSession().getAttribute("username"));
		List seenNumList = new ArrayList(0);
		Iterator it3 = seenList.iterator();
		while(it3.hasNext()){
			Mailmanager mm3 = (Mailmanager)it3.next();
			seenNumList.add(mm3.getMmMsgnum());
		}
		
		List<Mailmanager> deletedList = mailmanagerDao.findDeleted((String)request.getSession().getAttribute("username"));
		
		System.out.println("In MailManageAction to show deleted mail:"+deletedList.size());
		List<Integer> msgnumContainer = new ArrayList<Integer>(0);
		if(!deletedList.isEmpty()){
			Iterator<Mailmanager> it = deletedList.iterator();
			while(it.hasNext()){
				Mailmanager temp = it.next();
				msgnumContainer.add(temp.getMmMsgnum());
			}
		}
		if(!msgnumContainer.isEmpty()){
			System.out.println("In MailManageAction to show deleted mail:"+msgnumContainer.size());
			request.setAttribute("msgnumContainer", msgnumContainer);
			request.setAttribute("seenMsgNumList", seenNumList);

		}
		else{
			request.setAttribute("deletedmailempty", new String("1"));
		}
		return SUCCESS;
	}
	
	/**�鿴�����ʼ�
	 * @return ���������ʼ��б�
	 */
	public String rubbishMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//Inbox���Ѷ��ʼ�
		List<Mailmanager> seenList = mailmanagerDao.findSeen((String) request
				.getSession().getAttribute("username"));
		List seenNumList = new ArrayList(0);
		Iterator it3 = seenList.iterator();
		while(it3.hasNext()){
			Mailmanager mm3 = (Mailmanager)it3.next();
			seenNumList.add(mm3.getMmMsgnum());
		}
		
		List<Mailmanager> rubbishList = mailmanagerDao.findRubbish((String)request.getSession().getAttribute("username"));
		
		System.out.println("In MailManageAction to show deleted mail:"+rubbishList.size());
		List<Integer> msgnumContainer = new ArrayList<Integer>(0);
		if(!rubbishList.isEmpty()){
			Iterator<Mailmanager> it = rubbishList.iterator();
			while(it.hasNext()){
				Mailmanager temp = it.next();
				msgnumContainer.add(temp.getMmMsgnum());
			}
		}
		if(!msgnumContainer.isEmpty()){
			System.out.println("In MailManageAction to show deleted mail:"+msgnumContainer.size());
			request.setAttribute("msgnumContainer", msgnumContainer);
			request.setAttribute("seenMsgNumList", seenNumList);
		}
		else{
			request.setAttribute("rubbishmailempty", new String("1"));
		}
		return SUCCESS;
	}
	
	
	/**���ʼ��Ƴ������ʼ���
	 * @return ϵͳ�Ż����Դ���ˢ���ռ���
	 */
	public String rubbishRemove(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, (String)request.getSession().getAttribute("username"));
		mm.setMmRubbish(0);
		mailmanagerDao.updateDeleted(mm);
		return SUCCESS;
	}
	
	
	/**���ʼ��Ƴ���ɾ���ʼ���
	 * @return ϵͳ�Ż����Դ���ˢ���ռ���
	 */
	public String deletedRemove(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, (String)request.getSession().getAttribute("username"));
		System.out.println("In MailManageAction to show deleted remove function "+mm.getMmDeleted());
		
		mm.setMmDeleted(0);
		mailmanagerDao.updateRubbish(mm);
		System.out.println("In MailManageAction to show deleted remove function "+mm.getMmDeleted());
		return SUCCESS;
	}
	

}
