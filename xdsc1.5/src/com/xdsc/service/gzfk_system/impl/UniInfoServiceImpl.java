package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.UniInfoDAO;
import com.xdsc.model.GzfkTabStudyuniversity;
import com.xdsc.service.gzfk_system.UniInfoService;

public class UniInfoServiceImpl implements UniInfoService{
	private UniInfoDAO uniInfoDAO;

	public void addUniInfo(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		uniInfoDAO.addUniInfo(uni);	}

	public void delUniInfo(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		uniInfoDAO.delUniInfo(uni);
	}

	public List<GzfkTabStudyuniversity> findAllUniInfo() {
		// TODO Auto-generated method stub
		return uniInfoDAO.findAllUniInfo();
	}

	public List<GzfkTabStudyuniversity> findUniByName(String name) {
		// TODO Auto-generated method stub
		return uniInfoDAO.findUniByName(name);
	}

	public GzfkTabStudyuniversity findUniByNum(int num) {
		// TODO Auto-generated method stub
		return uniInfoDAO.findUniByNum(num);
	}

	public void updateUniInfo(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		uniInfoDAO.updateUniInfo(uni);
	}

	public UniInfoDAO getUniInfoDAO() {
		return uniInfoDAO;
	}

	public void setUniInfoDAO(UniInfoDAO uniInfoDAO) {
		this.uniInfoDAO = uniInfoDAO;
	}

	public Boolean UniIsValid(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		System.out.println("uni exist serviceimpl*******************************");

		if(uniInfoDAO.findUniByExample(uni).size()>0){
			System.out.println("yes uni  exist serviceimpl*******************************");

			return true;
		}
		System.out.println("no uni  exist serviceimpl*******************************");

		return false;
	}

	public List<GzfkTabStudyuniversity> searchUniByName(String name) {
		// TODO Auto-generated method stub
		return uniInfoDAO.searchUniByName(name);
	}

}
