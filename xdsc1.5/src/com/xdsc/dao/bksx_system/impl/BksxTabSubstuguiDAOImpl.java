package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabSubstuguiDAO;
import com.xdsc.model.BksxTabSubstugui;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSubstugui的相关操作
 */
public class BksxTabSubstuguiDAOImpl extends HibernateDaoSupport implements
		BksxTabSubstuguiDAO {

	/**
	 * 得到所有选题学生不为空的选题对象列表
	 * 
	 * @return List
	 */
	public List<BksxTabSubstugui> getSubstuguiList() {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据选题记录ID查找唯一的BksxTabSubstugui对象
	 * 
	 * @param id
	 *            选题记录唯一ID
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiById(int id) {
		String hql = "from BksxTabSubstugui bs where bs.FSubStuGuiId=" + id;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSubstugui) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * 保存一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public boolean saveSubstugui(BksxTabSubstugui substugui) {
		this.getHibernateTemplate().save(substugui);
		return true;
	}

	/**
	 * 删除一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public boolean deleteSubstugui(BksxTabSubstugui substugui) {
		this.getHibernateTemplate().delete(substugui);
		return true;
	}

	/**
	 * 更新一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public boolean updateSubstugui(BksxTabSubstugui substugui) {
		this.getHibernateTemplate().update(substugui);
		return true;
	}

	/**
	 * 根据一条HQL语句查询特定属性的BksxTabSubstugui对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public List<BksxTabSubstugui> getSomeSubstuguiList(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据学生学号查询返回一个BksxTabSubstugui对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiByStuNum(String stuNum) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSubstugui) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName + "' and bs.FTeacherDegreen='" + teacherDegree
				+ "' and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 得到所有的研究型（个人项目）且存在选题学生的BksxTabSubstugui对象列表
	 * 
	 * @return List
	 */
	public List getReacherList() {
		String hql = "from BksxTabSubstugui bs where bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个项目型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getProjectListByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.bksxTabProject != null and bs.FTeacherName='"
				+ teacherName
				+ "' and bs.FTeacherDegreen='"
				+ teacherDegree
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName + "' and bs.FTeacherDegreen='" + teacherDegree
				+ "' and bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据学生年级和课题来源查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param startDate
	 *            一年的开始日期
	 * @param endDate
	 *            一年的结束日期
	 * @return List
	 */
	public List getSubstuguiListByGradeCategory(Date startDate, Date endDate,
			String substuguiCategory) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents.FStudentRegData >= :startDate and bs.tabStudents.FStudentRegData <= :endDate and bs."
				+ substuguiCategory + "='Y'";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * 根据学生年级和课题类型查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param startDate
	 *            一年的开始日期
	 * @param endDate
	 *            一年的结束日期
	 * @param subtype
	 *            课题类型
	 * @return List
	 */
	public List getResearchByGrade(Date startDate, Date endDate, String subtype) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents.FStudentRegData >= :startDate and bs.tabStudents.FStudentRegData <= :endDate and bs."
				+ subtype + "='Y' and bs.bksxTabProject = null";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * 根据课题类型查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param subtype
	 *            课题类型
	 * @return List
	 */
	public List getReacherListByType(String type) {
		String hql = "from BksxTabSubstugui bs where bs."
				+ type
				+ "='Y' and bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个得到该教师的未被学生选题的课题信息对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName,
			String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents = null and bs.FTeacherName='"
				+ teacherName
				+ "' and bs.FTeacherDegreen='"
				+ teacherDegree
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 返回一个所有教师未被审核课题的对象列表
	 * 
	 * @return List
	 */
	public List getApplySubjectList() {
		String hql = "from BksxTabSubstugui bs where bs.FIsChecked = '待审核'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 返回一个可供选择的毕业设计课题的对象列表
	 * 
	 * @return List
	 */
	public List getAvilableSubjectList() {
		String hql = "from BksxTabSubstugui bs where bs.FIsChecked = '已通过' and bs.tabStudents = null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名查询返回一个得到该教师的未被学生选题的课题信息对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents = null and bs.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName + "' and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名查询返回一个项目型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getProjectListByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.bksxTabProject != null and bs.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName
				+ "' and bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}
}
