package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabTeacherstotype;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabTeacherstotypeManager {
	
	/**通过教师类型查找到教师记录列表
	 * @param teacherName
	 * @return 返回列表
	 */
	public abstract List<TabTeacherstotype> getTeacherByType();

}