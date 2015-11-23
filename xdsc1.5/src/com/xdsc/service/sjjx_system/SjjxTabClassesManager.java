package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabClasses;

/**对于班级信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public interface SjjxTabClassesManager {

	
	/**根据班级名称查找到对应的班级记录
	 * @param className
	 * @return 返回查找到的记录
	 */
	public abstract TabClasses getClassesByClassName(String className);

	/**根据班级编号查找到对应的班级记录
	 *@return 返回查到的记录
	 */
	public abstract TabClasses getClassesByClassNum(String classNum);

}