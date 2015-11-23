package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.YjssxTabTutorselectdispach;

/**
 * 接口功能：管理员分发研究生报名信息数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface StudentSelectTutorDispachDao {

	/**
	 * 添加一个信息的研究生分配信息
	 * @param student
	 */
	public void addDispachedStudent(YjssxTabTutorselectdispach student);
	
	/**
	 * 根据导师ID查找导师分配信息
	 * @param num
	 * @return 返回导师分配信息
	 */
	public List<YjssxTabTutorselectdispach> findDispachInfoByTutorNum(String num);
	
	/**
	 * 根据研究生ID查找研究生分配信息
	 * @param name
	 * @return 研究生分配信息
	 */
	public List<YjssxTabTutorselectdispach> findDispachInfoByStudentName(String name);
	
	/**
	 * 删除研究生分配信息
	 * @param student
	 */
	public void deleteDispachInfo(YjssxTabTutorselectdispach student);
}
