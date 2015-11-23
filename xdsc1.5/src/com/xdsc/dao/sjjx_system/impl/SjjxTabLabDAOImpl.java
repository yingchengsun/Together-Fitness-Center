package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




import com.xdsc.dao.sjjx_system.SjjxTabLabDAO;
import com.xdsc.model.SjjxTabLab;

/**对实验室信息进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabLabDAOImpl extends HibernateDaoSupport implements SjjxTabLabDAO{

	

	/**增添一条实验室记录到数据库中
	 * @param lab
	 */
	public boolean saveLab(SjjxTabLab lab) {
		this.getHibernateTemplate().save(lab);
		return true;
	}
	

	/**从数据库中删除一条实验室记录
	 * @param lab
	 */
	public boolean deleteLab(SjjxTabLab lab) {
		this.getHibernateTemplate().delete(lab);
		return true;
	}
	

	/**从数据库中读取所有的实验室记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabLab> getLabList() {
		String hql = "from SjjxTabLab";
		return this.getHibernateTemplate().find(hql);
	}
	

	/**通过实验室编号查找到实验室记录
	 * @param labId
	 * @return 返回查找到的记录
	 */
	public SjjxTabLab getLabByLabId(Integer labId) {
		String hql = "from SjjxTabLab l where l.FLabId='" + labId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (SjjxTabLab) this.getHibernateTemplate().find(hql).get(0);
	}
	
	/**通过实验室名称查找到实验室记录
	 * @param labName
	 * @return 返回查找到的一条记录
	 */
	public SjjxTabLab getLabByLabName1(String labName) {
		String hql = "from SjjxTabLab l where l.FLabName='" + labName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (SjjxTabLab) this.getHibernateTemplate().find(hql).get(0);
	}
	
    /**通过实验室名称查找实验室记录
	 * @param labName
	 * @return 返回查找到的记录
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
	
    
    /**通过实验室所在房间编号查找到实验室记录
	 * @param roomNumber
	 * @return 返回查找到的记录
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
    
	/**更新实验室信息
	 * @param lab
	 */
	public void updateLab(SjjxTabLab lab) {
		this.getHibernateTemplate().update(lab);
	}
	
	
	
}
