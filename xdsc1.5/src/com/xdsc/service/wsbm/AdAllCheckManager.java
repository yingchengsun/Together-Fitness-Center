package com.xdsc.service.wsbm;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;

/**����Ա�ۺϲ鿴������Ϣ������������Ϣ
 * @author ��С��
 * @version 1.2
 */
public interface AdAllCheckManager {
	public List<WsbmTabRegapplicant> findRegapplicantInfo();
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum);
	public MhqxTabUser sepFindByNumInUser(String FAppRegNum);
	public List<TabNotice> findNotice();
	public TabNotice sepFindByNoticeNum(int i);
	public void updateApp(WsbmTabRegapplicant wsbmTabRegapplicant);
	public List<WsbmTabRegapplicant> findAuthPassRegapplicantInfo();
	public List<WsbmTabRegapplicant> findAuthPassNotRegapplicantInfo();
	public List<WsbmTabRegapplicant> findAuthingRegapplicantInfo();
	public List<WsbmTabRegapplicant> findPrePassRegapplicantInfo();
	public List<WsbmTabRegapplicant> findPrePassNotRegapplicantInfo();
	public List<WsbmTabRegapplicant> findPreingRegapplicantInfo();
	public List<WsbmTabRegapplicant> findFinPassRegapplicantInfo();
	public List<WsbmTabRegapplicant> findFinPassNotRegapplicantInfo();
	public List<WsbmTabRegapplicant> findFiningRegapplicantInfo();
	public List<WsbmTabRegapplicant> findfeed();
	public List<WsbmTabRegapplicant> unfindfeed();
}
