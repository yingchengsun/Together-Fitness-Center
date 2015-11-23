package com.xdsc.dao.wsbm;
import java.util.List;

import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**考生查询信息
 * @author 苟小龙
 * @version 1.2
 */
public interface KsCheckDAO {
	public WsbmTabRegapplicant findKaoShengInfoByNum(String FAppRegNum);

	public List<WsbmTabExamsubject> findExamsubject();

	public WsbmTabExamsubject sepFindSubjectByNum(Integer subjectNumber);
}
