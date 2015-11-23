package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabGrade;

/**对年级信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabGradeManager {

	

	/**根据年级名称查找到对应的记录
	 * @param gradeName
	 * @return 返回年级记录
	 */
	public abstract TabGrade getGradeByGradeName(String gradeName);
	
	/**根据年级编号查找到对应的记录
	 * @param gradeId
	 * @return 返回年级记录
	 */
	public abstract TabGrade getGradeByGradeId(Integer gradeId);

}