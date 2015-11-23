package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
/**
 * <p>功能：学生课程管理相关的操作，包括课程信息查询、课程通知的查看、课程答疑的查找、提问和回复等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface StudentCourseManageManager {

	/**
	 * <p>功能：根据学生id号查找与之相关的课程信息<br>
	 * @param id 学生id号
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfoBySid(String id);
	
	/**
	 * <p>功能：根据学生id号查找相关的课程答疑信息<br>
	 * @param id 学生id号
	 * @return list 返回相关的课程答疑信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoBySid(String id);
	
	/**
	 * <p>功能：通过课程答疑id号查找与之匹配的对象信息<br>
	 * @param FQuestionId 课程答疑id号
	 * @return JfptTabCourseaskquestion 返回相关的课程答疑对象信息
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int FQuestionId);
	
	/**
	 * <p>功能：根据课程答疑id号查找相关的回复信息<br>
	 * @param FQuestionId 课程答疑的id号
	 * @return list 相关的回复信息
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int FQuestionId);
	
	/**
	 * <p>功能：添加课程答疑回复<br>
	 * @param jfptTabCoursereplyquestion 课程答疑回复对象信息
	 */
	public void addCoursereplyInfo(JfptTabCoursereplyquestion jfptTabCoursereplyquestion);
	
	/**
	 * <p>功能：根据学生id号和课程编号查找相关的课程答疑信息<br>
	 * @param id 学生id号
	 * @param coursenumber 课程编号
	 * @return list 返回相关的课程答疑信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(String id, String coursenumber);
	
	/**
	 * <p>功能：根据课程编号查找课程信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 课程信息
	 */
	public TabCourse findCourseByID(String FCourseNumber);
	
	/**
	 * <p>功能：根据学生学号查找相关学生信息<br>
	 * @param StudentNumber 学生学号
	 * @return TabStudents 返回查找到学生信息
	 */
	public TabStudents findStudentByID(String StudentNumber);
	
	/**
	 * <p>功能：进行课程提问<br>
	 * @param jfptTabCourseaskquestion 课程提问对象
	 */
	public void addCourseaskquestion(JfptTabCourseaskquestion jfptTabCourseaskquestion);
	
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
	 * <p>功能：删除课程通知对应配置信息<br>
	 * @param FNoticeId 课程通知id号
	 * @param id 学生学号
	 */
	public void deleteCourseNoticetotoInfo(int FNoticeId,String id);
}
