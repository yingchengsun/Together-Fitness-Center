package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.TabTeachers;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Խ�ʦ����ز���
 */
public interface TabTeachersDAO {
	/**
	 * ���ݽ�ʦ���Ż��һ��ѧ������
	 * 
	 * @param tId
	 *            ��ʦ����
	 * @return TabTeachers
	 */
	public abstract TabTeachers getTeacherById(String tId);

	/**
	 * ���ݽ�ʦ�������һ����ʦ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @return List
	 */
	public abstract List getTeacherByName(String teacherName);

	/**
	 * ���ݽ�ʦ��������ʦְ�ƻ��һ����ʦ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegreen
	 *            ��ʦְ��
	 * @return List
	 */
	public abstract List getTeacherByNameDegreen(String teacherName,
			String teacherDegreen);

	/**
	 * �õ����н�ʦ���б�
	 * 
	 * @return List
	 */
	public abstract List getTeacherList();

}