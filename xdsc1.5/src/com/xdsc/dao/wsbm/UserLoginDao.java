package com.xdsc.dao.wsbm;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
/**ÓÃ»§µÇÂ¼
 * @author ¹¶Ð¡Áú
 * @version 1.2
 */
public interface UserLoginDao {
	
	List<MhqxTabUser> findUserByExample(MhqxTabUser user);

}
