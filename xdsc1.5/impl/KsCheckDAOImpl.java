package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.KsCheckDAO;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**�����鿴��վ��Ϣ
 * @author ��С��
 * @version 1.2
 */
public class KsCheckDAOImpl extends HibernateDaoSupport implements KsCheckDAO {

	/**���ҵ�������
	 * @param FAppRegNum ����id
	 * @return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum) ��������
	 */
	public WsbmTabRegapplicant findKaoShengInfoByNum(String FAppRegNum) {
		return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum);
	}
	/**���ҿ�����Ϣ
	 * @return list ������Ϣ�б�
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
