package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabWorkstudent;


public interface WorkInfoService {
	//------工作学生---
	public Boolean WorkstudentIsValid(GzfkTabWorkstudent workStudent);
	public void addWorkStudent(GzfkTabWorkstudent workStudent);
	public List<GzfkTabWorkstudent> findWorkInfo();
	public GzfkTabWorkstudent findWorkInfoByID(Integer FNumber);
	public List<GzfkTabWorkstudent> findWorkInfoByName(String FCourseNameselect);
	public void deleteWorkInfo(GzfkTabWorkstudent workStudent);
	public void updateWorkInfo(GzfkTabWorkstudent workStudent);
	public  List<GzfkTabWorkstudent> findWorkInfoByCity(String FCityselect);
	public GzfkTabWorkstudent findWorkInfoByStuNum(String num);
	
}
