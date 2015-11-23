package com.xdsc.service.jiaofu.impl;

import java.io.File;
import java.util.List;

import com.xdsc.dao.jiaofu.AssistHomeworkManageDAO;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.AssistHomeworkManageManager;

/**
 * <p>���ܣ��й���ҵ�������漰���ķ�����������ҵ֪ͨ����ҵ���ġ��ɼ������<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistHomeworkManageManagerImpl implements AssistHomeworkManageManager{
	/**DAO�����*/
	private AssistHomeworkManageDAO assistHomeworkManageDAO;

	public AssistHomeworkManageDAO getAssistHomeworkManageDAO() {
		return assistHomeworkManageDAO;
	}

	public void setAssistHomeworkManageDAO(
			AssistHomeworkManageDAO assistHomeworkManageDAO) {
		this.assistHomeworkManageDAO = assistHomeworkManageDAO;
	}

	/**
	 * <p>���ܣ����ƽʱ�ɼ���Ϣ<br>
	 * @param jfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public void addUsualScoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		assistHomeworkManageDAO.addUsualScoreInfo(jfptTabUsualscore);
	}

	/**
	 * <p>���ܣ�ɾ��ƽʱ�ɼ���Ϣ<br>
	 * @param jfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public void deleteUsualscoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		assistHomeworkManageDAO.deleteUsualscoreInfo(jfptTabUsualscore);
	}

	/**
	 * <p>���ܣ����ݸ���id�Ų�����صĿγ���Ϣ<br>
	 * @param id ���˱��
	 * @return list ������صĿγ���Ϣ
	 */
	public List<TabCourse> findCourseInfoByAid(String id) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findCourseInfoByAid(id);
	}

	/**
	 * <p>���ܣ����ݿγ̺Ų��ҿγ���ϸ��Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse �γ������Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�����ص�ѧ����Ϣ<br>
	 * @param FStudentNumber ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsInfoByID(String FStudentNumber) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findStudentsInfoByID(FStudentNumber);
	}

	/**
	 * <p>���ܣ����ݳɼ�id�Ų�����صĳɼ���Ϣ<br>
	 * @param FNumber �ɼ���Ϣid��
	 * @return JfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public JfptTabUsualscore findUsualscoreInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findUsualscoreInfoByID(FNumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص�ѧ���ĳɼ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @param aid ���̱��
	 * @return list ѧ���ɼ���Ϣ
	 */
	public List<JfptTabUsualscore> findUsualscoreInfoByTwo(
			String FCourseNumber, String aid) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findUsualscoreInfoByTwo(FCourseNumber, aid);
	}

	/**
	 * <p>���ܣ������ҵ֪ͨ��Ϣ<br>
	 * @param jfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public void addHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		assistHomeworkManageDAO.addHomenotice(jfptTabHomenotice);
	}

	/**
	 * <p>���ܣ���ҵ֪ͨ���������Ϣ�洢<br>
	 * @param jfptTabHomenoticetoreceive ֪ͨ������Ϣ
	 */
	public void addHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		assistHomeworkManageDAO.addHomenoticetoto(jfptTabHomenoticetoreceive);
	}

	/**
	 * <p>���ܣ�ɾ����ҵ��Ϣ��������ɾ����ص�������Ϣ<br>
	 * @param jfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public void deleteHome(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		assistHomeworkManageDAO.deleteHome(jfptTabHomenotice);
	}

	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų��������ϸ��Ϣ<br>
	 * @param id ��ҵ֪ͨid��
	 * @return JfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public JfptTabHomenotice findHomeDetailByID(int id) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findHomeDetailByID(id);
	}

	/**
	 * <p>���ܣ��鿴���˷��͵���ҵ֪ͨ��Ϣ<br>
	 * @param tid ���˱��
	 * @return list ������ҵ��Ϣ
	 */
	public List<JfptTabHomenotice> findHomeNoticeInfoByAid(String tid) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findHomeNoticeInfoByAid(tid);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsByID(String id) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findStudentsByID(id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص�ѧ����Ϣ<br>
	 * @param aid ���˱��
	 * @param Coursenumber �γ̱��
	 * @return list ���ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfoByTwo(String aid,
			String Coursenumber) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findStudentsInfoByTwo(aid, Coursenumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų���User��Ϣ<br>
	 * @param id ���˱��
	 * @return MhqxTabUser User������Ϣ
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findUserByID(id);
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
		assistHomeworkManageDAO.savefile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>���ܣ������ϴ���ҵ��Ϣid�Ų��������ϸ��Ϣ<br>
	 * @param id �ϴ���ҵ��Ϣid��
	 * @return JfptTabHomeupload �ϴ���ҵ������Ϣ
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int id) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findHomeworkDetailByID(id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų鿴��ص�ѧ����ҵ��Ϣ<br>
	 * @param aid ���̱��
	 * @param FCourseNumber �γ̱��
	 * @return list ѧ����ҵ��Ϣ
	 */
	public List<JfptTabHomeupload> findHomeworkInfoByTwo(String aid,
			String FCourseNumber) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findHomeworkInfoByTwo(aid, FCourseNumber);
	}

	/**
	 * <p>���ܣ�������ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ����
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		assistHomeworkManageDAO.updateHomeworkInfo(jfptTabHomeupload);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����صİ༶��Ϣ<br>
	 * @param id ���˱��
	 * @param FCourseNumber �γ̱��
	 * @return list ������ذ༶�����Ϣ
	 */
	public List<String> findClassNumberInfo(String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		return assistHomeworkManageDAO.findClassNumberInfo(id, FCourseNumber);
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
		return assistHomeworkManageDAO.findDirectionInfo(listStudentsInfo, FCourseNumber);
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
		return assistHomeworkManageDAO.findStudentsInfo(ClassNumber, DirectionNumber, listStudentsInfo);
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
		assistHomeworkManageDAO.updateStudentsScore(listUsualscore, listStudentsInfo, tabCourse);
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
		return assistHomeworkManageDAO.findUsualscoreInfo(ClassNumber, DirectionNumber, listStudentsInfo, listUsualscoreInfo);
	}
}
