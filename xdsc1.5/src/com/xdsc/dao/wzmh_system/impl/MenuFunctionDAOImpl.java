package com.xdsc.dao.wzmh_system.impl;

import com.xdsc.dao.htgl_system.impl.MhqxTabFunctionDAOImpl;
import com.xdsc.dao.wzmh_system.MenuFunctionDAO;



/**
 * ����˵�����ʱ�Թ��ܱ�ļ���
 * @author �·�
 */
public class MenuFunctionDAOImpl implements MenuFunctionDAO {
	 private MhqxTabFunctionDAOImpl  mhqxTabFunctionDAO;

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public synchronized MhqxTabFunctionDAOImpl getMhqxTabFunctionDAO() {
		return mhqxTabFunctionDAO;
	}

	public synchronized void setMhqxTabFunctionDAO(
			MhqxTabFunctionDAOImpl mhqxTabFunctionDAO) {
		this.mhqxTabFunctionDAO = mhqxTabFunctionDAO;
	}
}
