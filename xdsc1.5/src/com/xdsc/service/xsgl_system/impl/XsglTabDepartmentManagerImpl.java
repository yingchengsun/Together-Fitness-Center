package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabDepartmentDAO;
import com.xdsc.model.XsglTabDepartment;
import com.xdsc.service.xsgl_system.XsglTabDepartmentManager;

public class XsglTabDepartmentManagerImpl implements XsglTabDepartmentManager {
	private XsglTabDepartmentDAO xsglTabDepartmentDAO;

	public XsglTabDepartmentDAO getXsglTabDepartmentDAO() {
		return xsglTabDepartmentDAO;
	}

	public void setXsglTabDepartmentDAO(XsglTabDepartmentDAO xsglTabDepartmentDAO) {
		this.xsglTabDepartmentDAO = xsglTabDepartmentDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabDepartmentManager#saveDepartment(com.xdsc.model.xsgl_system.XsglTabDepartment)
	 */
	public boolean saveDepartment(XsglTabDepartment department){
		return xsglTabDepartmentDAO.saveDepartment(department);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabDepartmentManager#deleteDepartment(com.xdsc.model.xsgl_system.XsglTabDepartment)
	 */
	public boolean deleteDepartment(XsglTabDepartment department){
		return xsglTabDepartmentDAO.deleteDepartment(department);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabDepartmentManager#getDepartmentList()
	 */
	public List<XsglTabDepartment> getDepartmentList(){
		return xsglTabDepartmentDAO.getDepartmentList();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabDepartmentManager#getDepartmentByName(java.lang.String)
	 */
	public List<XsglTabDepartment> getDepartmentByName(String name){
		return xsglTabDepartmentDAO.getDepartmentByName(name);
	}

	public XsglTabDepartment getDepartmentById(int departId) {
		// TODO Auto-generated method stub
		return xsglTabDepartmentDAO.getDepartmentById(departId);
	}

	public boolean updateDepartment(XsglTabDepartment department) {
		// TODO Auto-generated method stub
		return xsglTabDepartmentDAO.updateDepartment(department);
	}

	public List<XsglTabDepartment> getDepartmentByOName(String oname) {
		// TODO Auto-generated method stub
		return xsglTabDepartmentDAO.getDepartmentByOName(oname);
	}
}
