package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabCourseDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.service.xsgl_system.XsglTabCourseManager;

public class XsglTabCourseManagerImpl implements XsglTabCourseManager {
	private XsglTabCourseDAO xsglTabCourseDAO;

	public XsglTabCourseDAO getXsglTabCourseDAO() {
		return xsglTabCourseDAO;
	}

	public void setXsglTabCourseDAO(XsglTabCourseDAO xsglTabCourseDAO) {
		this.xsglTabCourseDAO = xsglTabCourseDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabCourseManager#getCourseByNum(java.lang.String)
	 */
	public TabCourse getCourseByNum(String courseNum) {
		return xsglTabCourseDAO.getCourseByNum(courseNum);
	}

	public List getAllCourse() {
		// TODO Auto-generated method stub
		return xsglTabCourseDAO.getAllCourse();
	}

}
