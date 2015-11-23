package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.WorkyearDAO;
import com.xdsc.model.GzfkTabComnums;
import com.xdsc.service.gzfk_system.WorkyearService;

public class WorkyearServiceImpl implements WorkyearService{
	private WorkyearDAO workyearDAO;

	public void addWorkyear(GzfkTabComnums workyear) {
		// TODO Auto-generated method stub
		workyearDAO.addWorkyear(workyear);
	}

	public GzfkTabComnums findWorkyearByNum(int FId) {
		// TODO Auto-generated method stub
		return workyearDAO.findWorkyearByNum(FId);
	}

	public List<GzfkTabComnums> findWorkyearInfoByNum(String name) {
		// TODO Auto-generated method stub
		return workyearDAO.findWorkyearInfoByNum(name);
	}

	public WorkyearDAO getWorkyearDAO() {
		return workyearDAO;
	}

	public void setWorkyearDAO(WorkyearDAO workyearDAO) {
		this.workyearDAO = workyearDAO;
	}

	public void deleteWorkyearByNum(GzfkTabComnums workyear) {
		// TODO Auto-generated method stub
		workyearDAO.deleteWorkyearByNum(workyear);
	}

	public List<GzfkTabComnums> findAllWorkyear() {
		// TODO Auto-generated method stub
		return workyearDAO.findAllWorkyear();
	}

	public void updateWorkyear(GzfkTabComnums workyear) {
		// TODO Auto-generated method stub
		workyearDAO.updateWorkyear(workyear);
	}

}
