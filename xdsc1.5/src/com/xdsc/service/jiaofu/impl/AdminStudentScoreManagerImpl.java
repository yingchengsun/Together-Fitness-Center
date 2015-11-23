package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AdminStudentScoreDAO;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.service.jiaofu.AdminStudentScoreManager;
/**
 * <p>功能：学生成绩管理中设计到的方法，包括成绩查询、删除等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AdminStudentScoreManagerImpl implements AdminStudentScoreManager{

	/**DAO层对象*/
	private AdminStudentScoreDAO adminStudentScoreDAO;

	public AdminStudentScoreDAO getAdminStudentScoreDAO() {
		return adminStudentScoreDAO;
	}

	public void setAdminStudentScoreDAO(AdminStudentScoreDAO adminStudentScoreDAO) {
		this.adminStudentScoreDAO = adminStudentScoreDAO;
	}

	/**
	 * <p>功能：查询出学生平时成绩<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualScore()
	 * @return list 返回学生的平时信息列表
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUsualscore> findUsualScore() {
		// TODO Auto-generated method stub
		return adminStudentScoreDAO.findUsualScore();
	}

	/**
	 * <p>功能：查询出某学生相关的成绩信息<br>
	 * @see com.xdsc.dao.jiaofu.AdminStudentScoreDAO#findUsualSelectInfoBy(java.lang.String)
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 * @param name 学生姓名
	 * @return list 学生相关的成绩信息
	 */
	public List<JfptTabUsualscore> findUsualSelectInfoBy(String name) {
		// TODO Auto-generated method stub
		return adminStudentScoreDAO.findUsualSelectInfoBy(name);
	}

	/**
	 * <p>功能：删除成绩对象<br>
	 * @param haha 成绩对象，类型为JfptTabUsualscore
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUsualScoreInfo(JfptTabUsualscore haha) {
		// TODO Auto-generated method stub
		adminStudentScoreDAO.deleteUsualScoreInfo(haha);
	}

	/**
	 * <p>功能：根据成绩Id号查询出成绩对象<br>
	 * @param i 成绩Id号
	 * @return 查询出的成绩对象
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUsualscore findUsualScoreInfoByID(int i) {
		// TODO Auto-generated method stub
		return adminStudentScoreDAO.findUsualScoreInfoByID(i);
	}
}
