package com.xdsc.service.jiaofu;

import java.io.File;
import java.util.List;

import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
/**
 * <p>功能：教师课程管理相关的操作，包括课程信息查询、课程通知的添加和删除、课程答疑的查找、删除和回复等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface TeacherCourseManageManager {

	/**
	 * <p>功能：根据教师id号查找与之相关的课程信息<br>
	 * @param FTeacherNumber 教师id号
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfoByTid(String FTeacherNumber);
	
	/**
	 * <p>功能：根据教师id号查找相关的课程答疑信息<br>
	 * @param id 教师id号
	 * @return list 返回查找到的信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoByTid(String id);
	
	/**
	 * <p>功能：根据课程答疑id号查找相关的回复信息<br>
	 * @param id 课程答疑的id号
	 * @return list 相关的回复信息
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int id);
	
	/**
	 * <p>功能：通过课程答疑id号查找与之匹配的对象信息<br>
	 * @param id 课程答疑id号
	 * @return JfptTabCourseaskquestion 返回相关的课程答疑对象信息
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int id);
	
	/**
	 * <p>功能：添加课程答疑回复<br>
	 * @param jfptTabCoursereplyquestion 课程答疑回复对象信息
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion);
	
	/**
	 * <p>功能：根据教师id号和课程编号查找相关的课程答疑信息<br>
	 * @param id 教师id号
	 * @param FCourseNumber 课程编号
	 * @return list 返回相关的课程答疑信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String FCourseNumber);
	
	/**
	 * <p>功能：根据课程答疑对象id删除与之匹配的答疑信息<br>
	 * @param id 答疑对象id号
	 */
	public void deleteAskQuestionByID(int id);
	
	/**
	 * <p>功能：根据id号查找相关的课程通知信息<br>
	 * @param id 个人编号
	 * @return list 课程通知对象信息
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id);
	
	/**
	 * <p>功能：根据课程通知id号查找相关的课程通知信息<br>
	 * @param id 课程通知id号
	 * @return JfptTabCoursenotice 课程通知信息
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id);
	
	/**
	 * <p>功能：删除课程通知信息<br>
	 * @param jfptTabCoursenotice 课程通知对象信息
	 */
	public void deleteCourseNoticeInfo(JfptTabCoursenotice jfptTabCoursenotice);
	
	/**
	 * <p>功能：根据课程编号查找相关的课程信息<br>
	 * @param id 课程编号
	 * @return TabCourse 返回相关的课程对象信息
	 */
	public TabCourse findCourseInfoByID(String id);
	
	/**
	 * <p>功能：根据个人编号和课程号查找相关的学生信息<br>
	 * @param id 个人编号
	 * @param Coursenumber 课程编号
	 * @return list 学生信息 <br>list3 学生信息
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,String Coursenumber);
	
	/**
	 * <p>功能：保存文件<br>
	 * @see com.xdsc.util.UpDownFileUtils
	 * @param uploadFile 上传文件
	 * @param savePath 保存路径
	 * @param uploadFileFileName 文件名称
	 */
	public void savefile(File uploadFile,String savePath,String uploadFileFileName);
	
	/**
	 * <p>功能：添加课程通知信息<br>
	 * @param jfptTabCoursenotice 课程通知信息
	 */
	public void addCoursenotice(JfptTabCoursenotice jfptTabCoursenotice);
	
	/**
	 * <p>功能：根据个人编号查找User对象<br>
	 * @param id　个人编号
	 * @return MhqxTabUser 返回查找到个人User信息
	 */
	public MhqxTabUser findUserByID(String id);
	
	/**
	 * <p>功能：添加课程通知的对应关联对象信息<br>
	 * @param jfptTabNoticetoreceive 课程通知对应的关联对象信息
	 */
	public void addCoursenoticetoto(JfptTabNoticetoreceive jfptTabNoticetoreceive);
	
	/**
	 * <p>功能：根据个人编号和课程编号查找相关的班级号信息<br>
	 * @param FTeacherNumber 个人编号
	 * @param FCourseNumber 课程编号
	 * @return list 班级号信息
	 */
	public List<String> findClassNumberInfo(String FTeacherNumber,String FCourseNumber);
	
	/**
	 * <p>功能：查找指定范围内的学生的方向信息<br>
	 * @param listStudentsInfo 学生信息
	 * @param FCourseNumber 课程编号信息
	 * @return list 方向信息
	 */
	public List<TabDirection> findDirectionInfo(List<TabStudents> listStudentsInfo,String FCourseNumber);
	
	/**
	 * <p>功能：根据班级号、方向号在指定范围内的学生中查找相关学生信息<br>
	 * @param ClassNumber 班级号
	 * @param DirectionNumber 方向编号
	 * @param listStudentsInfo　学生信息
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findStudentsInfo(java.lang.String, int, java.util.List)
	 * @return listt 学生信息
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,int DirectionNumber,List<TabStudents> listStudentsInfo);
}
