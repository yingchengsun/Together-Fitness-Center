package com.xdsc.service.wsbm;

import java.util.List;

import com.xdsc.model.MhqxTabUser;

/**用户登陆系统
 * @author 苟小龙
 * @version 1.2
 */
public interface UserLoginService {
	
	public Boolean UserIsValide(MhqxTabUser user);
}
