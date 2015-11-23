package com.xdsc.dao.bksx_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabProject;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对项目相关的操作
 */
public interface BksxTabProjectDAO {

	/**
	 * 根据项目ID得到一个BksxTabProject对象
	 * 
	 * @param proId
	 *            项目ID
	 * @return BksxTabProject
	 */
	public abstract BksxTabProject getProjectById(int proId);

	/**
	 * 保存一个BksxTabProject对象
	 * 
	 * @param project
	 *            项目对象
	 * @return boolean
	 */
	public abstract boolean saveProject(BksxTabProject project);

	/**
	 * 更新一个BksxTabProject对象
	 * 
	 * @param bksxTabProject
	 *            项目对象
	 * @return
	 */
	public abstract void updateProject(BksxTabProject bksxTabProject);

	/**
	 * 得到所有项目列表
	 * 
	 * @return List
	 */
	public abstract List getProjectList();

	/**
	 * 根据查询HQL语句得到一个项目列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public abstract List getProjectList(String hql);

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
	public abstract List getProjectByGradeAttribute(Date startDate,
			Date endDate, String attributeType, String attribute);

}