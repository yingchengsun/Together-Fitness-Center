package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.KaoyanInfoDAO;
import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.service.gzfk_system.KaoyanInfoService;

public class KaoyanInfoServiceImpl implements KaoyanInfoService{
	KaoyanInfoDAO kaoyanInfoDAO;
	
	public KaoyanInfoDAO getKaoyanInfoDAO() {
		return kaoyanInfoDAO;
	}

	public void setKaoyanInfoDAO(KaoyanInfoDAO kaoyanInfoDAO) {
		this.kaoyanInfoDAO = kaoyanInfoDAO;
	}

	//-----------¿¼ÑÐ³ö¹ú------
	public void addKaoyanStudent(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		kaoyanInfoDAO.addKaoyanStudent(kaoyanStudent);
	}

	public void deleteKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		kaoyanInfoDAO.deleteKaoyanInfo(kaoyanStudent);
	}

	public List<GzfkTabKaoyanstudent> findKaoyanInfo() {
		// TODO Auto-generated method stub
		return kaoyanInfoDAO.findKaoyanInfo();
	}

	public GzfkTabKaoyanstudent findKaoyanInfoByID(Integer FNumber) {
		// TODO Auto-generated method stub
		return kaoyanInfoDAO.findKaoyanInfoByID(FNumber);
	}

	public List<GzfkTabKaoyanstudent> findKaoyanInfoByName(String name) {
		// TODO Auto-generated method stub
		return kaoyanInfoDAO.findKaoyanInfoByName(name);
	}

	public void updateKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		kaoyanInfoDAO.updateKaoyanInfo(kaoyanStudent);
	}

	public GzfkTabKaoyanstudent findKaoyanInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		return kaoyanInfoDAO.findKaoyanInfoByStuNum(num);
	}

	public Boolean KaoyanstudentIsValid(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		if(kaoyanInfoDAO.findKaoyanstudentByExample(kaoyanStudent).size()>0){
			return true;
		}
		return false;
	}

}
