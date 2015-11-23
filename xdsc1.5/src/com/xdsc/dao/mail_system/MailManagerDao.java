package com.xdsc.dao.mail_system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.xdsc.model.Mailmanager;

/**实现类 实现MailManagerDaoInterface接口
 * 封装了与数据库交互的有关邮件管理的抽象函数
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class MailManagerDao implements MailManagerDaoInterface {
	
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
	
	
	
	/**通过邮件编号和用户名查找管理对象
	 * @param msgnum 邮件号 
	 * @param username 用户名
	 * @return 找到返回true 否则返回false
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
	
	
	/**如果没有对应的msgnum就是未读邮件，那么在读取内容的时候插入一条记录，并且置标志位为已读
	 * @param mailmanager 管理对象
	 */
	public void addSeen(Mailmanager mailmanager){
		System.out.println("In MailManagerDao addSeen: "+sessionFactory.getCurrentSession());
		sessionFactory.getCurrentSession().save(mailmanager);
	}
	
	/**找到所有的已读邮件
	 * @param username 用户名
	 * @return 邮件集合
	 */
	public List<Mailmanager> findSeen(String username){
		String hql = "from Mailmanager m where m.mmSeen=1 and m.mmUsername='"+username+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List seenList = query.list();
		return seenList;
	}

	/**查找出所有已读邮件的数量
	 * @param username 用户名
	 * @return 已读邮件数量
	 */
	public int findCountOfSeen(String username) {
		// TODO Auto-generated method stub
		//找到username下的所有已读邮件的数量
		Query query = sessionFactory.getCurrentSession().createQuery("from Mailmanager m where m.mmSeen=1 and m.mmUsername='"+username+"'");
		List list = query.list();
		int count = list.size();
		return count;
	}
	
	

	/**通过邮件编号和用户名查找管理对象
	 * @param msgnum 邮件号
	 * @param username 用户名
	 * @return 管理对象
	 */
	public Mailmanager findByMsgnumandUsername(int msgnum, String username) {
		// TODO Auto-generated method stub
		System.out.println("In MailManagerDao to print msgnum :"+msgnum);
		Query query = sessionFactory.getCurrentSession().createQuery("from Mailmanager m where m.mmMsgnum="+msgnum+" and m.mmUsername='"+username+"'");
		Mailmanager mm = (Mailmanager) query.uniqueResult();
		return mm;
		
	}

	/**抽象函数：将邮件删除标志位设置为1
	 * @param mailmanager 管理对象
	 */
	public void updateDeleted(Mailmanager mailmanager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mailmanager);
		
	}

	/**找到设置为删除的邮件
	 * @param username 用户名
	 * @return 已删除邮件列表
	 */
	public List<Mailmanager> findDeleted(String username) {
		// TODO Auto-generated method stub
		String hql = "from Mailmanager m where m.mmDeleted=1 and m.mmUsername='"+username+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List deletedList = query.list();
		return deletedList;
	}

	/**标记为未读
	 * @param mailmanager 管理对象
	 */
	public void updateNew(Mailmanager mailmanager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mailmanager);
		
	}

	/**标记为垃圾邮件
	 * @param mailmanager 管理对象
	 */
	public void updateRubbish(Mailmanager mailmanager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mailmanager);
		
	}

	/**查找所有的垃圾邮件
	 * @param username 用户名
	 * @return 垃圾邮件列表
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
