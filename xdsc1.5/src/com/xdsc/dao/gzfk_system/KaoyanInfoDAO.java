package com.xdsc.dao.gzfk_system;

import java.util.List;
import com.xdsc.model.GzfkTabKaoyanstudent;

public interface KaoyanInfoDAO {
	
	//-------------------考研，出国相关函数-------------------
	List<GzfkTabKaoyanstudent> findKaoyanstudentByExample(GzfkTabKaoyanstudent kaoyanStudent);
	public void addKaoyanStudent(GzfkTabKaoyanstudent kaoyanStudent);
	public List<GzfkTabKaoyanstudent> findKaoyanInfo();
	public GzfkTabKaoyanstudent findKaoyanInfoByID(Integer FNumber);
	public List<GzfkTabKaoyanstudent> findKaoyanInfoByName(String name);
	public void deleteKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent);
	public void updateKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent);
	public GzfkTabKaoyanstudent findKaoyanInfoByStuNum(String num);
	
	
}
