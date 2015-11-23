package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabPartyDAO;
import com.xdsc.model.XsglTabParty;

public class XsglTabPartyDAOImpl extends HibernateDaoSupport implements XsglTabPartyDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartyDAO#savePartyMember(com.xdsc.model.XsglTabParty)
	 */
	public boolean savePartyMember(XsglTabParty partyMember){
		this.getHibernateTemplate().save(partyMember);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartyDAO#deletePartyMember(com.xdsc.model.XsglTabParty)
	 */
	public boolean deletePartyMember(XsglTabParty partyMember){
		this.getHibernateTemplate().delete(partyMember);
		return true;
	}
	
	public boolean updatePartyMember(XsglTabParty partyMember){
		this.getHibernateTemplate().update(partyMember);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartyDAO#getPartyMemberList()
	 */
	public List<XsglTabParty> getPartyMemberList(){
		String hql = "form XsglTabParty";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabPartyDAO#getPartyMemberByFName(java.lang.String)
	 */
	public List<XsglTabParty> getPartyMemberByFName(String FName){
		String hql="from XsglTabParty xp where xp.FName='"+FName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParty> getPartyMemberByClass(String classid){
		String hql="from XsglTabParty xp where xp.tabStudents.tabClasses.FClassNumber='"+classid+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParty> getPartyMemberByClassAndFName(String classid,String fName){
		String hql="from XsglTabParty xp where xp.FName='"+fName+"'and xp.tabStudents.tabClasses.FClassNumber='"+classid+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public XsglTabParty getPartyMemberByFId(int FId){
		String hql="from XsglTabParty xp where xp.FId='"+FId+"'";
		return (XsglTabParty)this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<XsglTabParty> getPartyMemberByStuNum(String StuNum){
		String hql="from XsglTabParty xp where xp.tabStudents.FStudentNumber='"+StuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParty> getPartyMemberListByGrade(int gradeId){
		String hql="from XsglTabParty xp where xp.tabStudents.tabClasses.tabGrade.FGradeId='"+gradeId+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParty> getPartyMemberByNameYearAndClass(String year,String classid,String name){
		String hql="from XsglTabParty xp where xp.FYear='"+year+"' and xp.tabStudents.tabClasses.FClassNumber='"+classid+"' and xp.FName='"+name+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
