package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabJiaofei;

public interface XsglTabJiaofeiDAO {

	public abstract boolean saveJStudent(XsglTabJiaofei jstudent);

	public abstract boolean deleteJStudent(XsglTabJiaofei jstudent);
	
	public abstract boolean updateJStudent(XsglTabJiaofei jstudent);

	public abstract List<XsglTabJiaofei> getJStudentList();
	
	public abstract List<XsglTabJiaofei> getJStudentByStuNum(String stuNum);
	
	public abstract List<XsglTabJiaofei> getJStudentByStuName(String stuName);
	
	public abstract List<XsglTabJiaofei> getJStudentByYearClass(String year,String classid);

	public abstract List<XsglTabJiaofei> getJStudentListByGrade(int gradeId);
}