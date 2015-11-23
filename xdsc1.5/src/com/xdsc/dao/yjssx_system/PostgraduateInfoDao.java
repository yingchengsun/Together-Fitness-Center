package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;

/**
 * 接口功能：对研究生信息的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface PostgraduateInfoDao {
	
	/**
	 * 添加研究生信息，学生基本信息
	 * @param student
	 */
	public void addStudent(TabStudents student);
	
	/**
	 * 添加研究生信息，研究生信息
	 * @param stu
	 */
	public void addPostgraduate(TabPostgraduate stu);
	
	/**
	 * 删除学生信息
	 * @param student
	 */
	public void delStudent(TabStudents student);
	
	/**
	 * 删除用户信息(用户名和密码)
	 * @param user
	 */
	public void delModuleUser(MhqxTabUser user);
	
	/**
	 * 更新学生信息
	 * @param student
	 */
	public void updateStudent(TabStudents student);
	
	/**
	 * 更新研究生信息
	 * @param stu
	 */
	public void updatePostgraduateStuInfo(TabPostgraduate stu);
	
	/**
	 * 根据研究生ID查找研究生信息
	 * @param id
	 * @return 返回研究生信息
	 */
	public TabStudents findStudentById(String id);
	
	/**
	 * 根据公司名称查找研究生信息
	 * @param comNum
	 * @return 返回研究生信息
	 */
	public List<TabPostgraduate>  findPostgraduateByComNumber(String comNum);
	
	/**
	 * 查找出所有研究生信息
	 * @return 返回研究生信息
	 */
	public List<TabPostgraduate>  findAllStudent();
	
	/**
	 * 根据研究生姓名查找研究生信息
	 * @param name
	 * @return 返回研究生信息
	 */
	public List<TabPostgraduate>  findStudentByName(String name);
	
	/**
	 * 根据用户ID查找用户信息
	 * @param id
	 * @return 用户信息
	 */
	public MhqxTabUser findModuleById(String id);
	
	/**
	 * 根据研究生ID查找研究生信息
	 * @param StuNum
	 * @return 返回研究生信息
	 */
	public TabPostgraduate findPostgraduateByStuNumber(String StuNum);
	
	/** 根据导师姓名查找研究生信息
	 * @param Num
	 * @return 返回研究生信息
	 */
	public List<TabPostgraduate> findPostgraduateByTutorNumber(String Num);
	
	/**
	 * 根据用户输入条件查询研究生详情
	 * @param studentName
	 * @param studentSex
	 * @param tutorNumber
	 * @param companyNumber
	 * @param className
	 * @param gradeName
	 * @param studentType
	 * @param openThesis
	 * @param middleThesis
	 * @param lastThesis
	 * @return
	 */
	public List<TabPostgraduate> findPostgraduateByCondition(String studentName,String studentSex,String tutorNumber,String companyNumber,
			String className,String gradeName,String studentType,String openThesis,String middleThesis,String lastThesis);
	
	
}
