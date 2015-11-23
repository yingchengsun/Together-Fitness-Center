package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabTeacherstotypeDAO;

import com.xdsc.model.TabTeacherstotype;
import com.xdsc.service.sjjx_system.SjjxTabTeacherstotypeManager;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabTeacherstotypeManagerImpl implements SjjxTabTeacherstotypeManager {

	/**
	 * SjjxTabTeachersDAOImpl 的接口
	 */
	private SjjxTabTeacherstotypeDAO sjjxTabTeacherstotypeDAO;
	

	/**通过教师类型查找到教师记录列表
	 * @param teacherName
	 * @return 返回列表
	 */
	public List<TabTeacherstotype> getTeacherByType() {
		return sjjxTabTeacherstotypeDAO.getTeacherByType();
	}

	/**
	 * 数据访问方法
	 */
	public SjjxTabTeacherstotypeDAO getSjjxTabTeacherstotypeDAO() {
		return sjjxTabTeacherstotypeDAO;
	}


	public void setSjjxTabTeacherstotypeDAO(
			SjjxTabTeacherstotypeDAO sjjxTabTeacherstotypeDAO) {
		this.sjjxTabTeacherstotypeDAO = sjjxTabTeacherstotypeDAO;
	}
}
