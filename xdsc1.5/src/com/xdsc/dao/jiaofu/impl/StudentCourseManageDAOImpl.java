package com.xdsc.dao.jiaofu.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.StudentCourseManageDAO;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;

/**
 * <p>���ܣ�ѧ���γ̹�����صĲ����������γ���Ϣ��ѯ���γ�֪ͨ�Ĳ鿴���γ̴��ɵĲ��ҡ����ʺͻظ���<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class StudentCourseManageDAOImpl extends HibernateDaoSupport implements StudentCourseManageDAO{

	/**
	 * <p>���ܣ�����ѧ��id�Ų�����֮��صĿγ���Ϣ<br>
	 * @param id ѧ��id��
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfoBySid(String id) {
		// TODO Auto-generated method stub
		String sql1 = "from TabCourse t where t.FCourseNumber in (" +
				"select j.id.FCourseNumber from JfptTabStudentteacher j where" +
				" j.id.FStudentNumber='"+id+"')";
		String sql = "from TabCourse t where t.FCourseNumber in (" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c" +
				" where c.tabStudents.FStudentNumber='"+id+"')";
		List<TabCourse> list1 = this.getHibernateTemplate().find(sql1);
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		for(TabCourse i: list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>���ܣ�����ѧ��id�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ѧ��id��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoBySid(String id) {
		// TODO Auto-generated method stub
		List<JfptTabCourseaskquestion> list = new ArrayList<JfptTabCourseaskquestion>();
		TabStudents student = new TabStudents();
		student = (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
		if(student==null)
			return list;
		String classnumber = student.getTabClasses().getFClassNumber();
		if(classnumber==null)
			return list;
		String sql = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c where c.tabStudents.FStudentNumber='"+id+"')";
		list =  this.getHibernateTemplate().find(sql);
		
		String sql1 = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select s.id.FCourseNumber from JfptTabStudentteacher s where s.id.FStudentNumber='"+id+"')";
		List<JfptTabCourseaskquestion> list1 =  this.getHibernateTemplate().find(sql1);
		for(JfptTabCourseaskquestion i:list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>���ܣ����ݿγ̴���id�Ų�����صĻظ���Ϣ<br>
	 * @param FQuestionId �γ̴��ɵ�id��
	 * @return list ��صĻظ���Ϣ
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(
			int FQuestionId) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCoursereplyquestion r where r.jfptTabCourseaskquestion.FQuestionId="+FQuestionId;
		List<JfptTabCoursereplyquestion> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�ͨ���γ̴���id�Ų�����֮ƥ��Ķ�����Ϣ<br>
	 * @param FQuestionId �γ̴���id��
	 * @return JfptTabCourseaskquestion ������صĿγ̴��ɶ�����Ϣ
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(
			int FQuestionId) {
		// TODO Auto-generated method stub
		return (JfptTabCourseaskquestion)this.getHibernateTemplate().get(JfptTabCourseaskquestion.class, FQuestionId);
	}

	/**
	 * <p>���ܣ���ӿγ̴��ɻظ�<br>
	 * @param jfptTabCoursereplyquestion �γ̴��ɻظ�������Ϣ
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCoursereplyquestion);
	}

	/**
	 * <p>���ܣ�����ѧ��id�źͿγ̱�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ѧ��id��
	 * @param FCourseNumber �γ̱��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		TabStudents student = new TabStudents();
		student = (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
		String classnumber = student.getTabClasses().getFClassNumber();
		String sql = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c where c.tabStudents.FStudentNumber='"+id+"' and c.tabCourse.FCourseNumber='"+FCourseNumber+"')";
		List<JfptTabCourseaskquestion> list =  this.getHibernateTemplate().find(sql);
		
		String sql1 = "from JfptTabCourseaskquestion a where a.tabStudents.tabClasses.FClassNumber='"+classnumber+"' and a.tabCourse.FCourseNumber in(" +
				"select s.id.FCourseNumber from JfptTabStudentteacher s where s.id.FStudentNumber='"+id+"' and s.id.FCourseNumber='"+FCourseNumber+"')";
		List<JfptTabCourseaskquestion> list1 =  this.getHibernateTemplate().find(sql1);
		for(JfptTabCourseaskquestion i:list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse �γ���Ϣ
	 */
	public TabCourse findCourseByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų������ѧ����Ϣ<br>
	 * @param StudentNumber ѧ��ѧ��
	 * @return TabStudents ���ز��ҵ�ѧ����Ϣ
	 */
	public TabStudents findStudentByID(String StudentNumber) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, StudentNumber);
	}

	/**
	 * <p>���ܣ����пγ�����<br>
	 * @param jfptTabCourseaskquestion �γ����ʶ���
	 */
	public void addCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCourseaskquestion);
	}

	/**
	 * <p>���ܣ�����id�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id ���˱��
	 * @return list �γ�֪ͨ������Ϣ
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
//		String sql = "from JfptTabCoursenotice c where c.mhqxTabUser.FUserNumber="+id;
//		List<JfptTabCoursenotice> list = this.getHibernateTemplate().find(sql);
//		return list;
		
		String sql = "select n.jfptTabCoursenotice.FNoticeId from JfptTabNoticetoreceive n where n.mhqxTabUser.FUserNumber='"+id+"'";
		List<Integer> list = this.getHibernateTemplate().find(sql);
		List<JfptTabCoursenotice> listto= new ArrayList<JfptTabCoursenotice>();
		for(Integer i: list){
			listto.add((JfptTabCoursenotice)this.getHibernateTemplate().get(JfptTabCoursenotice.class, i));
		}
		return listto;
	}

	/**
	 * <p>���ܣ����ݿγ�֪ͨid�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id �γ�֪ͨid��
	 * @return JfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabCoursenotice)this.getHibernateTemplate().get(JfptTabCoursenotice.class, id);
	}

	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ӧ������Ϣ<br>
	 * @param FNoticeId �γ�֪ͨid��
	 * @param id ѧ��ѧ��
	 */
	public void deleteCourseNoticetotoInfo(int FNoticeId, String id) {
		// TODO Auto-generated method stub
		JfptTabNoticetoreceive toto = new JfptTabNoticetoreceive();
		String sql = "from JfptTabNoticetoreceive n where n.mhqxTabUser.FUserNumber='"+id+"' and n.jfptTabCoursenotice.FNoticeId="+FNoticeId;
		List<JfptTabNoticetoreceive> list = this.getHibernateTemplate().find(sql);
		this.getHibernateTemplate().delete(list.get(0));
	}
}
