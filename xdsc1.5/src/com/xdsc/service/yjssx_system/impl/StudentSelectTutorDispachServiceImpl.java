package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.StudentSelectTutorDispachDao;
import com.xdsc.model.YjssxTabTutorselectdispach;
import com.xdsc.service.yjssx_system.StudentSelectTutorDispachService;

/**
 * 类功能：管理员分发研究生报名信息数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class StudentSelectTutorDispachServiceImpl implements
		StudentSelectTutorDispachService {

	private StudentSelectTutorDispachDao studentSelectTutorDispachDao;
	
	/**
	 * 添加一个信息的研究生分配信息
	 * @param student
	 * @see com.xdsc.service.yjssx_system.StudentSelectTutorDispachService#addDispachedStudent(com.xdsc.model.YjssxTabTutorselectdispach)
	 */
	public void addDispachedStudent(YjssxTabTutorselectdispach student) {
		// TODO Auto-generated method stub
		studentSelectTutorDispachDao.addDispachedStudent(student);
	}

	/**
	 * 删除研究生分配信息
	 * @param student
	 * @see com.xdsc.service.yjssx_system.StudentSelectTutorDispachService#deleteDispachInfo(com.xdsc.model.YjssxTabTutorselectdispach)
	 */
	public void deleteDispachInfo(YjssxTabTutorselectdispach student) {
		// TODO Auto-generated method stub
		studentSelectTutorDispachDao.deleteDispachInfo(student);
	}

	/**
	 * 根据研究生ID查找研究生分配信息
	 * @param name
	 * @return 研究生分配信息
	 * @see com.xdsc.service.yjssx_system.StudentSelectTutorDispachService#findDispachInfoByStudentName(java.lang.String)
	 */
	public List<YjssxTabTutorselectdispach> findDispachInfoByStudentName(
			String name) {
		// TODO Auto-generated method stub
		return studentSelectTutorDispachDao.findDispachInfoByStudentName(name);
	}

	/**
	 * 根据导师ID查找导师分配信息
	 * @param num
	 * @return 返回导师分配信息
	 * @see com.xdsc.service.yjssx_system.StudentSelectTutorDispachService#findDispachInfoByTutorNum(java.lang.String)
	 */
	public List<YjssxTabTutorselectdispach> findDispachInfoByTutorNum(
			String num) {
		// TODO Auto-generated method stub
		return studentSelectTutorDispachDao.findDispachInfoByTutorNum(num);
	}

	public StudentSelectTutorDispachDao getStudentSelectTutorDispachDao() {
		return studentSelectTutorDispachDao;
	}

	public void setStudentSelectTutorDispachDao(
			StudentSelectTutorDispachDao studentSelectTutorDispachDao) {
		this.studentSelectTutorDispachDao = studentSelectTutorDispachDao;
	}

}
