package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabOrganizationsDAO;
import com.xdsc.model.XsglTabOrganizations;
import com.xdsc.service.xsgl_system.XsglTabOrganizationsManager;

public class XsglTabOrganizationsManagerImpl implements XsglTabOrganizationsManager {
	private XsglTabOrganizationsDAO xsglTabOrganizationsDAO;
	
	public XsglTabOrganizationsDAO getXsglTabOrganizationsDAO() {
		return xsglTabOrganizationsDAO;
	}

	public void setXsglTabOrganizationsDAO(
			XsglTabOrganizationsDAO xsglTabOrganizationsDAO) {
		this.xsglTabOrganizationsDAO = xsglTabOrganizationsDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabOrganizationsManager#saveOrganization(com.xdsc.model.xsgl_system.XsglTabOrganizations)
	 */
	public boolean saveOrganization(XsglTabOrganizations organization){
		return xsglTabOrganizationsDAO.saveOrganization(organization);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabOrganizationsManager#deleteOrganization(com.xdsc.model.xsgl_system.XsglTabOrganizations)
	 */
	public boolean deleteOrganization(XsglTabOrganizations organization){
		return xsglTabOrganizationsDAO.deleteOrganization(organization);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabOrganizationsManager#getOrganizationList()
	 */
	public List<XsglTabOrganizations> getOrganizationList(){
		return xsglTabOrganizationsDAO.getOrganizationList();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabOrganizationsManager#getOrganizationByName(java.lang.String)
	 */
	public List<XsglTabOrganizations> getOrganizationByName(String Oname){
		return xsglTabOrganizationsDAO.getOrganizationByName(Oname);
	}

	public XsglTabOrganizations getOrganizationById(int orgId) {
		// TODO Auto-generated method stub
		return xsglTabOrganizationsDAO.getOrganizationById(orgId);
	}

	public boolean updateOrganization(XsglTabOrganizations organization) {
		// TODO Auto-generated method stub
		return xsglTabOrganizationsDAO.updateOrganization(organization);
	} 
}
