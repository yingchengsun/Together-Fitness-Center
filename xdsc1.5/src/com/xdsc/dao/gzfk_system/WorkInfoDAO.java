package com.xdsc.dao.gzfk_system;
import java.util.List;

import com.xdsc.model.GzfkTabWorkstudent;



public interface WorkInfoDAO {
	//-------------------工作学生相关函数------------------- 
	List<GzfkTabWorkstudent> findWorkstudentByExample(GzfkTabWorkstudent workStudent);
	public void addWorkStudent(GzfkTabWorkstudent workStudent);
	public List<GzfkTabWorkstudent> findWorkInfo();
	public GzfkTabWorkstudent findWorkInfoByID(Integer FNumber);
	public List<GzfkTabWorkstudent> findWorkInfoByName(String FWorkNameselect);
	public void deleteWorkInfo(GzfkTabWorkstudent workStudent);
	public void updateWorkInfo(GzfkTabWorkstudent workStudent);
	public  List<GzfkTabWorkstudent> findWorkInfoByCity(String FCityselect);
	public GzfkTabWorkstudent findWorkInfoByStuNum(String num);
	

}
