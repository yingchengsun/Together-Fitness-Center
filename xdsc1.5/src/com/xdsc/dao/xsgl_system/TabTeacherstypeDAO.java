package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.TabTeacherstype;

public interface TabTeacherstypeDAO {

	public abstract List<TabTeacherstype> getTeacherByTypeNum(String TypeNum);

}