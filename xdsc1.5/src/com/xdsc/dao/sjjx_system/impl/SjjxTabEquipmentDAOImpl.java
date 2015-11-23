package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.xdsc.dao.sjjx_system.SjjxTabEquipmentDAO;
import com.xdsc.model.SjjxTabEquipment;

/**���豸������Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */

public class SjjxTabEquipmentDAOImpl extends HibernateDaoSupport implements SjjxTabEquipmentDAO{
	

	/**����һ���豸������Ϣ�����ݿ���
	 * @param equip
	 */
	public boolean saveEquip(SjjxTabEquipment equip) {
		this.getHibernateTemplate().save(equip);
		return true;
	}

	/**�����ݿ���ɾ��һ���豸������Ϣ��¼
	 * @param equip
	 */
	public boolean deleteEquip(SjjxTabEquipment equip) {
		this.getHibernateTemplate().delete(equip);
		return true;
	}


	/**�����ݿ��ж�ȡ���е��豸������Ϣ��¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipment> getEquipList() {
		String hql = "from SjjxTabEquipment order by FEquId";
		return this.getHibernateTemplate().find(hql);
	}
	


	/**ͨ���豸��Ų��ҵ��豸��¼
	 * @param equipId
	 * @return ���ز��ҵ���¼
	 */
	public SjjxTabEquipment getEquipByEquipId(Integer equipId) {
		String hql = "from SjjxTabEquipment e where e.FEquId="+equipId;
		if (this.getHibernateTemplate().find(hql).isEmpty()){	
			return null;
		}
		else{
			
			return (SjjxTabEquipment) this.getHibernateTemplate().find(hql).get(0);
			
		}
	}
	

	/**ͨ���豸�������Ʋ��Ҹ����������豸��¼
	 * @param equipTypeName
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipment> getEquipByEquipTypeName(String equipTypeName){
		String hql = null;
		if(null==equipTypeName||"".equals(equipTypeName)){
			hql = "from SjjxTabEquipment";
		}
		else{
			hql = "from SjjxTabEquipment e where e. sjjxTabEquipmenttype.FEquTypeName='" + equipTypeName
		             +"'";
		}
		
	    	return  this.getHibernateTemplate().find(hql);
	}
	
	
	/**ͨ��ʵ���������ҵ���ʵ���������豸��¼
	 * @param labName
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipment> getEquipByLabName(String labName){
		String hql = null;
		if(null==labName||"".equals(labName)){
			hql = "from SjjxTabEquipment";
		}
		else{
			hql = "from SjjxTabEquipment e where e. sjjxTabLab.FLabName='" + labName
		             +"'";
		}
		
	    	return  this.getHibernateTemplate().find(hql);
	}


	/**����һ���豸��¼
	 * @param equip
	 */
	public void updateEquip(SjjxTabEquipment equip) {
		this.getHibernateTemplate().update(equip);
	}
	
}
