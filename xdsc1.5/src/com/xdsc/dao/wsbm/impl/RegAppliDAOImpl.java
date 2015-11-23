package com.xdsc.dao.wsbm.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.RegAppliDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
/** 考生注册
 * @author 苟小龙
 * @version 1.2
 */
public class RegAppliDAOImpl extends HibernateDaoSupport implements RegAppliDAO {
	/**添加考生
	 * @param regAppli 考生对象
	 */
	public void addRegAppli(WsbmTabRegapplicant regAppli) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(regAppli);	
	}
	/**添加系统用户
	 * @param fun 系统用户对象
	 */
	public void addRegAppli(MhqxTabUser fun) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(fun);
	}

}
