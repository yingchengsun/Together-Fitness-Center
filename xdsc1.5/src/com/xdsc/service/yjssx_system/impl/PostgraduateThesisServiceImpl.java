package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.PostgraduateThesisDao;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;

/**
 * 类功能：对研究生提交的论文和导师反馈的论文的逻辑操作
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateThesisServiceImpl implements PostgraduateThesisService {
	
	public PostgraduateThesisDao postgraduateThesisDao;

	/**
	 * 导师反馈论文，保存反馈的论文信息
	 * @param thesis
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#addReturnThesis(com.xdsc.model.YjssxTabReturnthesis)
	 */
	public void addReturnThesis(YjssxTabReturnthesis thesis) {
		// TODO Auto-generated method stub
		postgraduateThesisDao.addReturnThesis(thesis);
	}

	/**
	 * 研究生提交论文，保存论文信息
	 * @param thesis
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#addSubmitThesis(com.xdsc.model.YjssxTabSubmitthesis)
	 */
	public void addSubmitThesis(YjssxTabSubmitthesis thesis) {
		// TODO Auto-generated method stub
		postgraduateThesisDao.addSubmitThesis(thesis);
	}

	/**
	 * 删除反馈的论文
	 * @param thesis
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#deleteReturnThesis(com.xdsc.model.YjssxTabReturnthesis)
	 */
	public void deleteReturnThesis(YjssxTabReturnthesis thesis) {
		// TODO Auto-generated method stub
		postgraduateThesisDao.deleteReturnThesis(thesis);
	}

	/**
	 * 删除提交的论文信息
	 * @param thesis
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#deleteSubmitThesis(com.xdsc.model.YjssxTabSubmitthesis)
	 */
	public void deleteSubmitThesis(YjssxTabSubmitthesis thesis) {
		// TODO Auto-generated method stub
		postgraduateThesisDao.deleteSubmitThesis(thesis);
	}

	/**
	 * 根据反馈论文的ID查找论文信息
	 * @param id
	 * @return 反馈论文的详情
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findReturnThesisById(int)
	 */
	public YjssxTabReturnthesis findReturnThesisById(int id) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findReturnThesisById(id);
	}

	/**
	 * 根据研究生好查找给研究生回复的论文
	 * @param num
	 * @return 返回反馈的论文
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findReturnThesisByStudentNum(java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByStudentNumAndType(String num,String type){
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findReturnThesisByStudentNumAndType(num,type);
	}

	/**
	 * 根据导师ID查找导师回复的论文
	 * @param num
	 * @return 导师回复的所有论文
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findReturnThesisByTutorNum(java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByTutorNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findReturnThesisByTutorNumAndType(num,type);
	}

	/**
	 * 根据论文的ID号来查找论文的信息
	 * @param id
	 * @return 返回论文的详情
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findSubmitThesisById(int)
	 */
	public YjssxTabSubmitthesis findSubmitThesisById(int id) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findSubmitThesisById(id);
	}

	/**
	 * 根据研究生的ID查找提交的论文
	 * @param num
	 * @return 返回研究生提交的论文
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findSubmitThesisByStudentNum(java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByStudentNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findSubmitThesisByStudentNumAndType(num,type);
	}

	/**
	 * 根据导师的姓名查找论文提交情况
	 * @param num
	 * @return 提交给该导师的所有论文信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findSubmitThesisByTutorNum(java.lang.String)
	 */
	public List<YjssxTabSubmitthesis> findSubmitThesisByTutorNumAndType(String num,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findSubmitThesisByTutorNumAndType(num,type);
	}

	/**
	 * 更新反馈的论文信息
	 * @param thesis
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#updateReturnThesis(com.xdsc.model.YjssxTabReturnthesis)
	 */
	public void updateReturnThesis(YjssxTabReturnthesis thesis) {
		// TODO Auto-generated method stub
		postgraduateThesisDao.updateReturnThesis(thesis);
	}

	/**
	 * 更新提交的论文信息
	 * @param thesis
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#updateSubmitThesis(com.xdsc.model.YjssxTabSubmitthesis)
	 */
	public void updateSubmitThesis(YjssxTabSubmitthesis thesis) {
		// TODO Auto-generated method stub
		postgraduateThesisDao.updateSubmitThesis(thesis);
	}

	public PostgraduateThesisDao getPostgraduateThesisDao() {
		return postgraduateThesisDao;
	}

	public void setPostgraduateThesisDao(PostgraduateThesisDao postgraduateThesisDao) {
		this.postgraduateThesisDao = postgraduateThesisDao;
	}

	/**
	 * 查找所有导师反馈的论文
	 * @return 返回所有查找出来的研究生反馈论文
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findAllReturnThesis()
	 */
	public List<YjssxTabReturnthesis> findAllReturnThesis() {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findAllReturnThesis();
	}

	/**
	 * 根据导师姓名查找研究生反馈论文
	 * @param name
	 * @return 返回研究生反馈的论文
	 * @see com.xdsc.service.yjssx_system.PostgraduateThesisService#findReturnThesisByTutorName(java.lang.String)
	 */
	public List<YjssxTabReturnthesis> findReturnThesisByTutorNameAndType(String name,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findReturnThesisByTutorNameAndType(name,type);
	}

	public List<YjssxTabSubmitthesis> findSubmitThesisByConditionAndType(
			String studentGrade, String studentName, String thesisStatus,String tutorNum,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findSubmitThesisByConditionAndType(studentGrade, studentName, thesisStatus,tutorNum,type);
	}

	public List<YjssxTabSubmitthesis> findSubmitInfoByTutorAndGradeAndType(
			String studentGrade, String tutorName,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findSubmitInfoByTutorAndGradeAndType(studentGrade, tutorName,type);
	}

	public List<YjssxTabReturnthesis> findReturnThesisByConditionAndType(
			String studentGrade, String studentName, String thesisStatus,
			String tutorNum,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findReturnThesisByConditionAndType(studentGrade, studentName, thesisStatus, tutorNum,type);
	}

	public List<YjssxTabSubmitthesis> findSubmitThesisByTutorNumAndStudentNumAndType(
			String stuNum, String tutorNum,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findSubmitThesisByTutorNumAndStudentNumAndType(stuNum, tutorNum,type);
	}

	public List<YjssxTabReturnthesis> findAllThesisReturnInformationByConditionAndType(
			String studentName, String tutorName, String className,
			String gradeName, String studentType, String IsReturned,
			String ThesisStatus,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findAllThesisReturnInformationByConditionAndType(studentName, tutorName, className, gradeName, studentType, IsReturned, ThesisStatus,type);
	}

	public List<YjssxTabSubmitthesis> findAllThesisSubmitInformationByConditionAndType(
			String studentName, String tutorName, String className,
			String gradeName, String studentType,String type) {
		// TODO Auto-generated method stub
		return postgraduateThesisDao.findAllThesisSubmitInformationByConditionAndType(studentName, tutorName, className, gradeName, studentType,type);
	}

}
