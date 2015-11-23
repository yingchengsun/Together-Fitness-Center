package com.xdsc.service.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabPostgraduateDAO;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.service.xsgl_system.XsglTabPostgraduateManager;

public class XsglTabPostgraduateManagerImpl implements XsglTabPostgraduateManager {
	private XsglTabPostgraduateDAO xsglTabPostgraduateDAO;


	
	public XsglTabPostgraduateDAO getXsglTabPostgraduateDAO() {
		return xsglTabPostgraduateDAO;
	}

	public void setXsglTabPostgraduateDAO(
			XsglTabPostgraduateDAO xsglTabPostgraduateDAO) {
		this.xsglTabPostgraduateDAO = xsglTabPostgraduateDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabPostgraduateManager#savePostgraduate(com.xdsc.model.xsgl_system.TabPostgraduate)
	 */
	public boolean savePostgraduate(TabPostgraduate postgraduate){
		return xsglTabPostgraduateDAO.savePostgraduate(postgraduate);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabPostgraduateManager#deletePostgraduate(com.xdsc.model.xsgl_system.TabPostgraduate)
	 */
	public boolean deletePostgraduate(TabPostgraduate postgraduate){
		return xsglTabPostgraduateDAO.deletePostgraduate(postgraduate);
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabPostgraduateManager#getPostgraduateList()
	 */
	public List<TabPostgraduate> getPostgraduateList(){
		return xsglTabPostgraduateDAO.getPostgraduateList();
	}

	
	public List<TabPostgraduate> getPostgraduateListByYear(Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		return xsglTabPostgraduateDAO.getPostgraduateListByYear(startDate, endDate);
	}

	
	public List<TabPostgraduate> getPostgraduateByStuNum(String stuNum) {
		// TODO Auto-generated method stub
		return xsglTabPostgraduateDAO.getPostgraduateByStuNum(stuNum);
	}

	public boolean updatePostgraduate(TabPostgraduate postgraduate) {
		// TODO Auto-generated method stub
		return xsglTabPostgraduateDAO.updatePostgraduate(postgraduate);
	}

	public List<TabPostgraduate> getPostgraduateByGrade(int gid) {
		// TODO Auto-generated method stub
		return xsglTabPostgraduateDAO.getPostgraduateByGrade(gid);
	}


	public List<TabPostgraduate> getPostgraduateByStuName(String stuName) {
		// TODO Auto-generated method stub
		return xsglTabPostgraduateDAO.getPostgraduateByStuName(stuName);
	}

	public List<TabPostgraduate> getPostgraduateByClass(String classid) {
		// TODO Auto-generated method stub
		return xsglTabPostgraduateDAO.getPostgraduateByClass(classid);
	}
}
