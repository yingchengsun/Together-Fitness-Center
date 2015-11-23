package com.xdsc.service.wsbm;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**É¾³ýÍøÕ¾ÐÅÏ¢
 * @author ¹¶Ð¡Áú
 * @version 1.2
 */
public interface DeleteManager {
	public void deleteAcc(MhqxTabUser mhqxTabUser);

	public MhqxTabUser findAccByNum(String FUserNumber);

	public List<WsbmTabRegapplicant> findRegapplicantInfo();

	public void deleteNotice(TabNotice tabNotice);

	public void deleteAcc(WsbmTabRegapplicant wsbmTabRegapplicant);

	public List<WsbmTabExamsubject> findSubject();

	public void deleteSubject(WsbmTabExamsubject wsbmTabExamsubject);

}
