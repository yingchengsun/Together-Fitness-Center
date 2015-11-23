package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AdminCourseAssistantDAO;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.AdminCourseAssistantManager;
/**
 * <p>����Ȩ�޹������漰���Ĳ��������а���������̡�����Ȩ��������ɾ�������ҵȡ�<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminCourseAssistantManagerImpl implements AdminCourseAssistantManager{

	/**Dao�����*/
	private AdminCourseAssistantDAO adminCourseAssistantDAO;

	public AdminCourseAssistantDAO getAdminCourseAssistantDAO() {
		return adminCourseAssistantDAO;
	}

	public void setAdminCourseAssistantDAO(
			AdminCourseAssistantDAO adminCourseAssistantDAO) {
		this.adminCourseAssistantDAO = adminCourseAssistantDAO;
	}

	/**
	 * <p>���ܣ���ѯ���������¼��Ϣ<br>
	 * @return list ���������Ϣ��¼��
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo() {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findAssistantapplyInfo();
	}

	/**
	 * <p>���ܣ����������¼����ID��Ϣ���Ҷ���<br>
	 * @param FId �����¼��Ϣ������
	 * @return JfptTabAssistantapply ���ز��ҵ��Ķ���
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId) {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findAssistantapplyInfoByID(FId);
	}

	/**
	 * <p>���ܣ�ɾ���������������Ϣ<br>
	 * @param jfptTabAssistantapply ���������¼��Ϣ����
	 */
	public void deleteAssistantapplyInfo(
			JfptTabAssistantapply jfptTabAssistantapply) {
		// TODO Auto-generated method stub
		adminCourseAssistantDAO.deleteAssistantapplyInfo(jfptTabAssistantapply);
	}

	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @param jfptTabAssistantapply1 ����������Ϣ����
	 */
	public void addAssistantInfo(JfptTabAssistantapply jfptTabAssistantapply1) {
		// TODO Auto-generated method stub
		adminCourseAssistantDAO.addAssistantInfo(jfptTabAssistantapply1);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ̶�����Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ز��ҵ��Ŀγ̶���
	 */
	public TabCourse findTabCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findTabCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ����<br>
	 * @param FTeacherNumber ��ʦְ����
	 * @return ���ز��ҵ��Ľ�ʦ����
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findTeacherInfoByID(FTeacherNumber);
	}
}
