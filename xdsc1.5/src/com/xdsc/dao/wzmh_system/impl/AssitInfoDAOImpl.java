package com.xdsc.dao.wzmh_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wzmh_system.AssitInfoDAO;
import com.xdsc.model.JfptTabOtherassist;

/**
 * ������Ϣά��
 * @author �·�
 *
 */
public class AssitInfoDAOImpl extends HibernateDaoSupport implements AssitInfoDAO {
	/**
	 * ����������Ϣ
	 * @param ����Աʵ��
	 */
	public JfptTabOtherassist findAssitByNum(String num) {
		
		return getHibernateTemplate().get(JfptTabOtherassist.class,num)==null?null:(JfptTabOtherassist)getHibernateTemplate().get(JfptTabOtherassist.class,num);
	}
	/**
	 * �����ʺŲ�ѯ����
	 * @param �ʺ�
	 * @return ����ʵ��
	 */
	public void updateAssitInfo(JfptTabOtherassist Assit) {
		if(Assit==null)
			return;
		this.getHibernateTemplate().update(Assit);
	}
	
	/**
	 * ����һ������Ա
	 * @param Admin
	 */
	public void insertAssitInfo(JfptTabOtherassist Assit) {
		if(Assit==null)
			return;
		this.getHibernateTemplate().save(Assit);
		
	}

}
