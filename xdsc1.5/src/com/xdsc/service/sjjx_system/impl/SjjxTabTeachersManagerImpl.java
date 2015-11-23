package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabTeachersDAO;

import com.xdsc.model.TabTeachers;
import com.xdsc.service.sjjx_system.SjjxTabTeachersManager;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabTeachersManagerImpl implements SjjxTabTeachersManager {

	
	/**
	 * SjjxTabTeachersDAOImpl �Ľӿ�
	 */
	private SjjxTabTeachersDAO sjjxTabTeachersDAO;

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabTeachersDAO getSjjxTabTeachersDAO() {
		return sjjxTabTeachersDAO;
	}
	public void setSjjxTabTeachersDAO(SjjxTabTeachersDAO sjjxTabTeachersDAO) {
		this.sjjxTabTeachersDAO = sjjxTabTeachersDAO;
	}

	/**�����ݿ��в��ҵ����еĽ�ʦ��¼
	 * @return ���ҵ������м�¼
	 */
	public List<TabTeachers> getTeacherList() {
		return sjjxTabTeachersDAO.getTeacherList();
	}


	/**ͨ����ʦѧ���Ų��ҵ���Ӧ�Ľ�ʦ��¼
	 * @param teacherNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
	public TabTeachers getTeacherByTeacherNumber(String teacherNumber) {
		return sjjxTabTeachersDAO.getTeacherByTeacherNumber(teacherNumber);
	}
	
	/**ͨ����ʦ�������ҵ���Ӧ�Ľ�ʦ��¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼
	 */
	public TabTeachers getTeacherByTeacherName(String teacherName) {
		return sjjxTabTeachersDAO.getTeacherByTeacherName(teacherName);
	}

}
