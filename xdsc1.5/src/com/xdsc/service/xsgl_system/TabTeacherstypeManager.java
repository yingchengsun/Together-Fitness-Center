package com.xdsc.service.xsgl_system;

import java.util.List;

import com.xdsc.model.TabTeacherstype;

public interface TabTeacherstypeManager {

	public abstract List<TabTeacherstype> getTeacherByTypeNum(String TypeNum);

}