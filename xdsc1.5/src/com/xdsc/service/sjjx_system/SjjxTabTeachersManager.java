package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabTeachers;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabTeachersManager {



	/**�����ݿ��в��ҵ����еĽ�ʦ��¼
	 * @return ���ҵ������м�¼
	 */
	public abstract List<TabTeachers> getTeacherList();

	/**ͨ����ʦѧ���Ų��ҵ���Ӧ�Ľ�ʦ��¼
	 * @param teacherNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract TabTeachers getTeacherByTeacherNumber(String teacherNumber);

	/**ͨ����ʦ�������ҵ���Ӧ�Ľ�ʦ��¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract TabTeachers getTeacherByTeacherName(String teacherName);



}