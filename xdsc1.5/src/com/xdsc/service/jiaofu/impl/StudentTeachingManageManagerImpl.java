package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.StudentTeachingManageDAO;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.StudentTeachingManageManager;
/**
 * <p>功能：教学管理相关的操作<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentTeachingManageManagerImpl implements StudentTeachingManageManager{
	/**DAO层对象*/
	private StudentTeachingManageDAO studentTeachingManageDAO;
	
	public StudentTeachingManageDAO getStudentTeachingManageDAO() {
		return studentTeachingManageDAO;
	}

	public void setStudentTeachingManageDAO(
			StudentTeachingManageDAO studentTeachingManageDAO) {
		this.studentTeachingManageDAO = studentTeachingManageDAO;
	}

	/**
	 * <p>功能：添加安排信息<br>
	 * @param info 安排信息对象
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		studentTeachingManageDAO.addZiwoanpai(info);
	}

	/**
	 * <p>功能：删除安排对象信息<br>
	 * @param info 安排对象信息
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		studentTeachingManageDAO.deleteZiwoanpai(info);
	}

	/**
	 * <p>功能：根据个人id号查找User对象信息<br>
	 * @param FUserNumber 个人id号
	 * @return MhqxTabUser 返回User对象信息
	 */
	public MhqxTabUser findUserByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return studentTeachingManageDAO.findUserByID(FUserNumber);
	}

	/**
	 * <p>功能：根据安排id号查找相关的安排信息<br>
	 * @param FId 安排id号
	 * @return JfptTabZiwoanpai 安排对象信息
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId) {
		// TODO Auto-generated method stub
		return studentTeachingManageDAO.findZiwoanpaiByID(FId);
	}

	/**
	 * <p>功能：根据自己编号查找相关的安排信息<br>
	 * @param number 个人编号
	 * @return list 安排信息
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number) {
		// TODO Auto-generated method stub
		return studentTeachingManageDAO.findZiwoanpaiByUserNumber(number);
	}

	
}
