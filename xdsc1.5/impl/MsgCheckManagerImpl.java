package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.MsgCheckDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.service.wsbm.MsgCheckManager;

/**��Ϣ��ѯ
 * @author ��С��
 * @version 1.2
 */
public class MsgCheckManagerImpl implements MsgCheckManager{
	/**
	 * DAO���������
	 */
	private MsgCheckDAO msgCheckDAO;
	/**��ѯ������Ϣ
	 * @param FAppRegNum ����id
	 * @return ������Ϣ�б�
	 */
	public List<TabNotice> findMsg(String FAppRegNum) {
		// TODO Auto-generated method stub
		return msgCheckDAO.findMsg(FAppRegNum);
	}
	/**���ҹ���Ա��Ϣ
	 * @return ��Ϣ�б�
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
	/** ������Ϣ�Ų�����Ϣ
	 * @param FInfoID ��Ϣid
	 * @return ��Ϣ����
	 */
	public TabNotice findMsgByNum(int FInfoID) {
		// TODO Auto-generated method stub
		return msgCheckDAO.findMsgByNum(FInfoID);
	}

}
