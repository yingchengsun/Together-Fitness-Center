package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabJiangzhugatherDAO;
import com.xdsc.model.XsglTabJiangzhugather;
import com.xdsc.service.xsgl_system.XsglTabJiangzhugatherManager;

public class XsglTabJiangzhugatherManagerImpl implements XsglTabJiangzhugatherManager {
	private XsglTabJiangzhugatherDAO xsglTabJiangzhugatherDAO;

	public XsglTabJiangzhugatherDAO getXsglTabJiangzhugatherDAO() {
		return xsglTabJiangzhugatherDAO;
	}

	public void setXsglTabJiangzhugatherDAO(
			XsglTabJiangzhugatherDAO xsglTabJiangzhugatherDAO) {
		this.xsglTabJiangzhugatherDAO = xsglTabJiangzhugatherDAO;
	}
	
	public boolean saveJiangzhu(XsglTabJiangzhugather fund){
		return xsglTabJiangzhugatherDAO.saveJiangzhu(fund);
	}
	
	public boolean deleteJiangzhu(XsglTabJiangzhugather fund){
		return xsglTabJiangzhugatherDAO.deleteJiangzhu(fund);
	}

	public List<XsglTabJiangzhugather> getLoanList() {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getLoanList();
	}

	public List<XsglTabJiangzhugather> getScholarshipList() {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getScholarshipList();
	}

	public List<XsglTabJiangzhugather> getStipendList() {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getStipendList();
	}

	public XsglTabJiangzhugather getFundById(int id) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getFundById(id);
	}

	public boolean updateJiangzhu(XsglTabJiangzhugather fund) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.updateJiangzhu(fund);
	}

	public List<XsglTabJiangzhugather> getFundList() {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getFundList();
	}

	public List<XsglTabJiangzhugather> getFundByClassNum(String classNum) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getFundByClassNum(classNum);
	}

	public List<XsglTabJiangzhugather> getFundByYear(String year) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getFundByYear(year);
	}

	public List<XsglTabJiangzhugather> getFundByNameClassAndYear(
			String classNum, String year,String name) {
		// TODO Auto-generated method stub
		return xsglTabJiangzhugatherDAO.getFundByNameClassAndYear(classNum, year, name);
	}

}
