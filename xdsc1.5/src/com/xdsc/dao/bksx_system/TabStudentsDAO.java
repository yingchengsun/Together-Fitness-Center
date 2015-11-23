package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.TabStudents;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�ѧ������ز���
 */
public interface TabStudentsDAO {

	/**
	 * ����ѧ��ѧ�Ż��һ��ѧ������
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return TabStudents
	 */
	public abstract TabStudents getStudentById(String stuNum);

	/**
	 * �õ�����ѧ�����б�
	 * 
	 * @return List
	 */
	public abstract List getStudentList();

}