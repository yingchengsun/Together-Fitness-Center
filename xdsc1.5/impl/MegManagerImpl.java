package com.xdsc.service.wsbm.impl;

import com.xdsc.dao.wsbm.MegDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.service.wsbm.MegManager;

/** 消息管理
 * @author 苟小龙
 * @version 1.2
 */
public class MegManagerImpl implements MegManager{
	/**
	 * DAO层对象属性
	 */
	MegDAO megDAO;

	public MegDAO getMegDAO() {
		return megDAO;
	}

	public void setMegDAO(MegDAO megDAO) {
		this.megDAO = megDAO;
	}
	/**插入消息
	 * @param tn 消息对象
	 */
	public void addMeg(TabNotice tn) {
		// TODO Auto-generated method stub
		megDAO.addMeg(tn);
	}

	public void addMeg(TabNoticetosb tnts) {
		// TODO Auto-generated method stub
		megDAO.addMeg(tnts);
	}
	/**更新消息
	 * @param tn 消息对象
	 */
	public void updateMeg(TabNotice tn) {
		megDAO.updateMeg(tn);
	}

}
