package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
/**
 * <p>功能：进行资源查找等操作<br>
 * @author qianxun
 * @version 1.1
 */
public interface AssistResourceManageManager {

	/**
	 * <p>功能：根据个人编号相关的资源<br>
	 * @param id 个人编号
	 * @return list 返回相关的资源信息
	 */
	public List<JfptTabUploadfile> findResourceInfoByID(String id);
	
	/**
	 * <p>功能：根据资源id号查找相关资源信息<br>
	 * @param FNumber 资源编号
	 * @return JfptTabUploadfile 资源信息对象
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}
