package com.xdsc.dao.mail_system;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.UserInfo;

/**ʵ���ࣺʵ��UserInfoDaoInterface�ӿ�
 * ���û���Ϣ�йص������ݿ⽻����ʵ�ַ���
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class UserInfoDao implements UserInfoDaoInterface {
	
	/**
	 * session������ͨ��spring�����ļ���ע��
	 */
	SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**ͨ���û��������û���Ϣ��Ŀ
	 * @param username �û���
	 * @return �û���Ϣ��Ŀ
	 */
	public UserInfo selectByUsername(String username) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.infoUsername='"+username+"'");
		System.out.println("execute in UserInfoDao "+username);
		UserInfo userInfo = (UserInfo)query.uniqueResult();
		System.out.println(null==userInfo);
		return userInfo;
	}


	/**ͨ��ID�����û���Ϣ��Ŀ
	 * @param info_id ID
	 * @return �û���Ϣ��Ŀ
	 */
	public UserInfo selectById(int info_id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.infoId="+info_id);
		UserInfo userInfo = (UserInfo)query.uniqueResult();
		return userInfo;
	}


	/**�޸��û���Ϣ
	 * @param userInfo �û���Ϣ��Ŀ
	 */
	public void updateInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(userInfo);
		
	}
	
	

}
