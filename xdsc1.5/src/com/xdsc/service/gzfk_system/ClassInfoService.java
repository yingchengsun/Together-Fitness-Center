package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.TabClasses;
import com.xdsc.model.TabStudents;

public interface ClassInfoService {
	public Boolean ClassIsValid(TabClasses class1);

	public void addClassInfo(TabClasses class1);
	
	public void delClassInfo(TabClasses class1);
	
	public void updateClassInfo(TabClasses class1);
	
	public TabClasses findClassByNum(String num);
	
	public List<TabClasses> findClassoneByNum(String num);
	
	public List<TabClasses> findGradeByNum(String num);

	public List<TabClasses> findAllClassInfo();
	
	

}
