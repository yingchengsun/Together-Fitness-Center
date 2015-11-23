package com.xdsc.dao.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabUsualscore;
/**
 * <p>���ܣ�ѧ���ɼ���������Ƶ��ķ����������ɼ���ѯ��ɾ����<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface AdminStudentScoreDAO {

	/**
	 * <p>���ܣ���ѯ��ѧ��ƽʱ�ɼ�<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualScore()
	 * @return list ����ѧ����ƽʱ��Ϣ�б�
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUsualscore> findUsualScore();
	/**
	 * <p>���ܣ���ѯ��ĳѧ����صĳɼ���Ϣ<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualSelectInfoBy(java.lang.String)
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 * @param name ѧ������
	 * @return list ѧ����صĳɼ���Ϣ
	 */
	public List<JfptTabUsualscore> findUsualSelectInfoBy(String name);
	/**
	 * <p>���ܣ����ݳɼ�Id�Ų�ѯ���ɼ�����<br>
	 * @param i �ɼ�Id��
	 * @return ��ѯ���ĳɼ�����
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUsualscore findUsualScoreInfoByID(int i);
	/**
	 * <p>���ܣ�ɾ���ɼ�����<br>
	 * @param haha �ɼ���������ΪJfptTabUsualscore
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUsualScoreInfo(JfptTabUsualscore haha);
}
