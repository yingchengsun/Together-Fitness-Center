package com.xdsc.dao.wsbm;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;


/**管理员综合查看网站信息
 * @author 苟小龙
 * @version 1.2
 */
public interface AdAllCheckDAO {
	public List<WsbmTabRegapplicant> findRegapplicantInfo();

	public WsbmTabRegapplicant sepFindByNum(String appRegNum);

	public List<TabNotice> findNotice();

	public TabNotice sepFindByNoticeNum(int i);

	public void updateApp(WsbmTabRegapplicant wsbmTabRegapplicant);

	public List<WsbmTabRegapplicant> findAuthPassRegapplicantInfo();

	public List<WsbmTabRegapplicant> findAuthPassNotRegapplicantInfo();

	public List<WsbmTabRegapplicant> findAuthingNotRegapplicantInfo();
	
	public List<WsbmTabRegapplicant> findPrePassRegapplicantInfo();

	public List<WsbmTabRegapplicant> findPrePassNotRegapplicantInfo();

	public List<WsbmTabRegapplicant> findPreingRegapplicantInfo();
	
	public List<WsbmTabRegapplicant> findFinPassRegapplicantInfo();

	public List<WsbmTabRegapplicant> findFinPassNotRegapplicantInfo();

	public List<WsbmTabRegapplicant> findFiningRegapplicantInfo();

	public List<WsbmTabRegapplicant> unfindfeed();

	public List<WsbmTabRegapplicant> findfeed();

	public MhqxTabUser sepFindByNumInUser(String FAppRegNum);
}
