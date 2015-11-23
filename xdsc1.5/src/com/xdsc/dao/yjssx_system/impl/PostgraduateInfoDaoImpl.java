package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.PostgraduateInfoDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;

/**
 * 类功能：对研究生信息的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateInfoDaoImpl extends HibernateDaoSupport implements PostgraduateInfoDao {

	/**
	 * 添加研究生信息，学生基本信息
	 * @param student
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#addStudent(com.xdsc.model.TabStudents)
	 */
	public void addStudent(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);

	}

	/**
	 * 删除学生信息
	 * @param student
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#delStudent(com.xdsc.model.TabStudents)
	 */
	public void delStudent(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(student);
	}

	/**
	 * 查找出所有研究生信息
	 * @return 返回研究生信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findAllStudent()
	 */
	public List<TabPostgraduate> findAllStudent() {
		// TODO Auto-generated method stub
		List<TabPostgraduate> list=(List<TabPostgraduate>)this.getHibernateTemplate().loadAll(TabPostgraduate.class);
		return list;
	}

	/**
	 * 根据研究生ID查找研究生信息
	 * @param StuNum
	 * @return 返回研究生信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findPostgraduateByStuNumber(java.lang.String)
	 */
	public TabPostgraduate findPostgraduateByStuNumber(String StuNum) {
		// TODO Auto-generated method stub
		TabPostgraduate student=(TabPostgraduate)this.getHibernateTemplate().get(TabPostgraduate.class, StuNum);
		return student;
	}

	/**
	 * 更新学生信息
	 * @param student
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#updateStudent(com.xdsc.model.TabStudents)
	 */
	public void updateStudent(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(student);
	}

	/**
	 * 更新研究生信息
	 * @param stu
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#updatePostgraduateStuInfo(com.xdsc.model.TabPostgraduate)
	 */
	public void updatePostgraduateStuInfo(TabPostgraduate stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(stu);
	}

	/**
	 * 根据公司名称查找研究生信息
	 * @param comNum
	 * @return 返回研究生信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findPostgraduateByComNumber(java.lang.String)
	 */
	public List<TabPostgraduate> findPostgraduateByComNumber(String comNum) {
		// TODO Auto-generated method stub
		String hql="from TabPostgraduate stu where stu.tabCompany.FCompanyNumber='"+comNum+"'";
		List<TabPostgraduate> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/** 根据导师姓名查找研究生信息
	 * @param Num
	 * @return 返回研究生信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findPostgraduateByTutorNumber(java.lang.String)
	 */
	public List<TabPostgraduate> findPostgraduateByTutorNumber(String Num) {
		// TODO Auto-generated method stub
		String hql="from TabPostgraduate stu where stu.tabTeachers.FTeacherNumber='"+Num+"'";
		List<TabPostgraduate> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据研究生姓名查找研究生信息
	 * @param name
	 * @return 返回研究生信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findStudentByName(java.lang.String)
	 */
	public List<TabPostgraduate> findStudentByName(String name) {
		// TODO Auto-generated method stub
		String LikeName="%"+name+"%";;           //模糊查询
		String hql="from TabPostgraduate stu where stu.tabStudents.FStudentName like'"+LikeName+"'";
		List<TabPostgraduate> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据用户ID查找用户信息
	 * @param id
	 * @return 用户信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findModuleById(java.lang.String)
	 */
	public MhqxTabUser findModuleById(String id) {
		// TODO Auto-generated method stub
		MhqxTabUser user=(MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, id);
		return user;
	}

	/**
	 * 添加研究生信息，研究生信息
	 * @param stu
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#addPostgraduate(com.xdsc.model.TabPostgraduate)
	 */
	public void addPostgraduate(TabPostgraduate stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(stu);
	}

	/**
	 * 删除用户信息(用户名和密码)
	 * @param user
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#delModuleUser(com.xdsc.model.MhqxTabUser)
	 */
	public void delModuleUser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}

	/**
	 * 根据研究生ID查找研究生信息
	 * @param id
	 * @return 返回研究生信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findStudentById(java.lang.String)
	 */
	public TabStudents findStudentById(String id) {
		// TODO Auto-generated method stub
		TabStudents stu=(TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
		return stu;
	}

	/**
	 * 根据用户输入条件查询研究生详情
	 * @param studentName
	 * @param studentSex
	 * @param tutorNumber
	 * @param companyNumber
	 * @param className
	 * @param gradeName
	 * @param studentType
	 * @param openThesis
	 * @param middleThesis
	 * @param lastThesis
	 * @see com.xdsc.dao.yjssx_system.PostgraduateInfoDao#findPostgraduateByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<TabPostgraduate> findPostgraduateByCondition(
			String studentName, String studentSex, String tutorNumber,
			String companyNumber, String className,String gradeName,
			String studentType, String openThesis, String middleThesis,
			String lastThesis) {
		// TODO Auto-generated method stub
		
		String StudentName="%"+studentName+"%";
		String StudentSex="%"+studentSex+"%";
		String TutorNumber="%"+tutorNumber+"%";
		String CompanyNumber="%"+companyNumber+"%";
		String ClassName="%"+className+"%";
		String GradeName="%"+gradeName+"%";
		String StudentType="%"+studentType+"%";
		String OpenThesis="%"+openThesis+"%";
		String MiddleThesis="%"+middleThesis+"%";
		String LastThesis="%"+lastThesis+"%";
		String hql;
		if((!tutorNumber.equals(""))&&(!companyNumber.equals(""))){
			hql="from TabPostgraduate stu where stu.tabStudents.FStudentName like'"+StudentName+"'"+
			"and stu.tabStudents.FStudentSex like'"+StudentSex+"'"+
			"and stu.tabTeachers.FTeacherName like'"+TutorNumber+"'"+
			"and stu.tabCompany.FCompanyName like'"+CompanyNumber+"'"+
			"and stu.tabStudents.tabClasses.FClassNumber like'"+ClassName+"'"+
			"and stu.tabStudents.tabClasses.tabGrade.FGradeNum like'"+GradeName+"'"+
			"and stu.FType like'"+StudentType+"'"+
			"and stu.FOpenThesisIsSubmit like'"+OpenThesis+"'"+
			"and stu.FMiddleThesIsSubmit like'"+MiddleThesis+"'"+
			"and stu.FThesisIsSubmit like'"+LastThesis+"'";	
		}else if((!tutorNumber.equals(""))&&(companyNumber.equals(""))){
			hql="from TabPostgraduate stu where stu.tabStudents.FStudentName like'"+StudentName+"'"+
			"and stu.tabStudents.FStudentSex like'"+StudentSex+"'"+
			"and stu.tabTeachers.FTeacherName like'"+TutorNumber+"'"+
			"and stu.tabStudents.tabClasses.FClassNumber like'"+ClassName+"'"+
			"and stu.tabStudents.tabClasses.tabGrade.FGradeNum like'"+GradeName+"'"+
			"and stu.FType like'"+StudentType+"'"+
			"and stu.FOpenThesisIsSubmit like'"+OpenThesis+"'"+
			"and stu.FMiddleThesIsSubmit like'"+MiddleThesis+"'"+
			"and stu.FThesisIsSubmit like'"+LastThesis+"'";	
		}else if((tutorNumber.equals(""))&&(!companyNumber.equals(""))){
			hql="from TabPostgraduate stu where stu.tabStudents.FStudentName like'"+StudentName+"'"+
			"and stu.tabStudents.FStudentSex like'"+StudentSex+"'"+
			"and stu.tabCompany.FCompanyName like'"+CompanyNumber+"'"+
			"and stu.tabStudents.tabClasses.FClassNumber like'"+ClassName+"'"+
			"and stu.tabStudents.tabClasses.tabGrade.FGradeNum like'"+GradeName+"'"+
			"and stu.FType like'"+StudentType+"'"+
			"and stu.FOpenThesisIsSubmit like'"+OpenThesis+"'"+
			"and stu.FMiddleThesIsSubmit like'"+MiddleThesis+"'"+
			"and stu.FThesisIsSubmit like'"+LastThesis+"'";
		}else {
			hql="from TabPostgraduate stu where stu.tabStudents.FStudentName like'"+StudentName+"'"+
			"and stu.tabStudents.FStudentSex like'"+StudentSex+"'"+
			"and stu.tabStudents.tabClasses.FClassNumber like'"+ClassName+"'"+
			"and stu.tabStudents.tabClasses.tabGrade.FGradeNum like'"+GradeName+"'"+
			"and stu.FType like'"+StudentType+"'"+
			"and stu.FOpenThesisIsSubmit like'"+OpenThesis+"'"+
			"and stu.FMiddleThesIsSubmit like'"+MiddleThesis+"'"+
			"and stu.FThesisIsSubmit like'"+LastThesis+"'";
		}
		System.out.println("++++++++++++++++++++++++"+hql);
		List<TabPostgraduate> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
