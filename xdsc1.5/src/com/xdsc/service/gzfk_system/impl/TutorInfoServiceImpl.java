package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.TutorInfoDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.service.gzfk_system.TutorInfoService;

public class TutorInfoServiceImpl implements TutorInfoService {
	
	private TutorInfoDao TutorInfoDao;

	public TutorInfoDao getTutorInfoDao() {
		return TutorInfoDao;
	}

	public void setTutorInfoDao(TutorInfoDao tutorInfoDao) {
		TutorInfoDao = tutorInfoDao;
	}

	public void deleteTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		TutorInfoDao.deleteTutorInfo(teacher);
	}

	public List<TabTeachers> findAllTutors() {
		// TODO Auto-generated method stub
		return TutorInfoDao.findAllTutors();
	}

	public TabTeachers findTutorById(String num) {
		// TODO Auto-generated method stub
		return TutorInfoDao.findTutorById(num);
	}

	public void updateTutorInfo(TabTeachers teacher) {
		// TODO Auto-generated method stub
		TutorInfoDao.updateTutorInfo(teacher);
	}

	public List<TabTeachers> findTutorByName(String name) {
		// TODO Auto-generated method stub
		return TutorInfoDao.findTutorByName(name);
	}

	public List<TabTeachers> findAllTeachers() {
		// TODO Auto-generated method stub
		return TutorInfoDao.findAllTeachers();
	}

	public void addTutorType(TabTeacherstotype to) {
		// TODO Auto-generated method stub
		TutorInfoDao.addTutorType(to);
	}

	public void addModuleUser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		TutorInfoDao.addModuleUser(user);
	}

	public void addTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		TutorInfoDao.addTeacher(teacher);
	}

}
