package com.xdsc.service.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabStudentsDAO;
import com.xdsc.model.TabStudents;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;

public class XsglTabStudentsManagerImpl implements XsglTabStudentsManager {
	private XsglTabStudentsDAO xsglTabStudentsDAO;

	

	

	public XsglTabStudentsDAO getXsglTabStudentsDAO() {
		return xsglTabStudentsDAO;
	}

	public void setXsglTabStudentsDAO(XsglTabStudentsDAO xsglTabStudentsDAO) {
		this.xsglTabStudentsDAO = xsglTabStudentsDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.service.xsgl_system.TabStudentsManager#saveStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	public boolean saveStudent(TabStudents student) {
		return xsglTabStudentsDAO.saveStudent(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.service.xsgl_system.TabStudentsManager#deleteStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	public boolean deleteStudent(TabStudents student) {
		return xsglTabStudentsDAO.deleteStudent(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.service.xsgl_system.TabStudentsManager#getStudentsList()
	 */
	public List<TabStudents> getStudentsList() {
		return xsglTabStudentsDAO.getStudentsList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.service.xsgl_system.TabStudentsManager#getStudentByStuNum(java.lang.String)
	 */
	public List getStudentByStuNum(String stuNum) {
		return xsglTabStudentsDAO.getStudentByStuNum(stuNum);
	}

	public List<TabStudents> getStudentByStuName(String stuName) {
		return xsglTabStudentsDAO.getStudentByStuName(stuName);
	}

	public void updateStudent(TabStudents student) {
		xsglTabStudentsDAO.updateStudent(student);

	}

	public List<TabStudents> getStudentListByClass(String classnumber) {
		return xsglTabStudentsDAO.getStudentListByClass(classnumber);
	}

	public List<TabStudents> getStudentListByGrade(int gradeId) {
		return xsglTabStudentsDAO.getStudentListByGrade(gradeId);
	}

	public List<TabStudents> getStudentListByYear(Date startDate, Date endDate,String classid,String direction_str) {
		return xsglTabStudentsDAO.getStudentListByYear(startDate, endDate,classid,direction_str);

	}

	public List getStudentByPartyList( ) {
		return xsglTabStudentsDAO.getStudentByPartyList();
	}
	
	public List<TabStudents> getStudentBySelectParty(String classid,String status){
		return xsglTabStudentsDAO.getStudentBySelectParty(classid, status);
	}

	public List<TabStudents> getGradeStudentByPartyList(Date startDate, Date endDate){
		// TODO Auto-generated method stub
		return xsglTabStudentsDAO.getGradeStudentByPartyList(startDate, endDate);
	}

}
