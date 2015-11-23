package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabProjectapplyDAO;
import com.xdsc.model.BksxTabProjectapply;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对立项申请的相关操作
 */
public class BksxTabProjectapplyDAOImpl extends HibernateDaoSupport implements
		BksxTabProjectapplyDAO {
	/**
	 * 保存一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public boolean addApply(BksxTabProjectapply apply) {
		this.getHibernateTemplate().save(apply);
		return true;
	}

	/**
	 * 更新一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public boolean updateApply(BksxTabProjectapply apply) {
		this.getHibernateTemplate().update(apply);
		return true;
	}

	/**
	 * 删除一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public boolean deleteApply(BksxTabProjectapply apply) {
		this.getHibernateTemplate().delete(apply);
		return true;
	}

	/**
	 * 根据教师ID得到申请该教师的立项列表
	 * 
	 * @param teacherNum
	 *            教师工号
	 * @return List
	 */
	public List getApplyByTeacherNum(String teacherNum) {
		String hql = "from BksxTabProjectapply bp where bp.tabTeachers.FTeacherNumber='"
				+ teacherNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据学生学号得到一个立项申请列表
	 * 
	 * @param studentNum
	 *            学生学号
	 * @return List
	 */
	public List getApplyByStudentNum(String studentNum) {
		String hql = "from BksxTabProjectapply bp where bp.tabStudents.FStudentNumber='"
				+ studentNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据申请记录ID得到一个BksxTabProjectapply对象
	 * 
	 * @param id
	 *            BksxTabProjectapply对象的ID
	 * @return BksxTabProjectapply
	 */
	public BksxTabProjectapply getApplyByID(int id) {
		String hql = "from BksxTabProjectapply bp where bp.id=" + id;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabProjectapply) this.getHibernateTemplate().find(hql)
					.get(0);
	}
}
