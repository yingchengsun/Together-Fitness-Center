package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.xdsc.dao.sjjx_system.SjjxTabEquipmentDAO;
import com.xdsc.model.SjjxTabEquipment;

/**对设备基本信息记录进行操作
 * @author 陈雪
 * @version1.1
 */

public class SjjxTabEquipmentDAOImpl extends HibernateDaoSupport implements SjjxTabEquipmentDAO{
	

	/**增添一条设备基本信息到数据库中
	 * @param equip
	 */
	public boolean saveEquip(SjjxTabEquipment equip) {
		this.getHibernateTemplate().save(equip);
		return true;
	}

	/**从数据库中删除一条设备基本信息记录
	 * @param equip
	 */
	public boolean deleteEquip(SjjxTabEquipment equip) {
		this.getHibernateTemplate().delete(equip);
		return true;
	}


	/**从数据库中读取所有的设备基本信息记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipment> getEquipList() {
		String hql = "from SjjxTabEquipment order by FEquId";
		return this.getHibernateTemplate().find(hql);
	}
	


	/**通过设备编号查找到设备记录
	 * @param equipId
	 * @return 返回查找到记录
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
	

	/**通过设备类型名称查找该类型所有设备记录
	 * @param equipTypeName
	 * @return 返回所有查找到记录
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
	
	
	/**通过实验室名称找到该实验室所有设备记录
	 * @param labName
	 * @return 返回所有查找到记录
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


	/**更新一条设备记录
	 * @param equip
	 */
	public void updateEquip(SjjxTabEquipment equip) {
		this.getHibernateTemplate().update(equip);
	}
	
}
