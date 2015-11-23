package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabClassesDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.service.sjjx_system.SjjxTabClassesManager;

/**���ڰ༶��Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabClassesManagerImpl implements SjjxTabClassesManager {

	/**
	 * SjjxTabClassesDAOImpl �Ľӿ�
	 */
	private SjjxTabClassesDAO sjjxTabClassesDAO;	

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabClassesDAO getSjjxTabClassesDAO() {
		return sjjxTabClassesDAO;
	}

	public void setSjjxTabClassesDAO(SjjxTabClassesDAO sjjxTabClassesDAO) {
		this.sjjxTabClassesDAO = sjjxTabClassesDAO;
	}



	/**���ݰ༶���Ʋ��ҵ���Ӧ�İ༶��¼
	 * @param className
	 * @return ���ز��ҵ��ļ�¼
	 */
	public TabClasses getClassesByClassName(String className) {
		return sjjxTabClassesDAO.getClassesByClassName(className);
	}
	/**���ݰ༶��Ų��ҵ���Ӧ�İ༶��¼
	 *@return ���ز鵽�ļ�¼
	 */
	public TabClasses getClassesByClassNum(String classNum){
		return sjjxTabClassesDAO.getClassesByClassNum(classNum);
	}

	
}
