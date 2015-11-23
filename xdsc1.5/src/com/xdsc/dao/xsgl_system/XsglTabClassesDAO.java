package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.TabClasses;



public interface XsglTabClassesDAO {

	public abstract boolean saveClass(TabClasses tabClass);

	public abstract boolean deleteClass(TabClasses tabClass);

	public abstract List<TabClasses> getClassList();

	public abstract TabClasses getClassByClassNum(String classNum);
	
	public abstract boolean updateClass(TabClasses tabClass);
	
	public abstract List<TabClasses> getClassByGradeId(int gradeId);
	
	public abstract List<TabClasses> getPostgraClassList();
	
	public abstract List<TabClasses> getUndergraClassList();

}