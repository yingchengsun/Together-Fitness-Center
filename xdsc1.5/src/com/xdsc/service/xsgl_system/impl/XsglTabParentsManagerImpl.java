package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabParentsDAO;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.xsgl_system.XsglTabParentsManager;

public class XsglTabParentsManagerImpl implements XsglTabParentsManager {
	private XsglTabParentsDAO xsglTabParentsDAO;
	
	public XsglTabParentsDAO getXsglTabParentsDAO() {
		return xsglTabParentsDAO;
	}

	public void setXsglTabParentsDAO(XsglTabParentsDAO xsglTabParentsDAO) {
		this.xsglTabParentsDAO = xsglTabParentsDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabParentsManager#getParentById(java.lang.String)
	 */
	public XsglTabParents getParentById(String pid){
		return xsglTabParentsDAO.getParentById(pid);
	}

	public boolean deleteParent(XsglTabParents parent) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.deleteParent(parent);
	}

	public List<XsglTabParents> getParentList() {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.getParentList();
	}

	public boolean saveParent(XsglTabParents parent) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.saveParent(parent);
	}

	public boolean updateParent(XsglTabParents parent) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.updateParent(parent);
	}

	public List<XsglTabParents> getParentByPName(String parentName) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.getParentByPName(parentName);
	}

	public List<XsglTabParents> getParentByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.getParentByStuName(stuName);
	}

	public List<XsglTabParents> getParentByStuNum(String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.getParentByStuNum(stuNum);
	}

	public List<XsglTabParents> getParentByPNum(String parentNum) {
		// TODO Auto-generated method stub
		return xsglTabParentsDAO.getParentByPNum(parentNum);
	}
}
