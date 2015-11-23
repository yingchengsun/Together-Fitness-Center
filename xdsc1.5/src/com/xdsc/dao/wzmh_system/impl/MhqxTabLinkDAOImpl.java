package com.xdsc.dao.wzmh_system.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xdsc.dao.wzmh_system.MhqxTabLinkDAO;
import com.xdsc.model.MhqxTabLink;
/**
 * @author ����
 *
 */

public class MhqxTabLinkDAOImpl   implements MhqxTabLinkDAO {

	private HibernateTemplate hibernateTemplate;
	
	/**
	 * ����һ��link��¼
	 * @param l
	 * @return true
	 */
	public boolean save(MhqxTabLink l)
	{
		if(l==null)
			return false;
		hibernateTemplate.save(l);
		return true;
	}
	
	/**
	 * ɾ��һ��link��¼
	 * @param l
	 * @return true
	 */
	public boolean delete(MhqxTabLink l) 
	{
		if(l==null)
			return false;
		hibernateTemplate.delete(l);
		return true;
	}
   /**
    * ����һ��link��¼
    * @param l
    * @return true
    */
	public boolean update(MhqxTabLink l)
	{
		if(l==null)
			return false;
		hibernateTemplate.saveOrUpdate(l);
		return true;
    }
	
	/**
	 *�������ݿ������е�link��¼
	 * @return List<MhqxTabLink>
	 */
	public List<MhqxTabLink> findAllMhqxTabLink() {
		String hql = "from MhqxTabLink link order by link.FLinkPriority ";
		List<MhqxTabLink> list = this.getHibernateTemplate().find(hql);
		return list.isEmpty()?null:list;
	}
	/**
	 * ͨ��id�õ�һ��link��¼
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public MhqxTabLink getMhqxTabLinkByID(int FLinkId) {
	
		String hql = "from MhqxTabLink link where link.FLinkId="
				+ FLinkId;
		List<MhqxTabLink> list = this.getHibernateTemplate().find(hql);
		return  list.isEmpty()?null:(MhqxTabLink)list.get(0);
	}
	/**
	 * ͨ�������Titleֵ���ҵ���ƥ�������link��¼
	 * @param FLinkTitle
	 * @return List< MhqxTabLink>
	 */
	public List< MhqxTabLink> findMhqxTabLinkByTitle(String FLinkTitle) {
		String str1="%"+FLinkTitle+"%";
		String hql = "from  MhqxTabLink link where link.FLinkTitle like '"+str1+"' order by link.FLinkPriority ";
		List< MhqxTabLink> link = this.getHibernateTemplate().find(hql);
		return link.isEmpty()?null:link;
	}
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

}
