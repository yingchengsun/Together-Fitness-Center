package com.xdsc.dao.gzfk_system;

import java.util.List;

import com.xdsc.model.GzfkTabStudyuniversity;


public interface UniInfoDAO {
	List<GzfkTabStudyuniversity> findUniByExample(GzfkTabStudyuniversity uni);

	public void addUniInfo(GzfkTabStudyuniversity uni);
	
	public void delUniInfo(GzfkTabStudyuniversity uni);
	
	public void updateUniInfo(GzfkTabStudyuniversity uni);
	
	public GzfkTabStudyuniversity findUniByNum(int num);
	
	public List<GzfkTabStudyuniversity> findUniByName(String name);
	
	public List<GzfkTabStudyuniversity> searchUniByName(String name);
	
	public List<GzfkTabStudyuniversity> findAllUniInfo();

}
