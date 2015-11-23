package com.xdsc.dao.wzmh_system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xdsc.dao.wzmh_system.TabInformationDAO;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;

/**
 * ���ż�֪ͨ����������ݿ��������
 * @author ���� �·�
 *
 */
public class TabInformationDAOImpl implements TabInformationDAO {

	private HibernateTemplate hibernateTemplate;

	/**
	 * �洢һ������
	 */
	public void save(TabInformation info) {
		if(info==null)
			return ;
		hibernateTemplate.save(info);

	}


	/**
	 * �洢��������ص�ͼƬ
	 */
	public void saveTabInformationimage(TabInformationimage infoimage) {
		if(infoimage==null)
			return;
		this.getHibernateTemplate().save(infoimage);

	}

	/** 
	 * ɾ��һ������
	 */
	public void delete(TabInformation info) {
		if(info==null)
			return;
		hibernateTemplate.delete(info);

	}

	/** 
	 * ɾ����Ϣ���ͼƬ
	 */
	public void deleteInformationImage(TabInformationimage infoimage) {
		if(infoimage==null)
			return;
		hibernateTemplate.delete(infoimage);
	}

	/** 
	 * ����һ������
	 */
	public void update(TabInformation info) {
		if(info==null)
			return;
		hibernateTemplate.saveOrUpdate(info);

	}

	/** 
	 * ������������
	 * @return list
	 */
	public List<TabInformation> findAllTabInformations() {
		String hql = "from TabInformation info order by info.FInfoId desc";
		List<TabInformation> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/** 
	 * ����ѧԺ������Ŀ��Ϣ
	 * @return xyxwList
	 */
	public List<TabInformation> findXYXWTabInformations() {
		/**��ȡ�ö���־  ʵ���ö�*/
		List<TabInformation> xyxwList = new ArrayList<TabInformation>();
		String hql0 = "from TabInformation info  where info.FInfoType='ѧԺ����' and info.FModuleId='1' and FInfoZhiDing='Y' order by info.FInfoId desc";
		if(getHibernateTemplate().find(hql0).size()>0)
			xyxwList.add((TabInformation)getHibernateTemplate().find(hql0).get(0));
		
		String hql = "from TabInformation info  where info.FInfoType='ѧԺ����' and info.FModuleId='1' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp=getHibernateTemplate().find(hql);
		for(TabInformation l:temp)
		{
			xyxwList.add(l);
		}
		
		
		
		
		
		String hql3 = "from TabInformation info  where info.FInfoType='���Ź���' and info.FModuleId='7'  order by info.FInfoId desc";
		List<TabInformation> temp3=getHibernateTemplate().find(hql3);
		for(TabInformation l:temp3)
		{
			xyxwList.add(l);
		}
		return xyxwList;
	}

	/** 
	 * ����������ʿ��Ŀ��Ϣ
	 * @return zxnsList
	 */
	public List<TabInformation> findZXNSTabInformations() {
		
		/**��ȡ�ö���־  ʵ���ö�*/
		List<TabInformation> zxnsList = new ArrayList<TabInformation>();
		String hql0 = "from TabInformation info  where info.FInfoType='������ʿ' and info.FModuleId='1' and FInfoZhiDing='Y' order by info.FInfoId desc";
		if(getHibernateTemplate().find(hql0).size()>0)
			zxnsList.add((TabInformation)getHibernateTemplate().find(hql0).get(0));
		
		String hql = "from TabInformation info  where info.FInfoType='������ʿ' and info.FModuleId='1' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp=getHibernateTemplate().find(hql);
		for(TabInformation l:temp)
		{
			zxnsList.add(l);
		}
		
		return zxnsList;
	}

	/** 
	 * ����������ҵ��Ŀ��Ϣ
	 * @return zsjyList
	 */
	public List<TabInformation> findZSJYTabInformations() {
		
		/**��ȡ�ö���־  ʵ���ö�*/
		List<TabInformation> zsjyList = new ArrayList<TabInformation>();
		String hql0 = "from TabInformation info  where info.FInfoType='ѧ����ҵ' and info.FModuleId='1' and FInfoZhiDing='Y' order by info.FInfoId desc";
		if(getHibernateTemplate().find(hql0).size()>0)
			zsjyList.add((TabInformation)getHibernateTemplate().find(hql0).get(0));
		
		String hql = "from TabInformation info  where info.FInfoType='ѧ����ҵ' and info.FModuleId='1' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp=getHibernateTemplate().find(hql);
		for(TabInformation l:temp)
		{
			zsjyList.add(l);
		}
		
		return zsjyList;
	}

	/** 
	 * ���Һ���������Ŀ��Ϣ
	 * @return hzjlList
	 */
	public List<TabInformation> findHZJLTabInformations() {
		/**��ȡ�ö���־  ʵ���ö�*/
		List<TabInformation> hzjlList = new ArrayList<TabInformation>();
		String hql0 = "from TabInformation info  where info.FInfoType='��������' and info.FModuleId='1' and FInfoZhiDing='Y' order by info.FInfoId desc";
		if(getHibernateTemplate().find(hql0).size()>0)
			hzjlList.add((TabInformation)getHibernateTemplate().find(hql0).get(0));
		
		String hql = "from TabInformation info  where info.FInfoType='��������' and info.FModuleId='1' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp=getHibernateTemplate().find(hql);
		for(TabInformation l:temp)
		{
			hzjlList.add(l);
		}
		
		return hzjlList;
	}

	/** 
	 * ����֪ͨ������Ŀ��Ϣ
	 * @return tzggList
	 */
	public List<TabInformation> findTZGGTabInformations() {
		
		
		/**��ȡ�ö���־  ʵ���ö�*/
		List<TabInformation> tzggList = new ArrayList<TabInformation>();
		String hql0 = "from TabInformation info  where info.FInfoType='֪ͨ����' and info.FModuleId='1' and FInfoZhiDing='Y' order by info.FInfoId desc";
		List<TabInformation> temp0=getHibernateTemplate().find(hql0);
		for(TabInformation l:temp0)
		{
			tzggList.add(l);
		}
		
		
		
		String hql1 = "from TabInformation info  where info.FInfoType='֪ͨ����' and info.FModuleId='5' and FBiaoZhi='����' and FInfoZhiDing='Y' order by info.FInfoId desc";
		List<TabInformation> temp1=getHibernateTemplate().find(hql1);
		for(TabInformation l:temp1)
		{
			tzggList.add(l);
		}
		
		
		
		String hql2 = "from TabInformation info  where info.FInfoType='֪ͨ����' and info.FModuleId='1' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp2=getHibernateTemplate().find(hql2);
		for(TabInformation l:temp2)
		{
			tzggList.add(l);
		}
	
		String hql3 = "from TabInformation info  where info.FInfoType='֪ͨ����' and info.FModuleId='5' and FBiaoZhi='����' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp3=getHibernateTemplate().find(hql3);
		for(TabInformation l:temp3)
		{
			tzggList.add(l);
		}
		
		
		String hql5 = "from TabInformation info  where info.FInfoType='��ҳ֪ͨ' and info.FModuleId='7'  order by info.FInfoId desc";
		List<TabInformation> temp5=getHibernateTemplate().find(hql5);
		for(TabInformation l:temp5)
		{
			tzggList.add(l);
		}
		
		
		return tzggList;
	}

	/** 
	 *  ����ͼƬ������Ŀ��Ϣ
	 * @return tpxwList
	 */
	public List<TabInformation> findTPXWTabInformations() {

		/**��ȡ�ö���־  ʵ���ö�*/
		List<TabInformation> tpxwList = new ArrayList<TabInformation>();
		String hql0 = "from TabInformation info  where info.FInfoType='ͼƬ����' and info.FModuleId='1' and FInfoZhiDing='Y' order by info.FInfoId desc";
		if(getHibernateTemplate().find(hql0).size()>0)
			tpxwList.add((TabInformation)getHibernateTemplate().find(hql0).get(0));
		
		String hql = "from TabInformation info  where info.FInfoType='ͼƬ����' and info.FModuleId='1' and FInfoZhiDing!='Y' order by info.FInfoId desc";
		List<TabInformation> temp=getHibernateTemplate().find(hql);
		for(TabInformation l:temp)
		{
			tpxwList.add(l);
		}
		return tpxwList;

	}

	/** 
	 * ����ID������Ϣ
	 * @return list.iterator().next()
	 */
	public TabInformation findTabInformationById(int id) {
		String hql = "from TabInformation info where info.FInfoId=?";
		List<TabInformation> list = this.getHibernateTemplate().find(hql, id);
		if (list.isEmpty())
			return null;
		else
			return list.iterator().next();
	}

	/** 
	 * �������һ����Ϣ
	 * @return infos.iterator().next()
	 */
	public TabInformation findLastTabInformation() {
		String hql = "from TabInformation info where info.FModuleId='1' order by info.FInfoId desc";
		List<TabInformation> infos = this.getHibernateTemplate().find(hql);
		if (infos.isEmpty())
			return null;
		else
			return infos.iterator().next();
	}

	/** 
	 * ������Ϣ�������ͼƬ
	 * @return list
	 */
	public List<TabInformationimage> findImageByInformationId(int id) {
		String hql = "from TabInformationimage infoImage where infoImage.tabInformation.FInfoId=? ";
		List<TabInformationimage> list = this.getHibernateTemplate().find(hql,
				id);
		return list;
	}

	/** 
	 * �������Ͳ�����Ϣ
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByType(String FMenuName) {
		String hql = "from TabInformation info where info.FInfoType=? and info.FModuleId='1' order by info.FInfoId desc";
		
		System.out.println(FMenuName);
		getHibernateTemplate().find(hql,FMenuName);
		List<TabInformation> list = this.getHibernateTemplate().find(hql,FMenuName);
		return list;
	}

	/** 
	 * ���ݱ������֪ͨ������Ϣ
	 * @return list
	 */
	public List<TabInformation> findTZGGTabInformationsByTitle(String FInfoTitle){
		String str1="%"+FInfoTitle+"%";
		String hql = "from TabInformation info where info.FInfoTitle like '"+str1+"' and info.FModuleId='1' order by info.FInfoId desc";
		List<TabInformation> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	/** 
	 * ���ݱ����������
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByTitle(String FInfoTitle){
		String str1="%"+FInfoTitle+"%";
		String hql = "from TabInformation info where info.FInfoTitle like '"+str1+"' and info.FModuleId='1' and info.FInfoType!='֪ͨ����' order by info.FInfoId desc";
		List<TabInformation> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
	/** 
	 * �߼���������
	 * @param FInfoTitle
	 * @param FInfoContet
	 * @param FInfoStartTime
	 * @param FModuleId
	 * @param FInfoType
	 * @param FInfoZhiDing
	 * @return list
	 */
	public List<TabInformation> NewsAdvanceSearch(String FInfoTitle,String FInfoContet,Date FInfoStartTime,
												String FModuleId,String FInfoType, String FInfoZhiDing){
		
		String str1="%"+FInfoTitle+"%";
		String str2="%"+FInfoContet+"%";
		//String str3="%"+FInfoStartTime+"%"; "and info.FInfoStartTime like '"+str3+"' " + 
		String str4="%"+FModuleId+"%";
		String str5="%"+FInfoType+"%";
		String str6="%"+FInfoZhiDing+"%";
		
		String hql="from TabInformation info where info.FInfoTitle like '"+str1+"' " + "and info.FInfoContet like '"+str2+"' " + 
		"and info.FModuleId like '"+str4+"' " + "and info.FInfoType like '"+str5+"' " +
		"and info.FInfoZhiDing like '"+str6+"' order by info.FInfoId desc";
		
		List<TabInformation> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
