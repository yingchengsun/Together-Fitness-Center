package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabClasses;

/**���ڰ༶��Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public interface SjjxTabClassesManager {

	
	/**���ݰ༶���Ʋ��ҵ���Ӧ�İ༶��¼
	 * @param className
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract TabClasses getClassesByClassName(String className);

	/**���ݰ༶��Ų��ҵ���Ӧ�İ༶��¼
	 *@return ���ز鵽�ļ�¼
	 */
	public abstract TabClasses getClassesByClassNum(String classNum);

}