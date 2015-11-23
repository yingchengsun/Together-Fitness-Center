package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AssistTeachingManageDAO;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.AssistTeachingManageManager;
/**
 * <p>���ܣ���ѧ������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistTeachingManageManagerImpl implements AssistTeachingManageManager{
	/**DAO�����*/
	private AssistTeachingManageDAO assistTeachingManageDAO;

	public AssistTeachingManageDAO getAssistTeachingManageDAO() {
		return assistTeachingManageDAO;
	}

	public void setAssistTeachingManageDAO(
			AssistTeachingManageDAO assistTeachingManageDAO) {
		this.assistTeachingManageDAO = assistTeachingManageDAO;
	}

	/**
	 * <p>���ܣ���Ӱ�����Ϣ<br>
	 * @param info ������Ϣ����
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		assistTeachingManageDAO.addZiwoanpai(info);
	}

	/**
	 * <p>���ܣ�ɾ�����Ŷ�����Ϣ<br>
	 * @param info ���Ŷ�����Ϣ
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		assistTeachingManageDAO.deleteZiwoanpai(info);
	}

	/**
	 * <p>���ܣ����ݸ���id�Ų���User������Ϣ<br>
	 * @param FUserNumber ����id��
	 * @return MhqxTabUser ����User������Ϣ
	 */
	public MhqxTabUser findUserByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return assistTeachingManageDAO.findUserByID(FUserNumber);
	}

	/**
	 * <p>���ܣ����ݰ���id�Ų�����صİ�����Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabZiwoanpai ���Ŷ�����Ϣ
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId) {
		// TODO Auto-generated method stub
		return assistTeachingManageDAO.findZiwoanpaiByID(FId);
	}

	/**
	 * <p>���ܣ������Լ���Ų�����صİ�����Ϣ<br>
	 * @param number ���˱��
	 * @return list ������Ϣ
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number) {
		// TODO Auto-generated method stub
		return assistTeachingManageDAO.findZiwoanpaiByUserNumber(number);
	}
}
