package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabTeacherstotype;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabTeacherstotypeDAO {

	/**ͨ����ʦ���ͺŲ��ҵ���ʦ��¼�б�
	 * @param teacherNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract List<TabTeacherstotype> getTeacherByType();

}