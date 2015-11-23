package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabGradeDAO;
import com.xdsc.model.TabGrade;

public class XsglTabGradeDAOImpl extends HibernateDaoSupport implements XsglTabGradeDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabGradegatherDAO#saveGrade(com.xdsc.model.xsgl_system.XsglTabGradegather)
	 */
	public boolean saveGrade(TabGrade grade){
		this.getHibernateTemplate().save(grade);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabGradegatherDAO#deleteGrade(com.xdsc.model.xsgl_system.XsglTabGradegather)
	 */
	public boolean deleteGrade(TabGrade grade){
		this.getHibernateTemplate().delete(grade);
		return true;
	}
	
	public boolean updateGrade(TabGrade grade){
		this.getHibernateTemplate().update(grade);
		return true;
	}
	
	public TabGrade getGradeByGradeId(int gradeId){
		String hql="from TabGrade tg where tg.FGradeId='"+gradeId+"'";
		return (TabGrade)this.getHibernateTemplate().find(hql).get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabGradegatherDAO#getGradeListByUndergraduate()
	 */
	public List<TabGrade> getGradeListByUndergraduate(){
		String hql="from TabGrade tg where tg.FGradeName like '%本科生%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabGradegatherDAO#getGradeListByPostgraduate()
	 */
	public List<TabGrade> getGradeListByPostgraduate(){
		String hql = "from TabGrade tg where tg.FGradeName like '%研究生%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabGrade> getGradeList(){
		String hql="from TabGrade";
		return this.getHibernateTemplate().find(hql);
	}
	
	public TabGrade getGradeByGradeName(String gradeName){
		String hql="from TabGrade tg where tg.FGradeName='"+gradeName+"'";
		List list = this.getHibernateTemplate().find(hql);
		if(list.isEmpty()) return null;
		else return (TabGrade)list.get(0);
	}

}
