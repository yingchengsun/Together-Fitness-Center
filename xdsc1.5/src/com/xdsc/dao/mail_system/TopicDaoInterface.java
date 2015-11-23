package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Topic;

public interface TopicDaoInterface {

	public abstract List selectTopic();

	public abstract Topic selectTopicById(int id);

	public abstract void addTopic(Topic topic);

	public abstract void deleteTopic(Topic topic);

}