package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabStuorgadepart;

public interface XsglTabStuorgadepartDAO {

	public abstract boolean saveStudent(XsglTabStuorgadepart student);

	public abstract boolean deleteStudent(XsglTabStuorgadepart student);
	
	public abstract boolean updateStudent(XsglTabStuorgadepart student);
	
	public abstract XsglTabStuorgadepart getStuorgdepById(int Id);
	
	public abstract List<XsglTabStuorgadepart> getStuOrgByStuNum(String stuNum);
	
	public abstract List<XsglTabStuorgadepart> getStudentList();

	public abstract List<XsglTabStuorgadepart> getStudentByStudentUnion();
	
	public abstract List<XsglTabStuorgadepart> getStudentByKeXie();
	
	public abstract List<XsglTabStuorgadepart> getStudentByTuanWei();
	
	public abstract List<XsglTabStuorgadepart> getStudentByDepartment(int dname);
	
	public abstract List<XsglTabStuorgadepart> getStudentByKXDepartment(int dname);
	
	public abstract List<XsglTabStuorgadepart> getStudentByTWDepartment(int dname);

	public abstract List<XsglTabStuorgadepart> getStuOrgByStuName(String stuName);

	public abstract List<XsglTabStuorgadepart> getStudentByOrgDep(int dName);
}