package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
/**
 * <p>����Ȩ�޹������漰���Ĳ��������а���������̡�����Ȩ��������ɾ�������ҵȡ�<br>
 * @author qianxun
 * @version 1.1
 */
public interface AdminCourseAssistantManager {

	/**
	 * <p>���ܣ���ѯ���������¼��Ϣ<br>
	 * @return list ���������Ϣ��¼��
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo();
	/**
	 * <p>���ܣ����������¼����ID��Ϣ���Ҷ���<br>
	 * @param FId �����¼��Ϣ������
	 * @return JfptTabAssistantapply ���ز��ҵ��Ķ���
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId);
	/**
	 * <p>���ܣ�ɾ���������������Ϣ<br>
	 * @param jfptTabAssistantapply ���������¼��Ϣ����
	 */
	public void deleteAssistantapplyInfo(JfptTabAssistantapply jfptTabAssistantapply);
	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @param jfptTabAssistantapply1 ����������Ϣ����
	 */
	public void addAssistantInfo(JfptTabAssistantapply jfptTabAssistantapply1);
	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ̶�����Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ز��ҵ��Ŀγ̶���
	 */
	public TabCourse findTabCourseInfoByID(String FCourseNumber);
	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ����<br>
	 * @param FTeacherNumber ��ʦְ����
	 * @return ���ز��ҵ��Ľ�ʦ����
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber);
}
