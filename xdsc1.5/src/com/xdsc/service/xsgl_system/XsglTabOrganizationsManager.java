package com.xdsc.service.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabOrganizations;

public interface XsglTabOrganizationsManager {

	public abstract boolean saveOrganization(XsglTabOrganizations organization);

	public abstract boolean deleteOrganization(XsglTabOrganizations organization);

	public abstract List<XsglTabOrganizations> getOrganizationList();

	public abstract List<XsglTabOrganizations> getOrganizationByName(
			String Oname);
	
	public abstract XsglTabOrganizations getOrganizationById(int orgId);
	
	public abstract boolean updateOrganization(XsglTabOrganizations organization);

}