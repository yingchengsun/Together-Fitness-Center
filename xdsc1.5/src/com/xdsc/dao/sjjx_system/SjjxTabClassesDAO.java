package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabClasses;

/**���ڰ༶��Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public interface SjjxTabClassesDAO {


	/**���ݰ༶���Ʋ��ҵ���Ӧ�İ༶����
	 * @param className
	 * @return ���ز��ҵ��Ķ��� 
	 */
	public abstract TabClasses getClassesByClassName(String className);
	/**���ݰ༶��Ų��ҵ���Ӧ�İ༶����
	 *@return ���ز鵽�Ķ���
	 */
	public abstract TabClasses getClassesByClassNum(String classNum);

}