package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.TabCourse;

public interface XsglTabCourseDAO {

	public abstract TabCourse getCourseByNum(String courseNum);

	public abstract List getAllCourse();

}