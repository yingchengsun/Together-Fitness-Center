package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.OwnArrangementDAO;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.OwnArrangementManager;
/**
 * <p>���ܣ���ѧ������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class OwnArrangementManagerImpl implements OwnArrangementManager{
	/**DAO�����*/
	private OwnArrangementDAO ownArrangementDAO;

	public OwnArrangementDAO getOwnArrangementDAO() {
		return ownArrangementDAO;
	}

	public void setOwnArrangementDAO(OwnArrangementDAO ownArrangementDAO) {
		this.ownArrangementDAO = ownArrangementDAO;
	}

	/**
	 * <p>���ܣ������Լ���Ų�����صİ�����Ϣ<br>
	 * @param number ���˱��
	 * @return list ������Ϣ
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number) {
		return ownArrangementDAO.findZiwoanpaiByUserNumber(number);
	}
	
	/**
	 * <p>���ܣ����ݰ���id�Ų�����صİ�����Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabZiwoanpai ���Ŷ�����Ϣ
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId) {
		return (JfptTabZiwoanpai)ownArrangementDAO.findZiwoanpaiByID(FId);
	}

	/**
	 * <p>���ܣ�ɾ�����Ŷ�����Ϣ<br>
	 * @param info ���Ŷ�����Ϣ
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		ownArrangementDAO.deleteZiwoanpai(info);
	}

	/**
	 * <p>���ܣ���Ӱ�����Ϣ<br>
	 * @param info ������Ϣ����
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		ownArrangementDAO.addZiwoanpai(info);
	}

	/**
	 * <p>���ܣ����ݸ���id�Ų���User������Ϣ<br>
	 * @param FUserNumber ����id��
	 * @return MhqxTabUser ����User������Ϣ
	 */
	public MhqxTabUser findUserByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)ownArrangementDAO.findUserByID(FUserNumber);
	}

}
