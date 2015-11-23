package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.TabStudents;
/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�ѧ������ز���
 */
public interface TabStudentsManager {
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
	
	public abstract void saveStudent(TabStudents student);

}