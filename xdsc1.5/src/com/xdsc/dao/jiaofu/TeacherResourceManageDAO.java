package com.xdsc.dao.jiaofu;

import java.io.File;
import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
/**
 * <p>功能：进行资源查找、上传、删除等操作<br>
 * @author qianxun
 * @version 1.1
 */
public interface TeacherResourceManageDAO {

	/**
	 * <p>功能：根据个人编号查找相关的课程信息<br>
	 * @param FUserNumber 个人编号
	 * @return list 返回课程信息
	 */
	public List<TabCourse> findCourseInfoUpload(String FUserNumber);
	
	/**
	 * <p>功能：添加上传资源信息<br>
	 * @param jfptTabUploadfile 资源信息
	 */
	public void addUploadInfo(JfptTabUploadfile jfptTabUploadfile);
	
	/**
	 * <p>功能：根据课程编号查找相关的课程信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse　课程信息
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber);
	
	/**
	 * <p>功能：根据个人编号查找User对象信息<br>
	 * @param FUserNumber 个人编号
	 * @return MhqxTabUser User对象信息
	 */
	public MhqxTabUser findUserInfoByID(String FUserNumber);
	
	/**
	 * <p>功能：保存文件<br>
	 * @param uploadFile 上传文件
	 * @param savePath 保存路径
	 * @param uploadFileFileName 文件名称
	 */
	public void savefile(File uploadFile,String savePath,String uploadFileFileName);
	
	/**
	 * <p>功能：根据个人编号相关的资源<br>
	 * @param tid 个人编号
	 * @return list 返回相关的资源信息
	 */
	public List<JfptTabUploadfile> findUploadfileInfo(String tid);
	
	/**
	 * <p>功能：根据资源信息id进行资源删除<br>
	 * @param FNumber 资源信息id号
	 */
	public void deleteUpfileInfoByID(int FNumber);
	
	/**
	 * <p>功能：根据资源id号查找相关资源信息<br>
	 * @param FNumber 资源编号
	 * @return JfptTabUploadfile 资源信息对象
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}
