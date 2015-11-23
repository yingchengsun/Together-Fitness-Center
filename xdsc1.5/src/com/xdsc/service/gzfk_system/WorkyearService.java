package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.GzfkTabComnums;

public interface WorkyearService {
	public void addWorkyear(GzfkTabComnums workyear);
	
	public GzfkTabComnums findWorkyearByNum(int FId);
	
	public  List<GzfkTabComnums> findWorkyearInfoByNum(String name);

	public List<GzfkTabComnums> findAllWorkyear();
	
	public void deleteWorkyearByNum(GzfkTabComnums workyear); 
	
	public void updateWorkyear(GzfkTabComnums workyear);

}
