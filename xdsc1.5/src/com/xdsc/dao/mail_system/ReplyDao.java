package com.xdsc.dao.mail_system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xdsc.hibernate.mail_system.HibernateSessionFactory;
import com.xdsc.model.Reply;
import com.xdsc.model.Topic;


public class ReplyDao implements ReplyDaoInterface {
	
	SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//≤È—ØÀ˘”–¡Ù—‘
	/* (non-Javadoc)
	 * @see cn.bsw.dao.ReplyDaoInterface#selectAll()
	 */
	public List<Reply> selectAll(){
		
		
		Query query=sessionFactory.getCurrentSession().createQuery("from Reply");
		List<Reply> list=query.list();
		return list;
	}
	
	//‘ˆº”¡Ù—‘
	/* (non-Javadoc)
	 * @see cn.bsw.dao.ReplyDaoInterface#addReply(com.struts2.dto.Reply)
	 */
	public void addReply(Reply reply){
		
		//Session session=HibernateSessionFactory.getSession();
		//Transaction tr=session.beginTransaction();
		sessionFactory.getCurrentSession().save(reply);
		//tr.commit();
		//session.close();
	}
	
	//…æ≥˝¡Ù—‘
	/* (non-Javadoc)
	 * @see cn.bsw.dao.ReplyDaoInterface#deleteReply(int)
	 */
	public void deleteReply(Reply reply) {
		//Session session=HibernateSessionFactory.getSession();
		//Transaction tr=session.beginTransaction();
		//Reply reply =selectReplyById(id);
		sessionFactory.getCurrentSession().delete(reply);
		//tr.commit();
		//session.close();
	}
	
	/* (non-Javadoc)
	 * @see cn.bsw.dao.ReplyDaoInterface#selectReplyById(int)
	 */
	public Reply selectReplyById(int id) {
		//Session session=HibernateSessionFactory.getSession();
		Query query=sessionFactory.getCurrentSession().createQuery("from Reply r where r.id="+id);
		Reply reply=(Reply)query.uniqueResult();
		return reply;
	}

}
