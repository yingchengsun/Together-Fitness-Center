package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.MsgCheckDAO;
import com.xdsc.model.TabNotice;

/**消息查看
 * @author 苟小龙
 * @version 1.2
 */
public class MsgCheckDAOImpl extends HibernateDaoSupport implements MsgCheckDAO{

	
	/**查看管理员消息
	 * @return list 消息列表 
	 */
	public List<TabNotice> findAdMsg(){
		String sql = "from TabNotice where (FInfoPath='admin' and FModuleId='4' and FInfoType='Message')or (FInfoType='Message' and FInfoFrom='admin' and FModuleId='4')";
		List<TabNotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**查找单个消息
	 * @param FInfoId 消息id
	 * @return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId) 消息对象 
	 */
	public TabNotice findMsgByNum(int FInfoId) {
		return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId);
	}
	/**查找考生消息
	 * @param FAppRegNum 考生id
	 * @return list 消息列表
	 */
	public List<TabNotice> findMsg(String FAppRegNum) {
		String sql = "from TabNotice c where c.FInfoPath='"+FAppRegNum+"' and c.FModuleId='4'";
		List<TabNotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

}
