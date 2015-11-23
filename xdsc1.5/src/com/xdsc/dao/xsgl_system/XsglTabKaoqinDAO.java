package com.xdsc.dao.xsgl_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.XsglTabKaoqin;

public interface XsglTabKaoqinDAO {

	public abstract boolean saveAttendance(XsglTabKaoqin attend);

	public abstract boolean deleteAttendance(XsglTabKaoqin attend);

	public abstract boolean updateAttendance(XsglTabKaoqin attend);

	public abstract List<XsglTabKaoqin> getAttendanceByStuNum(String stuNum);

	public abstract List<XsglTabKaoqin> getAttendanceByClass(String classid);

	public abstract List<XsglTabKaoqin> getAttendanceByGrade(String gradeId);

	public abstract List<XsglTabKaoqin> getAttendanceByCourse(String courseNum);
	
	public abstract List<XsglTabKaoqin> getAttendanceList();
	
	public abstract XsglTabKaoqin getAttendanceByFId(int fid);
	
	public abstract List<XsglTabKaoqin> getAttendByDateClassCourse(Date date,String classid,String courseNum);
	
	public abstract List<XsglTabKaoqin> getAttendByStuName(String stuName);
	
	public abstract List<XsglTabKaoqin> getAttendByStuDateCourse(Date date,String courseNum,String stuNum);

}