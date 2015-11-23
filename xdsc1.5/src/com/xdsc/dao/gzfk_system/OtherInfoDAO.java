package com.xdsc.dao.gzfk_system;

import java.util.List;

import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabOtherstudent;

public interface OtherInfoDAO {

	public void addOtherStudent(GzfkTabOtherstudent otherStudent);
	public List<GzfkTabOtherstudent> findOtherInfo();
	public GzfkTabOtherstudent findOtherInfoByID(Integer FNumber);
	public List<GzfkTabOtherstudent> findOtherInfoByName(String name);
	public void deleteOtherInfo(GzfkTabOtherstudent otherStudent);
	public void updateOtherInfo(GzfkTabOtherstudent otherStudent);
	public List<GzfkTabOtherstudent> findOtherInfoByStuNum(String num);
	public GzfkTabOtherstudent findOtherInfoByStuSelfNum(String num);


	
}
