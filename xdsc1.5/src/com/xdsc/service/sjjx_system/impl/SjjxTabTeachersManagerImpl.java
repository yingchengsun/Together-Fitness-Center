package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabTeachersDAO;

import com.xdsc.model.TabTeachers;
import com.xdsc.service.sjjx_system.SjjxTabTeachersManager;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabTeachersManagerImpl implements SjjxTabTeachersManager {

	
	/**
	 * SjjxTabTeachersDAOImpl 的接口
	 */
	private SjjxTabTeachersDAO sjjxTabTeachersDAO;

	/**
	 * 数据访问方法
	 */
	public SjjxTabTeachersDAO getSjjxTabTeachersDAO() {
		return sjjxTabTeachersDAO;
	}
	public void setSjjxTabTeachersDAO(SjjxTabTeachersDAO sjjxTabTeachersDAO) {
		this.sjjxTabTeachersDAO = sjjxTabTeachersDAO;
	}

	/**从数据库中查找到所有的教师记录
	 * @return 查找到的所有记录
	 */
	public List<TabTeachers> getTeacherList() {
		return sjjxTabTeachersDAO.getTeacherList();
	}


	/**通过教师学工号查找到相应的教师记录
	 * @param teacherNumber
	 * @return 返回查找到的记录
	 */
	public TabTeachers getTeacherByTeacherNumber(String teacherNumber) {
		return sjjxTabTeachersDAO.getTeacherByTeacherNumber(teacherNumber);
	}
	
	/**通过教师姓名查找到相应的教师记录
	 * @param teacherName
	 * @return 返回查找到的记录
	 */
	public TabTeachers getTeacherByTeacherName(String teacherName) {
		return sjjxTabTeachersDAO.getTeacherByTeacherName(teacherName);
	}

}
