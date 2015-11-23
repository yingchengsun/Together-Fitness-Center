package com.xdsc.dao.jiaofu;

import java.util.List;

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
public interface TeacherCourseAssistantDAO {

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų鿴��ص�������Ϣ<br>
	 * @param FTeacherNumber ��ʦ���
	 * @return list ������ص�������Ϣ
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo(String FTeacherNumber);
	
	/**
	 * <p>���ܣ�������������id�Ų�����ص�����������Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabAssistantapply ���ز��ҵ��Ķ�����Ϣ
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId);
	
	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�����ؽ�ʦ��Ϣ<br>
	 * @param FAssistantId ��ʦ���
	 * @return TabTeachers ��ʦ������Ϣ
	 */
	public TabTeachers findAssistantTeacherInfoByID(String FAssistantId);
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param FAssistantId ѧ��ѧ��
	 * @return TabStudents ���ز��ҵ���ѧ����Ϣ
	 */
	public TabStudents findAssistantStudentInfoByID(String FAssistantId);
	
	/**
	 * <p>���ܣ�����Ժ�����̱�Ų�����ص�������Ϣ<br>
	 * @param FAssistantId Ժ����Ա���
	 * @return JfptTabOtherassist ���ز��ҵ�����Ϣ
	 */
	public JfptTabOtherassist findAssistantOtherInfoByID(String FAssistantId);
	
	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @param jfptTabAssistantapply �������������Ϣ
	 */
	public void addAssistantapply(JfptTabAssistantapply jfptTabAssistantapply);
	
	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�����ؽ�ʦ��Ϣ<br>
	 * @param FTeacherNumber ��ʦ���
	 * @return TabTeachers ��ʦ������Ϣ
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber);
	
	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ̶�����Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ؿγ̶�����Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber);
	
	public void updateInfo(JfptTabAssistantapply ha);
}
