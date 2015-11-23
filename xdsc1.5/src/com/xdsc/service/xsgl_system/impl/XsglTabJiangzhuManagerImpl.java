package com.xdsc.service.xsgl_system.impl;


import java.util.Date;
import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabJiangzhuDAO;
import com.xdsc.model.XsglTabJiangzhu;
import com.xdsc.service.xsgl_system.XsglTabJiangzhuManager;

public class XsglTabJiangzhuManagerImpl implements XsglTabJiangzhuManager {
	private XsglTabJiangzhuDAO xsglTabJiangzhuDAO;

	public XsglTabJiangzhuDAO getXsglTabJiangzhuDAO() {
		return xsglTabJiangzhuDAO;
	}

	public void setXsglTabJiangzhuDAO(XsglTabJiangzhuDAO xsglTabJiangzhuDAO) {
		this.xsglTabJiangzhuDAO = xsglTabJiangzhuDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabJiangzhuManager#saveFStudent(com.xdsc.model.xsgl_system.XsglTabJiangzhu)
	 */
	public boolean saveFStudent(XsglTabJiangzhu fstudent){
		return xsglTabJiangzhuDAO.saveFStudent(fstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabJiangzhuManager#deleteFStudent(com.xdsc.model.xsgl_system.XsglTabJiangzhu)
	 */
	public boolean deleteFStudent(XsglTabJiangzhu fstudent){
		return xsglTabJiangzhuDAO.deleteFStudent(fstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabJiangzhuManager#getFStudentList()
	 */
	public List<XsglTabJiangzhu> getFStudentList(){
		return xsglTabJiangzhuDAO.getFStudentList();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabJiangzhuManager#getFStudentListByStuNum(java.lang.String)
	 */
	public List<XsglTabJiangzhu> getFStudentListByStuNum(String stuNum){
		return xsglTabJiangzhuDAO.getFStudentListByStuNum(stuNum);
	}

	public List<XsglTabJiangzhu> getFStudentListByLoan() {
		return xsglTabJiangzhuDAO.getFStudentListByLoan();
	}

	public List<XsglTabJiangzhu> getFStudentListByScholarship() {
		return xsglTabJiangzhuDAO.getFStudentListByScholarship();
	}

	public List<XsglTabJiangzhu> getFStudentListByStipend() {
		return xsglTabJiangzhuDAO.getFStudentListByStipend();
	}

	public List<XsglTabJiangzhu> getFStudentListByOption(String year,
			String classid) {
		return xsglTabJiangzhuDAO.getFStudentListByOption(year, classid);
	}

	public List<XsglTabJiangzhu> getFStudentListBySchOption(String year,
			String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentListBySchOption(year, classid);
	}

	public List<XsglTabJiangzhu> getFStudentListByStiOption(String year,
			String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentListByStiOption(year, classid);
	}

	public List<XsglTabJiangzhu> getGradeStudentListByLoan(Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getGradeStudentListByLoan(startDate, endDate);
	}

	public List<XsglTabJiangzhu> getGradeStudentListByScholarship(
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getGradeStudentListByScholarship(startDate, endDate);
	}

	public List<XsglTabJiangzhu> getGradeStudentListByStipend(Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getGradeStudentListByStipend(startDate, endDate);
	}

	public boolean updateFStudent(XsglTabJiangzhu fstudent) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.updateFStudent(fstudent);
	}


	public List<XsglTabJiangzhu> getGradeStuByLoan(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentListByLoan();
	}


	public List<XsglTabJiangzhu> getGradeStuBySholarship(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentListByScholarship();
	}

	
	public List<XsglTabJiangzhu> getGradeStuByStipend(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentListByStipend();
	}

	public List<XsglTabJiangzhu> getClassStudentByLoan(String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getClassStudentByLoan(classid);
	}

	public List<XsglTabJiangzhu> getClassStudentBySholarship(String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getClassStudentBySholarship(classid);
	}

	public List<XsglTabJiangzhu> getClassStudentByStipend(String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getClassStudentByStipend(classid);
	}

	public List<XsglTabJiangzhu> getStudentListByNameYearClass(String name,
			String year, String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getStudentListByNameYearClass(name, year, classid);
	}

	public XsglTabJiangzhu getFStudentByFid(int fid) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentByFid(fid);
	}

	public List<XsglTabJiangzhu> getFundStuByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFundStuByStuName(stuName);
	}

	public List<XsglTabJiangzhu> getFundStuByStuNum(String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhuDAO.getFStudentListByStuNum(stuNum);
	}

}
