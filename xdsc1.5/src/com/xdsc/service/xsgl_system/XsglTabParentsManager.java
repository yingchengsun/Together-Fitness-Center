package com.xdsc.service.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabParents;

public interface XsglTabParentsManager {

	public abstract boolean saveParent(XsglTabParents parent);
	
	public abstract boolean deleteParent(XsglTabParents parent);
	
	public abstract boolean updateParent(XsglTabParents parent);
	
	public abstract List<XsglTabParents> getParentList();

	public abstract XsglTabParents getParentById(String pid);
	
	public abstract List<XsglTabParents> getParentByStuNum(String stuNum);
	
	public abstract List<XsglTabParents> getParentByStuName(String stuName);
	
	public abstract List<XsglTabParents> getParentByPName(String parentName);
	
	public abstract List<XsglTabParents> getParentByPNum(String parentNum);

}