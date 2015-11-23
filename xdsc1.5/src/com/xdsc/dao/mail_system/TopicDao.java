package com.xdsc.dao.mail_system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xdsc.hibernate.mail_system.HibernateSessionFactory;
import com.xdsc.model.Topic;


public class TopicDao implements TopicDaoInterface {
	
	SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/* (non-Javadoc)
	 * @see cn.bsw.dao.TopicDaoInterface#selectTopic()
	 */
	public List selectTopic() {
		//Session session=HibernateSessionFactory.getSession();
		//Transaction tr=session.beginTransaction();
		Query query=sessionFactory.getCurrentSession().createQuery("from Topic");
		List list=query.list();
		//tr.commit();
		//session.close();
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see cn.bsw.dao.TopicDaoInterface#selectTopicById(int)
	 */
	public Topic selectTopicById(int id) {
		//Session session=HibernateSessionFactory.getSession();
		Query query=sessionFactory.getCurrentSession().createQuery("from Topic t where t.id="+id);
		Topic topic=(Topic)query.uniqueResult();
		return topic;
	}
	
	
	/* (non-Javadoc)
	 * @see cn.bsw.dao.TopicDaoInterface#addTopic(com.struts2.dto.Topic)
	 */
	public void addTopic(Topic topic) {
		//Session session=HibernateSessionFactory.getSession();
		//Transaction tr=session.beginTransaction();
		//tr.begin();
		sessionFactory.getCurrentSession().save(topic);
		//tr.commit();
		//session.close();
	}
	
	/* (non-Javadoc)
	 * @see cn.bsw.dao.TopicDaoInterface#deleteTopic(int)
	 */
	public void deleteTopic(Topic topic) {
		//Session session=HibernateSessionFactory.getSession();
		//Transaction tr=session.beginTransaction();
		//tr.begin();
		//TopicDaoInterface dao=new TopicDao();
		//Topic topic=dao.selectTopicById(id);
		sessionFactory.getCurrentSession().delete(topic);
		//tr.commit();
		//session.close();
	}

}
