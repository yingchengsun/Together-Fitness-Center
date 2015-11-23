package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabTeachers;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabTeachersManager {



	/**从数据库中查找到所有的教师记录
	 * @return 查找到的所有记录
	 */
	public abstract List<TabTeachers> getTeacherList();

	/**通过教师学工号查找到相应的教师记录
	 * @param teacherNumber
	 * @return 返回查找到的记录
	 */
	public abstract TabTeachers getTeacherByTeacherNumber(String teacherNumber);

	/**通过教师姓名查找到相应的教师记录
	 * @param teacherName
	 * @return 返回查找到的记录
	 */
	public abstract TabTeachers getTeacherByTeacherName(String teacherName);



}