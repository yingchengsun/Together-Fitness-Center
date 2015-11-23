package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabEquipmentdetailDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmentdetail;

/**对设备调拨等详细信息进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabEquipmentdetailDAOImpl extends HibernateDaoSupport implements SjjxTabEquipmentdetailDAO{
	

	/**增添一条设备调拨记录到数据库中
	 * @param equipDetail
	 */
	public boolean saveEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		this.getHibernateTemplate().save(equipDetail);
		return true;
	}


	/**从数据库中删除一条设备调拨记录
	 * @param equipDetail
	 * @return
	 */
	public boolean deleteEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		this.getHibernateTemplate().delete(equipDetail);
		return true;
	}


	/**从数据库中读取所有的设备调拨记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailList() {
		String hql = "from SjjxTabEquipmentdetail";
		return this.getHibernateTemplate().find(hql);
	}
	

	/**通过设备编号查找到设备调拨记录
	 * @param equipId
	 * @return 返回查找到记录
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailByEquipId(Integer equipId) {
		String hql = "from SjjxTabEquipmentdetail e where e.sjjxTabEquipment.FEquId="+equipId;
		if (this.getHibernateTemplate().find(hql).isEmpty()){
			return null;
		}
		else{
			return this.getHibernateTemplate().find(hql);
			
		}
	}
	

	/**更新设备调拨记录
	 * @param equipDetail
	 */
	public void updateEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		this.getHibernateTemplate().update(equipDetail);
	}
	
	
}
