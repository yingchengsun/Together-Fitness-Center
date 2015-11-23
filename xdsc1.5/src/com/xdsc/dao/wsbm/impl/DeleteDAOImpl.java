package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.DeleteDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**ɾ����վ��Ϣ
 * @author ��С��
 * @version 1.2
 */
public class DeleteDAOImpl extends HibernateDaoSupport implements DeleteDAO{

	/**ɾ�������ʺ�
	 * @param mhqxTabUser ϵͳ�û�����
	 */
	public void deleteAcc(MhqxTabUser mhqxTabUser) {
		this.getHibernateTemplate().delete(mhqxTabUser);
	}

	/**����ϵͳ�û�
	 * @param FUserNumber ϵͳ�û�id
	 * @return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber) ϵͳ�û�����
	 */
	public MhqxTabUser findAccByNum(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber);
	}

	/**�������п���
	 * @return listRegapplicantinfo ���������б�
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant";
		List<WsbmTabRegapplicant> listRegapplicantinfo = this.getHibernateTemplate().find(sql);
		return listRegapplicantinfo;
	}
	
	/**ɾ��ϵͳ������Ϣ
	 * @param tabNotice ������Ϣ����
	 */
	public void deleteNotice(TabNotice tabNotice) {
		this.getHibernateTemplate().delete(tabNotice);
	}

	/**ɾ�������ʺ�
	 * @param wsbmTabRegapplicant ��������
	 */
	public void deleteAcc(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(wsbmTabRegapplicant);
	}

	public List<WsbmTabExamsubject> findSubject() {
		String sql = "from WsbmTabExamsubject";
		List<WsbmTabExamsubject> listWsbmTabExamsubject = this.getHibernateTemplate().find(sql);
		return listWsbmTabExamsubject;
	}

	public void deleteSubject(WsbmTabExamsubject wsbmTabExamsubject) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(wsbmTabExamsubject);
	}
}
