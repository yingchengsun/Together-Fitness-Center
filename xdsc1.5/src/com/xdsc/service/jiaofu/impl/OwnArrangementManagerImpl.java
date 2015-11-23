package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.OwnArrangementDAO;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.OwnArrangementManager;
/**
 * <p>功能：教学管理相关的操作<br>
 * @author qianxun
 * @version 1.1
 */
public class OwnArrangementManagerImpl implements OwnArrangementManager{
	/**DAO层对象*/
	private OwnArrangementDAO ownArrangementDAO;

	public OwnArrangementDAO getOwnArrangementDAO() {
		return ownArrangementDAO;
	}

	public void setOwnArrangementDAO(OwnArrangementDAO ownArrangementDAO) {
		this.ownArrangementDAO = ownArrangementDAO;
	}

	/**
	 * <p>功能：根据自己编号查找相关的安排信息<br>
	 * @param number 个人编号
	 * @return list 安排信息
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number) {
		return ownArrangementDAO.findZiwoanpaiByUserNumber(number);
	}
	
	/**
	 * <p>功能：根据安排id号查找相关的安排信息<br>
	 * @param FId 安排id号
	 * @return JfptTabZiwoanpai 安排对象信息
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId) {
		return (JfptTabZiwoanpai)ownArrangementDAO.findZiwoanpaiByID(FId);
	}

	/**
	 * <p>功能：删除安排对象信息<br>
	 * @param info 安排对象信息
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		ownArrangementDAO.deleteZiwoanpai(info);
	}

	/**
	 * <p>功能：添加安排信息<br>
	 * @param info 安排信息对象
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		ownArrangementDAO.addZiwoanpai(info);
	}

	/**
	 * <p>功能：根据个人id号查找User对象信息<br>
	 * @param FUserNumber 个人id号
	 * @return MhqxTabUser 返回User对象信息
	 */
	public MhqxTabUser findUserByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)ownArrangementDAO.findUserByID(FUserNumber);
	}

}
