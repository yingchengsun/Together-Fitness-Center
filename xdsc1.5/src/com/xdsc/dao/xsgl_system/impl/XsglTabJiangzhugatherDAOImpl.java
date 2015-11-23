package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabJiangzhugatherDAO;
import com.xdsc.model.XsglTabJiangzhugather;


public class XsglTabJiangzhugatherDAOImpl extends HibernateDaoSupport implements XsglTabJiangzhugatherDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhugatherDAO#saveJiangzhu(com.xdsc.model.xsgl_system.XsglTabJiangzhugather)
	 */
	public boolean saveJiangzhu(XsglTabJiangzhugather fund) {
		this.getHibernateTemplate().save(fund);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhugatherDAO#deleteJiangzhu(com.xdsc.model.xsgl_system.XsglTabJiangzhugather)
	 */
	public boolean deleteJiangzhu(XsglTabJiangzhugather fund){
		this.getHibernateTemplate().delete(fund);
		return true;
	}
	
	public boolean updateJiangzhu(XsglTabJiangzhugather fund){
		this.getHibernateTemplate().update(fund);
		return true;
	}
	
	public List<XsglTabJiangzhugather> getFundList(){
		String hql="from XsglTabJiangzhugather";
		return this.getHibernateTemplate().find(hql);
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhugatherDAO#getJiangzhuList()
	 */
	public List<XsglTabJiangzhugather> getLoanList(){
		String hql="from XsglTabJiangzhugather xtj where xtj.FName like '%助学贷款%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhugather> getStipendList(){
		String hql = "from XsglTabJiangzhugather xtj where xtj.FName like '%助学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhugather> getScholarshipList(){
		String hql = "from XsglTabJiangzhugather xtj where xtj.FName like '%奖学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public XsglTabJiangzhugather getFundById(int id){
		String hql="from XsglTabJiangzhugather xtj where xtj.FId='"+id+"'";
		return (XsglTabJiangzhugather)this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<XsglTabJiangzhugather> getFundByClassNum(String classNum){
		String hql="from XsglTabJiangzhugather xtj where xtj.tabClasses.FClassNumber='"+classNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhugather> getFundByYear(String year){
		String hql="from XsglTabJiangzhugather xtj where xtj.FYear='"+year+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhugather> getFundByNameClassAndYear(String classNum,String year,String name){
		String hql="from XsglTabJiangzhugather xtj where xtj.tabClasses.FClassNumber='"+classNum+"'and xtj.FYear='"+year+"' and xtj.FName like '%"+name+"%'";
		return this.getHibernateTemplate().find(hql);
	}
}
