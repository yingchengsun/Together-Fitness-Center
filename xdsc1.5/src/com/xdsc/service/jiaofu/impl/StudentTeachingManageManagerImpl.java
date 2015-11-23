package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.StudentTeachingManageDAO;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.StudentTeachingManageManager;
/**
 * <p>���ܣ���ѧ������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentTeachingManageManagerImpl implements StudentTeachingManageManager{
	/**DAO�����*/
	private StudentTeachingManageDAO studentTeachingManageDAO;
	
	public StudentTeachingManageDAO getStudentTeachingManageDAO() {
		return studentTeachingManageDAO;
	}

	public void setStudentTeachingManageDAO(
			StudentTeachingManageDAO studentTeachingManageDAO) {
		this.studentTeachingManageDAO = studentTeachingManageDAO;
	}

	/**
	 * <p>���ܣ���Ӱ�����Ϣ<br>
	 * @param info ������Ϣ����
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		studentTeachingManageDAO.addZiwoanpai(info);
	}

	/**
	 * <p>���ܣ�ɾ�����Ŷ�����Ϣ<br>
	 * @param info ���Ŷ�����Ϣ
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		studentTeachingManageDAO.deleteZiwoanpai(info);
	}

	/**
	 * <p>���ܣ����ݸ���id�Ų���User������Ϣ<br>
	 * @param FUserNumber ����id��
	 * @return MhqxTabUser ����User������Ϣ
	 */
	public MhqxTabUser findUserByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return studentTeachingManageDAO.findUserByID(FUserNumber);
	}

	/**
	 * <p>���ܣ����ݰ���id�Ų�����صİ�����Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabZiwoanpai ���Ŷ�����Ϣ
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId) {
		// TODO Auto-generated method stub
		return studentTeachingManageDAO.findZiwoanpaiByID(FId);
	}

	/**
	 * <p>���ܣ������Լ���Ų�����صİ�����Ϣ<br>
	 * @param number ���˱��
	 * @return list ������Ϣ
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number) {
		// TODO Auto-generated method stub
		return studentTeachingManageDAO.findZiwoanpaiByUserNumber(number);
	}

	
}
