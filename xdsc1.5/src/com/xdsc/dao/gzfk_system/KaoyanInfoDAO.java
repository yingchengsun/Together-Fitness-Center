package com.xdsc.dao.gzfk_system;

import java.util.List;
import com.xdsc.model.GzfkTabKaoyanstudent;

public interface KaoyanInfoDAO {
	
	//-------------------���У�������غ���-------------------
	List<GzfkTabKaoyanstudent> findKaoyanstudentByExample(GzfkTabKaoyanstudent kaoyanStudent);
	public void addKaoyanStudent(GzfkTabKaoyanstudent kaoyanStudent);
	public List<GzfkTabKaoyanstudent> findKaoyanInfo();
	public GzfkTabKaoyanstudent findKaoyanInfoByID(Integer FNumber);
	public List<GzfkTabKaoyanstudent> findKaoyanInfoByName(String name);
	public void deleteKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent);
	public void updateKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent);
	public GzfkTabKaoyanstudent findKaoyanInfoByStuNum(String num);
	
	
}
