package com.xdsc.dao.wsbm.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.MegDAO;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;

/**��Ϣ���͸���
 * @author ��С��
 * @version 1.2
 */
public class MegDAOImpl extends HibernateDaoSupport implements MegDAO{
	/**�����Ϣ
	 *  @param tn ��Ϣ����
	 */
	public void addMeg(TabNotice tn) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(tn);
	}

	public void addMeg(TabNoticetosb tnts) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(tnts);
	}
	/**������Ϣ
	 *  @param tn ��Ϣ����
	 */
	public void updateMeg(TabNotice tn) {
		System.out.println("start@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		this.getHibernateTemplate().update(tn);
		System.out.println("finish@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

}
