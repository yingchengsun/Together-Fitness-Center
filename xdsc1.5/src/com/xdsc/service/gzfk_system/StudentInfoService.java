package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;

public interface StudentInfoService {
	public void addStudentInfo(TabStudents student);
	public void addStudentInfo(MhqxTabUser user);
	
	public void delStudentInfo(TabStudents student);
	
	public void updateStudentInfo(TabStudents student);
	
	public TabStudents findStudentByNum(String num);
	
	public List<TabStudents> findStudentByName(String name);
	
	public List<TabStudents> findAllStudentInfo();

	public MhqxTabUser findModuleById(String id);
	
	public List<TabStudents> findStudentByClass(String ClassNum);
	
	public List<TabStudents> findStudentbyQuxiang(String FQuxiangselect);
	
	public List<TabStudents> searchStudentByNum(String num);


}
