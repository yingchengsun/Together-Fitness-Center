package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabInformationDAO;
import com.xdsc.model.SjjxTabCourselab;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.TabInformation;



/**��֪ͨ������Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabInformationDAOImpl extends HibernateDaoSupport implements SjjxTabInformationDAO  {



	/**���һ����Ϣ��¼�����ݿ���
	 * @param info
	 */
	public boolean saveSjjxTabInformation(TabInformation info) {
		this.getHibernateTemplate().save(info);
		return true;
	}



	/**�����ݿ���ɾ��һ����Ϣ��¼
	 * @param info
	 */
	public boolean deleteSjjxTabInformation(TabInformation info) {
		this.getHibernateTemplate().delete(info);
		return true;
	}


	
	/**����һ����Ϣ��¼
	 * @param info
	 */
	public void updateSjjxTabInformation(TabInformation info) {
		this.getHibernateTemplate().update(info);
	}



	/**�����ݿ��ж�ȡ������ʵ����ѧϵͳ������֪ͨ������Ϣ
	 * @return ����������Ϣ��¼
	 */
	public List<TabInformation> getSjjxTZGGTabInformations() {
		String hql = "from TabInformation info  where info.FInfoType='֪ͨ����' and info.FModuleId='5'";		
		return this.getHibernateTemplate().find(hql);
	}

	


	/**ͨ����Ϣ��Ų��ҵ���Ӧ��Ϣ��¼
	 * @param id
	 * @return ������Ӧ��Ϣ��¼
	 */
	public TabInformation getSjjxTabInformationByInfoId(int id) {
		String hql = "from TabInformation info where info.FInfoId='"+id+"'";
		if (this.getHibernateTemplate().find(hql).isEmpty()){
			return null;
		}
		else{

			return (TabInformation) this.getHibernateTemplate().find(hql).get(0);
		}
	}

	
}
