package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.PostgraduateInfoDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;

/**
 * 类功能：对研究生信息的逻辑操作
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateInfoServiceImpl implements PostgraduateInfoService {

	private PostgraduateInfoDao postgraduateInfoDao;
	
	/**
	 * 添加研究生信息，学生基本信息
	 * @param student
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#addStudent(com.xdsc.model.TabStudents)
	 */
	public void addStudent(TabStudents student) {
		// TODO Auto-generated method stub
		postgraduateInfoDao.addStudent(student);
	}

	/**
	 * 删除学生信息
	 * @param student
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#delStudent(com.xdsc.model.TabStudents)
	 */
	public void delStudent(TabStudents student) {
		// TODO Auto-generated method stub
		postgraduateInfoDao.delStudent(student);
	}

	/**
	 * 查找出所有研究生信息
	 * @return 返回研究生信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findAllStudent()
	 */
	public List<TabPostgraduate> findAllStudent() {
		// TODO Auto-generated method stub
		List<TabPostgraduate> list=postgraduateInfoDao.findAllStudent();
		return list;
	}

	/**
	 * 根据研究生ID查找研究生信息
	 * @param StuNum
	 * @return 返回研究生信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findPostgraduateByStuNumber(java.lang.String)
	 */
	public TabPostgraduate findPostgraduateByStuNumber(String StuNum) {
		// TODO Auto-generated method stub
		TabPostgraduate student=postgraduateInfoDao.findPostgraduateByStuNumber(StuNum);
		return student;
	}

	/**
	 * 更新学生信息
	 * @param student
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#updateStudent(com.xdsc.model.TabStudents)
	 */
	public void updateStudent(TabStudents student) {
		// TODO Auto-generated method stub
		postgraduateInfoDao.updateStudent(student);
	}

	public PostgraduateInfoDao getPostgraduateInfoDao() {
		return postgraduateInfoDao;
	}

	public void setPostgraduateInfoDao(PostgraduateInfoDao postgraduateInfoDao) {
		this.postgraduateInfoDao = postgraduateInfoDao;
	}

	/**
	 * 更新研究生信息
	 * @param stu
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#updatePostgraduateStuInfo(com.xdsc.model.TabPostgraduate)
	 */
	public void updatePostgraduateStuInfo(TabPostgraduate stu) {
		// TODO Auto-generated method stub
		postgraduateInfoDao.updatePostgraduateStuInfo(stu);
	}

	/**
	 * 根据公司名称查找研究生信息
	 * @param comNum
	 * @return 返回研究生信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findPostgraduateByComNumber(java.lang.String)
	 */
	public List<TabPostgraduate> findPostgraduateByComNumber(String comNum) {
		// TODO Auto-generated method stub
		List<TabPostgraduate> list=postgraduateInfoDao.findPostgraduateByComNumber(comNum);
		return list;
	}

	/** 根据导师姓名查找研究生信息
	 * @param Num
	 * @return 返回研究生信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findPostgraduateByTutorNumber(java.lang.String)
	 */
	public List<TabPostgraduate> findPostgraduateByTutorNumber(String Num) {
		// TODO Auto-generated method stub
		List<TabPostgraduate> list=postgraduateInfoDao.findPostgraduateByTutorNumber(Num);
		return list;
	}

	/**
	 * 根据研究生姓名查找研究生信息
	 * @param name
	 * @return 返回研究生信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findStudentByName(java.lang.String)
	 */
	public List<TabPostgraduate> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return postgraduateInfoDao.findStudentByName(name);
	}

	/**
	 * 根据用户ID查找用户信息
	 * @param id
	 * @return 用户信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findModuleById(java.lang.String)
	 */
	public MhqxTabUser findModuleById(String id) {
		// TODO Auto-generated method stub
		return postgraduateInfoDao.findModuleById(id);
	}

	/**
	 * 添加研究生信息，研究生信息
	 * @param stu
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#addPostgraduate(com.xdsc.model.TabPostgraduate)
	 */
	public void addPostgraduate(TabPostgraduate stu) {
		// TODO Auto-generated method stub
		postgraduateInfoDao.addPostgraduate(stu);
	}

	/**
	 * 删除用户信息(用户名和密码)
	 * @param user
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#delModuleUser(com.xdsc.model.MhqxTabUser)
	 */
	public void delModuleUser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		postgraduateInfoDao.delModuleUser(user);
	}

	/**
	 * 根据研究生ID查找研究生信息
	 * @param id
	 * @return 返回研究生信息
	 * @see com.xdsc.service.yjssx_system.PostgraduateInfoService#findStudentById(java.lang.String)
	 */
	public TabStudents findStudentById(String id) {
		// TODO Auto-generated method stub
		return postgraduateInfoDao.findStudentById(id);
	}

	public List<TabPostgraduate> findPostgraduateByCondition(
			String studentName, String studentSex, String tutorNumber,
			String companyNumber, String className, String gradeName,
			String studentType, String openThesis, String middleThesis,
			String lastThesis) {
		// TODO Auto-generated method stub
		return postgraduateInfoDao.findPostgraduateByCondition(studentName, studentSex, tutorNumber, companyNumber, className, gradeName, studentType, openThesis, middleThesis, lastThesis);
	}

}
