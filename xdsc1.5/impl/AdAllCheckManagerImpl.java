package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.AdAllCheckDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;

/** 管理员综合查看网站信息
 * @author 苟小龙
 * @version 1.2
 */
public class AdAllCheckManagerImpl implements AdAllCheckManager{


	/**
	 * DAO层对象属性
	 */
	private AdAllCheckDAO adAllCheckDAO;

	/**查找考生
	 * @param FAppRegNum 考生id
	 * @考生对象
	 */
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum){
		return adAllCheckDAO.sepFindByNum(FAppRegNum);
	}
	/**查找所有考生
	 * @return 考生对象列表
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
	/**查看所有网站信息
	 * @return 网站信息列表
	 */
	public List<TabNotice> findNotice() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findNotice();
	}
	/** 根据消息号码查找网站信息
	 * @param i 公告id
	 * @return 网站信息对象
	 */
	public TabNotice sepFindByNoticeNum(int i) {
		// TODO Auto-generated method stub
		return adAllCheckDAO.sepFindByNoticeNum(i);
	}
	/**更新考生信息
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void updateApp(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		adAllCheckDAO.updateApp(wsbmTabRegapplicant);
	}
	/** 查找所有通过信息验证的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findAuthPassRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findAuthPassRegapplicantInfo();
	}
	/** 查找所有没有通过信息验证的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findAuthPassNotRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findAuthPassNotRegapplicantInfo();
	}
	/** 查找所有正在信息验证的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findAuthingRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findAuthingNotRegapplicantInfo();
	}
	/** 查找所有通过预录取的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findPrePassRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findPrePassRegapplicantInfo();
	}
	/** 查找所有未通过预录取的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findPrePassNotRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findPrePassNotRegapplicantInfo();
	}
	/** 查找所有预录取结果未定的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findPreingRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findPreingRegapplicantInfo();
	}
	/** 查找所有录取通过的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findFinPassRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findFinPassRegapplicantInfo();
	}
	/** 查找所有不被录取的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findFinPassNotRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findFinPassNotRegapplicantInfo();
	}
	/** 查找所有最终录取结果未定的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findFiningRegapplicantInfo() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findFiningRegapplicantInfo();
	}
	/** 查找所有已交报名费的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findfeed() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.findfeed();
	}
	/** 查找所有未交报名费的考生
	 * @return 考生对象列表
	 */
	public List<WsbmTabRegapplicant> unfindfeed() {
		// TODO Auto-generated method stub
		return adAllCheckDAO.unfindfeed();
	}
	public MhqxTabUser sepFindByNumInUser(String FAppRegNum) {
		return adAllCheckDAO.sepFindByNumInUser(FAppRegNum);
	}
}
