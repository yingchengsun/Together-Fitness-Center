package com.xdsc.service.yjssx_system.impl;

import java.util.ArrayList;
import java.util.List;

import com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;

/**
 * 接口功能：研究生导师双向选择
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateTutorSelectServiceImpl implements
		PostgraduateTutorSelectService {

	private PostgraduateTutorSelectDao postgraduateTutorSelectDao;
	
	/**
     * 查找所有导师信息
     * @return 返回所有导师信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#findAllTutorInfo()
	 */
	public List<TabTeachers> findAllTutorInfo() {
		// TODO Auto-generated method stub
		List<TabTeacherstotype> listTeacherstotype=postgraduateTutorSelectDao.findAllTutorInfo();
		List<TabTeachers> listTeacher=new ArrayList<TabTeachers>();
		for(int i=0;i<listTeacherstotype.size();i++){
			listTeacher.add(listTeacherstotype.get(i).getTabTeachers());
		}
		return listTeacher;
	}

	/**
	 * 根据导师的ID查找导师详细信息
	 * @param num
	 * @return 返回导师详情
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#findTutorInfoByNum(java.lang.String)
	 */
	public TabTeachers findTutorInfoByNum(String num) {
		// TODO Auto-generated method stub
		TabTeachers teacher=postgraduateTutorSelectDao.findTutorInfoByNum(num);
		return teacher;
	}
	
	/**
	 * 根据学生ID查找导师选择信息
	 * @param num
	 * @return 返回导师选择信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#tutorSelectInfoByStuNum(java.lang.String)
	 */
	public YjssxTabTutorselect tutorSelectInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		return postgraduateTutorSelectDao.tutorSelectInfoByStuNum(num);
	}

	public PostgraduateTutorSelectDao getPostgraduateTutorSelectDao() {
		return postgraduateTutorSelectDao;
	}

	public void setPostgraduateTutorSelectDao(
			PostgraduateTutorSelectDao postgraduateTutorSelectDao) {
		this.postgraduateTutorSelectDao = postgraduateTutorSelectDao;
	}

	/**
	 * 保存导师选择信息
	 * @param selectInfo
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#addTutorSelectInfo(com.xdsc.model.YjssxTabTutorselect)
	 */
	public void addTutorSelectInfo(YjssxTabTutorselect selectInfo) {
		// TODO Auto-generated method stub
		postgraduateTutorSelectDao.addTutorSelectInfo(selectInfo);
	}

	/**
	 * 更新导师选择信息
	 * @param selectInfo
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#updateTutorSelect(com.xdsc.model.YjssxTabTutorselect)
	 */
	public void updateTutorSelect(YjssxTabTutorselect selectInfo){
		postgraduateTutorSelectDao.updateTutorSelect(selectInfo);
	}

	/**
	 * 查找所有导师选择信息
	 * @return 返回导师选择信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#findSelectedTutorInfo(java.lang.String)
	 */
	public YjssxTabTutorselect findSelectedTutorInfo(String num) {
		// TODO Auto-generated method stub
		return postgraduateTutorSelectDao.findSelectedTutorInfo(num);
	}

	/**
	 * 查找所有导师选择信息
	 * @return 返回导师选择信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateTutorSelectService#findAllTutorSelectInfo()
	 */
	public List<YjssxTabTutorselect> findAllTutorSelectInfo() {
		// TODO Auto-generated method stub
		return postgraduateTutorSelectDao.findAllTutorSelectInfo();
	}

}
