package com.xdsc.dao.wsbm.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.MegDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;

/**消息发送更新
 * @author 苟小龙
 * @version 1.2
 */
public class MegDAOImpl extends HibernateDaoSupport implements MegDAO{
	/**添加消息
	 *  @param tn 消息对象
	 */
	public void addMeg(TabNotice tn) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(tn);
	}

	public void addMeg(TabNoticetosb tnts) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(tnts);
	}
	/**更新消息
	 *  @param tn 消息对象
	 */
	public void updateMeg(TabNotice tn) {
		System.out.println("start@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		this.getHibernateTemplate().update(tn);
		System.out.println("finish@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

}
