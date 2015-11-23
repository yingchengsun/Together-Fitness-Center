package com.xdsc.service.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabUndergraduateDAO;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.service.xsgl_system.XsglTabUndergraduateManager;

public class XsglTabUndergraduateManagerImpl implements XsglTabUndergraduateManager {
	private XsglTabUndergraduateDAO xsglTabUndergraduateDAO;


	
	public XsglTabUndergraduateDAO getXsglTabUndergraduateDAO() {
		return xsglTabUndergraduateDAO;
	}

	public void setXsglTabUndergraduateDAO(
			XsglTabUndergraduateDAO xsglTabUndergraduateDAO) {
		this.xsglTabUndergraduateDAO = xsglTabUndergraduateDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateDAO#saveUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateManager#saveUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	public boolean saveUndergraduate(TabUndergraduate undergraduate){
		return xsglTabUndergraduateDAO.saveUndergraduate(undergraduate);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateDAO#deleteUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateManager#deleteUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	public boolean deleteUndergraduate(TabUndergraduate undergraduate){
		return xsglTabUndergraduateDAO.deleteUndergraduate(undergraduate);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateDAO#getUndergraduateList()
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateManager#getUndergraduateList()
	 */
	public List<TabUndergraduate> getUndergraduateList(){
		return xsglTabUndergraduateDAO.getUndergraduateList();
	}

	
	public List<TabUndergraduate> getUndergraduateByStuNum(String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabUndergraduateDAO.getUndergraduateByStuNum(stuNum);
	}

	public List<TabUndergraduate> getUndergraduateListByYear(Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		return xsglTabUndergraduateDAO.getUndergraduateListByYear(startDate, endDate);
	}

	public boolean updateUndergraduate(TabUndergraduate undergraduate) {
		// TODO Auto-generated method stub
		return xsglTabUndergraduateDAO.updateUndergraduate(undergraduate);
	}

	public List<TabUndergraduate> getUndergraduateByGrade(int gid) {
		// TODO Auto-generated method stub
		return xsglTabUndergraduateDAO.getUndergraduateByGrade(gid);
	}

	public List<TabUndergraduate> getUndergraduateByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabUndergraduateDAO.getUndergraduateByStuName(stuName);
	}

}
