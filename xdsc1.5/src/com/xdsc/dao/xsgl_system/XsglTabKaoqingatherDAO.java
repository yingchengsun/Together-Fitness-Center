package com.xdsc.dao.xsgl_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.XsglTabKaoqingather;

public interface XsglTabKaoqingatherDAO {
	
	public abstract boolean saveTotalAttendance(XsglTabKaoqingather toAttend);
	
	public abstract boolean deleteTotalAttendance(XsglTabKaoqingather toAttend);
	
	public abstract boolean updateTotalAttendance(XsglTabKaoqingather toAttend);
	
	public abstract XsglTabKaoqingather getTotalAttendanceByFId(int FId);

	public abstract List<XsglTabKaoqingather> getTotalAttendanceList();

	public abstract List<XsglTabKaoqingather> getTotalAttendanceByGrade(
			int gradeId);

	public abstract List<XsglTabKaoqingather> getTotalAttendanceByCourse(
			String courseNum);
	
	public abstract List<XsglTabKaoqingather> getTotalAttendByDateClassCourse(Date date,String classid,String courseNum);
	
}