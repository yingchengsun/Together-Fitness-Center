package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
/**
 * <p>���ܣ�ѧ���γ̹�����صĲ����������γ���Ϣ��ѯ���γ�֪ͨ�Ĳ鿴���γ̴��ɵĲ��ҡ����ʺͻظ���<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface StudentCourseManageManager {

	/**
	 * <p>���ܣ�����ѧ��id�Ų�����֮��صĿγ���Ϣ<br>
	 * @param id ѧ��id��
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfoBySid(String id);
	
	/**
	 * <p>���ܣ�����ѧ��id�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ѧ��id��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoBySid(String id);
	
	/**
	 * <p>���ܣ�ͨ���γ̴���id�Ų�����֮ƥ��Ķ�����Ϣ<br>
	 * @param FQuestionId �γ̴���id��
	 * @return JfptTabCourseaskquestion ������صĿγ̴��ɶ�����Ϣ
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int FQuestionId);
	
	/**
	 * <p>���ܣ����ݿγ̴���id�Ų�����صĻظ���Ϣ<br>
	 * @param FQuestionId �γ̴��ɵ�id��
	 * @return list ��صĻظ���Ϣ
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int FQuestionId);
	
	/**
	 * <p>���ܣ���ӿγ̴��ɻظ�<br>
	 * @param jfptTabCoursereplyquestion �γ̴��ɻظ�������Ϣ
	 */
	public void addCoursereplyInfo(JfptTabCoursereplyquestion jfptTabCoursereplyquestion);
	
	/**
	 * <p>���ܣ�����ѧ��id�źͿγ̱�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ѧ��id��
	 * @param coursenumber �γ̱��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(String id, String coursenumber);
	
	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse �γ���Ϣ
	 */
	public TabCourse findCourseByID(String FCourseNumber);
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų������ѧ����Ϣ<br>
	 * @param StudentNumber ѧ��ѧ��
	 * @return TabStudents ���ز��ҵ�ѧ����Ϣ
	 */
	public TabStudents findStudentByID(String StudentNumber);
	
	/**
	 * <p>���ܣ����пγ�����<br>
	 * @param jfptTabCourseaskquestion �γ����ʶ���
	 */
	public void addCourseaskquestion(JfptTabCourseaskquestion jfptTabCourseaskquestion);
	
	/**
	 * <p>���ܣ�����id�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id ���˱��
	 * @return list �γ�֪ͨ������Ϣ
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id);
	
	/**
	 * <p>���ܣ����ݿγ�֪ͨid�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id �γ�֪ͨid��
	 * @return JfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id);
	
	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ӧ������Ϣ<br>
	 * @param FNoticeId �γ�֪ͨid��
	 * @param id ѧ��ѧ��
	 */
	public void deleteCourseNoticetotoInfo(int FNoticeId,String id);
}
