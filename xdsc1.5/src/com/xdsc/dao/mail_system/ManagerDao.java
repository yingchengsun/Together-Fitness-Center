package com.xdsc.dao.mail_system;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xdsc.hibernate.mail_system.HibernateSessionFactory;
import com.xdsc.model.Mailmanager;
import com.xdsc.model.User;


/**实现类：是想ManagerDaoInterface接口
 * 与用户登录有关的方法
 * @author Administrator
 *
 */
public class ManagerDao implements ManagerDaoInterface {
	
	/**
	 * session工厂类通过spring配置文件注入
	 */
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**通过用户名和密码验证登陆
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 通过返回true 否则false
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
	
	/**通过用户名找到User对象
	 * @param userName 用户名
	 * @return 用户对象
	 */
	public User findUserByName(String userName){
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userName='"+userName+"'");
		User user = (User) query.uniqueResult();
		return user;
	}

}
