package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabCourse;

/**�Կγ���Ϣ��¼���в���
 * @author ChenXue
 *@version 1.1
 */
public interface SjjxTabCourseDAO {

	

	/**���ݿγ̱�Ų��ҵ���Ӧ�Ŀγ̶���
	 * @param courseNumber
	 * @return ���ز鵽�Ķ���
	 */
	public abstract TabCourse getCourseByCourseNumber(String courseNumber);

	/**���ݿγ����Ʋ��ҵ���Ӧ�Ŀγ̶���
	 * @param courseName
	 * @return ���ز鵽�Ķ���
	 */
	public abstract TabCourse getCourseByCourseName(String courseName);


}