package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabEquipmenttypeDAO;
import com.xdsc.model.SjjxTabEquipmenttype;



/**���豸������Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabEquipmenttypeDAOImpl extends HibernateDaoSupport implements SjjxTabEquipmenttypeDAO{

	
	

	/**����һ���豸������Ϣ�����ݿ���
	 * @param equipType
	 */
	public boolean saveEquipType(SjjxTabEquipmenttype equipType) {
		this.getHibernateTemplate().save(equipType);
		return true;
	}


	/**�����ݿ���ɾ��һ���豸������Ϣ��¼
	 * @param equipType
	 */
	public boolean deleteEquiptype(SjjxTabEquipmenttype equipType) {
		this.getHibernateTemplate().delete(equipType);
		return true;
	}
	


	/**�����ݿ��ж�ȡ���е��豸���ͼ�¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipmenttype> getEquipTypeList() {
		String hql = "from SjjxTabEquipmenttype order by FEquTypeId";
		return this.getHibernateTemplate().find(hql);
	}
	


	/**ͨ���豸���ͱ�Ų��ҵ��豸���ͼ�¼
	 * @param equipTypeId
	 * @return ���ز��ҵ���¼
	 */
	public SjjxTabEquipmenttype getEquipTypeByEquipTypeId(Integer equipTypeId) {
		String hql = "from SjjxTabEquipmenttype et where et.FEquTypeId='" + equipTypeId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (SjjxTabEquipmenttype) this.getHibernateTemplate().find(hql).get(0);
	}
	

	/**ͨ���豸�������Ʋ��ҵ��豸���ͼ�¼
	 * @param equipTypeName
	 * @return ���ز��ҵ���¼
	 */
	public SjjxTabEquipmenttype getEquipTypeByEquipTypeName(String equipTypeName){
		String hql = "from SjjxTabEquipmenttype et where et.FEquTypeName='"+equipTypeName+"'";
	    if(this.getHibernateTemplate().find(hql).isEmpty())
	    	return null;
	    else 
	    	return (SjjxTabEquipmenttype) this.getHibernateTemplate().find(hql).get(0);
	
	}
	public List<SjjxTabEquipmenttype> getEquipTypeByEquipTypeName1(String equipTypeName){
		String hql = "from SjjxTabEquipmenttype et where et.FEquTypeName='"+equipTypeName+"'";
	    if(this.getHibernateTemplate().find(hql).isEmpty())
	    	return null;
	    else 
	    	return this.getHibernateTemplate().find(hql);
	
	}
	

	/**����һ���豸���ͼ�¼
	 * @param equipType
	 */
	public void updateEquipType(SjjxTabEquipmenttype equipType) {
		this.getHibernateTemplate().update(equipType);
	}
	
}
