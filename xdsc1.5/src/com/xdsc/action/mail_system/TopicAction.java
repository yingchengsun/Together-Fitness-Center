package com.xdsc.action.mail_system;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;




import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.ReplyDao;
import com.xdsc.dao.mail_system.TopicDao;
import com.xdsc.dao.mail_system.TopicDaoInterface;
import com.xdsc.model.Topic;

public class TopicAction extends ActionSupport {
	
	private Topic topic;
	TopicDaoInterface topicDao;
	

	public TopicDaoInterface getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDaoInterface topicDao) {
		this.topicDao = topicDao;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public String showTopic(){
		//TopicDaoInterface tdao = new TopicDao();
		List topiclist = topicDao.selectTopic();
		ActionContext context = ActionContext.getContext();
		Map request =(Map) context.get("request");
		request.put("topiclist", topiclist);
		return "showtopic";
	}
	
	public String addTopic(){
		
		//TopicDaoInterface tdao = new TopicDao();
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		topic.setCreatetime(sqldate);
		topic.setIp(ip);
		Set replies = new HashSet(0);
		
		topic.setReplies(replies);
		topicDao.addTopic(topic);
		return SUCCESS;
		
	}
	
	public String deleteTopic(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		//TopicDaoInterface tdao = new TopicDao();
		topicDao.deleteTopic(topicDao.selectTopicById(id));
		return SUCCESS;
	}
	

}
