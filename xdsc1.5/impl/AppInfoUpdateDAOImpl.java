package com.xdsc.dao.wsbm.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.AppInfoUpdateDAO;
import com.xdsc.model.WsbmTabRegapplicant;

/**������Ϣ����
 * @author ��С��
 * @version 1.2
 */
public class AppInfoUpdateDAOImpl extends HibernateDaoSupport implements AppInfoUpdateDAO{

	/**���¿�����Ϣ
	 * @param wsbmTabRegapplicant ��������
	 */
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.getHibernateTemplate().update(wsbmTabRegapplicant);
	}
	/**���ҵ�������
	 * @param FAppRegNum ����id
	 * @return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum) ��������
	 */
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum) {
		// TODO Auto-generated method stub
		return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum);	}

}
