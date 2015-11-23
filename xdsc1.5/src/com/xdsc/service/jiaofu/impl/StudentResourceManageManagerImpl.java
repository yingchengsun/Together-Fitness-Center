package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.StudentResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.service.jiaofu.StudentResourceManageManager;
/**
 * <p>���ܣ�������Դ���ҵȲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentResourceManageManagerImpl implements StudentResourceManageManager{
	/**DAO�����*/
	private StudentResourceManageDAO studentResourceManageDAO;

	public StudentResourceManageDAO getStudentResourceManageDAO() {
		return studentResourceManageDAO;
	}

	public void setStudentResourceManageDAO(
			StudentResourceManageDAO studentResourceManageDAO) {
		this.studentResourceManageDAO = studentResourceManageDAO;
	}

	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return studentResourceManageDAO.findUploadfileByID(FNumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param id ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findUploadfileInfoByID(String id) {
		// TODO Auto-generated method stub
		return studentResourceManageDAO.findUploadfileInfoByID(id);
	}
}
