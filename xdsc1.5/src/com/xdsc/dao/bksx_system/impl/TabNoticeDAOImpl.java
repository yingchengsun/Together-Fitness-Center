package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.TabNoticeDAO;
import com.xdsc.model.TabNotice;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对答辩通知的相关操作
 */
public class TabNoticeDAOImpl extends HibernateDaoSupport implements
		TabNoticeDAO {
	/**
	 * 保存一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public boolean saveNotice(TabNotice notice) {
		this.getHibernateTemplate().save(notice);
		return true;
	}

	/**
	 * 删除一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public boolean deleteNotice(TabNotice notice) {
		this.getHibernateTemplate().delete(notice);
		return true;
	}

	/**
	 * 更新一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public boolean updateNotice(TabNotice notice) {
		this.getHibernateTemplate().update(notice);
		return true;
	}

	/**
	 * 根据答辩通知唯一ID得到该信息的对象
	 * 
	 * @param noticeID
	 *            答辩通知唯一ＩＤ
	 * @return TabNotice
	 */
	public TabNotice getNoticebyID(int noticeID) {
		String hql = "from TabNotice t where t.FInfoId=" + noticeID;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabNotice) this.getHibernateTemplate().find(hql).get(0);
	}

	/**
	 * 得到所有的答辩通知对象列表
	 * 
	 * @return List
	 */
	public List getCheckNoticeList() {
		String hql = "from TabNotice t where t.FModuleId='6'";
		return this.getHibernateTemplate().find(hql);
	}
}
