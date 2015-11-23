package com.xdsc.dao.mail_system;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Contact;

/**ʵ���� ʵ��ContactDaoInterface�ӿ�
 * ��װ�����̨���ݿ⽻���Ļ�������
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class ContactDao implements ContactDaoInterface {
	
	/**
	 * Session������ͨ��spring�����ļ�ע��
	 */
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	/** �������е�ͨѶ¼��Ŀ
	 * @see com.xdsc.dao.mail_system.ContactDaoInterface#findContact()
	 */
	public List findContact() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from MhqxTabUser");
		List contactList = new ArrayList();
		contactList = query.list();
		return contactList;
	}
	
	/**ͨ���û�������ͨѶ¼��Ŀ
	 * @param username �û���
	 * @return �ض�ͨѶ¼��Ŀ
	 */
	public Contact findContactByUsername(String username){
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact c where c.CUsername='"+username+"'");
		Contact contact = (Contact)query.uniqueResult();
		return contact;
	}

	/**ͨ��roleId��ѯmhqx_tab_roleuser���õ�
	 * ���и�roleId������username ��userNumber
	 * @param roleId ��ɫID
	 * @return ����������ͨѶ¼��Ŀ
	 */
	public List findByClass() {
		// TODO Auto-generated method stub
		//ͨ��roleId��ѯmhqx_tab_roleuser���õ����и�roleId������username
		//��userNumber
		Query query = sessionFactory.getCurrentSession().createQuery("from TabClasses");
		
		List classList = query.list();
		return classList;
	}
	
	public List findByClassNumber(String classNumber){
		Query query = sessionFactory.getCurrentSession().createQuery("from TabStudents ts where ts.tabClasses.FClassNumber='"+classNumber+"'");
		List studentList = query.list();
		return studentList;
		
	}

	/**ͨ����������ͨѶ¼��Ŀ
	 * @param cid ����ֵ
	 * @return �ض�ͨѶ¼��Ŀ
	 */
	public Contact findById(int cid) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact c where c.CId="+cid);
		Contact contact =(Contact) query.uniqueResult();
		return contact;
	}

	/** ɾ������
	 * @param contact ͨѶ¼��Ŀ
	 */
	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(contact);
	}

	/** ���²���
	 * @param contact ͨѶ¼��Ŀ
	 */
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(contact);
	}

	/**�������
	 * @param contact ͨѶ¼��Ŀ
	 */
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(contact);
	}

}
