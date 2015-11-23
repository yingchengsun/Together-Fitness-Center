package com.xdsc.service.jiaofu.impl;

import java.io.File;
import java.util.List;

import com.xdsc.dao.jiaofu.TeacherHomeworkManageDAO;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.TeacherHomeworkManageManager;
/**
 * <p>功能：有关作业管理中涉及到的方法，进行作业通知、作业批改、成绩管理等<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherHomeworkManageManagerImpl implements TeacherHomeworkManageManager{
	/**DAO层对象*/
	private TeacherHomeworkManageDAO teacherHomeworkManageDAO;

	public TeacherHomeworkManageDAO getTeacherHomeworkManageDAO() {
		return teacherHomeworkManageDAO;
	}

	public void setTeacherHomeworkManageDAO(
			TeacherHomeworkManageDAO teacherHomeworkManageDAO) {
		this.teacherHomeworkManageDAO = teacherHomeworkManageDAO;
	}

	/**
	 * <p>功能：根据个人id号查找相关的课程信息<br>
	 * @param id 个人编号
	 * @return list 返回相关的课程信息
	 */
	public List<TabCourse> findCourseInfoByTid(String id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findCourseInfoByTid(id);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查找相关的学生的成绩信息<br>
	 * @param FCourseNumber 课程编号
	 * @param tid 教师编号
	 * @return list 学生成绩信息
	 */
	public List<JfptTabUsualscore> findUsualscoreInfoByTwo(
			String FCourseNumber, String tid) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUsualscoreInfoByTwo(FCourseNumber, tid);
	}

	/**
	 * <p>功能：删除平时成绩信息<br>
	 * @param jfptTabUsualscore 平时成绩信息
	 */
	public void deleteUsualscoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.deleteUsualscoreInfo(jfptTabUsualscore);
	}

	/**
	 * <p>功能：根据成绩id号查找相关的成绩信息<br>
	 * @param FNumber 成绩信息id号
	 * @return JfptTabUsualscore 平时成绩信息
	 */
	public JfptTabUsualscore findUsualscoreInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUsualscoreInfoByID(FNumber);
	}

	/**
	 * <p>功能：根据课程号查找课程详细信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 课程相关信息
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>功能：添加平时成绩信息<br>
	 * @param jfptTabUsualscore 平时成绩信息
	 */
	public void addUsualScoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.addUsualScoreInfo(jfptTabUsualscore);
	}

	/**
	 * <p>功能：根据学生学号查找相关的学生信息<br>
	 * @param FStudentNumber 学生学号
	 * @return TabStudents 学生信息
	 */
	public TabStudents findStudentsInfoByID(String FStudentNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsInfoByID(FStudentNumber);
	}

	/**
	 * <p>功能：查看个人发送的作业通知信息<br>
	 * @param tid 个人编号
	 * @return list 返回作业信息
	 */
	public List<JfptTabHomenotice> findHomeNoticeInfoByTid(String tid) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeNoticeInfoByTid(tid);
	}

	/**
	 * <p>功能：删除作业信息，并级联删除相关的配置信息<br>
	 * @param jfptTabHomenotice 作业通知信息
	 */
	public void deleteHome(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.deleteHome(jfptTabHomenotice);
	}

	/**
	 * <p>功能：根据作业通知id号查找相关详细信息<br>
	 * @param id 作业通知id号
	 * @return JfptTabHomenotice 作业通知信息
	 */
	public JfptTabHomenotice findHomeDetailByID(int id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeDetailByID(id);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查找相关的学生信息<br>
	 * @param id 个人编号
	 * @param Coursenumber 课程编号
	 * @return list 相关学生信息
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,
			String Coursenumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsInfoByTwo(id, Coursenumber);
	}

	/**
	 * <p>功能：添加作业通知信息<br>
	 * @param jfptTabHomenotice 作业通知信息
	 */
	public void addHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.addHomenotice(jfptTabHomenotice);
	}

	/**
	 * <p>功能：作业通知相关配置信息存储<br>
	 * @param jfptTabHomenoticetoreceive 通知配置信息
	 */
	public void addHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.addHomenoticetoto(jfptTabHomenoticetoreceive);
	}
	
	/**
	 * <p>功能：根据学生学号查找学生信息<br>
	 * @param id 学生学号
	 * @return TabStudents 学生信息
	 */
	public TabStudents findStudentsByID(String id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsByID(id);
	}

	/**
	 * <p>功能：根据个人编号查找User信息<br>
	 * @param id 个人编号
	 * @return MhqxTabUser User对象信息
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUserByID(id);
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
		teacherHomeworkManageDAO.savefile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查看相关的学生作业信息<br>
	 * @param tid 教师编号
	 * @param FCourseNumber 课程编号
	 * @return list 学生作业信息
	 */
	public List<JfptTabHomeupload> findHomeworkInfoByTwo(String tid,
			String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeworkInfoByTwo(tid, FCourseNumber);
	}

	/**
	 * <p>功能：根据上传作业信息id号查找相关详细信息<br>
	 * @param id 上传作业信息id号
	 * @return JfptTabHomeupload 上传作业对象信息
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeworkDetailByID(id);
	}

	/**
	 * <p>功能：更新作业信息<br>
	 * @param jfptTabHomeupload 作业信息对象
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.updateHomeworkInfo(jfptTabHomeupload);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查找相关的班级信息<br>
	 * @param FTeacherNumber 个人编号
	 * @param FCourseNumber 课程编号
	 * @return list 返回相关班级编号信息
	 */
	public List<String> findClassNumberInfo(String FTeacherNumber,
			String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findClassNumberInfo(FTeacherNumber, FCourseNumber);
	}

	/**
	 * <p>功能：根据课程编号查找指定学生的方向信息<br>
	 * @param listStudentsInfo 学生对象信息
	 * @param FCourseNumber 课程编号信息
	 * @return list 返回方向信息
	 */
	public List<TabDirection> findDirectionInfo(
			List<TabStudents> listStudentsInfo, String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findDirectionInfo(listStudentsInfo, FCourseNumber);
	}

	/**
	 * <p>功能：根据输入的班级信息、方向信息选择相应的学生对象信息<br>
	 * @param ClassNumber 班级信息
	 * @param DirectionNumber 方向编号
	 * @param listStudentsInfo 学生信息
	 * @return listt 学生信息
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsInfo(ClassNumber, DirectionNumber, listStudentsInfo);
	}

	/**
	 * <p>功能：更新学生信息，主要是统计学生平时相关成绩并汇总<br>
	 * @param listUsualscore 学生平时成绩
	 * @param listStudentsInfo 学生信息
	 * @param tabCourse 课程信息
	 */
	public void updateStudentsScore(List<JfptTabUsualscore> listUsualscore,
			List<TabStudents> listStudentsInfo, TabCourse tabCourse) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.updateStudentsScore(listUsualscore, listStudentsInfo, tabCourse);
	}

	/**
	 * <p>功能：根据选择的方向信息或者班级信息对学生成绩进行筛选提取<br>
	 * @param ClassNumber 班级信息
	 * @param DirectionNumber 方向编号
	 * @param listStudentsInfo 学生信息
	 * @param listUsualscoreInfo 学生成绩信息
	 * @return lists 学生成绩信息
	 */
	public List<JfptTabUsualscore> findUsualscoreInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo,
			List<JfptTabUsualscore> listUsualscoreInfo) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUsualscoreInfo(ClassNumber, DirectionNumber, listStudentsInfo, listUsualscoreInfo);
	}
}
