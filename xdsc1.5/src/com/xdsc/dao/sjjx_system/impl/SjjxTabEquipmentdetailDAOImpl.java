package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabEquipmentdetailDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmentdetail;

/**���豸��������ϸ��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabEquipmentdetailDAOImpl extends HibernateDaoSupport implements SjjxTabEquipmentdetailDAO{
	

	/**����һ���豸������¼�����ݿ���
	 * @param equipDetail
	 */
	public boolean saveEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		this.getHibernateTemplate().save(equipDetail);
		return true;
	}


	/**�����ݿ���ɾ��һ���豸������¼
	 * @param equipDetail
	 * @return
	 */
	public boolean deleteEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		this.getHibernateTemplate().delete(equipDetail);
		return true;
	}


	/**�����ݿ��ж�ȡ���е��豸������¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailList() {
		String hql = "from SjjxTabEquipmentdetail";
		return this.getHibernateTemplate().find(hql);
	}
	

	/**ͨ���豸��Ų��ҵ��豸������¼
	 * @param equipId
	 * @return ���ز��ҵ���¼
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
	

	/**�����豸������¼
	 * @param equipDetail
	 */
	public void updateEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		this.getHibernateTemplate().update(equipDetail);
	}
	
	
}
