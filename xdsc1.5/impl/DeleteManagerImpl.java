package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.DeleteDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.DeleteManager;

/** ɾ����վ��Ϣ
 * @author ��С��
 * @version 1.2
 */
public class DeleteManagerImpl implements DeleteManager{
	/**
	 * DAO���������
	 */
	private DeleteDAO deleteDAO;
	/** ɾ�������˺�
	 * @param mhqxTabUser ϵͳ�û�����
	 */
	public void deleteAcc(MhqxTabUser mhqxTabUser) {
		// TODO Auto-generated method stub
		deleteDAO.deleteAcc(mhqxTabUser);
	}
	public DeleteDAO getDeleteDAO() {
		return deleteDAO;
	}
	public void setDeleteDAO(DeleteDAO deleteDAO) {
		this.deleteDAO = deleteDAO;
	}
	/**�ҵ������˺�
	 * @param FUserNumber ϵͳ�û�id
	 * @return ϵͳ�û�����
	 */
	public MhqxTabUser findAccByNum(String FUserNumber) {
		// TODO Auto-generated method stub
		return deleteDAO.findAccByNum(FUserNumber);
	}
	/** ���ҿ�����Ϣ
	 * @return ��������
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		// TODO Auto-generated method stub
		return deleteDAO.findRegapplicantInfo();
	}
	/**ɾ����վ������Ϣ
	 * @param tabNotice ������Ϣ����
	 */
	public void deleteNotice(TabNotice tabNotice) {
		deleteDAO.deleteNotice(tabNotice);
	}
	/**ɾ�������˺�
	 * @param wsbmTabRegapplicant ��������
	 */
	public void deleteAcc(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		deleteDAO.deleteAcc(wsbmTabRegapplicant);
	}
	public List<WsbmTabExamsubject> findSubject() {
		// TODO Auto-generated method stub
		return deleteDAO.findSubject();
	}
	public void deleteSubject(WsbmTabExamsubject wsbmTabExamsubject) {
		// TODO Auto-generated method stub
		deleteDAO.deleteSubject(wsbmTabExamsubject);
	}

}
