package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.TabNoticeDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.service.bksx_system.TabNoticeManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对答辩通知的相关操作
 */
public class TabNoticeManagerImpl implements TabNoticeManager {
	/**
	 * TabNoticeDAOImpl接口
	 */
	TabNoticeDAO tabNoticeDAO;

	/**
	 * tabNoticeDAO属性的Get与Set方法
	 */
	public TabNoticeDAO getTabNoticeDAO() {
		return tabNoticeDAO;
	}

	public void setTabNoticeDAO(TabNoticeDAO tabNoticeDAO) {
		this.tabNoticeDAO = tabNoticeDAO;
	}

	/**
	 * 保存一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public boolean saveNotice(TabNotice notice) {
		return tabNoticeDAO.saveNotice(notice);
	}

	/**
	 * 删除一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public boolean deleteNotice(TabNotice notice) {
		return tabNoticeDAO.deleteNotice(notice);
	}

	/**
	 * 更新一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public boolean updateNotice(TabNotice notice) {
		return tabNoticeDAO.updateNotice(notice);
	}

	/**
	 * 根据答辩通知唯一ID得到该信息的对象
	 * 
	 * @param noticeID
	 *            答辩通知唯一ＩＤ
	 * @return TabNotice
	 */
	public TabNotice getNoticebyID(int noticeID) {
		return tabNoticeDAO.getNoticebyID(noticeID);
	}

	/**
	 * 得到所有的答辩通知对象列表
	 * 
	 * @return List
	 */
	public List getCheckNoticeList() {
		return tabNoticeDAO.getCheckNoticeList();
	}
}
