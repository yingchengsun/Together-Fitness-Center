package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabCourseDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.TabCourse;
import com.xdsc.service.sjjx_system.SjjxTabCourseManager;

/**�Կγ���Ϣ��¼���в���
 * @author ChenXue
 *@version 1.1
 */
public class SjjxTabCourseManagerImpl implements SjjxTabCourseManager {
	
	
	/**
	 * SjjxTabCourseDAOImpl �Ľӿ�
	 */
	private SjjxTabCourseDAO sjjxTabCourseDAO;


	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabCourseDAO getSjjxTabCourseDAO() {
		return sjjxTabCourseDAO;
	}


	public void setSjjxTabCourseDAO(SjjxTabCourseDAO sjjxTabCourseDAO) {
		this.sjjxTabCourseDAO = sjjxTabCourseDAO;
	}
	
	
	/**���ݿγ̱�Ų��ҵ���Ӧ�Ŀγ̼�¼
	 * @param courseNumber
	 * @return ���ز鵽�ļ�¼
	 */
	public TabCourse getCourseByCourseNumber(String courseNumber) {
		return sjjxTabCourseDAO.getCourseByCourseNumber(courseNumber);
	}
	


	/**���ݿγ����Ʋ��ҵ���Ӧ�Ŀγ̼�¼
	 * @param courseName
	 * @return ���ز鵽�ļ�¼
	 */
	public TabCourse getCourseByCourseName(String courseName) {
		return sjjxTabCourseDAO.getCourseByCourseName(courseName);
	}


		

}
