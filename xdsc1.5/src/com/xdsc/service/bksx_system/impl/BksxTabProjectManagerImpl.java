package com.xdsc.service.bksx_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabProjectDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.service.bksx_system.BksxTabProjectManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对项目相关的操作
 */
public class BksxTabProjectManagerImpl implements BksxTabProjectManager {
	BksxTabProjectDAO bksxTabProjectDAO;

	public BksxTabProjectDAO getBksxTabProjectDAO() {
		return bksxTabProjectDAO;
	}

	public void setBksxTabProjectDAO(BksxTabProjectDAO bksxTabProjectDAO) {
		this.bksxTabProjectDAO = bksxTabProjectDAO;
	}

	/**
	 * 根据项目ID得到一个BksxTabProject对象
	 * 
	 * @param proId
	 *            项目ID
	 * @return BksxTabProject
	 */
	public BksxTabProject getProjectById(int proId) {
		return bksxTabProjectDAO.getProjectById(proId);
	}

	/**
	 * 保存一个BksxTabProject对象
	 * 
	 * @param project
	 *            项目对象
	 * @return boolean
	 */
	public boolean saveProject(BksxTabProject project) {
		return bksxTabProjectDAO.saveProject(project);
	}

	/**
	 * 更新一个BksxTabProject对象
	 * 
	 * @param bksxTabProject
	 *            项目对象
	 * @return
	 */
	public void updateProject(BksxTabProject bksxTabProject) {
		bksxTabProjectDAO.updateProject(bksxTabProject);
	}

	/**
	 * 得到所有项目列表
	 * 
	 * @return List
	 */
	public List getProjectList() {
		return bksxTabProjectDAO.getProjectList();
	}

	/**
	 * 根据查询HQL语句得到一个项目列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public List getProjectList(String hql) {
		return bksxTabProjectDAO.getProjectList(hql);
	}

	/**
	 * 根据年级、属性得到一个项目列表
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param attributeType
	 *            属性名
	 * @param attribute
	 *            属性值
	 * @return List
	 */
	public List getProjectByGradeAttribute(Date startDate, Date endDate,
			String attributeType, String attribute) {
		return bksxTabProjectDAO.getProjectByGradeAttribute(startDate, endDate,
				attributeType, attribute);
	}
}
