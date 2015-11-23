package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.TeacherCourseAssistantDAO;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.TeacherCourseAssistantManager;
/**
 * <p>���ܣ���ʦ�������̣��������̵����롢���ҡ�ɾ����<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseAssistantManagerImpl implements TeacherCourseAssistantManager{
	/**DAO�����*/
	private TeacherCourseAssistantDAO teacherCourseAssistantDAO;

	public TeacherCourseAssistantDAO getTeacherCourseAssistantDAO() {
		return teacherCourseAssistantDAO;
	}

	public void setTeacherCourseAssistantDAO(
			TeacherCourseAssistantDAO teacherCourseAssistantDAO) {
		this.teacherCourseAssistantDAO = teacherCourseAssistantDAO;
	}

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų鿴��ص�������Ϣ<br>
	 * @param FTeacherNumber ��ʦ���
	 * @return list ������ص�������Ϣ
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findAssistantapplyInfo(FTeacherNumber);
	}

	/**
	 * <p>���ܣ�������������id�Ų�����ص�����������Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabAssistantapply ���ز��ҵ��Ķ�����Ϣ
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findAssistantapplyInfoByID(FId);
	}

	/**
	 * <p>���ܣ�����Ժ�����̱�Ų�����ص�������Ϣ<br>
	 * @param FAssistantId Ժ����Ա���
	 * @return JfptTabOtherassist ���ز��ҵ�����Ϣ
	 */
	public JfptTabOtherassist findAssistantOtherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findAssistantOtherInfoByID(FAssistantId);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param FAssistantId ѧ��ѧ��
	 * @return TabStudents ���ز��ҵ���ѧ����Ϣ
	 */
	public TabStudents findAssistantStudentInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findAssistantStudentInfoByID(FAssistantId);
	}

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�����ؽ�ʦ��Ϣ<br>
	 * @param FAssistantId ��ʦ���
	 * @return TabTeachers ��ʦ������Ϣ
	 */
	public TabTeachers findAssistantTeacherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findAssistantTeacherInfoByID(FAssistantId);
	}

	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @param jfptTabAssistantapply �������������Ϣ
	 */
	public void addAssistantapply(JfptTabAssistantapply jfptTabAssistantapply) {
		// TODO Auto-generated method stub
		teacherCourseAssistantDAO.addAssistantapply(jfptTabAssistantapply);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ̶�����Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ؿγ̶�����Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�����ؽ�ʦ��Ϣ<br>
	 * @param FTeacherNumber ��ʦ���
	 * @return TabTeachers ��ʦ������Ϣ
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return teacherCourseAssistantDAO.findTeacherInfoByID(FTeacherNumber);
	}

	public void updateInfo(JfptTabAssistantapply ha) {
		// TODO Auto-generated method stub
		teacherCourseAssistantDAO.updateInfo(ha);
	}
}
