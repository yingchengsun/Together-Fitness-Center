package com.xdsc.service.xsgl_system;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.xdsc.model.TabTeachers;

public interface XsglTabTeachersManager {

	public abstract List<TabTeachers> getTeacherByTeaNum(String TeaNum);

	public abstract TabTeachers getTeacherByTeaName(String teacherName0);
	
	public abstract boolean updateTeacher(TabTeachers teacher);

}