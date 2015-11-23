package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.dao.wsbm.WsbmTabRegapplicantDAO;

/**�ʺŴ���
 * @author ��С��
 * @version 1.2
 */
public class WsbmTabRegapplicantDAOImpl extends HibernateDaoSupport implements WsbmTabRegapplicantDAO
{

	@SuppressWarnings("unchecked")
	/**��������û��б�
	 * @return (List<WsbmTabRegapplicant>)this.getHibernateTemplate().find(hql) �����ʺ��б� 
	 */
	public List<WsbmTabRegapplicant> findAllWsbmTabRegapplicants()
	{
		String hql = "from WsbmTabRegapplicant WsbmTabRegapplicant order by WsbmTabRegapplicant.id desc";
		return (List<WsbmTabRegapplicant>)this.getHibernateTemplate().find(hql);
	}
	/** ���ҿ���
	 * @param id 
	 * @return WsbmTabRegapplicant ��������
	 */
	public WsbmTabRegapplicant findWsbmTabRegapplicantById(Integer id)
	{
		WsbmTabRegapplicant WsbmTabRegapplicant = (WsbmTabRegapplicant) this.getHibernateTemplate().get(WsbmTabRegapplicant.class, id);
		return WsbmTabRegapplicant;
	}
	/**ɾ���˺�
	 * @param wsbmTabRegapplicant ��������
	 */
	public void removeWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant)
	{
		this.getHibernateTemplate().delete(wsbmTabRegapplicant);
	}
	/**���濼������
	 * @param wsbmTabRegapplicant ��������
	 */
	public void saveWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant)
	{
		this.getHibernateTemplate().save(wsbmTabRegapplicant);
	}
	/**���¿�������
	 * @param wsbmTabRegapplicant ��������
	 */
	public void updateWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant)
	{
		this.getHibernateTemplate().update(wsbmTabRegapplicant);
	}


}
