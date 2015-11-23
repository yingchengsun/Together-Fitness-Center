package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabTeacherstotypeDAO;
import com.xdsc.model.TabTeacherstotype;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabTeacherstotypeDAOImpl extends HibernateDaoSupport implements SjjxTabTeacherstotypeDAO{

	
	/**ͨ����ʦ���Ͳ��ҵ���ʦ��¼�б�
	 * @param teacherName
	 * @return �����б�
	 */
	public List<TabTeacherstotype> getTeacherByType() {
		String hql = "from TabTeacherstotype";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return this.getHibernateTemplate().find(hql);
	}
}
