package com.xdsc.dao.jiaofu.impl;

import java.io.File;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.StudentHomeworkManageDAO;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.util.UpDownFileUtils;

/**
 * <p>功能：有关作业管理中涉及到的方法，进行作业通知、作业批改、成绩管理等<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentHomeworkManageDAOImpl extends HibernateDaoSupport implements StudentHomeworkManageDAO{

	/**
	 * <p>功能：根据作业通知id号查找相关详细信息<br>
	 * @param FHomeNoticeId 作业通知id号
	 * @return JfptTabHomenotice 作业通知信息
	 */
	public JfptTabHomenotice findHomeDetailByID(int FHomeNoticeId) {
		// TODO Auto-generated method stub
		return (JfptTabHomenotice)this.getHibernateTemplate().get(JfptTabHomenotice.class, FHomeNoticeId);
	}

	/**
	 * <p>功能：根据作业配置对应信息id号查找相关信息<br>
	 * @param FNumber 配置信息id号
	 * @return JfptTabHomenoticetireceive 作业配置对应信息
	 */
	public JfptTabHomenoticetoreceive findHomeNoticetotoInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabHomenoticetoreceive)this.getHibernateTemplate().get(JfptTabHomenoticetoreceive.class, FNumber);
	}

	/**
	 * <p>功能：根据学生学号查找相对应的作业配置信息<br>
	 * @param sid 学生学号
	 * @return list 返回对应信息
	 */
	public List<JfptTabHomenoticetoreceive> findHomeNoticetotoInfoBySid(String sid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabHomenoticetoreceive t where t.tabStudents.FStudentNumber='"+sid+"'";
		List<JfptTabHomenoticetoreceive> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：删除作业对应配置信息<br>
	 * @param jfptTabHomenoticetoreceive 作业配置对应信息
	 */
	public void deleteHomeNoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabHomenoticetoreceive);
	}

	/**
	 * <p>功能：更新作业配置信息<br>
	 * @param jfptTabHomenoticetoreceive 作业配置信息
	 */
	public void updateHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jfptTabHomenoticetoreceive);
	}

	//**************************************************************************
	/**
	 * <p>功能：查找自己提交的作业信息<br>
	 * @param sid 学生学号
	 * @return list 作业提交信息
	 */
	public List<JfptTabHomeupload> findHomeUploadInfoBySid(String sid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabHomeupload h where h.tabStudents.FStudentNumber='"+sid+"'";
		List<JfptTabHomeupload> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：根据上传作业信息id号查找相关详细信息<br>
	 * @param FHomeId 上传作业信息id号
	 * @return JfptTabHomeupload 上传作业对象信息
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int FHomeId) {
		// TODO Auto-generated method stub
		System.out.println("findHomeworkDetailByID--------------student-----------DAOImpl");
		return (JfptTabHomeupload)this.getHibernateTemplate().get(JfptTabHomeupload.class, FHomeId);
	}

	/**
	 * <p>功能：更新作业信息<br>
	 * @param jfptTabHomeupload 作业信息对象
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jfptTabHomeupload);
	}

	/**
	 * <p>功能：删除作业信息<br>
	 * @param jfptTabHomeupload 作业上传信息
	 */
	public void deleteHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		if(jfptTabHomeupload.getFFilePath()!=null){
			String name = jfptTabHomeupload.getFFilePath().substring(jfptTabHomeupload.getFFilePath().lastIndexOf("/")+1);
			UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\HomeUpload\\", name);
		}
		this.getHibernateTemplate().delete(jfptTabHomeupload);
	}
	
	/**
	 * <p>功能：根据学生学号查找相关的课程信息<br>
	 * @param id 学生学号
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
	 * <p>功能：根据课程号查找课程详细信息<br>
	 * @param id 课程编号
	 * @return TabCourse 课程相关信息
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, id);
	}

	/**
	 * <p>功能：根据学生学号查找学生信息<br>
	 * @param sid 学生学号
	 * @return TabStudents 学生信息
	 */
	public TabStudents findStudentsInfoBySid(String sid) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, sid);
	}

	/**
	 * <p>功能：保存文件<br>
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
	 * <p>功能：提交作业<br>
	 * @param jfptTabHomeupload 作业信息
	 */
	public void addHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabHomeupload);
	}

}
