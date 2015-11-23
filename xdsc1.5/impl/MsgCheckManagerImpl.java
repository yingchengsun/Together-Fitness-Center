package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.MsgCheckDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.service.wsbm.MsgCheckManager;

/**消息查询
 * @author 苟小龙
 * @version 1.2
 */
public class MsgCheckManagerImpl implements MsgCheckManager{
	/**
	 * DAO层对象属性
	 */
	private MsgCheckDAO msgCheckDAO;
	/**查询考生消息
	 * @param FAppRegNum 考生id
	 * @return 考生消息列表
	 */
	public List<TabNotice> findMsg(String FAppRegNum) {
		// TODO Auto-generated method stub
		return msgCheckDAO.findMsg(FAppRegNum);
	}
	/**查找管理员消息
	 * @return 消息列表
	 */
	public List<TabNotice> findAdMsg(){
		return msgCheckDAO.findAdMsg();
	}

	public MsgCheckDAO getMsgCheckDAO() {
		return msgCheckDAO;
	}
	public void setMsgCheckDAO(MsgCheckDAO msgCheckDAO) {
		this.msgCheckDAO = msgCheckDAO;
	}
	/** 根据消息号查找消息
	 * @param FInfoID 消息id
	 * @return 消息对象
	 */
	public TabNotice findMsgByNum(int FInfoID) {
		// TODO Auto-generated method stub
		return msgCheckDAO.findMsgByNum(FInfoID);
	}

}
