package com.xdsc.dao.wsbm.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.AppInfoUpdateDAO;
import com.xdsc.model.WsbmTabRegapplicant;

/**考生信息更新
 * @author 苟小龙
 * @version 1.2
 */
public class AppInfoUpdateDAOImpl extends HibernateDaoSupport implements AppInfoUpdateDAO{

	/**更新考生信息
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.getHibernateTemplate().update(wsbmTabRegapplicant);
	}
	/**查找单个考生
	 * @param FAppRegNum 考生id
	 * @return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum) 考生对象
	 */
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum) {
		// TODO Auto-generated method stub
		return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum);	}

}
