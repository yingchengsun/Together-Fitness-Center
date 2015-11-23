package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.TabNoticeDAO;
import com.xdsc.model.TabNotice;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Դ��֪ͨ����ز���
 */
public class TabNoticeDAOImpl extends HibernateDaoSupport implements
		TabNoticeDAO {
	/**
	 * ����һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public boolean saveNotice(TabNotice notice) {
		this.getHibernateTemplate().save(notice);
		return true;
	}

	/**
	 * ɾ��һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public boolean deleteNotice(TabNotice notice) {
		this.getHibernateTemplate().delete(notice);
		return true;
	}

	/**
	 * ����һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public boolean updateNotice(TabNotice notice) {
		this.getHibernateTemplate().update(notice);
		return true;
	}

	/**
	 * ���ݴ��֪ͨΨһID�õ�����Ϣ�Ķ���
	 * 
	 * @param noticeID
	 *            ���֪ͨΨһ�ɣ�
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
	 * �õ����еĴ��֪ͨ�����б�
	 * 
	 * @return List
	 */
	public List getCheckNoticeList() {
		String hql = "from TabNotice t where t.FModuleId='6'";
		return this.getHibernateTemplate().find(hql);
	}
}
