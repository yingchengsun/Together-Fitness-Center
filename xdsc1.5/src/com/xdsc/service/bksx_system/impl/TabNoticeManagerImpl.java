package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.TabNoticeDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.service.bksx_system.TabNoticeManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Դ��֪ͨ����ز���
 */
public class TabNoticeManagerImpl implements TabNoticeManager {
	/**
	 * TabNoticeDAOImpl�ӿ�
	 */
	TabNoticeDAO tabNoticeDAO;

	/**
	 * tabNoticeDAO���Ե�Get��Set����
	 */
	public TabNoticeDAO getTabNoticeDAO() {
		return tabNoticeDAO;
	}

	public void setTabNoticeDAO(TabNoticeDAO tabNoticeDAO) {
		this.tabNoticeDAO = tabNoticeDAO;
	}

	/**
	 * ����һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public boolean saveNotice(TabNotice notice) {
		return tabNoticeDAO.saveNotice(notice);
	}

	/**
	 * ɾ��һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public boolean deleteNotice(TabNotice notice) {
		return tabNoticeDAO.deleteNotice(notice);
	}

	/**
	 * ����һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public boolean updateNotice(TabNotice notice) {
		return tabNoticeDAO.updateNotice(notice);
	}

	/**
	 * ���ݴ��֪ͨΨһID�õ�����Ϣ�Ķ���
	 * 
	 * @param noticeID
	 *            ���֪ͨΨһ�ɣ�
	 * @return TabNotice
	 */
	public TabNotice getNoticebyID(int noticeID) {
		return tabNoticeDAO.getNoticebyID(noticeID);
	}

	/**
	 * �õ����еĴ��֪ͨ�����б�
	 * 
	 * @return List
	 */
	public List getCheckNoticeList() {
		return tabNoticeDAO.getCheckNoticeList();
	}
}
