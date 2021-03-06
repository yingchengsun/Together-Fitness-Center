package com.xdsc.dao.jiaofu;

import java.io.File;
import java.util.List;

import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
/**
 * <p>功能：有关作业管理中涉及到的方法，进行作业通知、作业批改、成绩管理等<br>
 * @author qianxun
 * @version 1.1
 */
public interface StudentHomeworkManageDAO {

	/**
	 * <p>功能：根据学生学号查找相对应的作业配置信息<br>
	 * @param sid 学生学号
	 * @return list 返回对应信息
	 */
	public List<JfptTabHomenoticetoreceive> findHomeNoticetotoInfoBySid(String sid);
	
	/**
	 * <p>功能：根据作业通知id号查找相关详细信息<br>
	 * @param FHomeNoticeId 作业通知id号
	 * @return JfptTabHomenotice 作业通知信息
	 */
	public JfptTabHomenotice findHomeDetailByID(int FHomeNoticeId);
	
	/**
	 * <p>功能：根据作业配置对应信息id号查找相关信息<br>
	 * @param FNumber 配置信息id号
	 * @return JfptTabHomenoticetireceive 作业配置对应信息
	 */
	public JfptTabHomenoticetoreceive findHomeNoticetotoInfoByID(int FNumber);
	
	/**
	 * <p>功能：删除作业对应配置信息<br>
	 * @param jfptTabHomenoticetoreceive 作业配置对应信息
	 */
	public void deleteHomeNoticetoto(JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive);
	
	/**
	 * <p>功能：更新作业配置信息<br>
	 * @param jfptTabHomenoticetoreceive 作业配置信息
	 */
	public void updateHomenoticetoto(JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive);
	
	//******************************************
	/**
	 * <p>功能：查找自己提交的作业信息<br>
	 * @param sid 学生学号
	 * @return list 作业提交信息
	 */
	public List<JfptTabHomeupload> findHomeUploadInfoBySid(String sid);
	
	/**
	 * <p>功能：根据上传作业信息id号查找相关详细信息<br>
	 * @param FHomeId 上传作业信息id号
	 * @return JfptTabHomeupload 上传作业对象信息
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int FHomeId);
	
	/**
	 * <p>功能：更新作业信息<br>
	 * @param jfptTabHomeupload 作业信息对象
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload);
	
	/**
	 * <p>功能：删除作业信息<br>
	 * @param jfptTabHomeupload 作业上传信息
	 */
	public void deleteHomeworkInfo(JfptTabHomeupload jfptTabHomeupload);
	
	/**
	 * <p>功能：根据学生学号查找相关的课程信息<br>
	 * @param sid 学生学号
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfoBySid(String sid);
	
	/**
	 * <p>功能：根据课程号查找课程详细信息<br>
	 * @param id 课程编号
	 * @return TabCourse 课程相关信息
	 */
	public TabCourse findCourseInfoByID(String id);
	
	/**
	 * <p>功能：根据学生学号查找学生信息<br>
	 * @param sid 学生学号
	 * @return TabStudents 学生信息
	 */
	public TabStudents findStudentsInfoBySid(String sid);
	
	/**
	 * <p>功能：保存文件<br>
	 * @param uploadFile 上传文件
	 * @param savePath 保存路径
	 * @param uploadFileFileName 文件名称
	 */
	public void savefile(File uploadFile,String savePath,String uploadFileFileName);
	
	/**
	 * <p>功能：提交作业<br>
	 * @param jfptTabHomeupload 作业信息
	 */
	public void addHomeworkInfo(JfptTabHomeupload jfptTabHomeupload);
}
