package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.AdAllCheckDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;

/** ����Ա�ۺϲ鿴��վ��Ϣ
 * @author ��С��
 * @version 1.2
 */
public class AdAllCheckManagerImpl implements AdAllCheckManager{


	/**
	 * DAO���������
	 */
	private AdAllCheckDAO adAllCheckDAO;

	/**���ҿ���
	 * @param FAppRegNum ����id
	 * @��������
	 */
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum){
		return adAllCheckDAO.sepFindByNum(FAppRegNum);
	}
	/**�������п���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findRegapplicantInfo();
	}
	
	public AdAllCheckDAO getAdAllCheckDAO() {
		return adAllCheckDAO;
	}
	public void setAdAllCheckDAO(AdAllCheckDAO adAllCheckDAO) {
		this.adAllCheckDAO = adAllCheckDAO;
	}
	/**�鿴������վ��Ϣ
	 * @return ��վ��Ϣ�б�
	 */
	public List<TabNotice> findNotice() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findNotice();
	}
	/** ������Ϣ���������վ��Ϣ
	 * @param i ����id
	 * @return ��վ��Ϣ����
	 */
	public TabNotice sepFindByNoticeNum(int i) {
		// TODO Auto-generated method stub
		return adAllCheckDAO.sepFindByNoticeNum(i);
	}
	/**���¿�����Ϣ
	 * @param wsbmTabRegapplicant ��������
	 */
	public void updateApp(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		adAllCheckDAO.updateApp(wsbmTabRegapplicant);
	}
	/** ��������ͨ����Ϣ��֤�Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findAuthPassRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findAuthPassRegapplicantInfo();
	}
	/** ��������û��ͨ����Ϣ��֤�Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findAuthPassNotRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findAuthPassNotRegapplicantInfo();
	}
	/** ��������������Ϣ��֤�Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findAuthingRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findAuthingNotRegapplicantInfo();
	}
	/** ��������ͨ��Ԥ¼ȡ�Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findPrePassRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findPrePassRegapplicantInfo();
	}
	/** ��������δͨ��Ԥ¼ȡ�Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findPrePassNotRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findPrePassNotRegapplicantInfo();
	}
	/** ��������Ԥ¼ȡ���δ���Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findPreingRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findPreingRegapplicantInfo();
	}
	/** ��������¼ȡͨ���Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findFinPassRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findFinPassRegapplicantInfo();
	}
	/** �������в���¼ȡ�Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findFinPassNotRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findFinPassNotRegapplicantInfo();
	}
	/** ������������¼ȡ���δ���Ŀ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findFiningRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findFiningRegapplicantInfo();
	}
	/** ���������ѽ������ѵĿ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> findfeed() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findfeed();
	}
	/** ��������δ�������ѵĿ���
	 * @return ���������б�
	 */
	public List<WsbmTabRegapplicant> unfindfeed() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.unfindfeed();
	}
	public MhqxTabUser sepFindByNumInUser(String FAppRegNum) {
		return adAllCheckDAO.sepFindByNumInUser(FAppRegNum);
	}
}
