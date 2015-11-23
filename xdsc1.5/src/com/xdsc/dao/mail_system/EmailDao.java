package com.xdsc.dao.mail_system;

import java.util.HashMap;
import java.util.List;

import javax.mail.Folder;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Mail;
import com.xdsc.service.mail_system.POP3Help;
import com.xdsc.service.mail_system.SendMail;


/**EmailDao ʵ��EmailDaoInterface
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class EmailDao implements EmailDaoInterface {
	
//	SessionFactory sessionFactory;
//
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//	
	

	/**�õ�POP3�ʼ��������ϵ��ʼ��ж���
	 * @param host ������
	 * @param username �û���
	 * @param password ����
	 * @return �ʼ���
	 */
	public Folder getFolder(String host, String username,
			String password) {
		// TODO Auto-generated method stub
		Folder folder = POP3Help.getFolder(host,username,password);
		return folder;
	}

	/**�����ʼ�
	 * @param mail �ʼ�ʵ��
	 * @return �ʼ��ķ���״̬
	 */
	public HashMap sendMail(Mail mail) {
		// TODO Auto-generated method stub
		SendMail sendmail = new SendMail();
		HashMap messagemap = new HashMap();
		messagemap = sendmail.sendMail(mail);
		return messagemap;
	}

//	public List searchMail(String search_condition, String search_value) {
//		// TODO Auto-generated method stub
//		String hql = "from Inbox in where in."+search_condition+" ="+search_value;
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		List mail_list = query.list();
//		return mail_list;
//	}
//	
	

}
