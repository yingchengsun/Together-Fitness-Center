package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabInformationDAO;
import com.xdsc.model.SjjxTabCourselab;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.TabInformation;



/**对通知公告信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabInformationDAOImpl extends HibernateDaoSupport implements SjjxTabInformationDAO  {



	/**添加一条信息记录到数据库中
	 * @param info
	 */
	public boolean saveSjjxTabInformation(TabInformation info) {
		this.getHibernateTemplate().save(info);
		return true;
	}



	/**从数据库中删除一条信息记录
	 * @param info
	 */
	public boolean deleteSjjxTabInformation(TabInformation info) {
		this.getHibernateTemplate().delete(info);
		return true;
	}


	
	/**更新一条信息记录
	 * @param info
	 */
	public void updateSjjxTabInformation(TabInformation info) {
		this.getHibernateTemplate().update(info);
	}



	/**从数据库中读取到所有实践教学系统发出的通知公告信息
	 * @return 返回所有信息记录
	 */
	public List<TabInformation> getSjjxTZGGTabInformations() {
		String hql = "from TabInformation info  where info.FInfoType='通知公告' and info.FModuleId='5'";		
		return this.getHibernateTemplate().find(hql);
	}

	


	/**通过信息编号查找到相应信息记录
	 * @param id
	 * @return 返回相应信息记录
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
