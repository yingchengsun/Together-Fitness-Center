package com.xdsc.dao.mail_system;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Remind;

/**ʵ���ࣺʵ��RemindDaoInterface�ӿ�
 * 
 * ����ݿ⽻������˽�������йص�ʵ�ַ���
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class RemindDao implements RemindDaoInterface {
	
	
	/**
	 * ��ô�applicationContext.xmlע���4��SessionFactory
	 */
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
//setter����ע��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**���������
	 * @param remind ����ʵ��
	 */
	public void addRemind(Remind remind) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(remind);

	}
	
	/**ɾ������
	 * @param remind ����ʵ��
	 */
	public void deleteRemind(Remind remind) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(remind);

	}

	/**ͨ��ID�ҵ�������Ŀ
	 * @param id ID
	 * @return ������Ŀ
	 */
	public Remind findById(int id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Remind r where r.RId="+id);
		Remind veryRemind =(Remind) query.uniqueResult();
		return veryRemind;
	}

	/**�ҵ���������������Ŀ
	 * @param username �û���
	 * @return �����б�
	 */
	public List<Remind> findRemind(String username) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Remind r where r.RUserid='"+username+"'");
		List<Remind> remindList = new ArrayList<Remind>();
		remindList = query.list();
		return remindList;
	}

}
