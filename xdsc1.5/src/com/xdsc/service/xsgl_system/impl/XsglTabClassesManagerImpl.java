package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabClassesDAO;
import com.xdsc.model.TabClasses;

import com.xdsc.service.xsgl_system.XsglTabClassesManager;

public class XsglTabClassesManagerImpl implements XsglTabClassesManager {
	private XsglTabClassesDAO xsglTabClassesDAO;

	
	
	public XsglTabClassesDAO getXsglTabClassesDAO() {
		return xsglTabClassesDAO;
	}

	public void setXsglTabClassesDAO(XsglTabClassesDAO xsglTabClassesDAO) {
		this.xsglTabClassesDAO = xsglTabClassesDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabClassesManager#saveClass(com.xdsc.model.xsgl_system.TabClasses)
	 */
	public boolean saveClass(TabClasses tabClass){
		return xsglTabClassesDAO.saveClass(tabClass);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabClassesManager#deleteClass(com.xdsc.model.xsgl_system.TabClasses)
	 */
	public boolean deleteClass(TabClasses tabClass){
		return xsglTabClassesDAO.deleteClass(tabClass);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabClassesManager#getClassList()
	 */
	public List<TabClasses> getClassList(){
		return xsglTabClassesDAO.getClassList();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabClassesManager#getClassByStuNum(java.lang.String)
	 */
	public TabClasses getClassByStuNum(String classNum) {
		return xsglTabClassesDAO.getClassByClassNum(classNum);
	}

	public TabClasses getClassByclassNum(String classNum) {
		// TODO Auto-generated method stub
		return xsglTabClassesDAO.getClassByClassNum(classNum);
	}

	public boolean updateClass(TabClasses tabClass) {
		// TODO Auto-generated method stub
		return xsglTabClassesDAO.updateClass(tabClass);
	}

	
	public List<TabClasses> getClassByGradeId(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabClassesDAO.getClassByGradeId(gradeId);
	}

	public List<TabClasses> getPostgraClassList() {
		// TODO Auto-generated method stub
		return xsglTabClassesDAO.getPostgraClassList();
	}

	public List<TabClasses> getUndergraClassList() {
		// TODO Auto-generated method stub
		return xsglTabClassesDAO.getUndergraClassList();
	}


}
