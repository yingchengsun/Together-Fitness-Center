package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.KsCheckDAO;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.KsCheckManager;

/** ������ѯ��Ϣ
 * @author ��С��
 * @version 1.2
 */
public class KsCheckManagerImpl implements KsCheckManager{
	/**
	 * DAO���������
	 */
	private KsCheckDAO ksCheckDAO;
	/**���ҿ������� 
	 * @param FAppRegNum ����id
	 * @return ��������
	 */
	public WsbmTabRegapplicant findKaoShengInfoByNum(String FAppRegNum) {
		// TODO Auto-generated method stub
		return ksCheckDAO.findKaoShengInfoByNum(FAppRegNum);
	}

	public KsCheckDAO getKsCheckDAO() {
		return ksCheckDAO;
	}
	public void setKsCheckDAO(KsCheckDAO ksCheckDAO) {
		this.ksCheckDAO = ksCheckDAO;
	}
	/** ���ҿ��Կ�Ŀ
	 * @return ���Կ�Ŀ�б�
	 */
	public List<WsbmTabExamsubject> findExamsubject() {
		return ksCheckDAO.findExamsubject();
	}

	public WsbmTabExamsubject sepFindSubjectByNum(Integer subjectNumber) {
		return ksCheckDAO.sepFindSubjectByNum(subjectNumber);
		
	}

}
