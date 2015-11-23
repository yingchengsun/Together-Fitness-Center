package com.xdsc.dao.jiaofu.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AssistCourseManageDAO;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.util.UpDownFileUtils;

/**
 * <p>功能：助教课程管理相关的操作，包括课程信息查询、课程通知的添加和删除、课程答疑的查找、删除和回复等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AssistCourseManageDAOImpl extends HibernateDaoSupport implements AssistCourseManageDAO{

	/**
	 * <p>功能：根据助教id号查找与之相关的课程信息<br>
	 * @param id 助教id号
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfoByAid(String id) {
		// TODO Auto-generated method stub
		String sql = "from TabCourse t where t.FCourseNumber in (" +
				"select j.tabCourse.FCourseNumber from JfptTabAssistantapply j where j.FShenQing='N' and " +
				"j.FAssistantId='"+id+"'" +
				" )";
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		return list;
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
	 * <p>功能：根据课程答疑对象id删除与之匹配的答疑信息<br>
	 * @param id 答疑对象id号
	 */
	public void deleteAskQuestionByID(int id) {
		// TODO Auto-generated method stub
		JfptTabCourseaskquestion jfptTabCourseaskquestion = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion = (JfptTabCourseaskquestion)this.getHibernateTemplate().get(jfptTabCourseaskquestion.getClass(), id);
		this.getHibernateTemplate().delete(jfptTabCourseaskquestion);
	}

	/**
	 * <p>功能：根据课程答疑id号查找相关的回复信息<br>
	 * @param id 课程答疑的id号
	 * @return list 相关的回复信息
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int id) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCoursereplyquestion r where r.jfptTabCourseaskquestion.FQuestionId="+id;
		List<JfptTabCoursereplyquestion> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：通过课程答疑id号查找与之匹配的对象信息<br>
	 * @param id 课程答疑id号
	 * @return JfptTabCourseaskquestion 返回相关的课程答疑对象信息
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabCourseaskquestion)this.getHibernateTemplate().get(JfptTabCourseaskquestion.class, id);
	}

	/**
	 * <p>功能：根据助教id号和课程编号查找相关的课程答疑信息<br>
	 * @param id 助教id号
	 * @param FCourseNumber 课程编号
	 * @return list 返回相关的课程答疑信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCourseaskquestion a where a.tabCourse.FCourseNumber in(select distinct a.tabCourse.FCourseNumber " +
				"from JfptTabAssistantapply a where a.FAssistantId='"+id+"' and a.tabCourse.FCourseNumber='"+FCourseNumber+"')";
		List<JfptTabCourseaskquestion> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：根据助教id号查找相关的课程答疑信息<br>
	 * @param id 助教id号
	 * @return list 返回查找到的信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoByAid(String id) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCourseaskquestion a where a.tabCourse.FCourseNumber in(select distinct a.tabCourse.FCourseNumber " +
		             "from JfptTabAssistantapply a where a.FAssistantId='"+id+"')";
        List<JfptTabCourseaskquestion> list = this.getHibernateTemplate().find(sql);
        return list;
	}

	/**
	 * <p>功能：添加课程通知信息<br>
	 * @param jfptTabCoursenotice 课程通知信息
	 */
	public void addCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCoursenotice);
	}

	/**
	 * <p>功能：添加课程通知的对应关联对象信息<br>
	 * @param jfptTabNoticetoreceive 课程通知对应的关联对象信息
	 */
	public void addCoursenoticetoto(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabNoticetoreceive);
	}

	/**
	 * <p>功能：删除课程通知信息<br>
	 * @param jfptTabCoursenotice 课程通知对象信息
	 */
	public void deleteCourseNoticeInfo(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		if(jfptTabCoursenotice.getFUrl()==null || jfptTabCoursenotice.getFUrl().equalsIgnoreCase("")){
			this.getHibernateTemplate().delete(jfptTabCoursenotice);
		}else{
			String name = jfptTabCoursenotice.getFUrl().substring(jfptTabCoursenotice.getFUrl().lastIndexOf("/")+1);
			UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\CourseNotice\\", name);
			this.getHibernateTemplate().delete(jfptTabCoursenotice);
		}
	}

	/**
	 * <p>功能：根据课程编号查找相关的课程信息<br>
	 * @param id 课程编号
	 * @return TabCourse 返回相关的课程对象信息
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, id);
	}

	/**
	 * <p>功能：根据id号查找相关的课程通知信息<br>
	 * @param id 个人编号
	 * @return list 课程通知对象信息
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCoursenotice c where c.mhqxTabUser.FUserNumber='"+id+"'";
		List<JfptTabCoursenotice> list = this.getHibernateTemplate().find(sql);
		return list;
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
	 * <p>功能：根据个人编号和课程号查找相关的学生信息<br>
	 * @param id 个人编号
	 * @param Coursenumber 课程编号
	 * @return list 学生信息 <br>list3 学生信息
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,String Coursenumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+Coursenumber+"' and a.FAssistantId='"+id+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String Tid = listt.get(0);
		System.out.println(Tid);
		
		String sql1 = "select distinct c.tabStudents from JfptTabChooseassociate c where c.tabTeachers.FTeacherNumber='"+Tid+"' and c.tabCourse.FCourseNumber='"+Coursenumber+"'";
		String sql2 = "select s.id.FStudentNumber from JfptTabStudentteacher s where s.id.FCourseNumber='"+Coursenumber+"' and s.id.FTeacherNumber='"+Tid+"'";
		List<TabStudents> list = this.getHibernateTemplate().find(sql1);
		if(list.size() > 0){
			return list;
		}else{
			List<String> list2 = this.getHibernateTemplate().find(sql2);
			List<TabStudents> list3 = new ArrayList<TabStudents>();
			for(String i: list2){
				list3.add((TabStudents)this.getHibernateTemplate().get(TabStudents.class, i));
			}
			return list3;
		}
	}

	/**
	 * <p>功能：根据个人编号查找User对象<br>
	 * @param id　个人编号
	 * @return MhqxTabUser 返回查找到个人User信息
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, id);
	}

	/**
	 * <p>功能：保存文件<br>
	 * @see com.xdsc.util.UpDownFileUtils
	 * @param uploadFile 上传文件
	 * @param savePath 保存路径
	 * @param uploadFileFileName 文件名称
	 */
	public void savefile(File uploadFile, String savePath,
			String uploadFileFileName) {
		// TODO Auto-generated method stub
		UpDownFileUtils.saveFile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查找相关的班级号信息<br>
	 * @param id 个人编号
	 * @param FCourseNumber 课程编号
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findClassNumberInfo(java.lang.String, java.lang.String)
	 * @return list 班级号信息
	 */
	public List<String> findClassNumberInfo(String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+FCourseNumber+"' and a.FAssistantId='"+id+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String Tid = listt.get(0);
		
		String sql1 = "select distinct j.id.FClassNumber from JfptTabStudentteacher j where j.id.FTeacherNumber='"+Tid+"' and j.id.FCourseNumber='"+FCourseNumber+"'";
		List<String> list = this.getHibernateTemplate().find(sql1);
		return list;
	}

	/**
	 * <p>功能：查找指定范围内的学生的方向信息<br>
	 * @param listStudentsInfo 学生信息
	 * @param FCourseNumber 课程编号信息
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findDirectionInfo(java.util.List, java.lang.String)
	 * @return list 方向信息
	 */
	public List<TabDirection> findDirectionInfo(
			List<TabStudents> listStudentsInfo, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabChooseassociate j where j.tabCourse.FCourseNumber ='"+FCourseNumber+"'";
		List<JfptTabChooseassociate> listt = this.getHibernateTemplate().find(sql);
		if(listt!=null && listt.size()>0){
			List<TabDirection> list = new ArrayList<TabDirection>();
			return list;
		}else{
			List<TabDirection> list = new ArrayList<TabDirection>();
			for(int i=0; i<listStudentsInfo.size(); i++){
				TabDirection directionn = listStudentsInfo.get(i).getTabDirection();
				if(list == null || (list.contains(directionn) != true)){
					list.add(directionn);
				}
			}
			return list;
		}
	}

	/**
	 * <p>功能：根据班级号、方向号在指定范围内的学生中查找相关学生信息<br>
	 * @param ClassNumber 班级号
	 * @param DirectionNumber 方向编号
	 * @param listStudentsInfo　学生信息
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findStudentsInfo(java.lang.String, int, java.util.List)
	 * @return listt 学生信息
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		int size = listStudentsInfo.size();
		List<TabStudents> listt =  new ArrayList<TabStudents>();
		System.out.println("ClassNumber---"+ClassNumber+"DirectionNumber-----"+DirectionNumber);
		if(ClassNumber.equals("0") && DirectionNumber==0){
			return listStudentsInfo;
		}else if(ClassNumber.equals("0")){//按方向分类
			System.out.println("return direction the message!----------------------------------------------"+listStudentsInfo.size());
			for(int i=0; i<size; i++){
				System.out.println(listStudentsInfo.get(i).getTabDirection().getFDirectionId()+"------------------elements directionid");
				if(listStudentsInfo.get(i).getTabDirection().getFDirectionId()!=DirectionNumber){
				}else{
					listt.add(listStudentsInfo.get(i));
				}
			}
			return listt;
		}else{//按班级分类 
			System.out.println("return classes the message!----------------------------------------------");
			for(int i=0; i<size; i++){
				if(listStudentsInfo.get(i).getTabClasses().getFClassNumber().equals(ClassNumber)){
					listt.add(listStudentsInfo.get(i));
				}
			}
			return listt;
		}
	}

}
