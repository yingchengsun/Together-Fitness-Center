package com.xdsc.service.gzfk_system.impl;


import java.util.List;

import com.xdsc.dao.gzfk_system.WorkInfoDAO;
import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabWorkstudent;
import com.xdsc.service.gzfk_system.WorkInfoService;

public class WorkInfoServiceImpl implements WorkInfoService{
	WorkInfoDAO workInfoDAO;
	
	public WorkInfoDAO getBasicInfoDAO() {
		return workInfoDAO;
	}
	
	public void setBasicInfoDAO(WorkInfoDAO workInfoDAO) {
		this.workInfoDAO = workInfoDAO;
	}
	//----นคื๗----
	public void addWorkStudent(GzfkTabWorkstudent workStudent) {
		workInfoDAO.addWorkStudent(workStudent);
	}
	
	public List<GzfkTabWorkstudent> findWorkInfo() {
		// TODO Auto-generated method stub
		return workInfoDAO.findWorkInfo();
	}
	
	public void deleteWorkInfo(GzfkTabWorkstudent workStudent) {
		// TODO Auto-generated method stub
		workInfoDAO.deleteWorkInfo(workStudent);
	}
	
	public GzfkTabWorkstudent findWorkInfoByID(Integer FNumber) {
		// TODO Auto-generated method stub
		return workInfoDAO.findWorkInfoByID(FNumber);
	}
	
	public void updateWorkInfo(GzfkTabWorkstudent workStudent) {
		// TODO Auto-generated method stub
		workInfoDAO.updateWorkInfo(workStudent);
	}

	public List<GzfkTabWorkstudent> findWorkInfoByName(String name) {
		// TODO Auto-generated method stub
		return workInfoDAO.findWorkInfoByName(name);
	}

	public WorkInfoDAO getWorkInfoDAO() {
		return workInfoDAO;
	}

	public void setWorkInfoDAO(WorkInfoDAO workInfoDAO) {
		this.workInfoDAO = workInfoDAO;
	}

	public List<GzfkTabWorkstudent> findWorkInfoByCity(String FCityselect) {
		// TODO Auto-generated method stub
		return workInfoDAO.findWorkInfoByCity(FCityselect);
	}

	public GzfkTabWorkstudent findWorkInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		return workInfoDAO.findWorkInfoByStuNum(num);
	}

	public Boolean WorkstudentIsValid(GzfkTabWorkstudent workStudent) {
		// TODO Auto-generated method stub
		if(workInfoDAO.findWorkstudentByExample(workStudent).size()>0){
			return true;
		}
		else
			return false;
	
	}


}
