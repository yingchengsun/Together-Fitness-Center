package com.xdsc.service.wzmh_system;

import com.xdsc.model.TabStudents;

/**
 * 学生管理
 * @author 陈丰
 *
 */
public interface StudentManager {
	public TabStudents findStudentByUserNumber(String id);
	public String getStudentInfoTable(String id);
}
