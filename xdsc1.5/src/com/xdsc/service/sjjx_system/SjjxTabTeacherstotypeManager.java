package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabTeacherstotype;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabTeacherstotypeManager {
	
	/**ͨ����ʦ���Ͳ��ҵ���ʦ��¼�б�
	 * @param teacherName
	 * @return �����б�
	 */
	public abstract List<TabTeacherstotype> getTeacherByType();

}