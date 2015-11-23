package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.StudentSelectTutorDispachDao;
import com.xdsc.model.YjssxTabTutorselectdispach;

/**
 * 类功能：管理员分发研究生报名信息数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class StudentSelectTutorDispachDaoImpl extends HibernateDaoSupport implements
		StudentSelectTutorDispachDao {

	/**
	 * 添加一个信息的研究生分配信息
	 * @param student
	 * @see com.xdsc.dao.yjssx_system.StudentSelectTutorDispachDao#addDispachedStudent(com.xdsc.model.YjssxTabTutorselectdispach)
	 */
	public void addDispachedStudent(YjssxTabTutorselectdispach student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
	}

	/**
	 * 删除研究生分配信息
	 * @param student
	 * @see com.xdsc.dao.yjssx_system.StudentSelectTutorDispachDao#deleteDispachInfo(com.xdsc.model.YjssxTabTutorselectdispach)
	 */
	public void deleteDispachInfo(YjssxTabTutorselectdispach student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(student);
	}

	/**
	 * 根据研究生ID查找研究生分配信息
	 * @param name
	 * @return 研究生分配信息
	 * @see com.xdsc.dao.yjssx_system.StudentSelectTutorDispachDao#findDispachInfoByStudentName(java.lang.String)
	 */
	public List<YjssxTabTutorselectdispach> findDispachInfoByStudentName(
			String name) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabTutorselectdispach dispach where dispach.tabPostgraduate.tabStudents.FStudentName='"+name+"'";
		List<YjssxTabTutorselectdispach> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据导师ID查找导师分配信息
	 * @param num
	 * @return 返回导师分配信息
	 * @see com.xdsc.dao.yjssx_system.StudentSelectTutorDispachDao#findDispachInfoByTutorNum(java.lang.String)
	 */
	public List<YjssxTabTutorselectdispach> findDispachInfoByTutorNum(
			String num) {
		String hql="from YjssxTabTutorselectdispach dispach where dispach.tabTeachers.FTeacherNumber='"+num+"'";
		List<YjssxTabTutorselectdispach> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
