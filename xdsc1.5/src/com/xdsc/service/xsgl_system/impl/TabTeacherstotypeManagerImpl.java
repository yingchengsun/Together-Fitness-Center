package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.TabTeacherstotypeDAO;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.service.xsgl_system.TabTeacherstotypeManager;

public class TabTeacherstotypeManagerImpl implements TabTeacherstotypeManager {
	private TabTeacherstotypeDAO tabTeacherstotypeDAO;

	public TabTeacherstotypeDAO getTabTeacherstotypeDAO() {
		return tabTeacherstotypeDAO;
	}

	public void setTabTeacherstotypeDAO(TabTeacherstotypeDAO tabTeacherstotypeDAO) {
		this.tabTeacherstotypeDAO = tabTeacherstotypeDAO;
	}
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.TabTeacherstotypeManager#getTeacherByNum(java.lang.String)
	 */
	public List<TabTeacherstotype> getTeacherByNum(String TeaNum){
		return tabTeacherstotypeDAO.getTeacherByNum(TeaNum);
	} 

}
