package com.xdsc.service.wsbm.impl;

import com.xdsc.dao.wsbm.MegDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.service.wsbm.MegManager;

/** ��Ϣ����
 * @author ��С��
 * @version 1.2
 */
public class MegManagerImpl implements MegManager{
	/**
	 * DAO���������
	 */
	MegDAO megDAO;

	public MegDAO getMegDAO() {
		return megDAO;
	}

	public void setMegDAO(MegDAO megDAO) {
		this.megDAO = megDAO;
	}
	/**������Ϣ
	 * @param tn ��Ϣ����
	 */
	public void addMeg(TabNotice tn) {
		// TODO Auto-generated method stub
		megDAO.addMeg(tn);
	}

	public void addMeg(TabNoticetosb tnts) {
		// TODO Auto-generated method stub
		megDAO.addMeg(tnts);
	}
	/**������Ϣ
	 * @param tn ��Ϣ����
	 */
	public void updateMeg(TabNotice tn) {
		megDAO.updateMeg(tn);
	}

}
