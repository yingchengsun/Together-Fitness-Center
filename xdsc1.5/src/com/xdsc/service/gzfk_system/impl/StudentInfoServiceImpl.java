package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.StudentInfoDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;
import com.xdsc.service.gzfk_system.StudentInfoService;

public class StudentInfoServiceImpl implements StudentInfoService{
	private StudentInfoDAO studentInfoDAO;

	public void addStudentInfo(TabStudents student) {
		// TODO Auto-generated method stub
		studentInfoDAO.addStudentInfo(student);
	}
	
	public void addStudentInfo(MhqxTabUser user){
		studentInfoDAO.addStudentInfo(user);
		
	}
	public void delStudentInfo(TabStudents student) {
		// TODO Auto-generated method stub
		studentInfoDAO.delStudentInfo(student);

	}

	public List<TabStudents> findAllStudentInfo() {
		// TODO Auto-generated method stub
		return studentInfoDAO.findAllStudentInfo();
	}

	public List<TabStudents> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentInfoDAO.findStudentByName(name);
	}

	public TabStudents findStudentByNum(String num) {
		// TODO Auto-generated method stub
		return studentInfoDAO.findStudentByNum(num);
	}

	public void updateStudentInfo(TabStudents student) {
		// TODO Auto-generated method stub
		 studentInfoDAO.updateStudentInfo(student);
	}

	public StudentInfoDAO getStudentInfoDAO() {
		return studentInfoDAO;
	}

	public void setStudentInfoDAO(StudentInfoDAO studentInfoDAO) {
		this.studentInfoDAO = studentInfoDAO;
	}

	public MhqxTabUser findModuleById(String id) {
		// TODO Auto-generated method stub
		return studentInfoDAO.findModuleById(id);
	}

	public List<TabStudents> findStudentByClass(String ClassNum) {
		// TODO Auto-generated method stub
		return studentInfoDAO.findStudentByClass(ClassNum);
	}

	public List<TabStudents> findStudentbyQuxiang(String FQuxiangselect) {
		// TODO Auto-generated method stub
		return studentInfoDAO.findStudentbyQuxiang(FQuxiangselect);
	}

	public List<TabStudents> searchStudentByNum(String num) {
		// TODO Auto-generated method stub
		return studentInfoDAO.searchStudentByNum(num);
	}
}
