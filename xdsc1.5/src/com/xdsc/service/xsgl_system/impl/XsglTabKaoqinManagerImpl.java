package com.xdsc.service.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabKaoqinDAO;
import com.xdsc.model.XsglTabKaoqin;
import com.xdsc.service.xsgl_system.XsglTabKaoqinManager;

public class XsglTabKaoqinManagerImpl implements XsglTabKaoqinManager {
	private XsglTabKaoqinDAO xsglTabKaoqinDAO;

	public XsglTabKaoqinDAO getXsglTabKaoqinDAO() {
		return xsglTabKaoqinDAO;
	}

	public void setXsglTabKaoqinDAO(XsglTabKaoqinDAO xsglTabKaoqinDAO) {
		this.xsglTabKaoqinDAO = xsglTabKaoqinDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#saveAttendance(com.xdsc.model.XsglTabKaoqin)
	 */
	public boolean saveAttendance(XsglTabKaoqin attend){
		return xsglTabKaoqinDAO.saveAttendance(attend);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#deleteAttendance(com.xdsc.model.XsglTabKaoqin)
	 */
	public boolean deleteAttendance(XsglTabKaoqin attend){
		return xsglTabKaoqinDAO.deleteAttendance(attend);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#updateAttendance(com.xdsc.model.XsglTabKaoqin)
	 */
	public boolean updateAttendance(XsglTabKaoqin attend){
		return xsglTabKaoqinDAO.updateAttendance(attend);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#getAttendanceByStuNum(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByStuNum(String stuNum){
		return xsglTabKaoqinDAO.getAttendanceByStuNum(stuNum);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#getAttendanceByClass(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByClass(String classid){
		return xsglTabKaoqinDAO.getAttendanceByClass(classid);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#getAttendanceByGrade(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByGrade(String gradeId){
		return xsglTabKaoqinDAO.getAttendanceByGrade(gradeId);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#getAttendanceByCourse(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByCourse(String courseNum){
		return xsglTabKaoqinDAO.getAttendanceByCourse(courseNum);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabKaoqinManager#getAttendanceList()
	 */
	public List<XsglTabKaoqin> getAttendanceList(){
		return xsglTabKaoqinDAO.getAttendanceList();
	}

	public XsglTabKaoqin getAttendanceByFId(int fid) {
		// TODO Auto-generated method stub
		return xsglTabKaoqinDAO.getAttendanceByFId(fid);
	}

	
	public List<XsglTabKaoqin> getAttendByDateClassCourse(Date date,String classid,String courseNum) {
		// TODO Auto-generated method stub
		return xsglTabKaoqinDAO.getAttendByDateClassCourse(date, classid, courseNum);
	}

	
	public List<XsglTabKaoqin> getAttendByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabKaoqinDAO.getAttendByStuName(stuName);
	}

	public List<XsglTabKaoqin> getAttendByStuDateCourse(Date date,
			String courseNum, String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabKaoqinDAO.getAttendByStuDateCourse(date, courseNum, stuNum);
	}

}
