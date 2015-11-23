package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabEquipmenttypeDAO;
import com.xdsc.model.SjjxTabEquipmenttype;



/**对设备类型信息记录进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabEquipmenttypeDAOImpl extends HibernateDaoSupport implements SjjxTabEquipmenttypeDAO{

	
	

	/**增添一条设备类型信息到数据库中
	 * @param equipType
	 */
	public boolean saveEquipType(SjjxTabEquipmenttype equipType) {
		this.getHibernateTemplate().save(equipType);
		return true;
	}


	/**从数据库中删除一条设备类型信息记录
	 * @param equipType
	 */
	public boolean deleteEquiptype(SjjxTabEquipmenttype equipType) {
		this.getHibernateTemplate().delete(equipType);
		return true;
	}
	


	/**从数据库中读取所有的设备类型记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipmenttype> getEquipTypeList() {
		String hql = "from SjjxTabEquipmenttype order by FEquTypeId";
		return this.getHibernateTemplate().find(hql);
	}
	


	/**通过设备类型编号查找到设备类型记录
	 * @param equipTypeId
	 * @return 返回查找到记录
	 */
	public SjjxTabEquipmenttype getEquipTypeByEquipTypeId(Integer equipTypeId) {
		String hql = "from SjjxTabEquipmenttype et where et.FEquTypeId='" + equipTypeId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (SjjxTabEquipmenttype) this.getHibernateTemplate().find(hql).get(0);
	}
	

	/**通过设备类型名称查找到设备类型记录
	 * @param equipTypeName
	 * @return 返回查找到记录
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
	

	/**更新一条设备类型记录
	 * @param equipType
	 */
	public void updateEquipType(SjjxTabEquipmenttype equipType) {
		this.getHibernateTemplate().update(equipType);
	}
	
}
