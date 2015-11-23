package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.dao.wsbm.WsbmTabRegapplicantDAO;

/**帐号处理
 * @author 苟小龙
 * @version 1.2
 */
public class WsbmTabRegapplicantDAOImpl extends HibernateDaoSupport implements WsbmTabRegapplicantDAO
{

	@SuppressWarnings("unchecked")
	/**获得所有用户列表
	 * @return (List<WsbmTabRegapplicant>)this.getHibernateTemplate().find(hql) 考生帐号列表 
	 */
	public List<WsbmTabRegapplicant> findAllWsbmTabRegapplicants()
	{
		String hql = "from WsbmTabRegapplicant WsbmTabRegapplicant order by WsbmTabRegapplicant.id desc";
		return (List<WsbmTabRegapplicant>)this.getHibernateTemplate().find(hql);
	}
	/** 查找考生
	 * @param id 
	 * @return WsbmTabRegapplicant 考生对象
	 */
	public WsbmTabRegapplicant findWsbmTabRegapplicantById(Integer id)
	{
		WsbmTabRegapplicant WsbmTabRegapplicant = (WsbmTabRegapplicant) this.getHibernateTemplate().get(WsbmTabRegapplicant.class, id);
		return WsbmTabRegapplicant;
	}
	/**删除账号
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void removeWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant)
	{
		this.getHibernateTemplate().delete(wsbmTabRegapplicant);
	}
	/**保存考生对象
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void saveWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant)
	{
		this.getHibernateTemplate().save(wsbmTabRegapplicant);
	}
	/**更新考生对象
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void updateWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant)
	{
		this.getHibernateTemplate().update(wsbmTabRegapplicant);
	}


}
