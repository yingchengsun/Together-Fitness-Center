package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;

public interface UserLoginService {
	
	public Boolean UserIsValide(MhqxTabUser user);
	
	public MhqxTabUser findUserByNum(String FUserNumber);
}
