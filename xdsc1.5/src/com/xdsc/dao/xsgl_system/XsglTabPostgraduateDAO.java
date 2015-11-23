package com.xdsc.dao.xsgl_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.TabPostgraduate;

public interface XsglTabPostgraduateDAO {

	public abstract boolean savePostgraduate(TabPostgraduate postgraduate);

	public abstract boolean deletePostgraduate(TabPostgraduate postgraduate);
	
	public abstract boolean updatePostgraduate(TabPostgraduate postgraduate);

	public abstract List<TabPostgraduate> getPostgraduateList();
	
	public abstract List<TabPostgraduate> getPostgraduateListByYear(Date startDate, Date endDate);
	
	public abstract List<TabPostgraduate> getPostgraduateByStuNum(String stuNum);

	public abstract List<TabPostgraduate> getPostgraduateByGrade(int gid);
	
	public abstract List<TabPostgraduate> getPostgraduateByStuName(String stuName);
	
	public abstract List<TabPostgraduate> getPostgraduateByClass(String classid);
}