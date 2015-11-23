package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.TabGrade;

public interface XsglTabGradeDAO {

	public abstract boolean saveGrade(TabGrade grade);

	public abstract boolean deleteGrade(TabGrade grade);

	public abstract List<TabGrade> getGradeListByUndergraduate();

	public abstract List<TabGrade> getGradeListByPostgraduate();
	
	public abstract List<TabGrade> getGradeList();
	
	public abstract TabGrade getGradeByGradeId(int gradeId);
	
	public abstract boolean updateGrade(TabGrade grade);
	
	public abstract TabGrade getGradeByGradeName(String gradeName);

}