package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabClasses;

/**对于班级信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public interface SjjxTabClassesDAO {


	/**根据班级名称查找到对应的班级对象
	 * @param className
	 * @return 返回查找到的对象 
	 */
	public abstract TabClasses getClassesByClassName(String className);
	/**根据班级编号查找到对应的班级对象
	 *@return 返回查到的对象
	 */
	public abstract TabClasses getClassesByClassNum(String classNum);

}