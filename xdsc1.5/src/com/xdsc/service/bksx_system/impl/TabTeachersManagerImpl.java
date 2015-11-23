package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.TabTeachersDAO;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.bksx_system.TabTeachersManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Խ�ʦ����ز���
 */
public class TabTeachersManagerImpl implements TabTeachersManager {
	/**
	 * TabTeachersDAOImpl �Ľӿ�
	 */
	private TabTeachersDAO tabTeachersDAO;

	/**
	 * tabTeachersDAO���Ե�Get��Set����
	 */
	public TabTeachersDAO getTabTeachersDAO() {
		return tabTeachersDAO;
	}

	public void setTabTeachersDAO(TabTeachersDAO tabTeachersDAO) {
		this.tabTeachersDAO = tabTeachersDAO;
	}

	/**
	 * ���ݽ�ʦ���Ż��һ��ѧ������
	 * 
	 * @param tId
	 *            ��ʦ����
	 * @return TabTeachers
	 */
	public TabTeachers getTeacherById(String tId) {
		return tabTeachersDAO.getTeacherById(tId);
	}

	/**
	 * ���ݽ�ʦ�������һ����ʦ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @return List
	 */
	public List getTeacherByName(String teacherName) {
		return tabTeachersDAO.getTeacherByName(teacherName);
	}

	/**
	 * ���ݽ�ʦ��������ʦְ�ƻ��һ����ʦ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegreen
	 *            ��ʦְ��
	 * @return List
	 */
	public List getTeacherByNameDegreen(String teacherName,
			String teacherDegreen) {
		return tabTeachersDAO.getTeacherByNameDegreen(teacherName,
				teacherDegreen);
	}

	/**
	 * �õ����н�ʦ���б�
	 * 
	 * @return List
	 */
	public List getTeacherList() {
		return tabTeachersDAO.getTeacherList();
	}
}
