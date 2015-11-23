package com.xdsc.service.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabKaoqingatherDAO;
import com.xdsc.model.XsglTabKaoqingather;
import com.xdsc.service.xsgl_system.XsglTabKaoqingatherManager;

public class XsglTabKaoqingatherManagerImpl implements XsglTabKaoqingatherManager {
	private XsglTabKaoqingatherDAO xsglTabKaoqingatherDAO;

	public XsglTabKaoqingatherDAO getXsglTabKaoqingatherDAO() {
		return xsglTabKaoqingatherDAO;
	}

	public void setXsglTabKaoqingatherDAO(
			XsglTabKaoqingatherDAO xsglTabKaoqingatherDAO) {
		this.xsglTabKaoqingatherDAO = xsglTabKaoqingatherDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqingatherManager#getTotalAttendanceList()
	 */
	public List<XsglTabKaoqingather> getTotalAttendanceList(){
		return xsglTabKaoqingatherDAO.getTotalAttendanceList();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqingatherManager#getTotalAttendanceByGrade(java.lang.String)
	 */
	public List<XsglTabKaoqingather> getTotalAttendanceByGrade(int gradeId){
		return xsglTabKaoqingatherDAO.getTotalAttendanceByGrade(gradeId);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqingatherManager#getTotalAttendanceByCourse(java.lang.String)
	 */
	public List<XsglTabKaoqingather> getTotalAttendanceByCourse(String courseNum){
		return xsglTabKaoqingatherDAO.getTotalAttendanceByCourse(courseNum);
	}

	public boolean deleteTotalAttendance(XsglTabKaoqingather toAttend) {
		// TODO Auto-generated method stub
		return xsglTabKaoqingatherDAO.deleteTotalAttendance(toAttend);
	}

	public XsglTabKaoqingather getTotalAttendanceByFId(int FId) {
		// TODO Auto-generated method stub
		return xsglTabKaoqingatherDAO.getTotalAttendanceByFId(FId);
	}

	public boolean saveTotalAttendance(XsglTabKaoqingather toAttend) {
		// TODO Auto-generated method stub
		return xsglTabKaoqingatherDAO.saveTotalAttendance(toAttend);
	}

	public boolean updateTotalAttendance(XsglTabKaoqingather toAttend) {
		// TODO Auto-generated method stub
		return xsglTabKaoqingatherDAO.updateTotalAttendance(toAttend);
	}

	public List<XsglTabKaoqingather> getTotalAttendByDateClassCourse(Date date,
			String classid, String courseNum) {
		// TODO Auto-generated method stub
		return xsglTabKaoqingatherDAO.getTotalAttendByDateClassCourse(date, classid, courseNum);
	}

}
