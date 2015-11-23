package com.xdsc.service.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabDepartment;

public interface XsglTabDepartmentManager {

	public abstract boolean saveDepartment(XsglTabDepartment department);

	public abstract boolean deleteDepartment(XsglTabDepartment department);

	public abstract List<XsglTabDepartment> getDepartmentList();

	public abstract List<XsglTabDepartment> getDepartmentByName(String name);
	
	public abstract XsglTabDepartment getDepartmentById(int departId);
	
	public abstract boolean updateDepartment(XsglTabDepartment department);

	public abstract List<XsglTabDepartment> getDepartmentByOName(String oname);

}