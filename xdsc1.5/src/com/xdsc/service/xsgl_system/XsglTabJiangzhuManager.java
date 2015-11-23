package com.xdsc.service.xsgl_system;


import java.util.Date;
import java.util.List;

import com.xdsc.model.XsglTabJiangzhu;

public interface XsglTabJiangzhuManager {

	public abstract boolean saveFStudent(XsglTabJiangzhu fstudent);

	public abstract boolean deleteFStudent(XsglTabJiangzhu fstudent);
	
	public abstract boolean updateFStudent(XsglTabJiangzhu fstudent);

	public abstract List<XsglTabJiangzhu> getFStudentList();

	public abstract List<XsglTabJiangzhu> getFStudentListByStuNum(String stuNum);
	
	public abstract List<XsglTabJiangzhu> getFStudentListByLoan();
	
	public abstract List<XsglTabJiangzhu> getGradeStudentListByLoan(Date startDate, Date endDate);
	
	public abstract List<XsglTabJiangzhu> getFStudentListByStipend();
	
	public abstract List<XsglTabJiangzhu> getGradeStuByLoan(int gradeId);
	
	public abstract List<XsglTabJiangzhu> getGradeStuBySholarship(int gradeId);
	
	public abstract List<XsglTabJiangzhu> getGradeStuByStipend(int gradeId);
	
	public abstract List<XsglTabJiangzhu> getGradeStudentListByStipend(Date startDate, Date endDate);
	
	public abstract List<XsglTabJiangzhu> getFStudentListByScholarship();
	
	public abstract List<XsglTabJiangzhu> getGradeStudentListByScholarship(Date startDate, Date endDate);
	
	public abstract List<XsglTabJiangzhu> getFStudentListByOption(String year,String classid);
	
	public abstract List<XsglTabJiangzhu> getFStudentListBySchOption(String year,String classid);
	
	public abstract List<XsglTabJiangzhu> getFStudentListByStiOption(String year,String classid);

    public abstract List<XsglTabJiangzhu> getClassStudentByLoan(String classid);
	
	public abstract List<XsglTabJiangzhu> getClassStudentByStipend(String classid);
	
	public abstract List<XsglTabJiangzhu> getClassStudentBySholarship(String classid);

	public abstract List<XsglTabJiangzhu> getStudentListByNameYearClass(String name,String year,String classid);

	public abstract XsglTabJiangzhu getFStudentByFid(int fid);
	
    public abstract List<XsglTabJiangzhu> getFundStuByStuNum(String stuNum);
	
	public abstract List<XsglTabJiangzhu> getFundStuByStuName(String stuName);
}