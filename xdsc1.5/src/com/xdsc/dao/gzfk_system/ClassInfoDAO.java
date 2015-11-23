package com.xdsc.dao.gzfk_system;

import java.util.List;

import com.xdsc.model.TabClasses;


public interface ClassInfoDAO {
	
	List<TabClasses> findClssByExample(TabClasses class1);
	
	public void addClassInfo(TabClasses class1);
	
	public void delClassInfo(TabClasses class1);
	
	public void updateClassInfo(TabClasses class1);
	
	public TabClasses findClassByNum(String num);
	
	public List<TabClasses> findClassoneByNum(String num);
	
	public List<TabClasses> findGradeByNum(String num);
	
	public List<TabClasses> findAllClassInfo();

}
