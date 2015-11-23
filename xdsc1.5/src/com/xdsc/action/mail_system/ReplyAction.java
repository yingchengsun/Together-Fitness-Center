package com.xdsc.action.mail_system;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;




import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.ReplyDaoInterface;
import com.xdsc.dao.mail_system.TopicDaoInterface;
import com.xdsc.model.Reply;
import com.xdsc.model.Topic;

public class ReplyAction extends ActionSupport {
	
	private Reply reply;
	ReplyDaoInterface replyDao;
	TopicDaoInterface topicDao;
	
	
	public ReplyDaoInterface getReplyDao() {
		return replyDao;
	}

	public void setReplyDao(ReplyDaoInterface replyDao) {
		this.replyDao = replyDao;
	}

	public TopicDaoInterface getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDaoInterface topicDao) {
		this.topicDao = topicDao;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
	public String replytemp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		return SUCCESS;	
	}
	
	public String addreply(){
		
		//…Ë÷√Topic
		HttpServletRequest request = ServletActionContext.getRequest();
		int tid =Integer.parseInt(request.getParameter("id"));
		//TopicDaoInterface tdao = new TopicDao();
		Topic topic = topicDao.selectTopicById(tid);
		reply.setTopic(topic);
		reply.setAuthor((String)request.getSession().getAttribute("manager"));
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		reply.setCreatetime(sqldate);
	
		replyDao.addReply(reply);
		//topic.getReplies().add(reply);
		return SUCCESS;
		
	}

}
