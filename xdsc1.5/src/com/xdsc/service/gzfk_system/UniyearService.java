package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.GzfkTabUninums;

public interface UniyearService {
	public void addUniyear(GzfkTabUninums uniyear);
	
	public GzfkTabUninums findUniyearByNum(int FNumber);
	
	public List<GzfkTabUninums> findUniyearInfoByNum(int uniNum);
	
	public List<GzfkTabUninums> findAllUniyear();
	
	public void deleteUniyearByNum(GzfkTabUninums uniyear);

	public void updateUniyear(GzfkTabUninums uniyear);
	
}
