package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.dao.gzfk_system.UniInfoDAO;
import com.xdsc.model.GzfkTabStudyuniversity;

public interface UniInfoService {
	public Boolean UniIsValid(GzfkTabStudyuniversity uni);
	
	public void addUniInfo(GzfkTabStudyuniversity uni);
	
	public void delUniInfo(GzfkTabStudyuniversity uni);
	
	public void updateUniInfo(GzfkTabStudyuniversity uni);
	
	public GzfkTabStudyuniversity findUniByNum(int id);
	
	public List<GzfkTabStudyuniversity> findUniByName(String name);
	
	public List<GzfkTabStudyuniversity> searchUniByName(String name);
	
	public List<GzfkTabStudyuniversity> findAllUniInfo();

}
