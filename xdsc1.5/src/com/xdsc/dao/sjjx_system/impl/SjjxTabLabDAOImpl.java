package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




import com.xdsc.dao.sjjx_system.SjjxTabLabDAO;
import com.xdsc.model.SjjxTabLab;

/**��ʵ������Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabLabDAOImpl extends HibernateDaoSupport implements SjjxTabLabDAO{

	

	/**����һ��ʵ���Ҽ�¼�����ݿ���
	 * @param lab
	 */
	public boolean saveLab(SjjxTabLab lab) {
		this.getHibernateTemplate().save(lab);
		return true;
	}
	

	/**�����ݿ���ɾ��һ��ʵ���Ҽ�¼
	 * @param lab
	 */
	public boolean deleteLab(SjjxTabLab lab) {
		this.getHibernateTemplate().delete(lab);
		return true;
	}
	

	/**�����ݿ��ж�ȡ���е�ʵ���Ҽ�¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabLab> getLabList() {
		String hql = "from SjjxTabLab";
		return this.getHibernateTemplate().find(hql);
	}
	

	/**ͨ��ʵ���ұ�Ų��ҵ�ʵ���Ҽ�¼
	 * @param labId
	 * @return ���ز��ҵ��ļ�¼
	 */
	public SjjxTabLab getLabByLabId(Integer labId) {
		String hql = "from SjjxTabLab l where l.FLabId='" + labId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (SjjxTabLab) this.getHibernateTemplate().find(hql).get(0);
	}
	
	/**ͨ��ʵ�������Ʋ��ҵ�ʵ���Ҽ�¼
	 * @param labName
	 * @return ���ز��ҵ���һ����¼
	 */
	public SjjxTabLab getLabByLabName1(String labName) {
		String hql = "from SjjxTabLab l where l.FLabName='" + labName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (SjjxTabLab) this.getHibernateTemplate().find(hql).get(0);
	}
	
    /**ͨ��ʵ�������Ʋ���ʵ���Ҽ�¼
	 * @param labName
	 * @return ���ز��ҵ��ļ�¼
	 */
    public List<SjjxTabLab> getLabByLabName(String labName){
    	String hql = null;
    	if(null==labName||"".equals(labName)){
    		hql="from SjjxTabLab";
    	}
    	else{
    	hql = "from SjjxTabLab l where l.FLabName='" + labName
    	        +"'";
    	}
			return this.getHibernateTemplate().find(hql);
    }
	
    
    /**ͨ��ʵ�������ڷ����Ų��ҵ�ʵ���Ҽ�¼
	 * @param roomNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
    public List<SjjxTabLab> getLabByRoomNumber(String roomNumber){
    	String hql = null;
    	if(null==roomNumber||"".equals(roomNumber)){
    		hql="from SjjxTabLab";
    	}
    	else{
    	hql = "from SjjxTabLab l where l.FRoomNumber='" + roomNumber
    	        +"'";
    	}
			return this.getHibernateTemplate().find(hql);
    }
    
	/**����ʵ������Ϣ
	 * @param lab
	 */
	public void updateLab(SjjxTabLab lab) {
		this.getHibernateTemplate().update(lab);
	}
	
	
	
}
