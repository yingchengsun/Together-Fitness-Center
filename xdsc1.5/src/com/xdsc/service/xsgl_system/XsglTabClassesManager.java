package com.xdsc.service.xsgl_system;

import java.util.List;

import com.xdsc.model.TabClasses;

public interface XsglTabClassesManager {

	public abstract boolean saveClass(TabClasses tabClass);

	public abstract boolean deleteClass(TabClasses tabClass);
	
	public abstract boolean updateClass(TabClasses tabClass);

	public abstract List<TabClasses> getClassList();

	public abstract TabClasses getClassByclassNum(String classNum);
	
	public abstract List<TabClasses> getClassByGradeId(int gradeId);

    public abstract List<TabClasses> getPostgraClassList();
	
	public abstract List<TabClasses> getUndergraClassList();
}