package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabJiaofeiDAO;
import com.xdsc.model.XsglTabJiaofei;
import com.xdsc.service.xsgl_system.XsglTabJiaofeiManager;

public class XsglTabJiaofeiManagerImpl implements XsglTabJiaofeiManager {
	private XsglTabJiaofeiDAO xsglTabJiaofeiDAO;

	public XsglTabJiaofeiDAO getXsglTabJiaofeiDAO() {
		return xsglTabJiaofeiDAO;
	}

	public void setXsglTabJiaofeiDAO(XsglTabJiaofeiDAO xsglTabJiaofeiDAO) {
		this.xsglTabJiaofeiDAO = xsglTabJiaofeiDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabJiaofeiManager#saveJStudent(com.xdsc.model.xsgl_system.XsglTabJiaofei)
	 */
	public boolean saveJStudent(XsglTabJiaofei jstudent){
		return xsglTabJiaofeiDAO.saveJStudent(jstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabJiaofeiManager#deleteJStudent(com.xdsc.model.xsgl_system.XsglTabJiaofei)
	 */
	public boolean deleteJStudent(XsglTabJiaofei jstudent){
		return xsglTabJiaofeiDAO.deleteJStudent(jstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabJiaofeiManager#getJStudentList()
	 */
	public List<XsglTabJiaofei> getJStudentList(){
		return xsglTabJiaofeiDAO.getJStudentList();
	}

	public boolean updateJStudent(XsglTabJiaofei jstudent) {
		// TODO Auto-generated method stub
		return xsglTabJiaofeiDAO.updateJStudent(jstudent);
	}

	public List<XsglTabJiaofei> getJStudentByStuNum(String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabJiaofeiDAO.getJStudentByStuNum(stuNum);
	}

	public List<XsglTabJiaofei> getJStudentByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabJiaofeiDAO.getJStudentByStuName(stuName);
	}

	public List<XsglTabJiaofei> getJStudentByYearClass(String year,
			String classid) {
		// TODO Auto-generated method stub
		return xsglTabJiaofeiDAO.getJStudentByYearClass(year, classid);
	}

	public List<XsglTabJiaofei> getJStudentListByGrade(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabJiaofeiDAO.getJStudentListByGrade(gradeId);
	}

}
