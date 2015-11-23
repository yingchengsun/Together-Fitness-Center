package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.TabStudentsDAO;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�ѧ������ز���
 */
public class TabStudentsManagerImpl implements TabStudentsManager {
	/**
	 * TabStudentsDAOImpl�ӿ�
	 */
	private TabStudentsDAO tabStudentsDAO;

	/**
	 * tabStudentsDAO���Ե�Get��Set����
	 */
	public TabStudentsDAO getTabStudentsDAO() {
		return tabStudentsDAO;
	}

	public void setTabStudentsDAO(TabStudentsDAO tabStudentsDAO) {
		this.tabStudentsDAO = tabStudentsDAO;
	}

	/**
	 * ����ѧ��ѧ�Ż��һ��ѧ������
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return TabStudents
	 */
	public TabStudents getStudentById(String stuNum) {
		return tabStudentsDAO.getStudentById(stuNum);
	}

	/**
	 * �õ�����ѧ�����б�
	 * 
	 * @return List
	 */
	public List getStudentList() {
		return tabStudentsDAO.getStudentList();
	}
}
