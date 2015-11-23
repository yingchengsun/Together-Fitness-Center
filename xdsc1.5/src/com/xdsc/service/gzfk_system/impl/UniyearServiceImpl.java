package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.UniyearDAO;
import com.xdsc.model.GzfkTabUninums;
import com.xdsc.service.gzfk_system.UniyearService;

public class UniyearServiceImpl implements UniyearService{
	
	private UniyearDAO uniyearDAO;

	public UniyearDAO getUniyearDAO() {
		return uniyearDAO;
	}

	public void setUniyearDAO(UniyearDAO uniyearDAO) {
		this.uniyearDAO = uniyearDAO;
	}

	public void addUniyear(GzfkTabUninums uniyear) {
		// TODO Auto-generated method stub
		uniyearDAO.addUniyear(uniyear);
	}

	public GzfkTabUninums findUniyearByNum(int FNumber) {
		// TODO Auto-generated method stub
		return uniyearDAO.findUniyearByNum(FNumber);
	}

	public List<GzfkTabUninums> findUniyearInfoByNum(int uniNum) {
		// TODO Auto-generated method stub
		return uniyearDAO.findUniyearInfoByNum(uniNum);
	}

	public List<GzfkTabUninums> findAllUniyear() {
		// TODO Auto-generated method stub
		return uniyearDAO.findAllUniyear();
	}

	public void deleteUniyearByNum(GzfkTabUninums uniyear) {
		// TODO Auto-generated method stub
		uniyearDAO.deleteUniyearByNum(uniyear);
	}

	public void updateUniyear(GzfkTabUninums uniyear) {
		// TODO Auto-generated method stub
		uniyearDAO.updateUniyear(uniyear);
	}

}
