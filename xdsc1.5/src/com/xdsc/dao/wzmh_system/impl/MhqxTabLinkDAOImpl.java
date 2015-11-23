package com.xdsc.dao.wzmh_system.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xdsc.dao.wzmh_system.MhqxTabLinkDAO;
import com.xdsc.model.MhqxTabLink;
/**
 * @author 高雅
 *
 */

public class MhqxTabLinkDAOImpl   implements MhqxTabLinkDAO {

	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 保存一条link记录
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
	 * 删除一条link记录
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
    * 更新一条link记录
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
	 *查找数据库中所有的link记录
	 * @return List<MhqxTabLink>
	 */
	public List<MhqxTabLink> findAllMhqxTabLink() {
		String hql = "from MhqxTabLink link order by link.FLinkPriority ";
		List<MhqxTabLink> list = this.getHibernateTemplate().find(hql);
		return list.isEmpty()?null:list;
	}
	/**
	 * 通过id得到一条link记录
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
	 * 通过传入的Title值查找到相匹配的所有link记录
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
