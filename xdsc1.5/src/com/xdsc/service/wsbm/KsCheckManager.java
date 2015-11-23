package com.xdsc.service.wsbm;

import java.util.List;

import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**考生查询网站信息
 * @author 苟小龙
 * @version 1.2
 *
 */
public interface KsCheckManager {
	public WsbmTabRegapplicant findKaoShengInfoByNum(String FAppRegNum);

	public List<WsbmTabExamsubject> findExamsubject();

	public WsbmTabExamsubject sepFindSubjectByNum(Integer subjectNumber);

}
