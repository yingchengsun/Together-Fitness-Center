package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AdminStudentScoreDAO;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.service.jiaofu.AdminStudentScoreManager;
/**
 * <p>���ܣ�ѧ���ɼ���������Ƶ��ķ����������ɼ���ѯ��ɾ����<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AdminStudentScoreManagerImpl implements AdminStudentScoreManager{

	/**DAO�����*/
	private AdminStudentScoreDAO adminStudentScoreDAO;

	public AdminStudentScoreDAO getAdminStudentScoreDAO() {
		return adminStudentScoreDAO;
	}

	public void setAdminStudentScoreDAO(AdminStudentScoreDAO adminStudentScoreDAO) {
		this.adminStudentScoreDAO = adminStudentScoreDAO;
	}

	/**
	 * <p>���ܣ���ѯ��ѧ��ƽʱ�ɼ�<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualScore()
	 * @return list ����ѧ����ƽʱ��Ϣ�б�
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUsualscore> findUsualScore() {
		// TODO Auto-generated method stub
		return adminStudentScoreDAO.findUsualScore();
	}

	/**
	 * <p>���ܣ���ѯ��ĳѧ����صĳɼ���Ϣ<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualSelectInfoBy(java.lang.String)
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 * @param name ѧ������
	 * @return list ѧ����صĳɼ���Ϣ
	 */
	public List<JfptTabUsualscore> findUsualSelectInfoBy(String name) {
		// TODO Auto-generated method stub
		return adminStudentScoreDAO.findUsualSelectInfoBy(name);
	}

	/**
	 * <p>���ܣ�ɾ���ɼ�����<br>
	 * @param haha �ɼ���������ΪJfptTabUsualscore
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUsualScoreInfo(JfptTabUsualscore haha) {
		// TODO Auto-generated method stub
		adminStudentScoreDAO.deleteUsualScoreInfo(haha);
	}

	/**
	 * <p>���ܣ����ݳɼ�Id�Ų�ѯ���ɼ�����<br>
	 * @param i �ɼ�Id��
	 * @return ��ѯ���ĳɼ�����
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUsualscore findUsualScoreInfoByID(int i) {
		// TODO Auto-generated method stub
		return adminStudentScoreDAO.findUsualScoreInfoByID(i);
	}
}
