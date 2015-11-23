package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabXiaoyou;

public interface XsglTabXiaoyouDAO {

	public abstract boolean saveXStudent(XsglTabXiaoyou xstudent);

	public abstract boolean deleteXStudent(XsglTabXiaoyou xstudent);

	public abstract List<XsglTabXiaoyou> getXStudentList();

	public abstract List<XsglTabXiaoyou> getXStudentByName(String name);

	public abstract List<XsglTabXiaoyou> getXStudentById(String xid);
	
	public abstract List<XsglTabXiaoyou> getXStudentByOption(String region,String year);

}