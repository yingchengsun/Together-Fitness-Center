package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.DeleteDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.DeleteManager;

/** 删除网站信息
 * @author 苟小龙
 * @version 1.2
 */
public class DeleteManagerImpl implements DeleteManager{
	/**
	 * DAO层对象属性
	 */
	private DeleteDAO deleteDAO;
	/** 删除考生账号
	 * @param mhqxTabUser 系统用户对象
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
	/**找到考生账号
	 * @param FUserNumber 系统用户id
	 * @return 系统用户对象
	 */
	public MhqxTabUser findAccByNum(String FUserNumber) {
		// TODO Auto-generated method stub
		return deleteDAO.findAccByNum(FUserNumber);
	}
	/** 查找考生信息
	 * @return 考生对象
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		// TODO Auto-generated method stub
		return deleteDAO.findRegapplicantInfo();
	}
	/**删除网站公告信息
	 * @param tabNotice 公告信息对象
	 */
	public void deleteNotice(TabNotice tabNotice) {
		deleteDAO.deleteNotice(tabNotice);
	}
	/**删除考生账号
	 * @param wsbmTabRegapplicant 考生对象
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
