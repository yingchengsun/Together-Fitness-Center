package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AdminCourseAssistantDAO;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;

/**
 * <p>����Ȩ�޹������漰���Ĳ��������а���������̡�����Ȩ��������ɾ�������ҵȡ�<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminCourseAssistantDAOImpl extends HibernateDaoSupport implements AdminCourseAssistantDAO{

	/**
	 * <p>���ܣ���ѯ���������¼��Ϣ<br>
	 * @return list ���������Ϣ��¼��
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabAssistantapply where FShenQing <> 'N'";
		List<JfptTabAssistantapply> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ����������¼����ID��Ϣ���Ҷ���<br>
	 * @param FId �����¼��Ϣ������
	 * @return JfptTabAssistantapply ���ز��ҵ��Ķ���
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId) {
		// TODO Auto-generated method stub
		return (JfptTabAssistantapply)this.getHibernateTemplate().get(JfptTabAssistantapply.class, FId);
	}

	/**
	 * <p>���ܣ�ɾ���������������Ϣ<br>
	 * @param jfptTabAssistantapply ���������¼��Ϣ����
	 */
	public void deleteAssistantapplyInfo(JfptTabAssistantapply jfptTabAssistantapply) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabAssistantapply);
	}

	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @param jfptTabAssistantapply1 ����������Ϣ����
	 */
	public void addAssistantInfo(JfptTabAssistantapply jfptTabAssistantapply1) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabAssistantapply1);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ̶�����Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ز��ҵ��Ŀγ̶���
	 */
	public TabCourse findTabCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ����<br>
	 * @param FTeacherNumber ��ʦְ����
	 * @return ���ز��ҵ��Ľ�ʦ����
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return (TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, FTeacherNumber);
	}

}
