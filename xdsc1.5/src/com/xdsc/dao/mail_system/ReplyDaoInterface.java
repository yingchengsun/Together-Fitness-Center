package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Reply;

public interface ReplyDaoInterface {

	//查询所有留言
	public abstract List<Reply> selectAll();

	//增加留言
	public abstract void addReply(Reply reply);

	//删除留言
	public abstract void deleteReply(Reply reply);

	public abstract Reply selectReplyById(int id);

}