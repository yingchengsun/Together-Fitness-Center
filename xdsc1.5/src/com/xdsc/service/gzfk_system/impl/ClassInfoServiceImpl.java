package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.ClassInfoDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabStudents;
import com.xdsc.service.gzfk_system.ClassInfoService;

public class ClassInfoServiceImpl implements ClassInfoService{
	private ClassInfoDAO classInfoDAO;

	public void addClassInfo(TabClasses class1) {
		// TODO Auto-generated method stub
		classInfoDAO.addClassInfo(class1);
	}

	public void delClassInfo(TabClasses class1) {
		// TODO Auto-generated method stub
		classInfoDAO.delClassInfo(class1);

	}

	public List<TabClasses> findAllClassInfo() {
		// TODO Auto-generated method stub
		return classInfoDAO.findAllClassInfo();
	}

	public TabClasses findClassByNum(String num) {
		// TODO Auto-generated method stub
		return classInfoDAO.findClassByNum(num);
	}

	public void updateClassInfo(TabClasses class1) {
		// TODO Auto-generated method stub
		classInfoDAO.updateClassInfo(class1);
	}

	public ClassInfoDAO getClassInfoDAO() {
		return classInfoDAO;
	}

	public void setClassInfoDAO(ClassInfoDAO classInfoDAO) {
		this.classInfoDAO = classInfoDAO;
	}

	public List<TabClasses> findClassoneByNum(String num) {
		// TODO Auto-generated method stub
		return classInfoDAO.findClassoneByNum(num);
	}

	public List<TabClasses> findGradeByNum(String num) {
		// TODO Auto-generated method stub
		return classInfoDAO.findGradeByNum(num);
	}

	public Boolean ClassIsValid(TabClasses class1) {
		// TODO Auto-generated method stub
		if(classInfoDAO.findClssByExample(class1).size()>0){
			return true;
		}
		return false;
	}


	
}
