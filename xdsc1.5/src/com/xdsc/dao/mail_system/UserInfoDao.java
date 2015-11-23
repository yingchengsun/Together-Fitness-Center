package com.xdsc.dao.mail_system;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.UserInfo;

/**实现类：实现UserInfoDaoInterface接口
 * 与用户信息有关的与数据库交互的实现方法
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class UserInfoDao implements UserInfoDaoInterface {
	
	/**
	 * session工厂类通过spring配置文件中注入
	 */
	SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**通过用户名查找用户信息条目
	 * @param username 用户名
	 * @return 用户信息条目
	 */
	public UserInfo selectByUsername(String username) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.infoUsername='"+username+"'");
		System.out.println("execute in UserInfoDao "+username);
		UserInfo userInfo = (UserInfo)query.uniqueResult();
		System.out.println(null==userInfo);
		return userInfo;
	}


	/**通过ID查找用户信息条目
	 * @param info_id ID
	 * @return 用户信息条目
	 */
	public UserInfo selectById(int info_id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.infoId="+info_id);
		UserInfo userInfo = (UserInfo)query.uniqueResult();
		return userInfo;
	}


	/**修改用户信息
	 * @param userInfo 用户信息条目
	 */
	public void updateInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(userInfo);
		
	}
	
	

}
