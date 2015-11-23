package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AssistTeachingManageDAO;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;

/**
 * <p>���ܣ���ѧ������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistTeachingManageDAOImpl extends HibernateDaoSupport implements AssistTeachingManageDAO{

	/**
	 * <p>���ܣ������Լ���Ų�����صİ�����Ϣ<br>
	 * @param number ���˱��
	 * @return list ������Ϣ
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabZiwoanpai j where j.mhqxTabUser.FUserNumber = '"+number+"'";
		List<JfptTabZiwoanpai> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ����ݰ���id�Ų�����صİ�����Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabZiwoanpai ���Ŷ�����Ϣ
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId) {
		// TODO Auto-generated method stub
		return (JfptTabZiwoanpai)this.getHibernateTemplate().get(JfptTabZiwoanpai.class, FId);
	}

	/**
	 * <p>���ܣ�ɾ�����Ŷ�����Ϣ<br>
	 * @param info ���Ŷ�����Ϣ
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub 
        this.getHibernateTemplate().delete(info);
	}

	/**
	 * <p>���ܣ���Ӱ�����Ϣ<br>
	 * @param info ������Ϣ����
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(info);
	}

	/**
	 * <p>���ܣ����ݸ���id�Ų���User������Ϣ<br>
	 * @param FUserNumber ����id��
	 * @return MhqxTabUser ����User������Ϣ
	 */
	public MhqxTabUser findUserByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber);
	}
}
