package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.StudentCourseManageDAO;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.StudentCourseManageManager;
/**
 * <p>���ܣ�ѧ���γ̹�����صĲ����������γ���Ϣ��ѯ���γ�֪ͨ�Ĳ鿴���γ̴��ɵĲ��ҡ����ʺͻظ���<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class StudentCourseManageManagerImpl implements StudentCourseManageManager{
	/**DAO�����*/
	private StudentCourseManageDAO studentCourseManageDAO;

	public StudentCourseManageDAO getStudentCourseManageDAO() {
		return studentCourseManageDAO;
	}

	public void setStudentCourseManageDAO(
			StudentCourseManageDAO studentCourseManageDAO) {
		this.studentCourseManageDAO = studentCourseManageDAO;
	}

	/**
	 * <p>���ܣ�����ѧ��id�Ų�����֮��صĿγ���Ϣ<br>
	 * @param id ѧ��id��
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfoBySid(String id) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findCourseInfoBySid(id);
	}
	
	/**
	 * <p>���ܣ�����ѧ��id�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ѧ��id��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoBySid(String id){
		return studentCourseManageDAO.findQuestionReplyInfoBySid(id);
	}

	/**
	 * <p>���ܣ����ݿγ̴���id�Ų�����صĻظ���Ϣ<br>
	 * @param FQuestionId �γ̴��ɵ�id��
	 * @return list ��صĻظ���Ϣ
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(
			int FQuestionId) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findCourseReplyInfoByID(FQuestionId);
	}

	/**
	 * <p>���ܣ�ͨ���γ̴���id�Ų�����֮ƥ��Ķ�����Ϣ<br>
	 * @param FQuestionId �γ̴���id��
	 * @return JfptTabCourseaskquestion ������صĿγ̴��ɶ�����Ϣ
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(
			int FQuestionId) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findCourseaskquestionInfoByID(FQuestionId);
	}

	/**
	 * <p>���ܣ���ӿγ̴��ɻظ�<br>
	 * @param jfptTabCoursereplyquestion �γ̴��ɻظ�������Ϣ
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		// TODO Auto-generated method stub
		studentCourseManageDAO.addCoursereplyInfo(jfptTabCoursereplyquestion);
	}

	/**
	 * <p>���ܣ�����ѧ��id�źͿγ̱�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ѧ��id��
	 * @param coursenumber �γ̱��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String coursenumber) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findQuestionReplayInfoByTwo(id, coursenumber);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse �γ���Ϣ
	 */
	public TabCourse findCourseByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findCourseByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų������ѧ����Ϣ<br>
	 * @param StudentNumber ѧ��ѧ��
	 * @return TabStudents ���ز��ҵ�ѧ����Ϣ
	 */
	public TabStudents findStudentByID(String StudentNumber) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findStudentByID(StudentNumber);
	}

	/**
	 * <p>���ܣ����пγ�����<br>
	 * @param jfptTabCourseaskquestion �γ����ʶ���
	 */
	public void addCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		// TODO Auto-generated method stub
		studentCourseManageDAO.addCourseaskquestion(jfptTabCourseaskquestion);
	}

	/**
	 * <p>���ܣ�����id�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id ���˱��
	 * @return list �γ�֪ͨ������Ϣ
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findCourseNoticeInfo(id);
	}

	/**
	 * <p>���ܣ����ݿγ�֪ͨid�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id �γ�֪ͨid��
	 * @return JfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id) {
		// TODO Auto-generated method stub
		return studentCourseManageDAO.findCourseNoticeInfoByID(id);
	}

	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ӧ������Ϣ<br>
	 * @param FNoticeId �γ�֪ͨid��
	 * @param id ѧ��ѧ��
	 */
	public void deleteCourseNoticetotoInfo(int FNoticeId, String id) {
		// TODO Auto-generated method stub
		studentCourseManageDAO.deleteCourseNoticetotoInfo(FNoticeId, id);
	}
}
