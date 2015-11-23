package com.xdsc.dao.jiaofu.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.StudentCourseManageDAO;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;

/**
 * <p>功能：学生课程管理相关的操作，包括课程信息查询、课程通知的查看、课程答疑的查找、提问和回复等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class StudentCourseManageDAOImpl extends HibernateDaoSupport implements StudentCourseManageDAO{

	/**
	 * <p>功能：根据学生id号查找与之相关的课程信息<br>
	 * @param id 学生id号
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfoBySid(String id) {
		// TODO Auto-generated method stub
		String sql1 = "from TabCourse t where t.FCourseNumber in (" +
				"select j.id.FCourseNumber from JfptTabStudentteacher j where" +
				" j.id.FStudentNumber='"+id+"')";
		String sql = "from TabCourse t where t.FCourseNumber in (" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c" +
				" where c.tabStudents.FStudentNumber='"+id+"')";
		List<TabCourse> list1 = this.getHibernateTemplate().find(sql1);
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		for(TabCourse i: list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>功能：根据学生id号查找相关的课程答疑信息<br>
	 * @param id 学生id号
	 * @return list 返回相关的课程答疑信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoBySid(String id) {
		// TODO Auto-generated method stub
		List<JfptTabCourseaskquestion> list = new ArrayList<JfptTabCourseaskquestion>();
		TabStudents student = new TabStudents();
		student = (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
		if(student==null)
			return list;
		String classnumber = student.getTabClasses().getFClassNumber();
		if(classnumber==null)
			return list;
		String sql = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c where c.tabStudents.FStudentNumber='"+id+"')";
		list =  this.getHibernateTemplate().find(sql);
		
		String sql1 = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select s.id.FCourseNumber from JfptTabStudentteacher s where s.id.FStudentNumber='"+id+"')";
		List<JfptTabCourseaskquestion> list1 =  this.getHibernateTemplate().find(sql1);
		for(JfptTabCourseaskquestion i:list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>功能：根据课程答疑id号查找相关的回复信息<br>
	 * @param FQuestionId 课程答疑的id号
	 * @return list 相关的回复信息
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(
			int FQuestionId) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCoursereplyquestion r where r.jfptTabCourseaskquestion.FQuestionId="+FQuestionId;
		List<JfptTabCoursereplyquestion> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：通过课程答疑id号查找与之匹配的对象信息<br>
	 * @param FQuestionId 课程答疑id号
	 * @return JfptTabCourseaskquestion 返回相关的课程答疑对象信息
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(
			int FQuestionId) {
		// TODO Auto-generated method stub
		return (JfptTabCourseaskquestion)this.getHibernateTemplate().get(JfptTabCourseaskquestion.class, FQuestionId);
	}

	/**
	 * <p>功能：添加课程答疑回复<br>
	 * @param jfptTabCoursereplyquestion 课程答疑回复对象信息
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCoursereplyquestion);
	}

	/**
	 * <p>功能：根据学生id号和课程编号查找相关的课程答疑信息<br>
	 * @param id 学生id号
	 * @param FCourseNumber 课程编号
	 * @return list 返回相关的课程答疑信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		TabStudents student = new TabStudents();
		student = (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
		String classnumber = student.getTabClasses().getFClassNumber();
		String sql = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c where c.tabStudents.FStudentNumber='"+id+"' and c.tabCourse.FCourseNumber='"+FCourseNumber+"')";
		List<JfptTabCourseaskquestion> list =  this.getHibernateTemplate().find(sql);
		
		String sql1 = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select s.id.FCourseNumber from JfptTabStudentteacher s where s.id.FStudentNumber='"+id+"' and s.id.FCourseNumber='"+FCourseNumber+"')";
		List<JfptTabCourseaskquestion> list1 =  this.getHibernateTemplate().find(sql1);
		for(JfptTabCourseaskquestion i:list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>功能：根据课程编号查找课程信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 课程信息
	 */
	public TabCourse findCourseByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>功能：根据学生学号查找相关学生信息<br>
	 * @param StudentNumber 学生学号
	 * @return TabStudents 返回查找到学生信息
	 */
	public TabStudents findStudentByID(String StudentNumber) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, StudentNumber);
	}

	/**
	 * <p>功能：进行课程提问<br>
	 * @param jfptTabCourseaskquestion 课程提问对象
	 */
	public void addCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCourseaskquestion);
	}

	/**
	 * <p>功能：根据id号查找相关的课程通知信息<br>
	 * @param id 个人编号
	 * @return list 课程通知对象信息
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
//		String sql = "from JfptTabCoursenotice c where c.mhqxTabUser.FUserNumber="+id;
//		List<JfptTabCoursenotice> list = this.getHibernateTemplate().find(sql);
//		return list;
		
		String sql = "select n.jfptTabCoursenotice.FNoticeId from JfptTabNoticetoreceive n where n.mhqxTabUser.FUserNumber='"+id+"'";
		List<Integer> list = this.getHibernateTemplate().find(sql);
		List<JfptTabCoursenotice> listto= new ArrayList<JfptTabCoursenotice>();
		for(Integer i: list){
			listto.add((JfptTabCoursenotice)this.getHibernateTemplate().get(JfptTabCoursenotice.class, i));
		}
		return listto;
	}

	/**
	 * <p>功能：根据课程通知id号查找相关的课程通知信息<br>
	 * @param id 课程通知id号
	 * @return JfptTabCoursenotice 课程通知信息
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabCoursenotice)this.getHibernateTemplate().get(JfptTabCoursenotice.class, id);
	}

	/**
	 * <p>功能：删除课程通知对应配置信息<br>
	 * @param FNoticeId 课程通知id号
	 * @param id 学生学号
	 */
	public void deleteCourseNoticetotoInfo(int FNoticeId, String id) {
		// TODO Auto-generated method stub
		JfptTabNoticetoreceive toto = new JfptTabNoticetoreceive();
		String sql = "from JfptTabNoticetoreceive n where n.mhqxTabUser.FUserNumber='"+id+"' and n.jfptTabCoursenotice.FNoticeId="+FNoticeId;
		List<JfptTabNoticetoreceive> list = this.getHibernateTemplate().find(sql);
		this.getHibernateTemplate().delete(list.get(0));
	}
}
