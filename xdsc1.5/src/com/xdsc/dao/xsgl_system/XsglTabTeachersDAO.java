package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.TabTeachers;

public interface XsglTabTeachersDAO {

	public abstract List<TabTeachers> getTeacherByTeaNum(String TeaNum);

	public abstract TabTeachers getTeacherByTeaName(String teacherName0);
	
	public abstract boolean updateTeacher(TabTeachers teacher);

}