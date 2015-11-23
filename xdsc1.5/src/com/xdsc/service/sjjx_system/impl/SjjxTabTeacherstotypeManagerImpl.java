package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabTeacherstotypeDAO;

import com.xdsc.model.TabTeacherstotype;
import com.xdsc.service.sjjx_system.SjjxTabTeacherstotypeManager;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabTeacherstotypeManagerImpl implements SjjxTabTeacherstotypeManager {

	/**
	 * SjjxTabTeachersDAOImpl �Ľӿ�
	 */
	private SjjxTabTeacherstotypeDAO sjjxTabTeacherstotypeDAO;
	

	/**ͨ����ʦ���Ͳ��ҵ���ʦ��¼�б�
	 * @param teacherName
	 * @return �����б�
	 */
	public List<TabTeacherstotype> getTeacherByType() {
		return sjjxTabTeacherstotypeDAO.getTeacherByType();
	}

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabTeacherstotypeDAO getSjjxTabTeacherstotypeDAO() {
		return sjjxTabTeacherstotypeDAO;
	}


	public void setSjjxTabTeacherstotypeDAO(
			SjjxTabTeacherstotypeDAO sjjxTabTeacherstotypeDAO) {
		this.sjjxTabTeacherstotypeDAO = sjjxTabTeacherstotypeDAO;
	}
}
