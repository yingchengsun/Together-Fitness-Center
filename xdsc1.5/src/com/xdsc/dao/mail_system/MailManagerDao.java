package com.xdsc.dao.mail_system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Mailmanager;

/**ʵ���� ʵ��MailManagerDaoInterface�ӿ�
 * ��װ�������ݿ⽻�����й��ʼ�����ĳ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class MailManagerDao implements MailManagerDaoInterface {
	
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
	
	
	
	/**ͨ���ʼ���ź��û������ҹ������
	 * @param msgnum �ʼ��� 
	 * @param username �û���
	 * @return �ҵ�����true ���򷵻�false
	 */
	public boolean findByMsgnum(int msgnum,String username){
		System.out.println("In MailManagerDao to print msgnum :"+msgnum);
		Query query = sessionFactory.getCurrentSession().createQuery("from Mailmanager m where m.mmMsgnum="+msgnum+" and m.mmUsername='"+username+"'");
		Mailmanager mm = (Mailmanager) query.uniqueResult();
		if(null==mm)
			return false;
		else 
			return true;
	}
	
	
	/**���û�ж�Ӧ��msgnum����δ���ʼ�����ô�ڶ�ȡ���ݵ�ʱ�����һ����¼�������ñ�־λΪ�Ѷ�
	 * @param mailmanager �������
	 */
	public void addSeen(Mailmanager mailmanager){
		System.out.println("In MailManagerDao addSeen: "+sessionFactory.getCurrentSession());
		sessionFactory.getCurrentSession().save(mailmanager);
	}
	
	/**�ҵ����е��Ѷ��ʼ�
	 * @param username �û���
	 * @return �ʼ�����
	 */
	public List<Mailmanager> findSeen(String username){
		String hql = "from Mailmanager m where m.mmSeen=1 and m.mmUsername='"+username+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List seenList = query.list();
		return seenList;
	}

	/**���ҳ������Ѷ��ʼ�������
	 * @param username �û���
	 * @return �Ѷ��ʼ�����
	 */
	public int findCountOfSeen(String username) {
		// TODO Auto-generated method stub
		//�ҵ�username�µ������Ѷ��ʼ�������
		Query query = sessionFactory.getCurrentSession().createQuery("from Mailmanager m where m.mmSeen=1 and m.mmUsername='"+username+"'");
		List list = query.list();
		int count = list.size();
		return count;
	}
	
	

	/**ͨ���ʼ���ź��û������ҹ������
	 * @param msgnum �ʼ���
	 * @param username �û���
	 * @return �������
	 */
	public Mailmanager findByMsgnumandUsername(int msgnum, String username) {
		// TODO Auto-generated method stub
		System.out.println("In MailManagerDao to print msgnum :"+msgnum);
		Query query = sessionFactory.getCurrentSession().createQuery("from Mailmanager m where m.mmMsgnum="+msgnum+" and m.mmUsername='"+username+"'");
		Mailmanager mm = (Mailmanager) query.uniqueResult();
		return mm;
		
	}

	/**�����������ʼ�ɾ����־λ����Ϊ1
	 * @param mailmanager �������
	 */
	public void updateDeleted(Mailmanager mailmanager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mailmanager);
		
	}

	/**�ҵ�����Ϊɾ�����ʼ�
	 * @param username �û���
	 * @return ��ɾ���ʼ��б�
	 */
	public List<Mailmanager> findDeleted(String username) {
		// TODO Auto-generated method stub
		String hql = "from Mailmanager m where m.mmDeleted=1 and m.mmUsername='"+username+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List deletedList = query.list();
		return deletedList;
	}

	/**���Ϊδ��
	 * @param mailmanager �������
	 */
	public void updateNew(Mailmanager mailmanager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mailmanager);
		
	}

	/**���Ϊ�����ʼ�
	 * @param mailmanager �������
	 */
	public void updateRubbish(Mailmanager mailmanager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mailmanager);
		
	}

	/**�������е������ʼ�
	 * @param username �û���
	 * @return �����ʼ��б�
	 */
	public List<Mailmanager> findRubbish(String username) {
		// TODO Auto-generated method stub
		String hql = "from Mailmanager m where m.mmRubbish=1 and m.mmUsername='"+username+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List rubbishList = query.list();
		return rubbishList;
	}

	

//	public void updateDeleted() {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
