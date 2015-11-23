package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.KsCheckDAO;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**考生查看网站信息
 * @author 苟小龙
 * @version 1.2
 */
public class KsCheckDAOImpl extends HibernateDaoSupport implements KsCheckDAO {

	/**查找单个考生
	 * @param FAppRegNum 考生id
	 * @return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum) 考生对象
	 */
	public WsbmTabRegapplicant findKaoShengInfoByNum(String FAppRegNum) {
		return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum);
	}
	/**查找考试信息
	 * @return list 考试信息列表
	 */
	public List<WsbmTabExamsubject> findExamsubject() {
		String sql = "from WsbmTabExamsubject";
		List<WsbmTabExamsubject> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	public WsbmTabExamsubject sepFindSubjectByNum(Integer subjectNumber) {
		WsbmTabExamsubject wsbmTabExamsubject = (WsbmTabExamsubject) this.getHibernateTemplate().get(WsbmTabExamsubject.class, subjectNumber);
		return wsbmTabExamsubject;
	}

}
