package com.xdsc.dao.gzfk_system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.TutorInfoDao;
import com.xdsc.model.MhqxTabUser;
//import com.xdsc.model.gzfk_system.TabCompany;

import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;

public class TutorInfoDaoImpl extends HibernateDaoSupport implements TutorInfoDao {

	public void deleteTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(teacher);
	}

	public List<TabTeachers> findAllTutors() {
		// TODO Auto-generated method stub
		String hql="from TabTeacherstotype t where t.tabTeacherstype.FTypeNumber='1'";   //找到所有导师中间表信息
		List<TabTeacherstotype> listTo=this.getHibernateTemplate().find(hql);
		List<TabTeachers> list = new ArrayList<TabTeachers>();
		for(int i=0;i<listTo.size();i++){
			list.add(listTo.get(i).getTabTeachers());
		}
		return list;
	}

	public TabTeachers findTutorById(String num) {
		// TODO Auto-generated method stub
		TabTeachers t=(TabTeachers)this.getHibernateTemplate().get(TabTeachers.class,num);
		return t;
	}

	public void updateTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(teacher);
	}

	public List<TabTeachers> findTutorByName(String name) {
		// TODO Auto-generated method stub
//		String hql="from TabTeachers t where t.FTeacherName='"+name+"'";
//		List<TabTeachers> list=this.getHibernateTemplate().find(hql);
//		return list;
		String LikeName="%"+name+"%";;           //模糊查询
		String hql="from TabTeachers t where t.FTeacherName like'"+LikeName+"'";
		List<TabTeachers> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabTeachers> findAllTeachers() {
		// TODO Auto-generated method stub
		List<TabTeachers> list= this.getHibernateTemplate().loadAll(TabTeachers.class);
		return list;
	}

	public void addTutorType(TabTeacherstotype to) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(to);
	}

	public void addModuleUser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	public void addTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(teacher);
	}

}
