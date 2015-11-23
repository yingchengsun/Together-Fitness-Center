package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;

/**
 * 接口功能：导师信息的数据库操作(增删改查)
 * @author 许鑫
 * @version 1.1
 */
public interface TutorInfoDao {
	
	/**
	 * 根据导师ID查找导师信息
	 * @param num
	 * @return 返回导师信息
	 */
	public TabTeachers findTutorById(String num);
	
	/**
	 * 查找所有导师信息
	 * @return 返回所有导师信息
	 */
	public List<TabTeachers> findAllTutors();
	
	/**
	 * 根据导师姓名查找导师信息
	 * @param name
	 * @return 返回导师信息列表
	 */
	public List<TabTeachers> findTutorByName(String name);
	
	/**
	 * 查找所有老师信息
	 * @return 返回所有来时信息列表
	 */
	public List<TabTeachers> findAllTeachers();
	
	/**
	 * 删除导师信息
	 * @param teacher
	 */
	public void deleteTutorInfo(TabTeachers teacher);
	
	/**
	 * 更新导师信息
	 * @param teacher
	 */
	public void updateTutorInfo(TabTeachers teacher);
	
	/**
	 * 增加导师类型
	 * @param to
	 */
	public void addTutorType(TabTeacherstotype to);
	
	/**
	 * 添加一个新的教师
	 * @param teacher
	 */
	public void addTeacher(TabTeachers teacher);
	
	/**
	 * 添加一个系统用户
	 * @param user
	 */
	public void addModuleUser(MhqxTabUser user);

}
