package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabGradeDAO;
import com.xdsc.model.TabGrade;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;

public class XsglTabGradeManagerImpl implements XsglTabGradeManager {
	private XsglTabGradeDAO xsglTabGradeDAO;

	
	
	

	public XsglTabGradeDAO getXsglTabGradeDAO() {
		return xsglTabGradeDAO;
	}

	public void setXsglTabGradeDAO(XsglTabGradeDAO xsglTabGradeDAO) {
		this.xsglTabGradeDAO = xsglTabGradeDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#saveGrade(com.xdsc.model.xsgl_system.XsglTabGradegather)
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#saveGrade(com.xdsc.model.xsgl_system.XsglTabGradegather)
	 */
	public boolean saveGrade(TabGrade grade){
		return xsglTabGradeDAO.saveGrade(grade);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#deleteGrade(com.xdsc.model.xsgl_system.XsglTabGradegather)
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#deleteGrade(com.xdsc.model.xsgl_system.XsglTabGradegather)
	 */
	public boolean deleteGrade(TabGrade grade){
		return xsglTabGradeDAO.deleteGrade(grade);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#getGradeListByUndergraduate()
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#getGradeListByUndergraduate()
	 */
	public List<TabGrade> getGradeListByUndergraduate(){
		return xsglTabGradeDAO.getGradeListByUndergraduate();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#getGradeListByPostgraduate()
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabGradegatherManager#getGradeListByPostgraduate()
	 */
	public List<TabGrade> getGradeListByPostgraduate(){
		return xsglTabGradeDAO.getGradeListByPostgraduate();
	}

	public List<TabGrade> getGradeList() {
		// TODO Auto-generated method stub
		return xsglTabGradeDAO.getGradeList();
	}

	
	public TabGrade getGradeByGradeId(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabGradeDAO.getGradeByGradeId(gradeId);
	}

	
	public boolean updateGrade(TabGrade grade) {
		// TODO Auto-generated method stub
		return xsglTabGradeDAO.updateGrade(grade);
	}

	public TabGrade getGradeByGradeName(String gradeName) {
		// TODO Auto-generated method stub
		return xsglTabGradeDAO.getGradeByGradeName(gradeName);
	}
 
}
