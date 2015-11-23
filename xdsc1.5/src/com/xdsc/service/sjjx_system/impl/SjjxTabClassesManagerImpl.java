package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabClassesDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.service.sjjx_system.SjjxTabClassesManager;

/**对于班级信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabClassesManagerImpl implements SjjxTabClassesManager {

	/**
	 * SjjxTabClassesDAOImpl 的接口
	 */
	private SjjxTabClassesDAO sjjxTabClassesDAO;	

	/**
	 * 数据访问方法
	 */
	public SjjxTabClassesDAO getSjjxTabClassesDAO() {
		return sjjxTabClassesDAO;
	}

	public void setSjjxTabClassesDAO(SjjxTabClassesDAO sjjxTabClassesDAO) {
		this.sjjxTabClassesDAO = sjjxTabClassesDAO;
	}



	/**根据班级名称查找到对应的班级记录
	 * @param className
	 * @return 返回查找到的记录
	 */
	public TabClasses getClassesByClassName(String className) {
		return sjjxTabClassesDAO.getClassesByClassName(className);
	}
	/**根据班级编号查找到对应的班级记录
	 *@return 返回查到的记录
	 */
	public TabClasses getClassesByClassNum(String classNum){
		return sjjxTabClassesDAO.getClassesByClassNum(classNum);
	}

	
}
