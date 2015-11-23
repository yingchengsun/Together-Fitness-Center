package com.xdsc.dao.wzmh_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.xdsc.dao.wzmh_system.NoticeToDao;
import com.xdsc.model.TabNoticetosb;


/**
 * 用户新鲜事
 * 
 * @author 陈丰
 *
 */
public class NoticeToDaoImpl extends HibernateDaoSupport implements NoticeToDao {

	/* (non-Javadoc)
	 * @see com.xdsc.dao.wzmh_system.NoticeToDao#deleteByFInfoId(int)
	 */
	public void deleteByFInfoId(int num) {
		// TODO Auto-generated method stub
		String hql = "from TabNoticetosb  where tabNotice.FInfoId =?";
		TabNoticetosb tb=(TabNoticetosb)(this.getHibernateTemplate().find(hql, num).get(0));
		tb.setFAlreadyRead("1");
		this.getHibernateTemplate().update(tb);
	}
}
