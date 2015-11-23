package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabJiangzhugather;

public interface XsglTabJiangzhugatherDAO {

	public abstract boolean saveJiangzhu(XsglTabJiangzhugather fund);

	public abstract boolean deleteJiangzhu(XsglTabJiangzhugather fund);
	
	public abstract boolean updateJiangzhu(XsglTabJiangzhugather fund);
	
	public abstract List<XsglTabJiangzhugather> getFundList();

	public abstract List<XsglTabJiangzhugather> getLoanList();
	
	public abstract List<XsglTabJiangzhugather> getStipendList();
	
	public abstract List<XsglTabJiangzhugather> getScholarshipList();
	
	public abstract XsglTabJiangzhugather getFundById(int id);
	
	public abstract List<XsglTabJiangzhugather> getFundByClassNum(String classNum);
	
	public abstract List<XsglTabJiangzhugather> getFundByYear(String year);
	
	public abstract List<XsglTabJiangzhugather> getFundByNameClassAndYear(String classNum,String year,String name);

}