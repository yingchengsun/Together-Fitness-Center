package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.TabTeacherstypeDAO;
import com.xdsc.model.TabTeacherstype;
import com.xdsc.service.xsgl_system.TabTeacherstypeManager;

public class TabTeacherstypeManagerImpl implements TabTeacherstypeManager {
	private TabTeacherstypeDAO tabTeacherstypeDAO;

	public TabTeacherstypeDAO getTabTeacherstypeDAO() {
		return tabTeacherstypeDAO;
	}

	public void setTabTeacherstypeDAO(TabTeacherstypeDAO tabTeacherstypeDAO) {
		this.tabTeacherstypeDAO = tabTeacherstypeDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.tabTeacherstypeManager#getTeacherByTypeNum(java.lang.String)
	 */
	public List<TabTeacherstype> getTeacherByTypeNum(String TypeNum){
		return tabTeacherstypeDAO.getTeacherByTypeNum(TypeNum);
	}

}
