package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabXiaoyouDAO;
import com.xdsc.model.XsglTabXiaoyou;
import com.xdsc.service.xsgl_system.XsglTabXiaoyouManager;

public class XsglTabXiaoyouManagerImpl implements XsglTabXiaoyouManager {
	private XsglTabXiaoyouDAO xsglTabXiaoyouDAO;

	public XsglTabXiaoyouDAO getXsglTabXiaoyouDAO() {
		return xsglTabXiaoyouDAO;
	}

	public void setXsglTabXiaoyouDAO(XsglTabXiaoyouDAO xsglTabXiaoyouDAO) {
		this.xsglTabXiaoyouDAO = xsglTabXiaoyouDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabXiaoyouManager#saveXStudent(com.xdsc.model.xsgl_system.XsglTabXiaoyou)
	 */
	public boolean saveXStudent(XsglTabXiaoyou xstudent){
		return xsglTabXiaoyouDAO.saveXStudent(xstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabXiaoyouManager#deleteXStudent(com.xdsc.model.xsgl_system.XsglTabXiaoyou)
	 */
	public boolean deleteXStudent(XsglTabXiaoyou xstudent){
		return xsglTabXiaoyouDAO.deleteXStudent(xstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.xsglTabXiaoyouManager#getXStudentList()
	 */
	public List<XsglTabXiaoyou> getXStudentList(){
		return xsglTabXiaoyouDAO.getXStudentList();
	}

	
	public List<XsglTabXiaoyou> getXStudentByName(String name) {
		// TODO Auto-generated method stub
		return xsglTabXiaoyouDAO.getXStudentByName(name);
	}

	
	public List<XsglTabXiaoyou> getXStudentById(String xid) {
		// TODO Auto-generated method stub
		return xsglTabXiaoyouDAO.getXStudentById(xid);
	}

	public List<XsglTabXiaoyou> getXStudentByOption(String region, String year) {
		// TODO Auto-generated method stub
		return xsglTabXiaoyouDAO.getXStudentByOption(region, year);
	}

}
