package com.xdsc.dao.wsbm.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.RegAppliDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
/** ����ע��
 * @author ��С��
 * @version 1.2
 */
public class RegAppliDAOImpl extends HibernateDaoSupport implements RegAppliDAO {
	/**��ӿ���
	 * @param regAppli ��������
	 */
	public void addRegAppli(WsbmTabRegapplicant regAppli) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(regAppli);	
	}
	/**���ϵͳ�û�
	 * @param fun ϵͳ�û�����
	 */
	public void addRegAppli(MhqxTabUser fun) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(fun);
	}

}
