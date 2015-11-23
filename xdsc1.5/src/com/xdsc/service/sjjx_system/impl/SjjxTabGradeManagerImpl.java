package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabCourseDAO;
import com.xdsc.dao.sjjx_system.SjjxTabGradeDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabGrade;
import com.xdsc.service.sjjx_system.SjjxTabGradeManager;

/**���꼶��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabGradeManagerImpl implements SjjxTabGradeManager {

	/**
	 * SjjxTabGradeDAOImpl �Ľӿ�
	 */
	private SjjxTabGradeDAO sjjxTabGradeDAO;

	

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabGradeDAO getSjjxTabGradeDAO() {
		return sjjxTabGradeDAO;
	}


	public void setSjjxTabGradeDAO(SjjxTabGradeDAO sjjxTabGradeDAO) {
		this.sjjxTabGradeDAO = sjjxTabGradeDAO;
	}


	/**�����꼶���Ʋ��ҵ���Ӧ�ļ�¼
	 * @param gradeName
	 * @return �����꼶��¼
	 */
	public TabGrade getGradeByGradeName(String gradeName) {
		return sjjxTabGradeDAO.getGradeByGradeName(gradeName);
	}

	/**�����꼶��Ų��ҵ���Ӧ�ļ�¼
	 * @param gradeId
	 * @return �����꼶��¼
	 */
	public TabGrade getGradeByGradeId(Integer gradeId) {
		return sjjxTabGradeDAO.getGradeByGradeId(gradeId);
	}


	
}
