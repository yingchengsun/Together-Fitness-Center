package com.xdsc.service.xsgl_system;

import java.util.List;

import com.xdsc.model.TabCourse;

public interface XsglTabCourseManager {

	public abstract TabCourse getCourseByNum(String courseNum);

	public abstract List getAllCourse();

}