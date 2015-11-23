package com.xdsc.service.xsgl_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.TabUndergraduate;

public interface XsglTabUndergraduateManager {

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateDAO#saveUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	public abstract boolean saveUndergraduate(TabUndergraduate undergraduate);

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateDAO#deleteUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	public abstract boolean deleteUndergraduate(TabUndergraduate undergraduate);

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabUndergraduateDAO#getUndergraduateList()
	 */
	public abstract boolean updateUndergraduate(TabUndergraduate undergraduate);
	
	public abstract List<TabUndergraduate> getUndergraduateList();
	
	public abstract List<TabUndergraduate> getUndergraduateByStuNum(String stuNum);

	public abstract List<TabUndergraduate> getUndergraduateListByYear(Date startDate, Date endDate);
	
	public abstract List<TabUndergraduate> getUndergraduateByGrade(int gid);
	
	public abstract List<TabUndergraduate> getUndergraduateByStuName(String stuName);
}