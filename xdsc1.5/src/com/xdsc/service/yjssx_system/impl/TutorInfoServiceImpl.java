package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.TutorInfoDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * 类功能：导师信息的数据库操作(增删改查)
 * @author 许鑫
 * @version 1.1
 */
public class TutorInfoServiceImpl implements TutorInfoService {
	
	private TutorInfoDao TutorInfoDao;

	public TutorInfoDao getTutorInfoDao() {
		return TutorInfoDao;
	}

	public void setTutorInfoDao(TutorInfoDao tutorInfoDao) {
		TutorInfoDao = tutorInfoDao;
	}

	/**
	 * 删除导师信息
	 * @param teacher
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#deleteTutorInfo(com.xdsc.model.TabTeachers)
	 */
	public void deleteTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		TutorInfoDao.deleteTutorInfo(teacher);
	}

	/**
	 * 查找所有导师信息
	 * @return 返回所有导师信息
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#findAllTutors()
	 */
	public List<TabTeachers> findAllTutors() {
		// TODO Auto-generated method stub
		return TutorInfoDao.findAllTutors();
	}

	/**
	 * 根据导师ID查找导师信息
	 * @param num
	 * @return 返回导师信息
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#findTutorById(java.lang.String)
	 */
	public TabTeachers findTutorById(String num) {
		// TODO Auto-generated method stub
		return TutorInfoDao.findTutorById(num);
	}

	/**
	 * 更新导师信息
	 * @param teacher
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#updateTutorInfo(com.xdsc.model.TabTeachers)
	 */
	public void updateTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		TutorInfoDao.updateTutorInfo(teacher);
	}

	/**
	 * 根据导师姓名查找导师信息
	 * @param name
	 * @return 返回导师信息列表
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#findTutorByName(java.lang.String)
	 */
	public List<TabTeachers> findTutorByName(String name) {
		// TODO Auto-generated method stub
		return TutorInfoDao.findTutorByName(name);
	}

	/**
	 * 查找所有老师信息
	 * @return 返回所有来时信息列表
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#findAllTeachers()
	 */
	public List<TabTeachers> findAllTeachers() {
		// TODO Auto-generated method stub
		return TutorInfoDao.findAllTeachers();
	}

	/**
	 * 增加导师类型
	 * @param to
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#addTutorType(com.xdsc.model.TabTeacherstotype)
	 */
	public void addTutorType(TabTeacherstotype to) {
		// TODO Auto-generated method stub
		TutorInfoDao.addTutorType(to);
	}

	/**
	 * 添加一个系统用户
	 * @param user
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#addModuleUser(com.xdsc.model.MhqxTabUser)
	 */
	public void addModuleUser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		TutorInfoDao.addModuleUser(user);
	}

	/**
	 * 添加一个新的教师
	 * @param teacher
	 * @see com.xdsc.service.yjssx_system.TutorInfoService#addTeacher(com.xdsc.model.TabTeachers)
	 */
	public void addTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		TutorInfoDao.addTeacher(teacher);
	}

}
