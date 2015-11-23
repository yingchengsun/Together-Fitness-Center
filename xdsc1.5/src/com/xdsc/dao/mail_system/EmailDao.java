package com.xdsc.dao.mail_system;

import java.util.HashMap;
import java.util.List;

import javax.mail.Folder;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Mail;
import com.xdsc.service.mail_system.POP3Help;
import com.xdsc.service.mail_system.SendMail;


/**EmailDao 实现EmailDaoInterface
 * @author 郑灿双 2010-04-30
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
	

	/**得到POP3邮件服务器上的邮件夹对象
	 * @param host 主机号
	 * @param username 用户名
	 * @param password 密码
	 * @return 邮件夹
	 */
	public Folder getFolder(String host, String username,
			String password) {
		// TODO Auto-generated method stub
		Folder folder = POP3Help.getFolder(host,username,password);
		return folder;
	}

	/**发送邮件
	 * @param mail 邮件实体
	 * @return 邮件的发送状态
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
