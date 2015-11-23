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
 * <p>���ܣ��й���ҵ�������漰���ķ�����������ҵ֪ͨ����ҵ���ġ��ɼ������<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherHomeworkManageManagerImpl implements TeacherHomeworkManageManager{
	/**DAO�����*/
	private TeacherHomeworkManageDAO teacherHomeworkManageDAO;

	public TeacherHomeworkManageDAO getTeacherHomeworkManageDAO() {
		return teacherHomeworkManageDAO;
	}

	public void setTeacherHomeworkManageDAO(
			TeacherHomeworkManageDAO teacherHomeworkManageDAO) {
		this.teacherHomeworkManageDAO = teacherHomeworkManageDAO;
	}

	/**
	 * <p>���ܣ����ݸ���id�Ų�����صĿγ���Ϣ<br>
	 * @param id ���˱��
	 * @return list ������صĿγ���Ϣ
	 */
	public List<TabCourse> findCourseInfoByTid(String id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findCourseInfoByTid(id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص�ѧ���ĳɼ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @param tid ��ʦ���
	 * @return list ѧ���ɼ���Ϣ
	 */
	public List<JfptTabUsualscore> findUsualscoreInfoByTwo(
			String FCourseNumber, String tid) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUsualscoreInfoByTwo(FCourseNumber, tid);
	}

	/**
	 * <p>���ܣ�ɾ��ƽʱ�ɼ���Ϣ<br>
	 * @param jfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public void deleteUsualscoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.deleteUsualscoreInfo(jfptTabUsualscore);
	}

	/**
	 * <p>���ܣ����ݳɼ�id�Ų�����صĳɼ���Ϣ<br>
	 * @param FNumber �ɼ���Ϣid��
	 * @return JfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public JfptTabUsualscore findUsualscoreInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUsualscoreInfoByID(FNumber);
	}

	/**
	 * <p>���ܣ����ݿγ̺Ų��ҿγ���ϸ��Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse �γ������Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ����ƽʱ�ɼ���Ϣ<br>
	 * @param jfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public void addUsualScoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.addUsualScoreInfo(jfptTabUsualscore);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�����ص�ѧ����Ϣ<br>
	 * @param FStudentNumber ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsInfoByID(String FStudentNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsInfoByID(FStudentNumber);
	}

	/**
	 * <p>���ܣ��鿴���˷��͵���ҵ֪ͨ��Ϣ<br>
	 * @param tid ���˱��
	 * @return list ������ҵ��Ϣ
	 */
	public List<JfptTabHomenotice> findHomeNoticeInfoByTid(String tid) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeNoticeInfoByTid(tid);
	}

	/**
	 * <p>���ܣ�ɾ����ҵ��Ϣ��������ɾ����ص�������Ϣ<br>
	 * @param jfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public void deleteHome(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.deleteHome(jfptTabHomenotice);
	}

	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų��������ϸ��Ϣ<br>
	 * @param id ��ҵ֪ͨid��
	 * @return JfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public JfptTabHomenotice findHomeDetailByID(int id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeDetailByID(id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص�ѧ����Ϣ<br>
	 * @param id ���˱��
	 * @param Coursenumber �γ̱��
	 * @return list ���ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,
			String Coursenumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsInfoByTwo(id, Coursenumber);
	}

	/**
	 * <p>���ܣ������ҵ֪ͨ��Ϣ<br>
	 * @param jfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public void addHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.addHomenotice(jfptTabHomenotice);
	}

	/**
	 * <p>���ܣ���ҵ֪ͨ���������Ϣ�洢<br>
	 * @param jfptTabHomenoticetoreceive ֪ͨ������Ϣ
	 */
	public void addHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.addHomenoticetoto(jfptTabHomenoticetoreceive);
	}
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsByID(String id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsByID(id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų���User��Ϣ<br>
	 * @param id ���˱��
	 * @return MhqxTabUser User������Ϣ
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUserByID(id);
	}

	/**
	 * <p>���ܣ������ļ�<br>
	 * @param uploadFile �ϴ��ļ�
	 * @param savePath ����·��
	 * @param uploadFileFileName �ļ�����
	 */
	public void savefile(File uploadFile, String savePath,
			String uploadFileFileName) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.savefile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų鿴��ص�ѧ����ҵ��Ϣ<br>
	 * @param tid ��ʦ���
	 * @param FCourseNumber �γ̱��
	 * @return list ѧ����ҵ��Ϣ
	 */
	public List<JfptTabHomeupload> findHomeworkInfoByTwo(String tid,
			String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeworkInfoByTwo(tid, FCourseNumber);
	}

	/**
	 * <p>���ܣ������ϴ���ҵ��Ϣid�Ų��������ϸ��Ϣ<br>
	 * @param id �ϴ���ҵ��Ϣid��
	 * @return JfptTabHomeupload �ϴ���ҵ������Ϣ
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int id) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findHomeworkDetailByID(id);
	}

	/**
	 * <p>���ܣ�������ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ����
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.updateHomeworkInfo(jfptTabHomeupload);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����صİ༶��Ϣ<br>
	 * @param FTeacherNumber ���˱��
	 * @param FCourseNumber �γ̱��
	 * @return list ������ذ༶�����Ϣ
	 */
	public List<String> findClassNumberInfo(String FTeacherNumber,
			String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findClassNumberInfo(FTeacherNumber, FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų���ָ��ѧ���ķ�����Ϣ<br>
	 * @param listStudentsInfo ѧ��������Ϣ
	 * @param FCourseNumber �γ̱����Ϣ
	 * @return list ���ط�����Ϣ
	 */
	public List<TabDirection> findDirectionInfo(
			List<TabStudents> listStudentsInfo, String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findDirectionInfo(listStudentsInfo, FCourseNumber);
	}

	/**
	 * <p>���ܣ���������İ༶��Ϣ��������Ϣѡ����Ӧ��ѧ��������Ϣ<br>
	 * @param ClassNumber �༶��Ϣ
	 * @param DirectionNumber ������
	 * @param listStudentsInfo ѧ����Ϣ
	 * @return listt ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findStudentsInfo(ClassNumber, DirectionNumber, listStudentsInfo);
	}

	/**
	 * <p>���ܣ�����ѧ����Ϣ����Ҫ��ͳ��ѧ��ƽʱ��سɼ�������<br>
	 * @param listUsualscore ѧ��ƽʱ�ɼ�
	 * @param listStudentsInfo ѧ����Ϣ
	 * @param tabCourse �γ���Ϣ
	 */
	public void updateStudentsScore(List<JfptTabUsualscore> listUsualscore,
			List<TabStudents> listStudentsInfo, TabCourse tabCourse) {
		// TODO Auto-generated method stub
		teacherHomeworkManageDAO.updateStudentsScore(listUsualscore, listStudentsInfo, tabCourse);
	}

	/**
	 * <p>���ܣ�����ѡ��ķ�����Ϣ���߰༶��Ϣ��ѧ���ɼ�����ɸѡ��ȡ<br>
	 * @param ClassNumber �༶��Ϣ
	 * @param DirectionNumber ������
	 * @param listStudentsInfo ѧ����Ϣ
	 * @param listUsualscoreInfo ѧ���ɼ���Ϣ
	 * @return lists ѧ���ɼ���Ϣ
	 */
	public List<JfptTabUsualscore> findUsualscoreInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo,
			List<JfptTabUsualscore> listUsualscoreInfo) {
		// TODO Auto-generated method stub
		return teacherHomeworkManageDAO.findUsualscoreInfo(ClassNumber, DirectionNumber, listStudentsInfo, listUsualscoreInfo);
	}
}
