package com.xdsc.dao.wzmh_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wzmh_system.AssitInfoDAO;
import com.xdsc.model.JfptTabOtherassist;

/**
 * 助教信息维护
 * @author 陈丰
 *
 */
public class AssitInfoDAOImpl extends HibernateDaoSupport implements AssitInfoDAO {
	/**
	 * 更新助教信息
	 * @param 管理员实例
	 */
	public JfptTabOtherassist findAssitByNum(String num) {
		
		return getHibernateTemplate().get(JfptTabOtherassist.class,num)==null?null:(JfptTabOtherassist)getHibernateTemplate().get(JfptTabOtherassist.class,num);
	}
	/**
	 * 根据帐号查询助教
	 * @param 帐号
	 * @return 助教实例
	 */
	public void updateAssitInfo(JfptTabOtherassist Assit) {
		if(Assit==null)
			return;
		this.getHibernateTemplate().update(Assit);
	}
	
	/**
	 * 插入一个管理员
	 * @param Admin
	 */
	public void insertAssitInfo(JfptTabOtherassist Assit) {
		if(Assit==null)
			return;
		this.getHibernateTemplate().save(Assit);
		
	}

}
