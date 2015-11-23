package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabJiangzhu;
import com.xdsc.model.XsglTabPartygather;

public interface XsglTabPartygatherDAO {

	public abstract boolean saveParty(XsglTabPartygather party);

	public abstract boolean deleteParty(XsglTabPartygather party);

	public abstract List<XsglTabPartygather> getPartyList();

	public abstract XsglTabPartygather getPartyByFCNum(String FCNum);

	public abstract XsglTabPartygather getPartyByFName(String FName);

	public abstract boolean updateParty(XsglTabPartygather party);
	
	public abstract XsglTabPartygather getPartyByFId(int FId);
	
	public abstract List<XsglTabPartygather> getPartyByNameYearAndClass(String year,String classid,String name);
	


}