package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabGrade;

/**���꼶��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabGradeManager {

	

	/**�����꼶���Ʋ��ҵ���Ӧ�ļ�¼
	 * @param gradeName
	 * @return �����꼶��¼
	 */
	public abstract TabGrade getGradeByGradeName(String gradeName);
	
	/**�����꼶��Ų��ҵ���Ӧ�ļ�¼
	 * @param gradeId
	 * @return �����꼶��¼
	 */
	public abstract TabGrade getGradeByGradeId(Integer gradeId);

}