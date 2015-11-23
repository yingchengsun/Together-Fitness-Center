package com.xdsc.dao.gzfk_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;

public interface StudentInfoDAO {
	public void addStudentInfo(TabStudents student);
	public void addStudentInfo(MhqxTabUser user);
	
	public void delStudentInfo(TabStudents student);
	
	public void updateStudentInfo(TabStudents student);
	
	public TabStudents findStudentByNum(String num);
	
	public List<TabStudents> findStudentByName(String name);
	
	public List<TabStudents> searchStudentByNum(String num);

	public List<TabStudents> findAllStudentInfo();
	
	public MhqxTabUser findModuleById(String id);
	
	public List<TabStudents> findStudentByClass(String ClassNum);

	public List<TabStudents> findStudentbyQuxiang(String FQuxiangselect);

}
