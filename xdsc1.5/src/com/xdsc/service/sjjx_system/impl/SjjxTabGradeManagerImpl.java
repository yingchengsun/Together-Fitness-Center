package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabCourseDAO;
import com.xdsc.dao.sjjx_system.SjjxTabGradeDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabGrade;
import com.xdsc.service.sjjx_system.SjjxTabGradeManager;

/**对年级信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabGradeManagerImpl implements SjjxTabGradeManager {

	/**
	 * SjjxTabGradeDAOImpl 的接口
	 */
	private SjjxTabGradeDAO sjjxTabGradeDAO;

	

	/**
	 * 数据访问方法
	 */
	public SjjxTabGradeDAO getSjjxTabGradeDAO() {
		return sjjxTabGradeDAO;
	}


	public void setSjjxTabGradeDAO(SjjxTabGradeDAO sjjxTabGradeDAO) {
		this.sjjxTabGradeDAO = sjjxTabGradeDAO;
	}


	/**根据年级名称查找到对应的记录
	 * @param gradeName
	 * @return 返回年级记录
	 */
	public TabGrade getGradeByGradeName(String gradeName) {
		return sjjxTabGradeDAO.getGradeByGradeName(gradeName);
	}

	/**根据年级编号查找到对应的记录
	 * @param gradeId
	 * @return 返回年级记录
	 */
	public TabGrade getGradeByGradeId(Integer gradeId) {
		return sjjxTabGradeDAO.getGradeByGradeId(gradeId);
	}


	
}
