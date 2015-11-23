package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.KsCheckDAO;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.KsCheckManager;

/** 考生查询信息
 * @author 苟小龙
 * @version 1.2
 */
public class KsCheckManagerImpl implements KsCheckManager{
	/**
	 * DAO层对象属性
	 */
	private KsCheckDAO ksCheckDAO;
	/**查找考生对象 
	 * @param FAppRegNum 考生id
	 * @return 考生对象
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
	/** 查找考试科目
	 * @return 考试科目列表
	 */
	public List<WsbmTabExamsubject> findExamsubject() {
		return ksCheckDAO.findExamsubject();
	}

	public WsbmTabExamsubject sepFindSubjectByNum(Integer subjectNumber) {
		return ksCheckDAO.sepFindSubjectByNum(subjectNumber);
		
	}

}
