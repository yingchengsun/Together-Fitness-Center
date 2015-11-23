package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.AdAllCheckDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;
/**����Ա�鿴��վ��Ϣ
 * @author ��С��
 * @version 1.2
 */
public class AdAllCheckDAOImpl extends HibernateDaoSupport implements AdAllCheckDAO{
	/**�������п�����Ϣ
	 * @return list ������Ϣ�б�
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/**���ҵ�������
	 * @param FAppRegNum ����id
	 * @return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum) ��������
	 */
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum){
		return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum);
	}
	public MhqxTabUser sepFindByNumInUser(String FAppRegNum) {
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FAppRegNum);
	}
	/**����������վ������Ϣ
	 * @return list ��վ������Ϣ�б�
	 */
	public List<TabNotice> findNotice() {
		String sql = "from TabNotice where (FModuleId='4' and FInfoType='notice')";
		List<TabNotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/**���ҵ�����վ��Ϣ
	 * @param FInfoId ������Ϣid
	 * @return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId) ��վ֪ͨ��Ϣ����
	 */
	public TabNotice sepFindByNoticeNum(int FInfoId) {
		// TODO Auto-generated method stub
		return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId);
	}

	/**���¿�����Ϣ
	 * @param wsbmTabRegapplicant ��������
	 */
	public void updateApp(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(wsbmTabRegapplicant);
	}

	/** ��������ͨ����Ϣ��֤�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findAuthPassRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassAuth='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** �������в�ͨ����Ϣ��֤�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findAuthPassNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassAuth='F'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** ��������������Ϣ��֤�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findAuthingNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassAuth='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** ��������ͨ��Ԥ¼ȡ�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findPrePassRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassPreAd='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** �������в�ͨ��Ԥ¼ȡ�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findPrePassNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassPreAd='F'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** ������������Ԥ¼ȡ�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findPreingRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassPreAd='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** ��������ͨ������¼ȡ�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findFinPassRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassFinAd='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** �������в�ͨ������¼ȡ�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findFinPassNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassFinAd='F'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** ����������������¼ȡ�Ŀ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findFiningRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassFinAd='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** �������н��������ѵĿ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> findfeed() {
		String sql = "from WsbmTabRegapplicant where FAppRegBaoMingFei='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** ��������δ�������ѵĿ���
	 * @return list ���������б�
	 */
	public List<WsbmTabRegapplicant> unfindfeed() {
		String sql = "from WsbmTabRegapplicant where FAppRegBaoMingFei='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}



}
