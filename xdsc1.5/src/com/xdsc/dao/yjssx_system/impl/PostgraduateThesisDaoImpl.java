package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.PostgraduateThesisDao;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;

/**
 * 类功能：对研究生提交的论文和导师反馈的论文的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateThesisDaoImpl extends HibernateDaoSupport implements PostgraduateThesisDao {

	/**
	 * 导师反馈论文，保存反馈的论文信息
	 * @param thesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#addReturnThesis(com.xdsc.model.YjssxTabReturnthesis)
	 */
	public void addReturnThesis(YjssxTabReturnthesis thesis) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(thesis);
	}

	/**
	 * 研究生提交论文，保存论文信息
	 * @param thesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#addSubmitThesis(com.xdsc.model.YjssxTabSubmitthesis)
	 */
	public void addSubmitThesis(YjssxTabSubmitthesis thesis) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(thesis);
	}

	/**
	 * 删除反馈的论文
	 * @param thesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#deleteReturnThesis(com.xdsc.model.YjssxTabReturnthesis)
	 */
	public void deleteReturnThesis(YjssxTabReturnthesis thesis) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(thesis);
	}

	/**
	 * 删除提交的论文信息
	 * @param thesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#deleteSubmitThesis(com.xdsc.model.YjssxTabSubmitthesis)
	 */
	public void deleteSubmitThesis(YjssxTabSubmitthesis thesis) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(thesis);
	}

	/**
	 * 根据反馈论文的ID查找论文信息
	 * @param id
	 * @return 反馈论文的详情
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findReturnThesisById(int)
	 */
	public YjssxTabReturnthesis findReturnThesisById(int id) {
		// TODO Auto-generated method stub
		YjssxTabReturnthesis thesis = (YjssxTabReturnthesis)this.getHibernateTemplate().get(YjssxTabReturnthesis.class, id);
		return thesis;
	}

	/**
	 * 根据研究生好查找给研究生回复的论文
	 * @param num
	 * @return 返回反馈的论文
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findReturnThesisByStudentNum(java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByStudentNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabReturnthesis ret where ret.tabPostgraduate.FStudentNumber='"+num+"'"+
		"and ret.FThesisType='"+type+"'";
		List<YjssxTabReturnthesis> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据导师ID查找导师回复的论文
	 * @param num
	 * @return 导师回复的所有论文
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findReturnThesisByTutorNum(java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByTutorNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabReturnthesis ret where ret.tabTeachers.FTeacherNumber='"+num+"'"+
		"and ret.FThesisType='"+type+"'";
		List<YjssxTabReturnthesis> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据论文的ID号来查找论文的信息
	 * @param id
	 * @return 返回论文的详情
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findSubmitThesisById(int)
	 */
	public YjssxTabSubmitthesis findSubmitThesisById(int id) {
		// TODO Auto-generated method stub
		YjssxTabSubmitthesis thesis = (YjssxTabSubmitthesis)this.getHibernateTemplate().get(YjssxTabSubmitthesis.class, id);
		return thesis;
	}

	/**
	 * 根据研究生的ID查找提交的论文
	 * @param num
	 * @return 返回研究生提交的论文
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findSubmitThesisByStudentNum(java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByStudentNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabSubmitthesis sub where sub.tabPostgraduate.FStudentNumber='"+num+"'"+
		"and sub.FThesisType='"+type+"'";
		List<YjssxTabSubmitthesis> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据导师的姓名查找论文提交情况
	 * @param num
	 * @return 提交给该导师的所有论文信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findSubmitThesisByTutorNum(java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByTutorNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabSubmitthesis sub where sub.tabTeachers.FTeacherNumber='"+num+"'"+
		"and sub.FThesisType='"+type+"'";;
		List<YjssxTabSubmitthesis> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 更新反馈的论文信息
	 * @param thesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#updateReturnThesis(com.xdsc.model.YjssxTabReturnthesis)
	 */
	public void updateReturnThesis(YjssxTabReturnthesis thesis) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(thesis);
	}

	/**
	 * 更新提交的论文信息
	 * @param thesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#updateSubmitThesis(com.xdsc.model.YjssxTabSubmitthesis)
	 */
	public void updateSubmitThesis(YjssxTabSubmitthesis thesis) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(thesis);
	}

	/**
	 * 查找所有导师反馈的论文
	 * @return 返回所有查找出来的研究生反馈论文
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findAllReturnThesis()
	 */
	public List<YjssxTabReturnthesis> findAllReturnThesis() {
		// TODO Auto-generated method stub
		List<YjssxTabReturnthesis> list=this.getHibernateTemplate().loadAll(YjssxTabReturnthesis.class);
		return list;
	}

	/**
	 * 根据导师姓名查找研究生反馈论文
	 * @param name
	 * @return 返回研究生反馈的论文
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findReturnThesisByTutorName(java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByTutorNameAndType(String name,String type) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabReturnthesis ret where ret.tabTeachers.FTeacherName='"+name+"'"+
		"and ret.FThesisType='"+type+"'";
		List<YjssxTabReturnthesis> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据条件查找提交的论文
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findSubmitThesisByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByConditionAndType(
			String studentGrade, String studentName, String thesisStatus,String tutorNum,String type) {
		// TODO Auto-generated method stub
		String StudentName="%"+studentName+"%";
		String StudentGrade="%"+studentGrade+"%";
		String ThesisStatus="%"+thesisStatus+"%";
		String hql="from YjssxTabSubmitthesis thesis where thesis.tabPostgraduate.tabStudents.FStudentName like'"+StudentName+"'"+
		"and thesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum like'"+StudentGrade+"'"+
		"and thesis.FStatus like'"+ThesisStatus+"'"+
		"and thesis.tabTeachers.FTeacherNumber='"+tutorNum+"'"+
		"and thesis.FThesisType='"+type+"'";
		List<YjssxTabSubmitthesis> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<YjssxTabSubmitthesis> findSubmitInfoByTutorAndGradeAndType(
			String studentGrade, String tutorName,String type) {
		// TODO Auto-generated method stub
		String StudentGrade="%"+studentGrade+"%";
		String hql="from YjssxTabSubmitthesis thesis where thesis.tabTeachers.FTeacherNumber='"+tutorName+"'"+
		"and thesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum like'"+StudentGrade+"'"+
		"and thesis.FThesisType='"+type+"'";
		List<YjssxTabSubmitthesis> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<YjssxTabReturnthesis> findReturnThesisByConditionAndType(
			String studentGrade, String studentName, String thesisStatus,
			String tutorNum,String type) {
		// TODO Auto-generated method stub
		String StudentName="%"+studentName+"%";
		String StudentGrade="%"+studentGrade+"%";
		String ThesisStatus="%"+thesisStatus+"%";
		String hql="from YjssxTabReturnthesis thesis where thesis.tabPostgraduate.tabStudents.FStudentName like'"+StudentName+"'"+
		"and thesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum like'"+StudentGrade+"'"+
		"and thesis.FStatus like'"+ThesisStatus+"'"+
		"and thesis.tabTeachers.FTeacherNumber='"+tutorNum+"'"+
		"and thesis.FThesisType='"+type+"'";
		List<YjssxTabReturnthesis> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据导师和研究生ID查找提交的论文
	 * @param stuNum
	 * @param tutorNum
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findSubmitThesisByTutorNumAndStudentNum(java.lang.String, java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByTutorNumAndStudentNumAndType(
			String stuNum, String tutorNum,String type) {
		// TODO Auto-generated method stub
		String hql="from YjssxTabSubmitthesis sub where sub.tabPostgraduate.FStudentNumber='"+stuNum+"'"+
		"and sub.tabTeachers.FTeacherNumber='"+tutorNum+"'"+
		"and sub.FThesisType='"+type+"'";
		List<YjssxTabSubmitthesis> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 管理员查找论文提交情况
	 * @param studentName
	 * @param tutorName
	 * @param className
	 * @param gradeName
	 * @param studentType
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findAllThesisReturnInformationByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findAllThesisReturnInformationByConditionAndType(
			String studentName, String tutorName, String className,String gradeName, String studentType, String IsReturned,String ThesisStatus,String type) {
		// TODO Auto-generated method stub
		String StudentName="%"+studentName+"%";
		String TutorName="%"+tutorName+"%";
		String StudentClass="%"+className+"%";
		String StudentGrade="%"+gradeName+"%";
		String StudentType="%"+studentType+"%";
		String ThesisIsReturn="%"+IsReturned+"%";
		String thesisStatus = "%"+ThesisStatus+"%";
		String hql="from YjssxTabReturnthesis thesis where thesis.tabPostgraduate.tabStudents.FStudentName like'"+StudentName+"'"+
		"and thesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum like'"+StudentGrade+"'"+
		"and thesis.tabPostgraduate.tabStudents.tabClasses.FClassNumber like'"+StudentClass+"'"+
		"and thesis.tabTeachers.FTeacherName like'"+TutorName+"'"+
		"and thesis.tabPostgraduate.FType like'"+StudentType+"'"+
		"and thesis.FThesisIsReturn like'"+ThesisIsReturn+"'"+
		"and thesis.FStatus like'"+thesisStatus+"'"+
		"and thesis.FThesisType='"+type+"'";
		List<YjssxTabReturnthesis> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 管理员查找论文反馈情况
	 * @param studentName
	 * @param tutorName
	 * @param className
	 * @param gradeName
	 * @param studentType
	 * @param IsReturned
	 * @param ThesisStatus
	 * @see com.xdsc.dao.yjssx_system.PostgraduateThesisDao#findAllThesisSubmitInformationByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findAllThesisSubmitInformationByConditionAndType(
			String studentName, String tutorName, String className,String gradeName, String studentType,String type) {
			String StudentName="%"+studentName+"%";
			String TutorName="%"+tutorName+"%";
			String StudentClass="%"+className+"%";
			String StudentGrade="%"+gradeName+"%";
			String StudentType="%"+studentType+"%";
			String hql="from YjssxTabSubmitthesis thesis where thesis.tabPostgraduate.tabStudents.FStudentName like'"+StudentName+"'"+
			"and thesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum like'"+StudentGrade+"'"+
			"and thesis.tabPostgraduate.tabStudents.tabClasses.FClassNumber like'"+StudentClass+"'"+
			"and thesis.tabTeachers.FTeacherName like'"+TutorName+"'"+
			"and thesis.tabPostgraduate.FType like'"+StudentType+"'"+
			"and thesis.FThesisType='"+type+"'";
			List<YjssxTabSubmitthesis> list=this.getHibernateTemplate().find(hql);
			return list;
	}

}
