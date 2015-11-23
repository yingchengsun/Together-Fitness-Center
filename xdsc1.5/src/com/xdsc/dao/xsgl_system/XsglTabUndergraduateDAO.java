package com.xdsc.dao.xsgl_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.TabUndergraduate;

public interface XsglTabUndergraduateDAO {

	public abstract boolean saveUndergraduate(TabUndergraduate undergraduate);

	public abstract boolean deleteUndergraduate(TabUndergraduate undergraduate);
	
	public abstract boolean updateUndergraduate(TabUndergraduate undergraduate);

	public abstract List<TabUndergraduate> getUndergraduateList();
	
	public abstract List<TabUndergraduate> getUndergraduateByStuNum(String stuNum);
	
	public abstract List<TabUndergraduate> getUndergraduateListByYear(Date startDate, Date endDate);

	public abstract List<TabUndergraduate> getUndergraduateByGrade(int gid);
	
	public abstract List<TabUndergraduate> getUndergraduateByStuName(String stuName);
}