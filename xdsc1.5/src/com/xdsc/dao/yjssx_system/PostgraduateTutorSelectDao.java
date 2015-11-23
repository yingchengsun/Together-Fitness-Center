package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.model.YjssxTabTutorselect;

/**
 * 接口功能：研究生导师双向选择
 * @author 许鑫
 * @version 1.1
 */
public interface PostgraduateTutorSelectDao {
	
	/**
	 * 查找出所有导师的信息
	 * @return 返回导师信息列表
	 */ 
	public List<TabTeacherstotype> findAllTutorInfo();
	
	/**
	 * 根据导师的ID查找导师详细信息
	 * @param num
	 * @return 返回导师详情
	 */
	public TabTeachers findTutorInfoByNum(String num);
	
	/**
	 * 查找所有导师选择信息
	 * @return 返回导师选择信息
	 */
	public List<YjssxTabTutorselect> findAllTutorSelectInfo();
	
	/**
	 * 根据学生ID查找导师选择信息
	 * @param num
	 * @return 返回导师选择信息
	 */
	public YjssxTabTutorselect tutorSelectInfoByStuNum(String num);
	
	/**
	 * 查找已选择导师信息
	 * @param num
	 * @return 已选择导师信息
	 */
	public YjssxTabTutorselect findSelectedTutorInfo(String num);
	
	/**
	 * 保存导师选择信息
	 * @param selectInfo
	 */
	public void addTutorSelectInfo(YjssxTabTutorselect selectInfo);
	
	/**
	 * 更新导师选择信息
	 * @param selectInfo
	 */
	public void updateTutorSelect(YjssxTabTutorselect selectInfo);
}
