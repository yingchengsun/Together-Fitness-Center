package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabTeacherstotype;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabTeacherstotypeDAO {

	/**通过教师类型号查找到教师记录列表
	 * @param teacherNumber
	 * @return 返回查找到的记录
	 */
	public abstract List<TabTeacherstotype> getTeacherByType();

}