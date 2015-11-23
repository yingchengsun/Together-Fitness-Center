package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Reply;

public interface ReplyDaoInterface {

	//��ѯ��������
	public abstract List<Reply> selectAll();

	//��������
	public abstract void addReply(Reply reply);

	//ɾ������
	public abstract void deleteReply(Reply reply);

	public abstract Reply selectReplyById(int id);

}