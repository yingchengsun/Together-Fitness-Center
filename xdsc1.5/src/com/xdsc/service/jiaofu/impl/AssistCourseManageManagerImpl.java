package com.xdsc.service.jiaofu.impl;

import java.io.File;
import java.util.List;

import com.xdsc.dao.jiaofu.AssistCourseManageDAO;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.AssistCourseManageManager;
/**
 * <p>功能：助教课程管理相关的操作，包括课程信息查询、课程通知的添加和删除、课程答疑的查找、删除和回复等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AssistCourseManageManagerImpl implements AssistCourseManageManager{
	/**DAO层对象*/
	private AssistCourseManageDAO assistCourseManageDAO;

	public AssistCourseManageDAO getAssistCourseManageDAO() {
		return assistCourseManageDAO;
	}

	public void setAssistCourseManageDAO(AssistCourseManageDAO assistCourseManageDAO) {
		this.assistCourseManageDAO = assistCourseManageDAO;
	}

	/**
	 * <p>功能：根据助教id号查找与之相关的课程信息<br>
	 * @param id 助教id号
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfoByAid(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseInfoByAid(id);
	}

	/**
	 * <p>功能：添加课程答疑回复<br>
	 * @param jfptTabCoursereplyquestion 课程答疑回复对象信息
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.addCoursereplyInfo(jfptTabCoursereplyquestion);
	}

	/**
	 * <p>功能：根据课程答疑对象id删除与之匹配的答疑信息<br>
	 * @param id 答疑对象id号
	 */
	public void deleteAskQuestionByID(int id) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.deleteAskQuestionByID(id);
	}

	/**
	 * <p>功能：根据课程答疑id号查找相关的回复信息<br>
	 * @param id 课程答疑的id号
	 * @return list 相关的回复信息
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseReplyInfoByID(id);
	}

	/**
	 * <p>功能：通过课程答疑id号查找与之匹配的对象信息<br>
	 * @param id 课程答疑id号
	 * @return JfptTabCourseaskquestion 返回相关的课程答疑对象信息
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseaskquestionInfoByID(id);
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
		return assistCourseManageDAO.findQuestionReplayInfoByTwo(id, FCourseNumber);
	}

	/**
	 * <p>功能：根据助教id号查找相关的课程答疑信息<br>
	 * @param id 助教id号
	 * @return list 返回查找到的信息
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoByAid(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findQuestionReplyInfoByAid(id);
	}

	/**
	 * <p>功能：添加课程通知信息<br>
	 * @param jfptTabCoursenotice 课程通知信息
	 */
	public void addCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.addCoursenotice(jfptTabCoursenotice);
	}

	/**
	 * <p>功能：添加课程通知的对应关联对象信息<br>
	 * @param jfptTabNoticetoreceive 课程通知对应的关联对象信息
	 */
	public void addCoursenoticetoto(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.addCoursenoticetoto(jfptTabNoticetoreceive);
	}

	/**
	 * <p>功能：删除课程通知信息<br>
	 * @param jfptTabCoursenotice 课程通知对象信息
	 */
	public void deleteCourseNoticeInfo(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.deleteCourseNoticeInfo(jfptTabCoursenotice);
	}

	/**
	 * <p>功能：根据课程编号查找相关的课程信息<br>
	 * @param id 课程编号
	 * @return TabCourse 返回相关的课程对象信息
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseInfoByID(id);
	}

	/**
	 * <p>功能：根据id号查找相关的课程通知信息<br>
	 * @param id 个人编号
	 * @return list 课程通知对象信息
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseNoticeInfo(id);
	}

	/**
	 * <p>功能：根据课程通知id号查找相关的课程通知信息<br>
	 * @param id 课程通知id号
	 * @return JfptTabCoursenotice 课程通知信息
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseNoticeInfoByID(id);
	}

	/**
	 * <p>功能：根据个人编号和课程号查找相关的学生信息<br>
	 * @param id 个人编号
	 * @param Coursenumber 课程编号
	 * @return list 学生信息 <br>list3 学生信息
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,
			String Coursenumber) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findStudentsInfoByTwo(id, Coursenumber);
	}

	/**
	 * <p>功能：根据个人编号查找User对象<br>
	 * @param id　个人编号
	 * @return MhqxTabUser 返回查找到个人User信息
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findUserByID(id);
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
		assistCourseManageDAO.savefile(uploadFile, savePath, uploadFileFileName);
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
		return assistCourseManageDAO.findClassNumberInfo(id, FCourseNumber);
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
		return assistCourseManageDAO.findDirectionInfo(listStudentsInfo, FCourseNumber);
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
		return assistCourseManageDAO.findStudentsInfo(ClassNumber, DirectionNumber, listStudentsInfo);
	}
}
