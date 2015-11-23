package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabStuorgadepartDAO;
import com.xdsc.model.XsglTabStuorgadepart;
import com.xdsc.service.xsgl_system.XsglTabStuorgadepartManager;

public class XsglTabStuorgadepartManagerImpl implements XsglTabStuorgadepartManager {
	private XsglTabStuorgadepartDAO xsglTabStuorgadepartDAO;

	public XsglTabStuorgadepartDAO getXsglTabStuorgadepartDAO() {
		return xsglTabStuorgadepartDAO;
	}

	public void setXsglTabStuorgadepartDAO(
			XsglTabStuorgadepartDAO xsglTabStuorgadepartDAO) {
		this.xsglTabStuorgadepartDAO = xsglTabStuorgadepartDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabStuorgadepartManager#saveStudent(com.xdsc.model.xsgl_system.XsglTabStuorgadepart)
	 */
	public boolean saveStudent(XsglTabStuorgadepart student){
		return xsglTabStuorgadepartDAO.saveStudent(student);
	} 
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabStuorgadepartManager#deleteStudent(com.xdsc.model.xsgl_system.XsglTabStuorgadepart)
	 */
	public boolean deleteStudent(XsglTabStuorgadepart student){
		return xsglTabStuorgadepartDAO.deleteStudent(student);
	}
	
	public List<XsglTabStuorgadepart> getStudentList(){
		return xsglTabStuorgadepartDAO.getStudentList();
	}

	
	public List<XsglTabStuorgadepart> getStudentByDepartment(int dname) {
		return xsglTabStuorgadepartDAO.getStudentByDepartment(dname);
	}

	public List<XsglTabStuorgadepart> getStudentByKeXie() {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStudentByKeXie();
	}

	public List<XsglTabStuorgadepart> getStudentByStudentUnion() {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStudentByStudentUnion();
	}

	public List<XsglTabStuorgadepart> getStudentByTuanWei() {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStudentByTuanWei();
	}

	public List<XsglTabStuorgadepart> getStudentByKXDepartment(int dname) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStudentByKXDepartment(dname);
	}

	public List<XsglTabStuorgadepart> getStudentByTWDepartment(int dname) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStudentByTWDepartment(dname);
	}

	public boolean updateStudent(XsglTabStuorgadepart student) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.updateStudent(student);
	}

	public XsglTabStuorgadepart getStuorgdepById(int Id) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStuorgdepById(Id);
	}

	public List<XsglTabStuorgadepart> getStuOrgByStuNum(String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStuOrgByStuNum(stuNum);
	}

	public List<XsglTabStuorgadepart> getStuOrgByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStuOrgByStuName(stuName);
	}

	public List<XsglTabStuorgadepart> getStudentByOrgDep(int dName) {
		// TODO Auto-generated method stub
		return xsglTabStuorgadepartDAO.getStudentByOrgDep(dName);
	}


}
