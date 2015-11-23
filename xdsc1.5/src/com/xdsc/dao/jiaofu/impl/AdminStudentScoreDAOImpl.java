package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AdminStudentScoreDAO;
import com.xdsc.model.JfptTabUsualscore;

/**
 * <p>���ܣ�ѧ���ɼ���������Ƶ��ķ����������ɼ���ѯ��ɾ����<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AdminStudentScoreDAOImpl extends HibernateDaoSupport implements AdminStudentScoreDAO{


	/**
	 * <p>���ܣ���ѯ��ѧ��ƽʱ�ɼ�<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualScore()
	 * @return list ����ѧ����ƽʱ��Ϣ�б�
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUsualscore> findUsualScore() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabUsualscore";
		List<JfptTabUsualscore> list = this.getHibernateTemplate().find(sql);
		return list;
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
		String sql = "from JfptTabUsualscore j where j.tabCourse.FCourseName like '%"+name+"%'";
		List<JfptTabUsualscore> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�ɾ���ɼ�����<br>
	 * @param haha �ɼ���������ΪJfptTabUsualscore
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUsualScoreInfo(JfptTabUsualscore haha) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(haha);
	}

	/**
	 * <p>���ܣ����ݳɼ�Id�Ų�ѯ���ɼ�����<br>
	 * @param i �ɼ�Id��
	 * @return ��ѯ���ĳɼ�����
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUsualscore findUsualScoreInfoByID(int i) {
		// TODO Auto-generated method stub
		return (JfptTabUsualscore)this.getHibernateTemplate().get(JfptTabUsualscore.class, i);
	}

}
