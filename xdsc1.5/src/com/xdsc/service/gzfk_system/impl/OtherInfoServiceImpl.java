package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.OtherInfoDAO;
import com.xdsc.model.GzfkTabOtherstudent;
import com.xdsc.service.gzfk_system.OtherInfoService;

public class OtherInfoServiceImpl implements OtherInfoService{
	OtherInfoDAO otherInfoDAO;

	public OtherInfoDAO getOtherInfoDAO() {
		return otherInfoDAO;
	}

	public void setOtherInfoDAO(OtherInfoDAO otherInfoDAO) {
		this.otherInfoDAO = otherInfoDAO;
	}

	public void addOtherStudent(GzfkTabOtherstudent otherStudent) {
		// TODO Auto-generated method stub
		otherInfoDAO.addOtherStudent(otherStudent);
	}

	public void deleteOtherInfo(GzfkTabOtherstudent otherStudent) {
		// TODO Auto-generated method stub
		otherInfoDAO.deleteOtherInfo(otherStudent);
	}

	public List<GzfkTabOtherstudent> findOtherInfo() {
		// TODO Auto-generated method stub
		return otherInfoDAO.findOtherInfo();
	}

	public GzfkTabOtherstudent findOtherInfoByID(Integer FNumber) {
		// TODO Auto-generated method stub
		return otherInfoDAO.findOtherInfoByID(FNumber);
	}

	public List<GzfkTabOtherstudent> findOtherInfoByName(String name) {
		// TODO Auto-generated method stub
		return otherInfoDAO.findOtherInfoByName(name);
	}

	public void updateOtherInfo(GzfkTabOtherstudent otherStudent) {
		// TODO Auto-generated method stub
		otherInfoDAO.updateOtherInfo(otherStudent);
	}

	public List<GzfkTabOtherstudent> findOtherInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		return otherInfoDAO.findOtherInfoByStuNum(num);
	}

	public GzfkTabOtherstudent findOtherInfoByStuSelfNum(String num) {
		// TODO Auto-generated method stub
		return otherInfoDAO.findOtherInfoByStuSelfNum(num);
	}

}
