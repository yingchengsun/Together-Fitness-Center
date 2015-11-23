package com.xdsc.dao.mail_system;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xdsc.hibernate.mail_system.HibernateSessionFactory;
import com.xdsc.model.Mailmanager;
import com.xdsc.model.User;


/**ʵ���ࣺ����ManagerDaoInterface�ӿ�
 * ���û���¼�йصķ���
 * @author Administrator
 *
 */
public class ManagerDao implements ManagerDaoInterface {
	
	/**
	 * session������ͨ��spring�����ļ�ע��
	 */
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**ͨ���û�����������֤��½
	 * @param name �û���
	 * @param pwd ����
	 * @return ͨ������true ����false
	 */
	public boolean findManager(String name,String pwd){
		//Session session = HibernateSessionFactory.getSession();
		
		Query query = sessionFactory.getCurrentSession().
				createQuery("from User u where u.userName=? and u.userPassword=?");
		query.setString(0, name);
		query.setString(1, pwd);
		//System.out.println("********");
		User user =(User) query.uniqueResult();
		if(null==user)
			return false;
		else 
			return true;
	}
	
	/**ͨ���û����ҵ�User����
	 * @param userName �û���
	 * @return �û�����
	 */
	public User findUserByName(String userName){
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userName='"+userName+"'");
		User user = (User) query.uniqueResult();
		return user;
	}

}
