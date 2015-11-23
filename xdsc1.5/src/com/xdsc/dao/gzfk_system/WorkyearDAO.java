package com.xdsc.dao.gzfk_system;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.model.GzfkTabComnums;

public interface WorkyearDAO{
	public void addWorkyear(GzfkTabComnums workyear);
	
	public GzfkTabComnums findWorkyearByNum(int FId);
	
	public  List<GzfkTabComnums> findWorkyearInfoByNum(String name);
	
	public List<GzfkTabComnums> findAllWorkyear();
	
	public void deleteWorkyearByNum(GzfkTabComnums workyear);
	
	public void updateWorkyear(GzfkTabComnums workyear);
}
