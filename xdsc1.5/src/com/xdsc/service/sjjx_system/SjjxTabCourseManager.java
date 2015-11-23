package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabCourse;

/**�Կγ���Ϣ��¼���в���
 * @author ChenXue
 * @version 1.1
 */
public interface SjjxTabCourseManager {

	
	/**���ݿγ̱�Ų��ҵ���Ӧ�Ŀγ̼�¼
	 * @param courseNumber
	 * @return ���ز鵽�ļ�¼
	 */
	public abstract TabCourse getCourseByCourseNumber(String courseNumber);

	/**���ݿγ����Ʋ��ҵ���Ӧ�Ŀγ̼�¼
	 * @param courseName
	 * @return ���ز鵽�ļ�¼
	 */
	public abstract TabCourse getCourseByCourseName(String courseName);

	

}