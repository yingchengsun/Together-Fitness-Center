package com.xdsc.dao.jiaofu.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AssistResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;

/**
 * <p>���ܣ�������Դ���ҵȲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistResourceManageDAOImpl extends HibernateDaoSupport implements AssistResourceManageDAO{

	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param aid ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findResourceInfoByID(String aid) {
		List<JfptTabUploadfile> list = new ArrayList<JfptTabUploadfile>();
		String sql = "select j from JfptTabUploadfile j, JfptTabAssistantapply a where j.tabCourse.FCourseNumber = a.tabCourse.FCourseNumber " 
                                                             +"and j.mhqxTabUser.FUserNumber = a.tabTeachers.FTeacherNumber "
                                                             +"and a.FAssistantId='"+aid+"'"
                                                             +" and a.FShenQing='N'";
	    list = this.getHibernateTemplate().find(sql);
	    return list;
	}

	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
	}
}
