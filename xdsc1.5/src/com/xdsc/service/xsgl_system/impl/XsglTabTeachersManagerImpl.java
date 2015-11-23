package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabTeachersDAO;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;

public class XsglTabTeachersManagerImpl implements XsglTabTeachersManager {
	private XsglTabTeachersDAO xsglTabTeachersDAO;

	public XsglTabTeachersDAO getXsglTabTeachersDAO() {
		return xsglTabTeachersDAO;
	}

	public void setXsglTabTeachersDAO(XsglTabTeachersDAO xsglTabTeachersDAO) {
		this.xsglTabTeachersDAO = xsglTabTeachersDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.service.xsgl_system.impl.TabTeachersManager#getTeacherByTeaNum(java.lang.String)
	 */
	public List<TabTeachers> getTeacherByTeaNum(String TeaNum) {
		return xsglTabTeachersDAO.getTeacherByTeaNum(TeaNum);
	}

	public TabTeachers getTeacherByTeaName(String teacherName0) {
		// TODO Auto-generated method stub
		return xsglTabTeachersDAO.getTeacherByTeaName(teacherName0);
	}


	public boolean updateTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		return xsglTabTeachersDAO.updateTeacher(teacher);
	}

}
