package com.xdsc.dao.gzfk_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;

public interface UserLoginDao {
	
	List<MhqxTabUser> findUserByExample(MhqxTabUser user);
	
	public MhqxTabUser findUserByNum(String FUserNumber);

}
