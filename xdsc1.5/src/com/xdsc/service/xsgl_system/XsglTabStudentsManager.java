package com.xdsc.service.xsgl_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.TabStudents;

public interface XsglTabStudentsManager {

	public abstract boolean saveStudent(TabStudents student);

	public abstract boolean deleteStudent(TabStudents student);

	public abstract List<TabStudents> getStudentsList();

	public abstract List getStudentByStuNum(String stuNum);
	
	public abstract List<TabStudents> getStudentByStuName(String stuName);

	public abstract void updateStudent(TabStudents student);
	
	public abstract List<TabStudents> getStudentListByClass(String classnumber);
	
	public abstract List<TabStudents> getStudentListByGrade(int gradeId);

	public abstract List<TabStudents> getStudentListByYear(Date startDate, Date endDate,String classid,String direction_str);

	public abstract List getStudentByPartyList();
	
	public abstract List<TabStudents> getGradeStudentByPartyList(Date startDate, Date endDate);
	
	public abstract List<TabStudents> getStudentBySelectParty(String classid,String status);

}