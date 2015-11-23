package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.MsgCheckDAO;
import com.xdsc.model.TabNotice;

/**��Ϣ�鿴
 * @author ��С��
 * @version 1.2
 */
public class MsgCheckDAOImpl extends HibernateDaoSupport implements MsgCheckDAO{

	
	/**�鿴����Ա��Ϣ
	 * @return list ��Ϣ�б� 
	 */
	public List<TabNotice> findAdMsg(){
		String sql = "from TabNotice where (FInfoPath='admin' and FModuleId='4' and FInfoType='Message')or (FInfoType='Message' and FInfoFrom='admin' and FModuleId='4')";
		List<TabNotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**���ҵ�����Ϣ
	 * @param FInfoId ��Ϣid
	 * @return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId) ��Ϣ���� 
	 */
	public TabNotice findMsgByNum(int FInfoId) {
		return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId);
	}
	/**���ҿ�����Ϣ
	 * @param FAppRegNum ����id
	 * @return list ��Ϣ�б�
	 */
	public List<TabNotice> findMsg(String FAppRegNum) {
		String sql = "from TabNotice c where c.FInfoPath='"+FAppRegNum+"' and c.FModuleId='4'";
		List<TabNotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

}
