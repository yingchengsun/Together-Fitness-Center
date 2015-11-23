package com.xdsc.dao.mail_system;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Contact;

/**实现类 实现ContactDaoInterface接口
 * 封装了与后台数据库交互的基本操作
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class ContactDao implements ContactDaoInterface {
	
	/**
	 * Session工厂类通过spring配置文件注入
	 */
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	/** 查找所有的通讯录条目
	 * @see com.xdsc.dao.mail_system.ContactDaoInterface#findContact()
	 */
	public List findContact() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from MhqxTabUser");
		List contactList = new ArrayList();
		contactList = query.list();
		return contactList;
	}
	
	/**通过用户名查找通讯录条目
	 * @param username 用户名
	 * @return 特定通讯录条目
	 */
	public Contact findContactByUsername(String username){
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact c where c.CUsername='"+username+"'");
		Contact contact = (Contact)query.uniqueResult();
		return contact;
	}

	/**通过roleId查询mhqx_tab_roleuser表，得到
	 * 具有该roleId的所有username 即userNumber
	 * @param roleId 角色ID
	 * @return 符合条件的通讯录条目
	 */
	public List findByClass() {
		// TODO Auto-generated method stub
		//通过roleId查询mhqx_tab_roleuser表，得到具有该roleId的所有username
		//即userNumber
		Query query = sessionFactory.getCurrentSession().createQuery("from TabClasses");
		
		List classList = query.list();
		return classList;
	}
	
	public List findByClassNumber(String classNumber){
		Query query = sessionFactory.getCurrentSession().createQuery("from TabStudents ts where ts.tabClasses.FClassNumber='"+classNumber+"'");
		List studentList = query.list();
		return studentList;
		
	}

	/**通过主键查找通讯录条目
	 * @param cid 主键值
	 * @return 特定通讯录条目
	 */
	public Contact findById(int cid) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact c where c.CId="+cid);
		Contact contact =(Contact) query.uniqueResult();
		return contact;
	}

	/** 删除操作
	 * @param contact 通讯录条目
	 */
	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(contact);
	}

	/** 更新操作
	 * @param contact 通讯录条目
	 */
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(contact);
	}

	/**插入操作
	 * @param contact 通讯录条目
	 */
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(contact);
	}

}
