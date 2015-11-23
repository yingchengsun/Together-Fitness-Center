package com.xdsc.dao.gzfk_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;

public interface TutorInfoDao {
	
	public TabTeachers findTutorById(String num);
	
	public List<TabTeachers> findAllTutors();
	
	public List<TabTeachers> findTutorByName(String name);
	
	public List<TabTeachers> findAllTeachers();
	
	public void deleteTutorInfo(TabTeachers teacher);
	
	public void updateTutorInfo(TabTeachers teacher);
	
	public void addTutorType(TabTeacherstotype to);
	
	public void addTeacher(TabTeachers teacher);
	
	public void addModuleUser(MhqxTabUser user);

}
