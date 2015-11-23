package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.YjssxTabResume;

/**
 * 接口功能：研究生简历的数据库操作(增删改查)
 * @author 许鑫
 * @version 1.1
 */
public interface UploadResumeDao {
	
	/**
	 * 增加一个简历信息
	 * @param resume
	 */
	public void addResume(YjssxTabResume resume);
	
	/**
	 * 删除一个简历信息
	 * @param resume
	 */
	public void deleteResume(YjssxTabResume resume);
	
	/**
	 * 根据公司的ID查找所有提交的简历
	 * @param num
	 * @return 返回所有已经提交的简历
	 */
	public List<YjssxTabResume> findAllResumeByComNum(String num);
	
	/**
	 * 根据简历的ID查找简历的详情
	 * @param id
	 * @return 返回简历的详情
	 */
	public YjssxTabResume findResumeById(int id);

}
