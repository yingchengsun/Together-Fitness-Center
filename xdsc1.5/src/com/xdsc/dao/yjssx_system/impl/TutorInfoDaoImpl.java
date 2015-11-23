package com.xdsc.dao.yjssx_system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.TutorInfoDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;

/**
 * 类功能：导师信息的数据库操作(增删改查)
 * @author 许鑫
 * @version 1.1
 */
public class TutorInfoDaoImpl extends HibernateDaoSupport implements TutorInfoDao {

	/**
	 * 删除导师信息
	 * @param teacher
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#deleteTutorInfo(com.xdsc.model.TabTeachers)
	 */
	public void deleteTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(teacher);
	}

	/**
	 * 查找所有导师信息
	 * @return 返回所有导师信息
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#findAllTutors()
	 */
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

	/**
	 * 根据导师ID查找导师信息
	 * @param num
	 * @return 返回导师信息
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#findTutorById(java.lang.String)
	 */
	public TabTeachers findTutorById(String num) {
		// TODO Auto-generated method stub
		TabTeachers t=(TabTeachers)this.getHibernateTemplate().get(TabTeachers.class,num);
		return t;
	}

	/**
	 * 更新导师信息
	 * @param teacher
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#updateTutorInfo(com.xdsc.model.TabTeachers)
	 */
	public void updateTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(teacher);
	}

	/**
	 * 根据导师姓名查找导师信息
	 * @param name
	 * @return 返回导师信息列表
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#findTutorByName(java.lang.String)
	 */
	public List<TabTeachers> findTutorByName(String name) {
		// TODO Auto-generated method stub
		String LikeName="%"+name+"%";;           //模糊查询
		String hql="from TabTeachers t where t.FTeacherName like'"+LikeName+"'";
		List<TabTeachers> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 查找所有老师信息
	 * @return 返回所有来时信息列表
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#findAllTeachers()
	 */
	public List<TabTeachers> findAllTeachers() {
		// TODO Auto-generated method stub
		List<TabTeachers> list= this.getHibernateTemplate().loadAll(TabTeachers.class);
		return list;
	}

	/**
	 * 增加导师类型
	 * @param to
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#addTutorType(com.xdsc.model.TabTeacherstotype)
	 */
	public void addTutorType(TabTeacherstotype to) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(to);
	}

	/**
	 * 添加一个系统用户
	 * @param user
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#addModuleUser(com.xdsc.model.MhqxTabUser)
	 */
	public void addModuleUser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 添加一个新的教师
	 * @param teacher
	 * @see com.xdsc.dao.yjssx_system.TutorInfoDao#addTeacher(com.xdsc.model.TabTeachers)
	 */
	public void addTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(teacher);
	}

}
