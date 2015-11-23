package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.TeacherCourseAssistantDAO;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;

/**
 * <p>���ܣ���ʦ�������̣��������̵����롢���ҡ�ɾ����<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseAssistantDAOImpl extends HibernateDaoSupport implements TeacherCourseAssistantDAO{

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų鿴��ص�������Ϣ<br>
	 * @param FTeacherNumber ��ʦ���
	 * @return list ������ص�������Ϣ
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo(String FTeacherNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabAssistantapply where tabTeachers.FTeacherNumber='"+FTeacherNumber+"'";
		List<JfptTabAssistantapply> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�������������id�Ų�����ص�����������Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabAssistantapply ���ز��ҵ��Ķ�����Ϣ
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId) {
		// TODO Auto-generated method stub
		return (JfptTabAssistantapply)this.getHibernateTemplate().get(JfptTabAssistantapply.class, FId);
	}

	/**
	 * <p>���ܣ�����Ժ�����̱�Ų�����ص�������Ϣ<br>
	 * @param FAssistantId Ժ����Ա���
	 * @return JfptTabOtherassist ���ز��ҵ�����Ϣ
	 */
	public JfptTabOtherassist findAssistantOtherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return (JfptTabOtherassist)this.getHibernateTemplate().get(JfptTabOtherassist.class, FAssistantId);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param FAssistantId ѧ��ѧ��
	 * @return TabStudents ���ز��ҵ���ѧ����Ϣ
	 */
	public TabStudents findAssistantStudentInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, FAssistantId);
	}

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�����ؽ�ʦ��Ϣ<br>
	 * @param FAssistantId ��ʦ���
	 * @return TabTeachers ��ʦ������Ϣ
	 */
	public TabTeachers findAssistantTeacherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return (TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, FAssistantId);
	}

	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @param jfptTabAssistantapply �������������Ϣ
	 */
	public void addAssistantapply(JfptTabAssistantapply jfptTabAssistantapply) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabAssistantapply);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ̶�����Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ؿγ̶�����Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�����ؽ�ʦ��Ϣ<br>
	 * @param FTeacherNumber ��ʦ���
	 * @return TabTeachers ��ʦ������Ϣ
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return (TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, FTeacherNumber);
	}

	public void updateInfo(JfptTabAssistantapply ha) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(ha);
	}
}
