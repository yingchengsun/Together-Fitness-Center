package com.xdsc.dao.wzmh_system.impl;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;



import com.xdsc.dao.wzmh_system.MhqxTabNavigationDAO;
import com.xdsc.model.MhqxTabLink;
import com.xdsc.model.MhqxTabNavigation;
import com.xdsc.util.HibernateUtil;



public class MhqxTabNavigationDAOImpl implements MhqxTabNavigationDAO{
private HibernateTemplate hibernateTemplate;
	
	/**
	 * ����һ��navigation��¼
	 * @param n
	 * @return true
	 */
	public boolean save(MhqxTabNavigation n)
	{
		if(n==null)
			return false;
		hibernateTemplate.save(n);
		return true;
	}
	
	/**
	 * ɾ��һ��navigation��¼
	 * @param n
	 * @return true
	 */
	public boolean delete(MhqxTabNavigation n) 
	{
		if(n==null)
			return false;
		hibernateTemplate.delete(n);
		return true;
	}
   /**
    * ����һ��navigation��¼
    * @param n
    * @return true
    */
	public boolean update(MhqxTabNavigation n)
	{
		if(n==null)
		return false;
		hibernateTemplate.saveOrUpdate(n);
		return true;
    }
	
	/**
	 *�������ݿ������е�navigation��¼
	 * @return List<MhqxTabNavigation>
	 */
	public List<MhqxTabNavigation> findAllMhqxTabNavigation (){
		String hql = "from MhqxTabNavigation navigation order by navigation.FNavigationPriority";
		List<MhqxTabNavigation> navigation = this.getHibernateTemplate().find(hql);
		return navigation;
	}
	/**
	 * ͨ��id�õ�һ��navigation��¼
	 * @param FNavigationId
	 * @return MhqxTabNavigation
	 */
	public MhqxTabNavigation getMhqxTabNavigationByID(int FNavigationId) {
		String hql = "from MhqxTabNavigation navigation where navigation.FNavigationId="
				+ FNavigationId;
		List<MhqxTabNavigation> navigation=getHibernateTemplate().find(hql);
		return navigation.isEmpty()?null:navigation.get(0);
	}
	/**
	 * ͨ�������FNavigationNameֵ���ҵ���ƥ�������navigation��¼
	 * @param FNavigationName
	 * @return List< MhqxTabNavigation>
	 */

	public List<MhqxTabNavigation> findMhqxTabNavigationByName(String FNavigationName) {
		String str1="%"+FNavigationName+"%";
		String hql = "from  MhqxTabNavigation navigation where navigation.FNavigationName like '"+str1+"' order by navigation.FNavigationPriority";
		List< MhqxTabNavigation> navigation = this.getHibernateTemplate().find(hql);
		return navigation;
	}
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

}