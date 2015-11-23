package com.xdsc.service.sjjx_system;

import java.io.InputStream;

import java.util.List;

import com.xdsc.model.SjjxTabCourselab;

/**��ʵ�鰲�Ž�����ز���
 * @author ��ѩ
 * @version 1.1
 */
public interface SjjxTabCourselabManager {

	/**���һ��ʵ�鰲����Ϣ��¼�����ݿ���
	 * @param courseLab
	 */
	public abstract boolean saveCourseLab(SjjxTabCourselab courseLab);

	/**ɾ�����ݿ�һ��ʵ�鰲����Ϣ��¼
	 * @param courseLab
	 */
	public abstract boolean deleteCourseLab(SjjxTabCourselab courseLab);

	/**���ҵ����ݿ������е�ʵ�鰲�ż�¼
	 * @return ���ز鵽�ļ�¼
	 */
	public abstract List<SjjxTabCourselab> getCourseLabList();
	
	/**����������id������鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param id
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public abstract SjjxTabCourselab getCourseLabById(Integer id);

	/**����ʵ�������Ʋ鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param labName
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByLabName(String labName);

	
	/**���ݽ�ʦ�����鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByTeacherName(String teacherName);
	
	/**���ݽ�ʦ��¼ID�鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByTeacherNum(String teacherNum);
	
	/**����ʵ���ұ�Ų鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param labId
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByLabId(int labId);
	


	/**����һ��ʵ�鰲�ż�¼
	 * @param courseLab
	 */
	public abstract void updateCourseLab(SjjxTabCourselab courseLab);
	
	/**
	 * ����ʵ�鰲�ű�excel�ļ�
	 */
	public abstract InputStream getInputStream();

}