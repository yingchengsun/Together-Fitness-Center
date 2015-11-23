package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabPartygatherDAO;
import com.xdsc.model.XsglTabPartygather;

public class XsglTabPartygatherDAOImpl extends HibernateDaoSupport implements XsglTabPartygatherDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartygatherDAO#saveParty(com.xdsc.model.xsgl_system.XsglTabPartygather)
	 */
	public boolean saveParty(XsglTabPartygather party) {
		this.getHibernateTemplate().save(party);
		return true;
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartygatherDAO#deleteParty(com.xdsc.model.xsgl_system.XsglTabPartygather)
	 */
	public boolean deleteParty(XsglTabPartygather party) {
		this.getHibernateTemplate().delete(party);
		return true;
	}
	
	public boolean updateParty(XsglTabPartygather party){
		this.getHibernateTemplate().update(party);
		return true;
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartygatherDAO#getPartyList()
	 */
	public List<XsglTabPartygather> getPartyList() {
		String hql = "from XsglTabPartygather";
		return this.getHibernateTemplate().find(hql);
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartygatherDAO#getPartyByFCNum(java.lang.String)
	 */
	public XsglTabPartygather getPartyByFCNum(String FCNum) {
		String hql = "from XsglTabPartygather xtpg where xtpg.tabClasses.FClassNumber='" + FCNum
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (XsglTabPartygather) this.getHibernateTemplate().find(hql).get(0);
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartygatherDAO#getPartyByFName(java.lang.String)
	 */
	public XsglTabPartygather getPartyByFName(String FName) {
		String hql = "from XsglTabPartygather xtpg where xtpg.FName=" + FName;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (XsglTabPartygather) this.getHibernateTemplate().find(hql).get(0);
	}

	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartygatherDAO#updateParty(com.xdsc.model.xsgl_system.XsglTabPartygather)
	 */
	
	public XsglTabPartygather getPartyByFId(int FId){
		String hql="from XsglTabPartygather xtpg where xtpg.FId='"+FId+"'";
		return (XsglTabPartygather)this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<XsglTabPartygather> getPartyByNameYearAndClass(String year,String classid,String name){
		String hql="from XsglTabPartygather xtpg where xtpg.FYear='"+year+"' and xtpg.tabClasses.FClassNumber='"+classid+"' and xtpg.FName='"+name+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
}
