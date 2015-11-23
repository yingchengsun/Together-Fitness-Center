package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AssistResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.service.jiaofu.AssistResourceManageManager;
/**
 * <p>���ܣ�������Դ���ҵȲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistResourceManageManagerImpl implements AssistResourceManageManager{
	/**DAO�����*/
	private AssistResourceManageDAO assistResourceManageDAO;

	public AssistResourceManageDAO getAssistResourceManageDAO() {
		return assistResourceManageDAO;
	}

	public void setAssistResourceManageDAO(
			AssistResourceManageDAO assistResourceManageDAO) {
		this.assistResourceManageDAO = assistResourceManageDAO;
	}

	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param id ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findResourceInfoByID(String id) {
		// TODO Auto-generated method stub
		return assistResourceManageDAO.findResourceInfoByID(id);
	}

	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return assistResourceManageDAO.findUploadfileByID(FNumber);
	}
}
