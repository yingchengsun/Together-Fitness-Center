package com.xdsc.service.wzmh_system;


import com.xdsc.model.TabTeachers;

/**
 * 教师管理
 * @author 陈丰
 *
 */
public interface TeacherManager {
	public TabTeachers findTeacherByUserNumber(String id);
}
