package com.xdsc.service.yjssx_system;

import java.util.List;

import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;

/**
 * 接口功能：对研究生提交的论文和导师反馈的论文的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface PostgraduateThesisService {
	
	/**
	 * 研究生提交论文，保存论文信息
	 * @param thesis
	 */
	public void addSubmitThesis(YjssxTabSubmitthesis thesis);
	
	/**
	 * 删除提交的论文信息
	 * @param thesis
	 */
	public void deleteSubmitThesis(YjssxTabSubmitthesis thesis);
	
	/**
	 * 更新提交的论文信息
	 * @param thesis
	 */
	public void updateSubmitThesis(YjssxTabSubmitthesis thesis);
	
	/**
	 * 根据论文的ID号来查找论文的信息
	 * @param id
	 * @return 返回论文的详情
	 */
	public YjssxTabSubmitthesis findSubmitThesisById(int id);
	
	/**
	 * 根据导师的姓名查找论文提交情况
	 * @param num
	 * @return 提交给该导师的所有论文信息
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByTutorNumAndType(String num,String type);
	
	/**
	 * 根据研究生的ID查找提交的论文
	 * @param num
	 * @return 返回研究生提交的论文
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByStudentNumAndType(String num,String type);  
	
	/**
	 * 查找所有导师反馈的论文
	 * @return 返回所有查找出来的研究生反馈论文
	 */
	public List<YjssxTabReturnthesis> findAllReturnThesis();
	
	/**
	 * 根据导师姓名查找研究生反馈论文
	 * @param name
	 * @return 返回研究生反馈的论文
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByTutorNameAndType(String name,String type);
	
	/**
	 * 导师反馈论文，保存反馈的论文信息
	 * @param thesis
	 */
	public void addReturnThesis(YjssxTabReturnthesis thesis);
	
	/**
	 * 删除反馈的论文
	 * @param thesis
	 */
	public void deleteReturnThesis(YjssxTabReturnthesis thesis);
	
	/**
	 * 更新反馈的论文信息
	 * @param thesis
	 */
	public void updateReturnThesis(YjssxTabReturnthesis thesis);
	
	/**
	 * 根据反馈论文的ID查找论文信息
	 * @param id
	 * @return 反馈论文的详情
	 */
	public YjssxTabReturnthesis findReturnThesisById(int id);
	
	/**
	 * 根据导师ID查找导师回复的论文
	 * @param num
	 * @return 导师回复的所有论文
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByTutorNumAndType(String num,String type);
	
	/**
	 * 根据研究生好查找给研究生回复的论文
	 * @param num
	 * @return 返回反馈的论文
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByStudentNumAndType(String num,String type);
	
	/**
	 * 根据条件查询提交的论文
	 * @param studentGrade
	 * @param studentName
	 * @param thesisStatus
	 * @param tutorNum
	 * @return
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByConditionAndType(String studentGrade,String studentName,
																	String thesisStatus,String tutorNum,String type); 
	
	/**
	 * 根据导师姓名和学生年级查询提交的论文
	 * @param studentGrade
	 * @param tutorName
	 * @return
	 */
	public List<YjssxTabSubmitthesis> findSubmitInfoByTutorAndGradeAndType(String studentGrade,String tutorName,String type);
	
	/**
	 * 根据条件查询反馈的论文
	 * @param studentGrade
	 * @param studentName
	 * @param thesisStatus
	 * @param tutorNum
	 * @return
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByConditionAndType(String studentGrade,String studentName,
			String thesisStatus,String tutorNum,String type); 
	
	/**
	 * 根据导师和研究生ID查找提交的论文
	 * @param stuNum
	 * @param tutorNum
	 * @return
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByTutorNumAndStudentNumAndType(String stuNum,String tutorNum,String type);
	
	/**
	 * 管理员查找论文提交情况
	 * @param studentName
	 * @param tutorName
	 * @param className
	 * @param gradeName
	 * @param studentType
	 * @return
	 */
	public List<YjssxTabSubmitthesis> findAllThesisSubmitInformationByConditionAndType(String studentName,String tutorName,String className,
			String gradeName,String studentType,String type);
	
	/**
	 * 管理员查找论文反馈情况
	 * @param studentName
	 * @param tutorName
	 * @param className
	 * @param gradeName
	 * @param studentType
	 * @param IsReturned
	 * @param ThesisStatus
	 * @return
	 */
	public List<YjssxTabReturnthesis> findAllThesisReturnInformationByConditionAndType(String studentName,String tutorName,String className,
			String gradeName,String studentType,String IsReturned,String ThesisStatus,String type);
}
